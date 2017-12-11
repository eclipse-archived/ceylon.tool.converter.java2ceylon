/********************************************************************************
 * Copyright (c) 2011-2017 Red Hat Inc. and/or its affiliates and others
 *
 * This program and the accompanying materials are made available under the 
 * terms of the Apache License, Version 2.0 which is available at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * SPDX-License-Identifier: Apache-2.0 
 ********************************************************************************/
package ceylon.tool.converter.java2ceylon;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import ceylon.tool.converter.java2ceylon.Java8Parser.AssignmentContext;
import ceylon.tool.converter.java2ceylon.Java8Parser.CompilationUnitContext;
import ceylon.tool.converter.java2ceylon.Java8Parser.LocalVariableDeclarationContext;
import ceylon.tool.converter.java2ceylon.Java8Parser.MethodDeclarationContext;
import ceylon.tool.converter.java2ceylon.Java8Parser.NormalClassDeclarationContext;
import ceylon.tool.converter.java2ceylon.Java8Parser.PostDecrementExpressionContext;
import ceylon.tool.converter.java2ceylon.Java8Parser.PostIncrementExpressionContext;
import ceylon.tool.converter.java2ceylon.Java8Parser.PostfixExpressionContext;
import ceylon.tool.converter.java2ceylon.Java8Parser.PreDecrementExpressionContext;
import ceylon.tool.converter.java2ceylon.Java8Parser.PreIncrementExpressionContext;
import ceylon.tool.converter.java2ceylon.Java8Parser.VariableDeclaratorContext;
import ceylon.tool.converter.java2ceylon.Java8Parser.VariableDeclaratorIdContext;
import ceylon.tool.converter.java2ceylon.Java8Parser.VariableInitializerContext;

public class ScopeTree extends Java8BaseVisitor<Void> {
    public Node root, scopeNode;

    public ScopeTree() {
        root = new Node();
    }

    public static class Node {
        ParserRuleContext data;
        Node parent;
        List<Node> children;
        boolean scope, variable, optional;

        Node() {
            data = new ParserRuleContext();
            scope = false;
            variable = false;
            optional = false;
            children = new ArrayList<>();
        }

        void addNode(Node n) {
            children.add(n);
        }
    }

    public Node getNode(ParserRuleContext ctx, Node n) {
        if (ctx == n.data) {
            return n;
        } else {
            for (Node c : n.children) {
                Node found = getNode(ctx, c);
                if (found != null)
                    return found;
            }
        }
        return null;
    }

    @Override
    public Void visitCompilationUnit(CompilationUnitContext ctx) {
        Node n = new Node();
        n.data = ctx;
        n.scope = true;
        root = n;

        scopeNode = n;

        return super.visitCompilationUnit(ctx);
    }

    @Override
    public Void visitNormalClassDeclaration(NormalClassDeclarationContext ctx) {
        Node n = new Node();
        n.data = ctx;
        n.parent = scopeNode;
        n.scope = true;
        scopeNode.addNode(n);

        scopeNode = n;
        visitClassBody(ctx.classBody());
        scopeNode = n.parent;

        return null;
    }

    @Override
    public Void visitVariableDeclaratorId(VariableDeclaratorIdContext ctx) {
        Node n = new Node();
        n.data = ctx;
        n.parent = scopeNode;

        ParserRuleContext parent = ctx.getParent();

        if (parent instanceof VariableDeclaratorContext) {
            VariableInitializerContext initial = ((VariableDeclaratorContext) parent).variableInitializer();

            if (initial != null && initial.getText().equals("null"))
                n.optional = true;
        }

        scopeNode.addNode(n);

        return super.visitVariableDeclaratorId(ctx);
    }

    @Override
    public Void visitMethodDeclaration(MethodDeclarationContext ctx) {
        Node n = new Node();
        n.parent = scopeNode;
        n.data = ctx;
        n.scope = true;
        scopeNode.addNode(n);

        scopeNode = n;

        visitMethodHeader(ctx.methodHeader());
        visitMethodBody(ctx.methodBody());

        scopeNode = n.parent;

        return null;
    }

    @Override
    public Void visitPostIncrementExpression(PostIncrementExpressionContext ctx) {
        String var = ctx.postfixExpression().getText();
        checkVariable(scopeNode, var, false);

        return super.visitPostIncrementExpression(ctx);
    }

    @Override
    public Void visitPostfixExpression(PostfixExpressionContext ctx) {
        if (ctx.postDecrementExpression_lf_postfixExpression(0) != null
                || ctx.postIncrementExpression_lf_postfixExpression(0) != null) {
            String var = ctx.expressionName().getText();
            checkVariable(scopeNode, var, false);
        }

        return super.visitPostfixExpression(ctx);
    }

    @Override
    public Void visitPostDecrementExpression(PostDecrementExpressionContext ctx) {
        String var = ctx.postfixExpression().getText();
        checkVariable(scopeNode, var, false);

        return super.visitPostDecrementExpression(ctx);
    }

    @Override
    public Void visitPreIncrementExpression(PreIncrementExpressionContext ctx) {
        String var = ctx.unaryExpression().getText();
        checkVariable(scopeNode, var, false);

        return super.visitPreIncrementExpression(ctx);
    }

    @Override
    public Void visitPreDecrementExpression(PreDecrementExpressionContext ctx) {
        String var = ctx.unaryExpression().getText();
        checkVariable(scopeNode, var, false);

        return super.visitPreDecrementExpression(ctx);
    }

    @Override
    public Void visitAssignment(AssignmentContext ctx) {
        String leftHandSide = ctx.leftHandSide().getText();

        String expression = ctx.expression().getText();

        checkVariable(scopeNode, leftHandSide, expression.equals("null"));

        return super.visitAssignment(ctx);
    }

    private void checkVariable(Node n, String var, boolean isNull) {
        boolean flag = false;

        for (Node c : n.children) {
            if (c.data instanceof LocalVariableDeclarationContext) {
                LocalVariableDeclarationContext context = (LocalVariableDeclarationContext) c.data;

                for (VariableDeclaratorContext x : context.variableDeclaratorList().variableDeclarator()) {
                    String id = x.variableDeclaratorId().getText();

                    if (var.equals(id)) {
                        c.variable = true;

                        if (isNull)
                            c.optional = true;

                        flag = true;
                        break;
                    }

                }
            }
            if (c.data instanceof VariableDeclaratorIdContext) {
                VariableDeclaratorIdContext context = (VariableDeclaratorIdContext) c.data;

                if (var.equals(context.Identifier().getText())) {
                    c.variable = true;
                    flag = true;

                    if (isNull)
                        c.optional = true;
                }
            }
        }

        if (!flag && n.parent != null)
            checkVariable(n.parent, var, isNull);
    }
}
