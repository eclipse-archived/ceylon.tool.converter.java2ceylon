package com.rohit.converter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import com.rohit.converter.Java8Lexer;
import com.rohit.converter.Java8Listener;
import com.rohit.converter.Java8Parser;
import com.rohit.converter.Java8Parser.*;

public class Main {

	/**
	 * Main Method
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		if (args.length != 2) {
			System.out
					.println("First Argument: original java file.\nSecond Argument: destination ceylon file");
		} else {
			File f = new File(args[0]);

			ANTLRInputStream input = new ANTLRInputStream(
					new FileInputStream(f));
			Java8Lexer lexer = new Java8Lexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			Java8Parser parser = new Java8Parser(tokens);
			ParseTree tree = parser.compilationUnit();

			final BufferedWriter bw = new BufferedWriter(new FileWriter(
					new File(args[1])));

			Java8Listener listener = new Java8Listener() {
				public void exitVariableInitializer(
						VariableInitializerContext ctx) {
					// TODO Auto-generated method stub

					try {
						bw.write(" = " + ctx.getChild(0).getText());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				public void exitVariableDeclaratorId(
						VariableDeclaratorIdContext ctx) {
					// TODO Auto-generated method stub
					try {
						bw.write(ctx.getText());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				public void exitLocalVariableDeclarationStatement(
						LocalVariableDeclarationStatementContext ctx) {
					// TODO Auto-generated method stub
					try {
						bw.write(ctx.getChild(ctx.getChildCount() - 1) + "\n");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				public void exitFieldDeclaration(FieldDeclarationContext ctx) {
					// TODO Auto-generated method stub
					try {
						bw.write(ctx.getChild(ctx.getChildCount() - 1) + "\n");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				public void exitExpressionStatement(
						ExpressionStatementContext ctx) {
					// TODO Auto-generated method stub
					try {
						bw.write(ctx.getChild(ctx.getChildCount() - 1) + "\n");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				public void exitClassBody(ClassBodyContext ctx) {
					// TODO Auto-generated method stub
					int count = ctx.getChildCount();

					try {
						bw.write(ctx.getChild(count - 1).toString());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				public void exitBlock(BlockContext ctx) {
					// TODO Auto-generated method stub
					int count = ctx.getChildCount();
					try {
						bw.write(ctx.getChild(count - 1).toString() + "\n");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				public void enterUnannPrimitiveType(
						UnannPrimitiveTypeContext ctx) {
					// TODO Auto-generated method stub
					String type = ctx.getText();
					try {
						if (type.equals("int") || type.equals("short")
								|| type.equals("long")) {
							bw.write("Integer ");
						} else if (type.equals("byte")) {
							bw.write("Byte ");
						} else if (type.equals("char")) {
							bw.write("Character ");
						} else if (type.equals("float")
								|| type.equals("double")) {
							bw.write("Float ");
						} else if (type.equals("boolean")) {
							bw.write("Boolean ");
						}

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				public void enterResult(ResultContext ctx) {
					// TODO Auto-generated method stub
					try {
						bw.write(ctx.getChild(0).toString() + " ");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				public void enterNormalClassDeclaration(
						NormalClassDeclarationContext ctx) {
					// TODO Auto-generated method stub

					String modifier = " ";
					if (ctx.classModifier(0).getText().equals("public"))
						modifier = "shared ";
					try {
						bw.write(modifier + "class " + ctx.Identifier() + "() ");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				public void enterMethodModifier(MethodModifierContext ctx) {
					// TODO Auto-generated method stub
					if (ctx.getText().equals("public"))
						try {
							bw.write("shared ");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}

				public void enterMethodDeclarator(MethodDeclaratorContext ctx) {
					// TODO Auto-generated method stub

					try {
						bw.write(ctx.Identifier() + "() ");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				public void enterClassBody(ClassBodyContext ctx) {
					// TODO Auto-generated method stub

					try {
						bw.write(ctx.getChild(0).toString() + "\n");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

				public void enterBlock(BlockContext ctx) {
					// TODO Auto-generated method stub

					try {
						bw.write(ctx.getChild(0) + "\n");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				public void enterAssignment(AssignmentContext ctx) {
					// TODO Auto-generated method stub
					try {
						bw.write(ctx.leftHandSide().getText());
						bw.write(ctx.assignmentOperator().getText());
						bw.write(ctx.expression().getText());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				public void visitTerminal(TerminalNode node) {
					// TODO Auto-generated method stub

				}

				public void visitErrorNode(ErrorNode node) {
					// TODO Auto-generated method stub

				}

				public void exitEveryRule(ParserRuleContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterEveryRule(ParserRuleContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitWildcardBounds(WildcardBoundsContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitWildcard(WildcardContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitWhileStatementNoShortIf(
						WhileStatementNoShortIfContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitWhileStatement(WhileStatementContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitVariableModifier(VariableModifierContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitVariableInitializerList(
						VariableInitializerListContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitVariableDeclaratorList(
						VariableDeclaratorListContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitVariableDeclarator(VariableDeclaratorContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitUnaryExpressionNotPlusMinus(
						UnaryExpressionNotPlusMinusContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitUnaryExpression(UnaryExpressionContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitUnannTypeVariable(UnannTypeVariableContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitUnannType(UnannTypeContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitUnannReferenceType(UnannReferenceTypeContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitUnannPrimitiveType(UnannPrimitiveTypeContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitUnannInterfaceType_lfno_unannClassOrInterfaceType(
						UnannInterfaceType_lfno_unannClassOrInterfaceTypeContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitUnannInterfaceType_lf_unannClassOrInterfaceType(
						UnannInterfaceType_lf_unannClassOrInterfaceTypeContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitUnannInterfaceType(UnannInterfaceTypeContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitUnannClassType_lfno_unannClassOrInterfaceType(
						UnannClassType_lfno_unannClassOrInterfaceTypeContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitUnannClassType_lf_unannClassOrInterfaceType(
						UnannClassType_lf_unannClassOrInterfaceTypeContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitUnannClassType(UnannClassTypeContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitUnannClassOrInterfaceType(
						UnannClassOrInterfaceTypeContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitUnannArrayType(UnannArrayTypeContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitTypeVariable(TypeVariableContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitTypeParameters(TypeParametersContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitTypeParameterModifier(
						TypeParameterModifierContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitTypeParameterList(TypeParameterListContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitTypeParameter(TypeParameterContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitTypeName(TypeNameContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitTypeImportOnDemandDeclaration(
						TypeImportOnDemandDeclarationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitTypeDeclaration(TypeDeclarationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitTypeBound(TypeBoundContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitTypeArgumentsOrDiamond(
						TypeArgumentsOrDiamondContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitTypeArguments(TypeArgumentsContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitTypeArgumentList(TypeArgumentListContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitTypeArgument(TypeArgumentContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitType(TypeContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitTryWithResourcesStatement(
						TryWithResourcesStatementContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitTryStatement(TryStatementContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitThrows_(Throws_Context ctx) {
					// TODO Auto-generated method stub

				}

				public void exitThrowStatement(ThrowStatementContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitSynchronizedStatement(
						SynchronizedStatementContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitSwitchStatement(SwitchStatementContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitSwitchLabels(SwitchLabelsContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitSwitchLabel(SwitchLabelContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitSwitchBlockStatementGroup(
						SwitchBlockStatementGroupContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitSwitchBlock(SwitchBlockContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitSuperinterfaces(SuperinterfacesContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitSuperclass(SuperclassContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitStaticInitializer(StaticInitializerContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitStaticImportOnDemandDeclaration(
						StaticImportOnDemandDeclarationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitStatementWithoutTrailingSubstatement(
						StatementWithoutTrailingSubstatementContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitStatementNoShortIf(StatementNoShortIfContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitStatementExpressionList(
						StatementExpressionListContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitStatementExpression(
						StatementExpressionContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitStatement(StatementContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitSingleTypeImportDeclaration(
						SingleTypeImportDeclarationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitSingleStaticImportDeclaration(
						SingleStaticImportDeclarationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitSingleElementAnnotation(
						SingleElementAnnotationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitSimpleTypeName(SimpleTypeNameContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitShiftExpression(ShiftExpressionContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitReturnStatement(ReturnStatementContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitResult(ResultContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitResourceSpecification(
						ResourceSpecificationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitResourceList(ResourceListContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitResource(ResourceContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitRelationalExpression(
						RelationalExpressionContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitReferenceType(ReferenceTypeContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitReceiverParameter(ReceiverParameterContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitPrimitiveType(PrimitiveTypeContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitPrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary(
						PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitPrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary(
						PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitPrimaryNoNewArray_lfno_primary(
						PrimaryNoNewArray_lfno_primaryContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitPrimaryNoNewArray_lfno_arrayAccess(
						PrimaryNoNewArray_lfno_arrayAccessContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitPrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary(
						PrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitPrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary(
						PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitPrimaryNoNewArray_lf_primary(
						PrimaryNoNewArray_lf_primaryContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitPrimaryNoNewArray_lf_arrayAccess(
						PrimaryNoNewArray_lf_arrayAccessContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitPrimaryNoNewArray(PrimaryNoNewArrayContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitPrimary(PrimaryContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitPreIncrementExpression(
						PreIncrementExpressionContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitPreDecrementExpression(
						PreDecrementExpressionContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitPostfixExpression(PostfixExpressionContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitPostIncrementExpression_lf_postfixExpression(
						PostIncrementExpression_lf_postfixExpressionContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitPostIncrementExpression(
						PostIncrementExpressionContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitPostDecrementExpression_lf_postfixExpression(
						PostDecrementExpression_lf_postfixExpressionContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitPostDecrementExpression(
						PostDecrementExpressionContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitPackageOrTypeName(PackageOrTypeNameContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitPackageName(PackageNameContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitPackageModifier(PackageModifierContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitPackageDeclaration(PackageDeclarationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitNumericType(NumericTypeContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitNormalInterfaceDeclaration(
						NormalInterfaceDeclarationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitNormalClassDeclaration(
						NormalClassDeclarationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitNormalAnnotation(NormalAnnotationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitMultiplicativeExpression(
						MultiplicativeExpressionContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitMethodReference_lfno_primary(
						MethodReference_lfno_primaryContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitMethodReference_lf_primary(
						MethodReference_lf_primaryContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitMethodReference(MethodReferenceContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitMethodName(MethodNameContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitMethodModifier(MethodModifierContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitMethodInvocation_lfno_primary(
						MethodInvocation_lfno_primaryContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitMethodInvocation_lf_primary(
						MethodInvocation_lf_primaryContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitMethodInvocation(MethodInvocationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitMethodHeader(MethodHeaderContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitMethodDeclarator(MethodDeclaratorContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitMethodDeclaration(MethodDeclarationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitMethodBody(MethodBodyContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitMarkerAnnotation(MarkerAnnotationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitLocalVariableDeclaration(
						LocalVariableDeclarationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitLiteral(LiteralContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitLeftHandSide(LeftHandSideContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitLastFormalParameter(
						LastFormalParameterContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitLambdaParameters(LambdaParametersContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitLambdaExpression(LambdaExpressionContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitLambdaBody(LambdaBodyContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitLabeledStatementNoShortIf(
						LabeledStatementNoShortIfContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitLabeledStatement(LabeledStatementContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitInterfaceType_lfno_classOrInterfaceType(
						InterfaceType_lfno_classOrInterfaceTypeContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitInterfaceType_lf_classOrInterfaceType(
						InterfaceType_lf_classOrInterfaceTypeContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitInterfaceTypeList(InterfaceTypeListContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitInterfaceType(InterfaceTypeContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitInterfaceModifier(InterfaceModifierContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitInterfaceMethodModifier(
						InterfaceMethodModifierContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitInterfaceMethodDeclaration(
						InterfaceMethodDeclarationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitInterfaceMemberDeclaration(
						InterfaceMemberDeclarationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitInterfaceDeclaration(
						InterfaceDeclarationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitInterfaceBody(InterfaceBodyContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitIntegralType(IntegralTypeContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitInstanceInitializer(
						InstanceInitializerContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitInferredFormalParameterList(
						InferredFormalParameterListContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitInclusiveOrExpression(
						InclusiveOrExpressionContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitImportDeclaration(ImportDeclarationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitIfThenStatement(IfThenStatementContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitIfThenElseStatementNoShortIf(
						IfThenElseStatementNoShortIfContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitIfThenElseStatement(
						IfThenElseStatementContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitFormalParameters(FormalParametersContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitFormalParameterList(
						FormalParameterListContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitFormalParameter(FormalParameterContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitForUpdate(ForUpdateContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitForStatementNoShortIf(
						ForStatementNoShortIfContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitForStatement(ForStatementContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitForInit(ForInitContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitFloatingPointType(FloatingPointTypeContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitFinally_(Finally_Context ctx) {
					// TODO Auto-generated method stub

				}

				public void exitFieldModifier(FieldModifierContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitFieldAccess_lfno_primary(
						FieldAccess_lfno_primaryContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitFieldAccess_lf_primary(
						FieldAccess_lf_primaryContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitFieldAccess(FieldAccessContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitExtendsInterfaces(ExtendsInterfacesContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitExpressionName(ExpressionNameContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitExpression(ExpressionContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitExplicitConstructorInvocation(
						ExplicitConstructorInvocationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitExclusiveOrExpression(
						ExclusiveOrExpressionContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitExceptionTypeList(ExceptionTypeListContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitExceptionType(ExceptionTypeContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitEqualityExpression(EqualityExpressionContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitEnumDeclaration(EnumDeclarationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitEnumConstantName(EnumConstantNameContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitEnumConstantModifier(
						EnumConstantModifierContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitEnumConstantList(EnumConstantListContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitEnumConstant(EnumConstantContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitEnumBodyDeclarations(
						EnumBodyDeclarationsContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitEnumBody(EnumBodyContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitEnhancedForStatementNoShortIf(
						EnhancedForStatementNoShortIfContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitEnhancedForStatement(
						EnhancedForStatementContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitEmptyStatement(EmptyStatementContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitElementValuePairList(
						ElementValuePairListContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitElementValuePair(ElementValuePairContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitElementValueList(ElementValueListContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitElementValueArrayInitializer(
						ElementValueArrayInitializerContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitElementValue(ElementValueContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitDoStatement(DoStatementContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitDims(DimsContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitDimExprs(DimExprsContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitDimExpr(DimExprContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitDefaultValue(DefaultValueContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitContinueStatement(ContinueStatementContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitConstructorModifier(
						ConstructorModifierContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitConstructorDeclarator(
						ConstructorDeclaratorContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitConstructorDeclaration(
						ConstructorDeclarationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitConstructorBody(ConstructorBodyContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitConstantModifier(ConstantModifierContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitConstantExpression(ConstantExpressionContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitConstantDeclaration(
						ConstantDeclarationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitConditionalOrExpression(
						ConditionalOrExpressionContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitConditionalExpression(
						ConditionalExpressionContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitConditionalAndExpression(
						ConditionalAndExpressionContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitCompilationUnit(CompilationUnitContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitClassType_lfno_classOrInterfaceType(
						ClassType_lfno_classOrInterfaceTypeContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitClassType_lf_classOrInterfaceType(
						ClassType_lf_classOrInterfaceTypeContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitClassType(ClassTypeContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitClassOrInterfaceType(
						ClassOrInterfaceTypeContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitClassModifier(ClassModifierContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitClassMemberDeclaration(
						ClassMemberDeclarationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitClassInstanceCreationExpression_lfno_primary(
						ClassInstanceCreationExpression_lfno_primaryContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitClassInstanceCreationExpression_lf_primary(
						ClassInstanceCreationExpression_lf_primaryContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitClassInstanceCreationExpression(
						ClassInstanceCreationExpressionContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitClassDeclaration(ClassDeclarationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitClassBodyDeclaration(
						ClassBodyDeclarationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitCatches(CatchesContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitCatchType(CatchTypeContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitCatchFormalParameter(
						CatchFormalParameterContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitCatchClause(CatchClauseContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitCastExpression(CastExpressionContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitBreakStatement(BreakStatementContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitBlockStatements(BlockStatementsContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitBlockStatement(BlockStatementContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitBasicForStatementNoShortIf(
						BasicForStatementNoShortIfContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitBasicForStatement(BasicForStatementContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitAssignmentOperator(AssignmentOperatorContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitAssignmentExpression(
						AssignmentExpressionContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitAssignment(AssignmentContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitAssertStatement(AssertStatementContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitArrayType(ArrayTypeContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitArrayInitializer(ArrayInitializerContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitArrayCreationExpression(
						ArrayCreationExpressionContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitArrayAccess_lfno_primary(
						ArrayAccess_lfno_primaryContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitArrayAccess_lf_primary(
						ArrayAccess_lf_primaryContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitArrayAccess(ArrayAccessContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitArgumentList(ArgumentListContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitAnnotationTypeMemberDeclaration(
						AnnotationTypeMemberDeclarationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitAnnotationTypeElementModifier(
						AnnotationTypeElementModifierContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitAnnotationTypeElementDeclaration(
						AnnotationTypeElementDeclarationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitAnnotationTypeDeclaration(
						AnnotationTypeDeclarationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitAnnotationTypeBody(AnnotationTypeBodyContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitAnnotation(AnnotationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitAndExpression(AndExpressionContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitAmbiguousName(AmbiguousNameContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitAdditiveExpression(AdditiveExpressionContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitAdditionalBound(AdditionalBoundContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterWildcardBounds(WildcardBoundsContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterWildcard(WildcardContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterWhileStatementNoShortIf(
						WhileStatementNoShortIfContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterWhileStatement(WhileStatementContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterVariableModifier(VariableModifierContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterVariableInitializerList(
						VariableInitializerListContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterVariableInitializer(
						VariableInitializerContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterVariableDeclaratorList(
						VariableDeclaratorListContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterVariableDeclaratorId(
						VariableDeclaratorIdContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterVariableDeclarator(
						VariableDeclaratorContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterUnaryExpressionNotPlusMinus(
						UnaryExpressionNotPlusMinusContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterUnaryExpression(UnaryExpressionContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterUnannTypeVariable(UnannTypeVariableContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterUnannType(UnannTypeContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterUnannReferenceType(
						UnannReferenceTypeContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterUnannInterfaceType_lfno_unannClassOrInterfaceType(
						UnannInterfaceType_lfno_unannClassOrInterfaceTypeContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterUnannInterfaceType_lf_unannClassOrInterfaceType(
						UnannInterfaceType_lf_unannClassOrInterfaceTypeContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterUnannInterfaceType(
						UnannInterfaceTypeContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterUnannClassType_lfno_unannClassOrInterfaceType(
						UnannClassType_lfno_unannClassOrInterfaceTypeContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterUnannClassType_lf_unannClassOrInterfaceType(
						UnannClassType_lf_unannClassOrInterfaceTypeContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterUnannClassType(UnannClassTypeContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterUnannClassOrInterfaceType(
						UnannClassOrInterfaceTypeContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterUnannArrayType(UnannArrayTypeContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterTypeVariable(TypeVariableContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterTypeParameters(TypeParametersContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterTypeParameterModifier(
						TypeParameterModifierContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterTypeParameterList(TypeParameterListContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterTypeParameter(TypeParameterContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterTypeName(TypeNameContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterTypeImportOnDemandDeclaration(
						TypeImportOnDemandDeclarationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterTypeDeclaration(TypeDeclarationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterTypeBound(TypeBoundContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterTypeArgumentsOrDiamond(
						TypeArgumentsOrDiamondContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterTypeArguments(TypeArgumentsContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterTypeArgumentList(TypeArgumentListContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterTypeArgument(TypeArgumentContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterType(TypeContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterTryWithResourcesStatement(
						TryWithResourcesStatementContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterTryStatement(TryStatementContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterThrows_(Throws_Context ctx) {
					// TODO Auto-generated method stub

				}

				public void enterThrowStatement(ThrowStatementContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterSynchronizedStatement(
						SynchronizedStatementContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterSwitchStatement(SwitchStatementContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterSwitchLabels(SwitchLabelsContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterSwitchLabel(SwitchLabelContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterSwitchBlockStatementGroup(
						SwitchBlockStatementGroupContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterSwitchBlock(SwitchBlockContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterSuperinterfaces(SuperinterfacesContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterSuperclass(SuperclassContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterStaticInitializer(StaticInitializerContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterStaticImportOnDemandDeclaration(
						StaticImportOnDemandDeclarationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterStatementWithoutTrailingSubstatement(
						StatementWithoutTrailingSubstatementContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterStatementNoShortIf(
						StatementNoShortIfContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterStatementExpressionList(
						StatementExpressionListContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterStatementExpression(
						StatementExpressionContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterStatement(StatementContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterSingleTypeImportDeclaration(
						SingleTypeImportDeclarationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterSingleStaticImportDeclaration(
						SingleStaticImportDeclarationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterSingleElementAnnotation(
						SingleElementAnnotationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterSimpleTypeName(SimpleTypeNameContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterShiftExpression(ShiftExpressionContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterReturnStatement(ReturnStatementContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterResourceSpecification(
						ResourceSpecificationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterResourceList(ResourceListContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterResource(ResourceContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterRelationalExpression(
						RelationalExpressionContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterReferenceType(ReferenceTypeContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterReceiverParameter(ReceiverParameterContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterPrimitiveType(PrimitiveTypeContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterPrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary(
						PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterPrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary(
						PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterPrimaryNoNewArray_lfno_primary(
						PrimaryNoNewArray_lfno_primaryContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterPrimaryNoNewArray_lfno_arrayAccess(
						PrimaryNoNewArray_lfno_arrayAccessContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterPrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary(
						PrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterPrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary(
						PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterPrimaryNoNewArray_lf_primary(
						PrimaryNoNewArray_lf_primaryContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterPrimaryNoNewArray_lf_arrayAccess(
						PrimaryNoNewArray_lf_arrayAccessContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterPrimaryNoNewArray(PrimaryNoNewArrayContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterPrimary(PrimaryContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterPreIncrementExpression(
						PreIncrementExpressionContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterPreDecrementExpression(
						PreDecrementExpressionContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterPostfixExpression(PostfixExpressionContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterPostIncrementExpression_lf_postfixExpression(
						PostIncrementExpression_lf_postfixExpressionContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterPostIncrementExpression(
						PostIncrementExpressionContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterPostDecrementExpression_lf_postfixExpression(
						PostDecrementExpression_lf_postfixExpressionContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterPostDecrementExpression(
						PostDecrementExpressionContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterPackageOrTypeName(PackageOrTypeNameContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterPackageName(PackageNameContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterPackageModifier(PackageModifierContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterPackageDeclaration(
						PackageDeclarationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterNumericType(NumericTypeContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterNormalInterfaceDeclaration(
						NormalInterfaceDeclarationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterNormalAnnotation(NormalAnnotationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterMultiplicativeExpression(
						MultiplicativeExpressionContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterMethodReference_lfno_primary(
						MethodReference_lfno_primaryContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterMethodReference_lf_primary(
						MethodReference_lf_primaryContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterMethodReference(MethodReferenceContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterMethodName(MethodNameContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterMethodInvocation_lfno_primary(
						MethodInvocation_lfno_primaryContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterMethodInvocation_lf_primary(
						MethodInvocation_lf_primaryContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterMethodInvocation(MethodInvocationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterMethodHeader(MethodHeaderContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterMethodDeclaration(MethodDeclarationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterMethodBody(MethodBodyContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterMarkerAnnotation(MarkerAnnotationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterLocalVariableDeclarationStatement(
						LocalVariableDeclarationStatementContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterLocalVariableDeclaration(
						LocalVariableDeclarationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterLiteral(LiteralContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterLeftHandSide(LeftHandSideContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterLastFormalParameter(
						LastFormalParameterContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterLambdaParameters(LambdaParametersContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterLambdaExpression(LambdaExpressionContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterLambdaBody(LambdaBodyContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterLabeledStatementNoShortIf(
						LabeledStatementNoShortIfContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterLabeledStatement(LabeledStatementContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterInterfaceType_lfno_classOrInterfaceType(
						InterfaceType_lfno_classOrInterfaceTypeContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterInterfaceType_lf_classOrInterfaceType(
						InterfaceType_lf_classOrInterfaceTypeContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterInterfaceTypeList(InterfaceTypeListContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterInterfaceType(InterfaceTypeContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterInterfaceModifier(InterfaceModifierContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterInterfaceMethodModifier(
						InterfaceMethodModifierContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterInterfaceMethodDeclaration(
						InterfaceMethodDeclarationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterInterfaceMemberDeclaration(
						InterfaceMemberDeclarationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterInterfaceDeclaration(
						InterfaceDeclarationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterInterfaceBody(InterfaceBodyContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterIntegralType(IntegralTypeContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterInstanceInitializer(
						InstanceInitializerContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterInferredFormalParameterList(
						InferredFormalParameterListContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterInclusiveOrExpression(
						InclusiveOrExpressionContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterImportDeclaration(ImportDeclarationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterIfThenStatement(IfThenStatementContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterIfThenElseStatementNoShortIf(
						IfThenElseStatementNoShortIfContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterIfThenElseStatement(
						IfThenElseStatementContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterFormalParameters(FormalParametersContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterFormalParameterList(
						FormalParameterListContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterFormalParameter(FormalParameterContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterForUpdate(ForUpdateContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterForStatementNoShortIf(
						ForStatementNoShortIfContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterForStatement(ForStatementContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterForInit(ForInitContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterFloatingPointType(FloatingPointTypeContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterFinally_(Finally_Context ctx) {
					// TODO Auto-generated method stub

				}

				public void enterFieldModifier(FieldModifierContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterFieldDeclaration(FieldDeclarationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterFieldAccess_lfno_primary(
						FieldAccess_lfno_primaryContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterFieldAccess_lf_primary(
						FieldAccess_lf_primaryContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterFieldAccess(FieldAccessContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterExtendsInterfaces(ExtendsInterfacesContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterExpressionStatement(
						ExpressionStatementContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterExpressionName(ExpressionNameContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterExpression(ExpressionContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterExplicitConstructorInvocation(
						ExplicitConstructorInvocationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterExclusiveOrExpression(
						ExclusiveOrExpressionContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterExceptionTypeList(ExceptionTypeListContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterExceptionType(ExceptionTypeContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterEqualityExpression(
						EqualityExpressionContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterEnumDeclaration(EnumDeclarationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterEnumConstantName(EnumConstantNameContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterEnumConstantModifier(
						EnumConstantModifierContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterEnumConstantList(EnumConstantListContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterEnumConstant(EnumConstantContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterEnumBodyDeclarations(
						EnumBodyDeclarationsContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterEnumBody(EnumBodyContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterEnhancedForStatementNoShortIf(
						EnhancedForStatementNoShortIfContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterEnhancedForStatement(
						EnhancedForStatementContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterEmptyStatement(EmptyStatementContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterElementValuePairList(
						ElementValuePairListContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterElementValuePair(ElementValuePairContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterElementValueList(ElementValueListContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterElementValueArrayInitializer(
						ElementValueArrayInitializerContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterElementValue(ElementValueContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterDoStatement(DoStatementContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterDims(DimsContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterDimExprs(DimExprsContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterDimExpr(DimExprContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterDefaultValue(DefaultValueContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterContinueStatement(ContinueStatementContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterConstructorModifier(
						ConstructorModifierContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterConstructorDeclarator(
						ConstructorDeclaratorContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterConstructorDeclaration(
						ConstructorDeclarationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterConstructorBody(ConstructorBodyContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterConstantModifier(ConstantModifierContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterConstantExpression(
						ConstantExpressionContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterConstantDeclaration(
						ConstantDeclarationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterConditionalOrExpression(
						ConditionalOrExpressionContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterConditionalExpression(
						ConditionalExpressionContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterConditionalAndExpression(
						ConditionalAndExpressionContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterCompilationUnit(CompilationUnitContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterClassType_lfno_classOrInterfaceType(
						ClassType_lfno_classOrInterfaceTypeContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterClassType_lf_classOrInterfaceType(
						ClassType_lf_classOrInterfaceTypeContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterClassType(ClassTypeContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterClassOrInterfaceType(
						ClassOrInterfaceTypeContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterClassModifier(ClassModifierContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterClassMemberDeclaration(
						ClassMemberDeclarationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterClassInstanceCreationExpression_lfno_primary(
						ClassInstanceCreationExpression_lfno_primaryContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterClassInstanceCreationExpression_lf_primary(
						ClassInstanceCreationExpression_lf_primaryContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterClassInstanceCreationExpression(
						ClassInstanceCreationExpressionContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterClassDeclaration(ClassDeclarationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterClassBodyDeclaration(
						ClassBodyDeclarationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterCatches(CatchesContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterCatchType(CatchTypeContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterCatchFormalParameter(
						CatchFormalParameterContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterCatchClause(CatchClauseContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterCastExpression(CastExpressionContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterBreakStatement(BreakStatementContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterBlockStatements(BlockStatementsContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterBlockStatement(BlockStatementContext ctx) {
					// TODO Auto-generated method stub

				}
				
				public void enterBasicForStatementNoShortIf(
						BasicForStatementNoShortIfContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterBasicForStatement(BasicForStatementContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterAssignmentOperator(
						AssignmentOperatorContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterAssignmentExpression(
						AssignmentExpressionContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterAssertStatement(AssertStatementContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterArrayType(ArrayTypeContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterArrayInitializer(ArrayInitializerContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterArrayCreationExpression(
						ArrayCreationExpressionContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterArrayAccess_lfno_primary(
						ArrayAccess_lfno_primaryContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterArrayAccess_lf_primary(
						ArrayAccess_lf_primaryContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterArrayAccess(ArrayAccessContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterArgumentList(ArgumentListContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterAnnotationTypeMemberDeclaration(
						AnnotationTypeMemberDeclarationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterAnnotationTypeElementModifier(
						AnnotationTypeElementModifierContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterAnnotationTypeElementDeclaration(
						AnnotationTypeElementDeclarationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterAnnotationTypeDeclaration(
						AnnotationTypeDeclarationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterAnnotationTypeBody(
						AnnotationTypeBodyContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterAnnotation(AnnotationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterAndExpression(AndExpressionContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterAmbiguousName(AmbiguousNameContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterAdditiveExpression(
						AdditiveExpressionContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterAdditionalBound(AdditionalBoundContext ctx) {
					// TODO Auto-generated method stub

				}
			};
			ParseTreeWalker.DEFAULT.walk(listener, tree);

			// Use to generate a viewable AST diagram

			/*
			 * JFrame frame = new JFrame("Antlr AST"); JPanel panel = new
			 * JPanel(); TreeViewer viewer = new TreeViewer(Arrays.asList(parser
			 * .getRuleNames()), tree); viewer.setScale(1.5); panel.add(viewer);
			 * JScrollPane jScrollPane = new JScrollPane(panel);
			 * frame.add(jScrollPane);
			 * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 * frame.setSize(200, 200);
			 * 
			 * frame.setVisible(true);
			 */

			bw.flush();
			bw.close();
		}
	}

}