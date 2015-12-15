package ceylon.tool.converter.java2ceylon;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import ceylon.tool.converter.java2ceylon.Java8Parser.CompilationUnitContext;
import ceylon.tool.converter.java2ceylon.Java8Parser.LeftHandSideContext;
import ceylon.tool.converter.java2ceylon.Java8Parser.LocalVariableDeclarationContext;
import ceylon.tool.converter.java2ceylon.Java8Parser.MethodDeclarationContext;
import ceylon.tool.converter.java2ceylon.Java8Parser.NormalClassDeclarationContext;
import ceylon.tool.converter.java2ceylon.Java8Parser.VariableDeclaratorContext;
import ceylon.tool.converter.java2ceylon.Java8Parser.VariableDeclaratorIdContext;

public class ScopeTree extends Java8BaseVisitor<Void> {
    public Node root, scopeNode;

    public ScopeTree() {
        root = new Node();
    }

    public static class Node {
        ParserRuleContext data;
        Node parent;
        List<Node> children;
        boolean scope, variable;

        Node() {
            data = new ParserRuleContext();
            scope = false;
            variable = false;
            children = new ArrayList<>();
        }

        void addNode(Node n) {
            children.add(n);
        }
    }

    public Node getNode(ParserRuleContext ctx, Node n,
            ParserRuleContext scope) {
        if (ctx == n.data) {
            return n;
        } else {
            for (Node c : n.children) {
                Node found = getNode(ctx, c, scope);
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
    public Void visitLeftHandSide(LeftHandSideContext ctx) {
        String var = ctx.getText();
        checkVariable(scopeNode, var);

        return super.visitLeftHandSide(ctx);
    }

    void checkVariable(Node n, String var) {
        boolean flag = false;
        for (Node c : n.children) {
            if (c.data instanceof LocalVariableDeclarationContext) {
                LocalVariableDeclarationContext context = (LocalVariableDeclarationContext) c.data;

                for (VariableDeclaratorContext x : context
                        .variableDeclaratorList().variableDeclarator()) {
                    String id = x.variableDeclaratorId().getText();

                    if (var.equals(id)) {
                        c.variable = true;
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
                }
            }
        }

        if (!flag && n.parent != null)
            checkVariable(n.parent, var);
    }
}
