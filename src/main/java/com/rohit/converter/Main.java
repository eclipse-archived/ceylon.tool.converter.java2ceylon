package com.rohit.converter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import com.rohit.converter.Java8Parser.AdditionalBoundContext;
import com.rohit.converter.Java8Parser.AdditiveExpressionContext;
import com.rohit.converter.Java8Parser.AmbiguousNameContext;
import com.rohit.converter.Java8Parser.AndExpressionContext;
import com.rohit.converter.Java8Parser.AnnotationContext;
import com.rohit.converter.Java8Parser.AnnotationTypeBodyContext;
import com.rohit.converter.Java8Parser.AnnotationTypeDeclarationContext;
import com.rohit.converter.Java8Parser.AnnotationTypeElementDeclarationContext;
import com.rohit.converter.Java8Parser.AnnotationTypeElementModifierContext;
import com.rohit.converter.Java8Parser.AnnotationTypeMemberDeclarationContext;
import com.rohit.converter.Java8Parser.ArgumentListContext;
import com.rohit.converter.Java8Parser.ArrayAccessContext;
import com.rohit.converter.Java8Parser.ArrayAccess_lf_primaryContext;
import com.rohit.converter.Java8Parser.ArrayAccess_lfno_primaryContext;
import com.rohit.converter.Java8Parser.ArrayCreationExpressionContext;
import com.rohit.converter.Java8Parser.ArrayInitializerContext;
import com.rohit.converter.Java8Parser.ArrayTypeContext;
import com.rohit.converter.Java8Parser.AssertStatementContext;
import com.rohit.converter.Java8Parser.AssignmentContext;
import com.rohit.converter.Java8Parser.AssignmentExpressionContext;
import com.rohit.converter.Java8Parser.AssignmentOperatorContext;
import com.rohit.converter.Java8Parser.BasicForStatementContext;
import com.rohit.converter.Java8Parser.BasicForStatementNoShortIfContext;
import com.rohit.converter.Java8Parser.BlockContext;
import com.rohit.converter.Java8Parser.BlockStatementContext;
import com.rohit.converter.Java8Parser.BlockStatementsContext;
import com.rohit.converter.Java8Parser.BreakStatementContext;
import com.rohit.converter.Java8Parser.CastExpressionContext;
import com.rohit.converter.Java8Parser.CatchClauseContext;
import com.rohit.converter.Java8Parser.CatchFormalParameterContext;
import com.rohit.converter.Java8Parser.CatchTypeContext;
import com.rohit.converter.Java8Parser.CatchesContext;
import com.rohit.converter.Java8Parser.ClassBodyContext;
import com.rohit.converter.Java8Parser.ClassBodyDeclarationContext;
import com.rohit.converter.Java8Parser.ClassDeclarationContext;
import com.rohit.converter.Java8Parser.ClassInstanceCreationExpressionContext;
import com.rohit.converter.Java8Parser.ClassInstanceCreationExpression_lf_primaryContext;
import com.rohit.converter.Java8Parser.ClassInstanceCreationExpression_lfno_primaryContext;
import com.rohit.converter.Java8Parser.ClassMemberDeclarationContext;
import com.rohit.converter.Java8Parser.ClassModifierContext;
import com.rohit.converter.Java8Parser.ClassOrInterfaceTypeContext;
import com.rohit.converter.Java8Parser.ClassTypeContext;
import com.rohit.converter.Java8Parser.ClassType_lf_classOrInterfaceTypeContext;
import com.rohit.converter.Java8Parser.ClassType_lfno_classOrInterfaceTypeContext;
import com.rohit.converter.Java8Parser.CompilationUnitContext;
import com.rohit.converter.Java8Parser.ConditionalAndExpressionContext;
import com.rohit.converter.Java8Parser.ConditionalExpressionContext;
import com.rohit.converter.Java8Parser.ConditionalOrExpressionContext;
import com.rohit.converter.Java8Parser.ConstantDeclarationContext;
import com.rohit.converter.Java8Parser.ConstantExpressionContext;
import com.rohit.converter.Java8Parser.ConstantModifierContext;
import com.rohit.converter.Java8Parser.ConstructorBodyContext;
import com.rohit.converter.Java8Parser.ConstructorDeclarationContext;
import com.rohit.converter.Java8Parser.ConstructorDeclaratorContext;
import com.rohit.converter.Java8Parser.ConstructorModifierContext;
import com.rohit.converter.Java8Parser.ContinueStatementContext;
import com.rohit.converter.Java8Parser.DefaultValueContext;
import com.rohit.converter.Java8Parser.DimExprContext;
import com.rohit.converter.Java8Parser.DimExprsContext;
import com.rohit.converter.Java8Parser.DimsContext;
import com.rohit.converter.Java8Parser.DoStatementContext;
import com.rohit.converter.Java8Parser.ElementValueArrayInitializerContext;
import com.rohit.converter.Java8Parser.ElementValueContext;
import com.rohit.converter.Java8Parser.ElementValueListContext;
import com.rohit.converter.Java8Parser.ElementValuePairContext;
import com.rohit.converter.Java8Parser.ElementValuePairListContext;
import com.rohit.converter.Java8Parser.EmptyStatementContext;
import com.rohit.converter.Java8Parser.EnhancedForStatementContext;
import com.rohit.converter.Java8Parser.EnhancedForStatementNoShortIfContext;
import com.rohit.converter.Java8Parser.EnumBodyContext;
import com.rohit.converter.Java8Parser.EnumBodyDeclarationsContext;
import com.rohit.converter.Java8Parser.EnumConstantContext;
import com.rohit.converter.Java8Parser.EnumConstantListContext;
import com.rohit.converter.Java8Parser.EnumConstantModifierContext;
import com.rohit.converter.Java8Parser.EnumConstantNameContext;
import com.rohit.converter.Java8Parser.EnumDeclarationContext;
import com.rohit.converter.Java8Parser.EqualityExpressionContext;
import com.rohit.converter.Java8Parser.ExceptionTypeContext;
import com.rohit.converter.Java8Parser.ExceptionTypeListContext;
import com.rohit.converter.Java8Parser.ExclusiveOrExpressionContext;
import com.rohit.converter.Java8Parser.ExplicitConstructorInvocationContext;
import com.rohit.converter.Java8Parser.ExpressionContext;
import com.rohit.converter.Java8Parser.ExpressionNameContext;
import com.rohit.converter.Java8Parser.ExpressionStatementContext;
import com.rohit.converter.Java8Parser.ExtendsInterfacesContext;
import com.rohit.converter.Java8Parser.FieldAccessContext;
import com.rohit.converter.Java8Parser.FieldAccess_lf_primaryContext;
import com.rohit.converter.Java8Parser.FieldAccess_lfno_primaryContext;
import com.rohit.converter.Java8Parser.FieldDeclarationContext;
import com.rohit.converter.Java8Parser.FieldModifierContext;
import com.rohit.converter.Java8Parser.Finally_Context;
import com.rohit.converter.Java8Parser.FloatingPointTypeContext;
import com.rohit.converter.Java8Parser.ForInitContext;
import com.rohit.converter.Java8Parser.ForStatementContext;
import com.rohit.converter.Java8Parser.ForStatementNoShortIfContext;
import com.rohit.converter.Java8Parser.ForUpdateContext;
import com.rohit.converter.Java8Parser.FormalParameterContext;
import com.rohit.converter.Java8Parser.FormalParameterListContext;
import com.rohit.converter.Java8Parser.FormalParametersContext;
import com.rohit.converter.Java8Parser.IfThenElseStatementContext;
import com.rohit.converter.Java8Parser.IfThenElseStatementNoShortIfContext;
import com.rohit.converter.Java8Parser.IfThenStatementContext;
import com.rohit.converter.Java8Parser.ImportDeclarationContext;
import com.rohit.converter.Java8Parser.InclusiveOrExpressionContext;
import com.rohit.converter.Java8Parser.InferredFormalParameterListContext;
import com.rohit.converter.Java8Parser.InstanceInitializerContext;
import com.rohit.converter.Java8Parser.IntegralTypeContext;
import com.rohit.converter.Java8Parser.InterfaceBodyContext;
import com.rohit.converter.Java8Parser.InterfaceDeclarationContext;
import com.rohit.converter.Java8Parser.InterfaceMemberDeclarationContext;
import com.rohit.converter.Java8Parser.InterfaceMethodDeclarationContext;
import com.rohit.converter.Java8Parser.InterfaceMethodModifierContext;
import com.rohit.converter.Java8Parser.InterfaceModifierContext;
import com.rohit.converter.Java8Parser.InterfaceTypeContext;
import com.rohit.converter.Java8Parser.InterfaceTypeListContext;
import com.rohit.converter.Java8Parser.InterfaceType_lf_classOrInterfaceTypeContext;
import com.rohit.converter.Java8Parser.InterfaceType_lfno_classOrInterfaceTypeContext;
import com.rohit.converter.Java8Parser.LabeledStatementContext;
import com.rohit.converter.Java8Parser.LabeledStatementNoShortIfContext;
import com.rohit.converter.Java8Parser.LambdaBodyContext;
import com.rohit.converter.Java8Parser.LambdaExpressionContext;
import com.rohit.converter.Java8Parser.LambdaParametersContext;
import com.rohit.converter.Java8Parser.LastFormalParameterContext;
import com.rohit.converter.Java8Parser.LeftHandSideContext;
import com.rohit.converter.Java8Parser.LiteralContext;
import com.rohit.converter.Java8Parser.LocalVariableDeclarationContext;
import com.rohit.converter.Java8Parser.LocalVariableDeclarationStatementContext;
import com.rohit.converter.Java8Parser.MarkerAnnotationContext;
import com.rohit.converter.Java8Parser.MethodBodyContext;
import com.rohit.converter.Java8Parser.MethodDeclarationContext;
import com.rohit.converter.Java8Parser.MethodDeclaratorContext;
import com.rohit.converter.Java8Parser.MethodHeaderContext;
import com.rohit.converter.Java8Parser.MethodInvocationContext;
import com.rohit.converter.Java8Parser.MethodInvocation_lf_primaryContext;
import com.rohit.converter.Java8Parser.MethodInvocation_lfno_primaryContext;
import com.rohit.converter.Java8Parser.MethodModifierContext;
import com.rohit.converter.Java8Parser.MethodNameContext;
import com.rohit.converter.Java8Parser.MethodReferenceContext;
import com.rohit.converter.Java8Parser.MethodReference_lf_primaryContext;
import com.rohit.converter.Java8Parser.MethodReference_lfno_primaryContext;
import com.rohit.converter.Java8Parser.MultiplicativeExpressionContext;
import com.rohit.converter.Java8Parser.NormalAnnotationContext;
import com.rohit.converter.Java8Parser.NormalClassDeclarationContext;
import com.rohit.converter.Java8Parser.NormalInterfaceDeclarationContext;
import com.rohit.converter.Java8Parser.NumericTypeContext;
import com.rohit.converter.Java8Parser.PackageDeclarationContext;
import com.rohit.converter.Java8Parser.PackageModifierContext;
import com.rohit.converter.Java8Parser.PackageNameContext;
import com.rohit.converter.Java8Parser.PackageOrTypeNameContext;
import com.rohit.converter.Java8Parser.PostDecrementExpressionContext;
import com.rohit.converter.Java8Parser.PostDecrementExpression_lf_postfixExpressionContext;
import com.rohit.converter.Java8Parser.PostIncrementExpressionContext;
import com.rohit.converter.Java8Parser.PostIncrementExpression_lf_postfixExpressionContext;
import com.rohit.converter.Java8Parser.PostfixExpressionContext;
import com.rohit.converter.Java8Parser.PreDecrementExpressionContext;
import com.rohit.converter.Java8Parser.PreIncrementExpressionContext;
import com.rohit.converter.Java8Parser.PrimaryContext;
import com.rohit.converter.Java8Parser.PrimaryNoNewArrayContext;
import com.rohit.converter.Java8Parser.PrimaryNoNewArray_lf_arrayAccessContext;
import com.rohit.converter.Java8Parser.PrimaryNoNewArray_lf_primaryContext;
import com.rohit.converter.Java8Parser.PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext;
import com.rohit.converter.Java8Parser.PrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryContext;
import com.rohit.converter.Java8Parser.PrimaryNoNewArray_lfno_arrayAccessContext;
import com.rohit.converter.Java8Parser.PrimaryNoNewArray_lfno_primaryContext;
import com.rohit.converter.Java8Parser.PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext;
import com.rohit.converter.Java8Parser.PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext;
import com.rohit.converter.Java8Parser.PrimitiveTypeContext;
import com.rohit.converter.Java8Parser.ReceiverParameterContext;
import com.rohit.converter.Java8Parser.ReferenceTypeContext;
import com.rohit.converter.Java8Parser.RelationalExpressionContext;
import com.rohit.converter.Java8Parser.ResourceContext;
import com.rohit.converter.Java8Parser.ResourceListContext;
import com.rohit.converter.Java8Parser.ResourceSpecificationContext;
import com.rohit.converter.Java8Parser.ResultContext;
import com.rohit.converter.Java8Parser.ReturnStatementContext;
import com.rohit.converter.Java8Parser.ShiftExpressionContext;
import com.rohit.converter.Java8Parser.SimpleTypeNameContext;
import com.rohit.converter.Java8Parser.SingleElementAnnotationContext;
import com.rohit.converter.Java8Parser.SingleStaticImportDeclarationContext;
import com.rohit.converter.Java8Parser.SingleTypeImportDeclarationContext;
import com.rohit.converter.Java8Parser.StatementContext;
import com.rohit.converter.Java8Parser.StatementExpressionContext;
import com.rohit.converter.Java8Parser.StatementExpressionListContext;
import com.rohit.converter.Java8Parser.StatementNoShortIfContext;
import com.rohit.converter.Java8Parser.StatementWithoutTrailingSubstatementContext;
import com.rohit.converter.Java8Parser.StaticImportOnDemandDeclarationContext;
import com.rohit.converter.Java8Parser.StaticInitializerContext;
import com.rohit.converter.Java8Parser.SuperclassContext;
import com.rohit.converter.Java8Parser.SuperinterfacesContext;
import com.rohit.converter.Java8Parser.SwitchBlockContext;
import com.rohit.converter.Java8Parser.SwitchBlockStatementGroupContext;
import com.rohit.converter.Java8Parser.SwitchLabelContext;
import com.rohit.converter.Java8Parser.SwitchLabelsContext;
import com.rohit.converter.Java8Parser.SwitchStatementContext;
import com.rohit.converter.Java8Parser.SynchronizedStatementContext;
import com.rohit.converter.Java8Parser.ThrowStatementContext;
import com.rohit.converter.Java8Parser.Throws_Context;
import com.rohit.converter.Java8Parser.TryStatementContext;
import com.rohit.converter.Java8Parser.TryWithResourcesStatementContext;
import com.rohit.converter.Java8Parser.TypeArgumentContext;
import com.rohit.converter.Java8Parser.TypeArgumentListContext;
import com.rohit.converter.Java8Parser.TypeArgumentsContext;
import com.rohit.converter.Java8Parser.TypeArgumentsOrDiamondContext;
import com.rohit.converter.Java8Parser.TypeBoundContext;
import com.rohit.converter.Java8Parser.TypeContext;
import com.rohit.converter.Java8Parser.TypeDeclarationContext;
import com.rohit.converter.Java8Parser.TypeImportOnDemandDeclarationContext;
import com.rohit.converter.Java8Parser.TypeNameContext;
import com.rohit.converter.Java8Parser.TypeParameterContext;
import com.rohit.converter.Java8Parser.TypeParameterListContext;
import com.rohit.converter.Java8Parser.TypeParameterModifierContext;
import com.rohit.converter.Java8Parser.TypeParametersContext;
import com.rohit.converter.Java8Parser.TypeVariableContext;
import com.rohit.converter.Java8Parser.UnannArrayTypeContext;
import com.rohit.converter.Java8Parser.UnannClassOrInterfaceTypeContext;
import com.rohit.converter.Java8Parser.UnannClassTypeContext;
import com.rohit.converter.Java8Parser.UnannClassType_lf_unannClassOrInterfaceTypeContext;
import com.rohit.converter.Java8Parser.UnannClassType_lfno_unannClassOrInterfaceTypeContext;
import com.rohit.converter.Java8Parser.UnannInterfaceTypeContext;
import com.rohit.converter.Java8Parser.UnannInterfaceType_lf_unannClassOrInterfaceTypeContext;
import com.rohit.converter.Java8Parser.UnannInterfaceType_lfno_unannClassOrInterfaceTypeContext;
import com.rohit.converter.Java8Parser.UnannPrimitiveTypeContext;
import com.rohit.converter.Java8Parser.UnannReferenceTypeContext;
import com.rohit.converter.Java8Parser.UnannTypeContext;
import com.rohit.converter.Java8Parser.UnannTypeVariableContext;
import com.rohit.converter.Java8Parser.UnaryExpressionContext;
import com.rohit.converter.Java8Parser.UnaryExpressionNotPlusMinusContext;
import com.rohit.converter.Java8Parser.VariableDeclaratorContext;
import com.rohit.converter.Java8Parser.VariableDeclaratorIdContext;
import com.rohit.converter.Java8Parser.VariableDeclaratorListContext;
import com.rohit.converter.Java8Parser.VariableInitializerContext;
import com.rohit.converter.Java8Parser.VariableInitializerListContext;
import com.rohit.converter.Java8Parser.VariableModifierContext;
import com.rohit.converter.Java8Parser.WhileStatementContext;
import com.rohit.converter.Java8Parser.WhileStatementNoShortIfContext;
import com.rohit.converter.Java8Parser.WildcardBoundsContext;
import com.rohit.converter.Java8Parser.WildcardContext;

/**
 * 
 * @author rohitmohan96
 * 
 */
public class Main {

	static String lastFormalParameter, forinit, forlimit, forConditionOperator,
			forCounterDatatype, lastActualParameter = "",
			variableModifier = "", variableListType = "";
	static boolean enterif = false;
	static boolean enterfor = false;
	static boolean enterwhile = false;
	static boolean enterelse = false;
	static boolean enterresult = false;
	static boolean enterswitch = false;
	static boolean enterArgumentList = false;
	static boolean multipleVariables = false;

	static int lastActualParameterIndex = 0, numOfArguments = 0;

	static Stack<String> operators = new Stack<String>();
	static String lastInterface;
	protected static String firstVariableInList;
	protected static boolean enterTypeArgumentsList;
	protected static boolean enterTypeParametersList;
	protected static boolean enterConstructor;

	/**
	 * Main Method
	 * 
	 * @author rohitmohan96
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		if (args.length != 2) {
			System.err
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

				}

				public void exitVariableDeclaratorId(
						VariableDeclaratorIdContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitLocalVariableDeclarationStatement(
						LocalVariableDeclarationStatementContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitFieldDeclaration(FieldDeclarationContext ctx) {
					// TODO Auto-generated method stub

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
						bw.write(ctx.getChild(count - 1).toString());
						if (enterelse) {
							bw.write(" else ");
							enterelse = false;
						} else {
							bw.write("\n");
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				public void enterUnannPrimitiveType(
						UnannPrimitiveTypeContext ctx) {
					// TODO Auto-generated method stub
					String type = ctx.getText();
					String ceylonType = "";

					try {
						if (!enterfor && !enterresult) {
							if (!variableModifier.equals("final") && !enterConstructor) {
								bw.write("variable ");
								variableListType = "variable ";
							}
						}
						variableModifier = "";

						if (type.equals("int") || type.equals("short")
								|| type.equals("long")) {
							ceylonType = "Integer ";
						} else if (type.equals("byte")) {
							ceylonType = "Byte ";
						} else if (type.equals("char")) {
							ceylonType = "Character ";
						} else if (type.equals("float")
								|| type.equals("double")) {
							ceylonType = "Float ";
						} else if (type.equals("boolean")) {
							ceylonType = "Boolean ";
						} else {
							ceylonType = type + " ";
						}

						variableListType += ceylonType;

						if (!enterConstructor)
							bw.write(ceylonType);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				public void enterResult(ResultContext ctx) {
					// TODO Auto-generated method stub
					try {
						enterresult = true;
						if (ctx.getChild(0).toString().equals("void"))
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

					for (int i = 0; i < ctx.classModifier().size(); i++) {
						String mod = ctx.classModifier(i).getText();
						if (mod.equals("public"))
							modifier = "shared ";
						else if (mod.equals("abstract"))
							modifier = "abstract ";

					}

					try {
						if (ctx.typeParameters() == null)
							bw.write(modifier + "class " + ctx.Identifier()
									+ "() ");
						else {
							enterTypeParametersList = true;
							bw.write(modifier + "class " + ctx.Identifier());
						}

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				public void enterMethodModifier(MethodModifierContext ctx) {
					// TODO Auto-generated method stub
					try {
						if (ctx.getText().equals("public"))
							bw.write("shared ");
						else if (ctx.getText().equals("abstract"))
							bw.write("formal ");
					} catch (IOException e) {
						e.printStackTrace();
					}

				}

				public void enterMethodDeclarator(MethodDeclaratorContext ctx) {
					// TODO Auto-generated method stub

					try {
						bw.write(ctx.Identifier() + "(");
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
					multipleVariables = false;
				}

				public void exitVariableDeclarator(VariableDeclaratorContext ctx) {
					// TODO Auto-generated method stub
					try {
						if (!enterfor)
							bw.write(";\n");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				public void exitUnaryExpressionNotPlusMinus(
						UnaryExpressionNotPlusMinusContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitUnaryExpression(UnaryExpressionContext ctx) {
					// TODO Auto-generated method stub
					try {
						if (!operators.isEmpty()) {
							bw.write(" " + operators.lastElement() + " ");
							operators.pop();
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
					try {
						bw.write(">()");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
					try {
						bw.write("(");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				public void exitTypeArguments(TypeArgumentsContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitTypeArgumentList(TypeArgumentListContext ctx) {
					// TODO Auto-generated method stub
					try {
						enterTypeArgumentsList = false;
						bw.write("> ");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
					try {
						if (ctx.getChild(0).toString().equals("case"))
							bw.write(") {\n");
						else
							bw.write("{\n");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				public void exitSwitchBlockStatementGroup(
						SwitchBlockStatementGroupContext ctx) {
					// TODO Auto-generated method stub
					try {
						bw.write("}\n");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				public void exitSwitchBlock(SwitchBlockContext ctx) {
					// TODO Auto-generated method stub
					try {
						bw.write("\n");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
					try {
						bw.write(";\n");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				public void exitResult(ResultContext ctx) {
					// TODO Auto-generated method stub
					enterresult = false;
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
					// TODO Auto-generated method stubtry {
					try {
						bw.write(")");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

				public void exitMethodInvocation_lf_primary(
						MethodInvocation_lf_primaryContext ctx) {
					// TODO Auto-generated method stub

				}

				public void exitMethodInvocation(MethodInvocationContext ctx) {
					// TODO Auto-generated method stub
					try {
						bw.write(")");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				public void exitMethodHeader(MethodHeaderContext ctx) {
					// TODO Auto-generated method stub
				}

				public void exitMethodDeclarator(MethodDeclaratorContext ctx) {
					// TODO Auto-generated method stub
					try {
						bw.write(") ");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
					if (!ctx.getText().equals(lastInterface)) {
						try {
							bw.write(" & ");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

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
					int count = ctx.getChildCount();

					try {
						bw.write(ctx.getChild(count - 1).toString());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
					try {
						if (!ctx.variableDeclaratorId().getText()
								.equals(lastFormalParameter)
								&& !enterConstructor)
							bw.write(", ");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				public void exitForUpdate(ForUpdateContext ctx) {
					// TODO change by(1) according to step
					try {
						bw.write(".by(1))");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					enterfor = false;
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
					try {
						forCounterDatatype = ctx.getChild(0).getChild(0)
								.getText();
						bw.write(" in (" + forinit);
					} catch (IOException e) {
						e.getStackTrace();
					}
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

					try {

						if (enterif || enterwhile || enterswitch) {
							bw.write(")");
							enterif = enterwhile = enterswitch = false;
						} else if (enterArgumentList) {
							numOfArguments++;
							if (!(ctx.getText().equals(lastActualParameter) && lastActualParameterIndex == numOfArguments)) {
								bw.write(", ");
							}
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

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
					enterConstructor = false;
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
					try {
						bw.write(")");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
					try {
						bw.write(") ");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
					enterArgumentList = false;
					numOfArguments = 0;
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
					try {
						if ((ctx.getChild(0).getText() + ctx.wildcardBounds()
								.getChild(0)).equals("?extends"))
							bw.write("out ");
						else if ((ctx.getChild(0).getText() + ctx
								.wildcardBounds().getChild(0)).equals("?super"))
							bw.write("in ");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

				public void enterWhileStatementNoShortIf(
						WhileStatementNoShortIfContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterWhileStatement(WhileStatementContext ctx) {
					// TODO Auto-generated method stub
					try {
						bw.write("while(");
						enterwhile = true;
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				public void enterVariableModifier(VariableModifierContext ctx) {
					// TODO Auto-generated method stub

					variableModifier = ctx.getText();
				}

				public void enterVariableInitializerList(
						VariableInitializerListContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterVariableInitializer(
						VariableInitializerContext ctx) {
					// TODO Auto-generated method stub
					try {
						if (!enterfor)
							bw.write(" = ");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				public void enterVariableDeclaratorList(
						VariableDeclaratorListContext ctx) {
					// TODO Auto-generated method stub
					firstVariableInList = ctx.getChild(0).getText();

					if (ctx.getChildCount() > 1) {
						multipleVariables = true;
					}
				}

				public void enterVariableDeclaratorId(
						VariableDeclaratorIdContext ctx) {
					// TODO Auto-generated method stub
					try {
						if (!enterConstructor)
							bw.write(ctx.getText());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				public void enterVariableDeclarator(
						VariableDeclaratorContext ctx) {
					// TODO Auto-generated method stub
					if (multipleVariables
							&& !ctx.getText().equals(firstVariableInList)) {
						try {
							bw.write(variableListType);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
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
					String type = ctx.getChild(0).getText();
					String ceylonType = "";

					try {
						if (!enterfor && !enterresult) {
							if (!variableModifier.equals("final")) {
								bw.write("variable ");
								variableListType = "variable ";
							}
						}
						variableModifier = "";

						ceylonType = type + " ";

						variableListType += ceylonType;

						bw.write(ceylonType);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

				public void enterUnannClassType_lf_unannClassOrInterfaceType(
						UnannClassType_lf_unannClassOrInterfaceTypeContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterUnannClassType(UnannClassTypeContext ctx) {
					// TODO Auto-generated method stub
					try {
						bw.write(ctx.getText() + " ");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
					try {
						bw.write("<");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
					try {
						bw.write(ctx.getText());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
					try {
						enterTypeArgumentsList = true;
						bw.write("<");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
					try {
						bw.write("try ");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
					try {
						bw.write("switch(");
						enterswitch = true;
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				public void enterSwitchLabels(SwitchLabelsContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterSwitchLabel(SwitchLabelContext ctx) {
					// TODO Auto-generated method stub
					try {
						if (ctx.getChild(0).toString().equals("case"))
							bw.write(ctx.getChild(0) + "(");
						else
							bw.write("else ");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				public void enterSwitchBlockStatementGroup(
						SwitchBlockStatementGroupContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterSwitchBlock(SwitchBlockContext ctx) {
					// TODO Auto-generated method stub
					try {
						bw.write("\n");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				public void enterSuperinterfaces(SuperinterfacesContext ctx) {
					// TODO Auto-generated method stub
					try {
						bw.write("satisfies ");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				public void enterSuperclass(SuperclassContext ctx) {
					// TODO Auto-generated method stub
					try {
						bw.write(ctx.getChild(0).getText() + " "
								+ ctx.getChild(1).getText() + "() ");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
					try {
						bw.write("return ");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
					if (ctx.getChildCount() > 1)
						if (!enterfor)
							operators.push(ctx.getChild(1).getText());
						else
							forConditionOperator = ctx.getChild(1).getText();
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
					String modifier = " ";
					if (ctx.interfaceModifier(0).getText().equals("public"))
						modifier = "shared ";

					try {
						bw.write(modifier + "interface " + ctx.Identifier()
								+ " ");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
					try {
						int a = ctx.getChildCount();
						String str = "";

						for (int i = 0; i < a; i++) {
							if (ctx.getChild(i).getText().equals("("))
								break;

							str += ctx.getChild(i).getText();

						}

						if (str.equals("System.out.println")) {
							bw.write("print");
							if (ctx.argumentList() == null)
								bw.write("\"\"");
						} else if (str.equals("System.out.print")) {
							bw.write("process.write");
						} else {
							bw.write(str);
							if (ctx.argumentList() == null)
								bw.write("(");
						}

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

				public void enterMethodInvocation_lf_primary(
						MethodInvocation_lf_primaryContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterMethodInvocation(MethodInvocationContext ctx) {
					// TODO Auto-generated method stub

					try {
						int a = ctx.getChildCount();
						String str = "";

						for (int i = 0; i < a; i++) {
							if (ctx.getChild(i).getText().equals("("))
								break;

							str += ctx.getChild(i).getText();

						}

						if (str.equals("System.out.println")) {
							bw.write("print");
							if (ctx.argumentList() == null)
								bw.write("\"\"");
						} else if (str.equals("System.out.print")) {
							bw.write("process.write");
						} else {
							bw.write(str);
							if (ctx.argumentList() == null)
								bw.write("(");
						}

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				public void enterMethodHeader(MethodHeaderContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterMethodDeclaration(MethodDeclarationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterMethodBody(MethodBodyContext ctx) {
					// TODO Auto-generated method stub
					if (ctx.getText().equals(";"))
						try {
							bw.write(";\n");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}

				public void enterMarkerAnnotation(MarkerAnnotationContext ctx) {
					// TODO Auto-generated method stub
					if (ctx.typeName().getText().equals("Override")) {
						try {
							bw.write("actual ");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
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
					try {
						if (!enterfor) {
							bw.write(ctx.getText());
						} else {
							forinit = ctx.getText();
							forlimit = forinit;
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				public void enterLeftHandSide(LeftHandSideContext ctx) {
					// TODO Auto-generated method stub
					if (enterfor)
						try {
							bw.write(ctx.getText());
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}

				public void enterLastFormalParameter(
						LastFormalParameterContext ctx) {
					// TODO Auto-generated method stub
					lastFormalParameter = ctx.formalParameter()
							.variableDeclaratorId().getText();
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
					lastInterface = ctx.getChild(ctx.getChildCount() - 1)
							.getText();

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
					if (ctx.getText().equals("public"))
						try {
							bw.write("shared ");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
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
					try {
						bw.write(ctx.getChild(0).toString() + "\n");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
					if (ctx.getChildCount() > 1)
						operators.push(ctx.getChild(1).getText());
				}

				public void enterImportDeclaration(ImportDeclarationContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterIfThenStatement(IfThenStatementContext ctx) {
					// TODO Auto-generated method stub

					enterif = true;
					try {
						bw.write(ctx.getChild(0).getText()
								+ ctx.getChild(1).getText());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

				public void enterIfThenElseStatementNoShortIf(
						IfThenElseStatementNoShortIfContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterIfThenElseStatement(
						IfThenElseStatementContext ctx) {
					// TODO Auto-generated method stub
					enterif = true;
					enterelse = true;
					try {
						bw.write(ctx.getChild(0).getText()
								+ ctx.getChild(1).getText());
					} catch (IOException e) {
						e.printStackTrace();
					}
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
					try {

						if (forConditionOperator.equals("<=")
								|| forConditionOperator.equals(">="))
							bw.write(".." + forlimit + ")");
						else if (isNumeric(forlimit)) {
							if (forCounterDatatype.equals("int"))
								bw.write(".."
										+ (int) (Double.parseDouble(forlimit) - 1)
										+ ")");
							else
								bw.write(".."
										+ (Double.parseDouble(forlimit) - 1)
										+ ")");
						} else
							bw.write(".." + forlimit + " - 1)");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
					try {
						bw.write("finally ");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				public void enterFieldModifier(FieldModifierContext ctx) {
					// TODO Auto-generated method stub
					variableModifier = ctx.getText();
					try {
						if (!enterfor && !enterresult) {
							if (variableModifier.equals("public"))

								bw.write("shared ");

						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
					try {
						bw.write("satisfies ");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				public void enterExpressionStatement(
						ExpressionStatementContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterExpressionName(ExpressionNameContext ctx) {
					// TODO Auto-generated method stub
					try {
						if (!enterfor) {
							bw.write(ctx.getText());
						} else {
							forinit = ctx.getText();
							forlimit = forinit;
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
					if (ctx.getChildCount() > 1)
						operators.push(ctx.getChild(1).getText());
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
					if (ctx.getChildCount() > 1)
						operators.push(ctx.getChild(1).getText());
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
					enterConstructor = true;
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
					if (ctx.getChildCount() > 1)
						operators.push(ctx.getChild(1).getText());
				}

				public void enterConditionalExpression(
						ConditionalExpressionContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterConditionalAndExpression(
						ConditionalAndExpressionContext ctx) {
					// TODO Auto-generated method stub
					if (ctx.getChildCount() > 1)
						operators.push(ctx.getChild(1).getText());
				}

				public void enterCompilationUnit(CompilationUnitContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterClassType_lfno_classOrInterfaceType(
						ClassType_lfno_classOrInterfaceTypeContext ctx) {
					// TODO Auto-generated method stub
					try {
						bw.write(ctx.getText());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				public void enterClassType_lf_classOrInterfaceType(
						ClassType_lf_classOrInterfaceTypeContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterClassType(ClassTypeContext ctx) {
					// TODO Auto-generated method stub
					try {
						bw.write(ctx.getText());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
					try {
						bw.write(ctx.getChild(1).getText());

						if (ctx.argumentList() != null) {
							enterArgumentList = true;
						} else if (ctx.typeArgumentsOrDiamond() != null) {
							enterTypeArgumentsList = true;
						} else {
							bw.write("(");
						}

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
					try {
						bw.write("(");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				public void enterCatchClause(CatchClauseContext ctx) {
					// TODO Auto-generated method stub
					try {
						bw.write("catch ");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
					try {
						enterfor = true;
						bw.write(ctx.getChild(0).getText()
								+ ctx.getChild(1).getText());
					} catch (IOException e) {
						e.getStackTrace();
					}
				}

				public void enterAssignmentOperator(
						AssignmentOperatorContext ctx) {
					// TODO Auto-generated method stub
					try {
						if (!enterfor)
							bw.write(ctx.getText());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
					enterArgumentList = true;
					try {
						bw.write("(");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					lastActualParameter = ctx.getChild(ctx.getChildCount() - 1)
							.getText();
					lastActualParameterIndex = ctx.getChildCount() / 2 + 1;
					numOfArguments = 0;
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
					if (ctx.getChildCount() > 1)
						operators.push(ctx.getChild(1).getText());
				}

				public void enterAmbiguousName(AmbiguousNameContext ctx) {
					// TODO Auto-generated method stub

				}

				public void enterAdditiveExpression(
						AdditiveExpressionContext ctx) {
					// TODO Auto-generated method stub
					if (ctx.getChildCount() > 1)
						operators.push(ctx.getChild(1).getText());
				}

				public void enterAdditionalBound(AdditionalBoundContext ctx) {
					// TODO Auto-generated method stub

				}
			};
			ParseTreeWalker.DEFAULT.walk(listener, tree);

			// Use to generate a viewable AST diagram

//			JFrame frame = new JFrame("Antlr AST");
//			JPanel panel = new JPanel();
//			TreeViewer viewer = new TreeViewer(Arrays.asList(parser
//					.getRuleNames()), tree);
//			viewer.setScale(1.1);
//			panel.add(viewer);
//			JScrollPane jScrollPane = new JScrollPane(panel);
//			frame.add(jScrollPane);
//			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//			frame.setSize(500, 500);
//			frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//
//			frame.setVisible(true);

			bw.flush();
			bw.close();
		}
	}

	public static boolean isNumeric(String str) {
		return str.matches("-?\\d+(\\.\\d+)?");
	}

}