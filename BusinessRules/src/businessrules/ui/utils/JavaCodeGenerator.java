package businessrules.ui.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import org.br.excel.exceldsl.excelDSL.BasicExpression;
import org.br.excel.exceldsl.excelDSL.Excel;
import org.br.excel.exceldsl.excelDSL.Expression;
import org.br.excel.exceldsl.excelDSL.ExpressionGroup;
import org.br.excel.exceldsl.excelDSL.FunctionParameters;
import org.br.excel.exceldsl.excelDSL.InBuiltFunctionCall;
import org.br.excel.exceldsl.excelDSL.JavaClass;
import org.br.excel.exceldsl.excelDSL.JavaMemberCall;
import org.br.excel.exceldsl.excelDSL.JavaMethodCall;
import org.br.excel.exceldsl.excelDSL.Primitive;
import org.br.excel.exceldsl.excelDSL.Statement;
import org.br.excel.exceldsl.excelDSL.Variable;
import org.eclipse.core.internal.resources.BuildConfiguration;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;

import businessrulesruntime.core.engine.FieldInfo;
import businessrulesruntime.core.engine.codegen.CodeGenHelper;
import businessrulesruntime.core.engine.excel.ExcelFormulaContentProvider;
import businessrulesruntime.core.engine.excel.ExcelFunctionInfo;
import businessrulesruntime.core.engine.excel.ExcelFunctions;
import businessrulesruntime.core.engine.model.Context;
import businessrulesruntime.core.engine.model.Message;

public class JavaCodeGenerator {

	private List<FieldInfo> parameterFieldInfos;
	private int intermediateFunctionCount = 0;
	private String excelFormula;
	private EList<EObject> contents;
	private CodeGenHelper codeGenHelper;
	private Stack<String> intermediateFunctions = new Stack<String>();
	private String groupName;
	private List<String> excelFunctionsList = new ArrayList<String>();
	private String returnType;
	private StringBuffer standardParamNames;

	public JavaCodeGenerator(List<FieldInfo> parameterFieldInfos, String excelFormula, EList<EObject> contents,
			String groupName, String returnType) {
		this.parameterFieldInfos = parameterFieldInfos;
		this.excelFormula = excelFormula;
		this.contents = contents;
		this.groupName = groupName;
		this.returnType = returnType;
		this.codeGenHelper = new CodeGenHelper("");
	}

	public String generateJavaCode() throws Exception {
		StringBuffer javaCode = new StringBuffer();
		String classname = "public class ${className} extends ExcelFunctions{\n\n";
		StringBuffer importstmts = new StringBuffer();
		populateExcelfunctionsList();

		if (parameterFieldInfos == null) {
			parameterFieldInfos = new ArrayList<FieldInfo>();
		}
		for (FieldInfo fieldInfo : parameterFieldInfos) {
			codeGenHelper.addImport(fieldInfo.getDataType());
		}

		StringBuffer paramNames = new StringBuffer();
		standardParamNames = new StringBuffer();

		codeGenHelper.addImport(Message.class.getCanonicalName());
		standardParamNames.append(Message.class.getSimpleName() + " _message, ");
		codeGenHelper.addImport(Context.class.getCanonicalName());
		standardParamNames.append(Context.class.getSimpleName() + " _context");
		paramNames.append(standardParamNames.toString());
		if (parameterFieldInfos.size() > 0) {
			paramNames.append(",");
		}
		for (int index = 0; index < parameterFieldInfos.size(); index++) {
			FieldInfo fieldInfo = (FieldInfo) parameterFieldInfos.toArray()[index];
			String dataType = CodeGenHelper.getClassShortName(fieldInfo.getDataType());
			if (fieldInfo.isArray()) {
				dataType = dataType + "[]";
			}
			paramNames.append(dataType + " " + fieldInfo.getName());
			if ((index + 1) != parameterFieldInfos.size()) {
				paramNames.append(",");
			}
		}
		StringBuffer parsedExcelFormula = getParsedExcelFormula();

		for (String imports : codeGenHelper.getImports()) {
			importstmts.append("import " + imports + ";\n");
		}
		importstmts.append("import " + ExcelFunctions.class.getCanonicalName() + ";\n");
		// importstmts.append("import java.util.Map;\n");

		javaCode.append("\n" + importstmts + "\n" + classname + "\t public " + returnType + " doExecute(" + paramNames
				+ "){\n");
		javaCode.append(parsedExcelFormula);

		StringBuffer sortedIntermediateFunction = new StringBuffer();
		while (!intermediateFunctions.empty()) {
			sortedIntermediateFunction.append(intermediateFunctions.pop());
		}
		javaCode.append(";\n\t}\n" + sortedIntermediateFunction + "\n}");
		return javaCode.toString();
	}

	public StringBuffer getParsedExcelFormula() throws Exception {
		intermediateFunctionCount = 0;
		String text = excelFormula;

		StringBuffer excelFormula = new StringBuffer();
		StringBuffer parsedExcelFormula = new StringBuffer();
		if (text != null && text.trim().equals("") == false) {
			for (EObject object : contents) {
				Excel excel = (Excel) object;

				if (excel.getStatements() != null) {
					for (Statement statement : excel.getStatements()) {
						StringBuffer tempparsedExcelFormula = new StringBuffer();
						getExpression((Expression) statement.getExpression(), tempparsedExcelFormula);
						parsedExcelFormula.append("\t\t" + statement.getDataType().getDatatype() + " "
								+ statement.getVariable().getVariableName() + " = " + tempparsedExcelFormula + ";\n");

						excelFormula.append(parsedExcelFormula);
						parsedExcelFormula = new StringBuffer();
					}
				}
				if (excel.getExpression() != null) {
					getExpression(excel.getExpression(), excelFormula.append("\t\treturn "));
				}
			}
		}
		return excelFormula;
	}

	private void getExpression(Expression expression, StringBuffer parsedExcelFormula) throws Exception {
		EList<EObject> expressionList = expression.getExpression();

		/*
		 * if (expression.getAssignment() != null) { Assignment assignment =
		 * expression.getAssignment(); StringBuffer tempparsedExcelFormula = new
		 * StringBuffer(); getExpression((Expression)
		 * assignment.getExpression().get(0), tempparsedExcelFormula);
		 * parsedExcelFormula.append(assignment.getDatatype().getDatatype() +
		 * " " + tempparsedExcelFormula + ";\n"); }
		 */
		if (expressionList != null) {
			if (expressionList.size() > 0) {
				EObject expressionObject = expressionList.get(0);
				if (expressionObject instanceof BasicExpression) {
					BasicExpression basicExpression = (BasicExpression) expressionObject;
					if (basicExpression.getPrimitive() != null) {
						Primitive primitive = (Primitive) basicExpression.getPrimitive();
						getPrimitive(primitive, parsedExcelFormula);
					} else if (basicExpression.getVariable() != null) {
						Variable variable = (Variable) basicExpression.getVariable();
						parsedExcelFormula
								.append("_message.get" + Character.toUpperCase(variable.getVariableName().charAt(0))
										+ variable.getVariableName().substring(1) + "()");
					} else if (basicExpression.getInBuiltFunctionCall() != null) {
						InBuiltFunctionCall inBuiltFunctionCall = (InBuiltFunctionCall) basicExpression
								.getInBuiltFunctionCall();
						getInBuiltFunctionCall(inBuiltFunctionCall, parsedExcelFormula);
					} else if (basicExpression.getJavaClass() != null) {
						JavaClass javaClass = (JavaClass) basicExpression.getJavaClass();
						getJavaClassCall(javaClass, parsedExcelFormula);
					} else if (basicExpression.getExpressionGroup() != null) {
						ExpressionGroup expressionGroup = (ExpressionGroup) basicExpression.getExpressionGroup();
						getExpressionGroup(expressionGroup, parsedExcelFormula);
					}

				}
			}
		}
		if (expression.getOperator() != null && expressionList.size() > 1) {
			parsedExcelFormula.append(" " + expression.getOperator().getOperator() + " ");
			getExpression((Expression) expressionList.get(1), parsedExcelFormula);
		}
	}

	private void getPrimitive(Primitive primitive, StringBuffer parsedExcelFormula) {
		if (primitive.getBooleanValue() != null) {
			parsedExcelFormula.append(primitive.getBooleanValue());
		} else if (primitive.getDoubleValue() != null) {
			parsedExcelFormula.append(primitive.getDoubleValue());
		} else if (primitive.getFloatValue() != null) {
			parsedExcelFormula.append(primitive.getFloatValue());
		} else if (primitive.getIntValue() != null) {
			parsedExcelFormula.append(primitive.getIntValue());
		} else if (primitive.getStrValue() != null) {
			parsedExcelFormula.append(primitive.getStrValue());
		}

	}

	private void getExpressionGroup(ExpressionGroup expressionGroup, StringBuffer parsedExcelFormula) throws Exception {
		Expression expression = (Expression) expressionGroup;
		parsedExcelFormula.append("(");
		getExpression(expression, parsedExcelFormula);
		parsedExcelFormula.append(")");
	}

	private void getJavaClassCall(JavaClass javaClass, StringBuffer parsedExcelFormula) throws Exception {
		parsedExcelFormula.append(javaClass.getJavaObjectName());
		List<String> staticImportClassNames = ExcelFormulaContentProvider.getInstance().getStaticImportClassNames();
		for (String fullyQualifiedClassName : staticImportClassNames) {
			String className = fullyQualifiedClassName.substring(fullyQualifiedClassName.lastIndexOf(".") + 1);
			if (className.equals(javaClass.getJavaObjectName())) {
				codeGenHelper.addImport(fullyQualifiedClassName);
			}
		}
		if (javaClass.getJavaMemberCall() != null) {
			JavaMemberCall javaMemberCall = (JavaMemberCall) javaClass.getJavaMemberCall();
			parsedExcelFormula.append("." + javaMemberCall.getAccessName());
		} else if (javaClass.getJavaMethodCall() != null) {
			JavaMethodCall javaMethodCall = (JavaMethodCall) javaClass.getJavaMethodCall();
			getJavaObjectFunction(javaMethodCall, parsedExcelFormula);
		}
	}

	private void getJavaObjectFunction(JavaMethodCall javaMethodCall, StringBuffer parsedExcelFormula)
			throws Exception {
		for (String accessName : javaMethodCall.getAccessName()) {
			parsedExcelFormula.append("." + accessName);
		}
		parsedExcelFormula.append("(");
		if (javaMethodCall.getFunctionParameters() != null) {
			FunctionParameters functionParameters = (FunctionParameters) javaMethodCall.getFunctionParameters();
			getFunctionParameters(functionParameters, parsedExcelFormula, ",");
		}
		parsedExcelFormula.append(")");
		if (javaMethodCall.getJavaMethodCall() != null) {
			for (JavaMethodCall javaObjFunc : javaMethodCall.getJavaMethodCall()) {
				getJavaObjectFunction((JavaMethodCall) javaObjFunc, parsedExcelFormula);
			}
		}
	}

	private void getFunctionParameters(FunctionParameters functionParameters, StringBuffer parsedExcelFormula,
			String delimiter) throws Exception {
		for (Iterator<Expression> iterator = functionParameters.getParameter().iterator(); iterator.hasNext();) {
			Expression expression = (Expression) iterator.next();
			getExpression(expression, parsedExcelFormula);
			if (iterator.hasNext()) {
				parsedExcelFormula.append(delimiter);
			}
		}
	}

	private void getInBuiltFunctionCall(InBuiltFunctionCall inBuiltFunctionCall, StringBuffer parsedExcelFormula)
			throws Exception {
		String excelFunctionName = inBuiltFunctionCall.getExcelFunction().getExcelFunctionName();
		FunctionParameters functionParameters = (FunctionParameters) inBuiltFunctionCall.getFunctionParameters();
		if (excelFunctionName.equals("IF")) {
			generateIFFunction(functionParameters, parsedExcelFormula);
		} else if (excelFunctionName.equals("AND") || excelFunctionName.equals("OR")) {
			StringBuffer tempParsedExcelFormula = new StringBuffer();
			String symbol = new String();
			if (excelFunctionName.equals("OR")) {
				symbol = "||";
			} else if (excelFunctionName.equals("AND")) {
				symbol = "&&";
			}
			StringBuffer intermediateBuffer = new StringBuffer();
			intermediateBuffer.append("\n\tpublic static boolean INTFUN" + intermediateFunctionCount + "("
					+ standardParamNames + ((parameterFieldInfos.size() > 0) ? "," : "")
					+ getParameterNamesWithDataType() + ") {\n\t\t " + "\t\t\treturn (");
			parsedExcelFormula.append("INTFUN" + intermediateFunctionCount + "(_message, _context"
					+ ((parameterFieldInfos.size() > 0) ? "," : "") + getParameterNamesWithoutDataType() + ")");
			intermediateFunctionCount++;
			for (int index = 0; index < functionParameters.getParameter().size(); index++) {
				tempParsedExcelFormula = new StringBuffer();
				getExpression(functionParameters.getParameter().get(index), tempParsedExcelFormula);
				intermediateBuffer.append(tempParsedExcelFormula);
				if (!(index + 1 == functionParameters.getParameter().size())) {
					intermediateBuffer.append(symbol);
				}
			}
			intermediateBuffer.append(");\n\t}\n");
			intermediateFunctions.push(intermediateBuffer.toString());
		} else if (excelFunctionName.equals("SWITCH")) {
			generateSwitchFunction(functionParameters, parsedExcelFormula);
		} else if (excelFunctionName.equals("SUM")) {
			StringBuffer tempParsedExcelFormula = new StringBuffer();
			getFunctionParameters(functionParameters, tempParsedExcelFormula, ",");
			parsedExcelFormula.append("SUM(new int[] {" + tempParsedExcelFormula + "})");
		} else if (inBuiltFunctionCall.getExcelFunction().getExcelFunctionName().equals("CONCATENATE")) {
			StringBuffer tempParsedExcelFormula = new StringBuffer();
			getFunctionParameters(functionParameters, tempParsedExcelFormula, ",");
			parsedExcelFormula.append("CONCATENATE(new String[]{" + tempParsedExcelFormula + "})");
		} else if (inBuiltFunctionCall.getExcelFunction().getExcelFunctionName().equals("ISSUCCESS")) {
			parsedExcelFormula.append("_context.ISSUCCESS()");
		} else /*
				 * } Show error incase not available in list if
				 * (excelFunctionsList.contains(excelFunctionName))
				 */ {
			StringBuffer tempParsedExcelFormula = new StringBuffer();
			getFunctionParameters(functionParameters, tempParsedExcelFormula, ",");
			parsedExcelFormula.append(
					inBuiltFunctionCall.getExcelFunction().getExcelFunctionName() + "(" + tempParsedExcelFormula + ")");
		}
	}

	private void generateIFFunction(FunctionParameters functionParameters, StringBuffer parsedExcelFormula)
			throws Exception {
		StringBuffer intermediateStmtBuffer = new StringBuffer();
		intermediateStmtBuffer.append("\n\tpublic static Object INTFUN" + intermediateFunctionCount + "("
				+ standardParamNames + ((parameterFieldInfos.size() > 0) ? "," : "") + getParameterNamesWithDataType()
				+ ") {\n\t\tif (");
		parsedExcelFormula.append("INTFUN" + intermediateFunctionCount++ + "(_message, _context"
				+ ((parameterFieldInfos.size() > 0) ? "," : "") + getParameterNamesWithoutDataType() + ")");
		getExpression(functionParameters.getParameter().get(0), intermediateStmtBuffer);
		intermediateStmtBuffer.append(") {\n\t\t\treturn ");
		getExpression(functionParameters.getParameter().get(1), intermediateStmtBuffer);
		intermediateStmtBuffer.append(";\n\t\t} else {\n\t\t\treturn ");
		getExpression(functionParameters.getParameter().get(2), intermediateStmtBuffer);
		intermediateStmtBuffer.append(";\n\t\t}\n\t}\n");
		intermediateFunctions.push(intermediateStmtBuffer.toString());
	}

	private void generateSwitchFunction(FunctionParameters functionParameters, StringBuffer parsedExcelFormula)
			throws Exception {
		int parametersSize = functionParameters.getParameter().size();
		if (parametersSize >= 3) {

			StringBuffer tempParsedExcelFormula = new StringBuffer();
			StringBuffer intermediateStmtBuffer = new StringBuffer();
			intermediateStmtBuffer.append("\n\tpublic static Object INTFUN" + intermediateFunctionCount + "("
					+ standardParamNames + ((parameterFieldInfos.size() > 0) ? "," : "")
					+ getParameterNamesWithDataType() + ") {\n\t\tObject expression=");
			parsedExcelFormula.append("INTFUN" + intermediateFunctionCount + "(_message, _context"
					+ ((parameterFieldInfos.size() > 0) ? "," : "") + getParameterNamesWithoutDataType() + ")");
			intermediateFunctionCount++;
			getExpression(functionParameters.getParameter().get(0), tempParsedExcelFormula);
			intermediateStmtBuffer.append(tempParsedExcelFormula + ";");
			int paramsLength = parametersSize;
			if ((paramsLength % 2) == 0) {
				paramsLength = parametersSize - 2;
			} else {
				paramsLength = parametersSize;
			}
			for (int index = 1; index < paramsLength; index++) {
				tempParsedExcelFormula = new StringBuffer();
				getExpression(functionParameters.getParameter().get(index), tempParsedExcelFormula);
				intermediateStmtBuffer.append("\n\t\tif(expression.equals(" + tempParsedExcelFormula + ")){");
				tempParsedExcelFormula = new StringBuffer();
				getExpression(functionParameters.getParameter().get(++index), tempParsedExcelFormula);
				intermediateStmtBuffer.append("\n\t\t\treturn " + tempParsedExcelFormula + ";\n\t\t}");
			}
			tempParsedExcelFormula = new StringBuffer();
			getExpression(functionParameters.getParameter().get(parametersSize - 1), tempParsedExcelFormula);
			intermediateStmtBuffer.append("\n\t\treturn " + tempParsedExcelFormula + ";\n\t}\n");

			intermediateFunctions.push(intermediateStmtBuffer.toString());
		} else {
			throw new Exception("Invalid number of arguments");
		}

	}

	private StringBuffer getParameterNamesWithDataType() {
		StringBuffer paramNamesWithDatatype = new StringBuffer();
		for (int index = 0; index < parameterFieldInfos.size(); index++) {
			FieldInfo fieldInfo = (FieldInfo) parameterFieldInfos.toArray()[index];
			paramNamesWithDatatype
					.append(CodeGenHelper.getClassShortName(fieldInfo.getDataType()) + " " + fieldInfo.getName());
			if ((index + 1) != parameterFieldInfos.size()) {
				paramNamesWithDatatype.append(",");
			}
		}
		return paramNamesWithDatatype;
	}

	private StringBuffer getParameterNamesWithoutDataType() {
		StringBuffer paramNames = new StringBuffer();
		for (int index = 0; index < parameterFieldInfos.size(); index++) {
			FieldInfo fieldInfo = (FieldInfo) parameterFieldInfos.toArray()[index];
			paramNames.append(fieldInfo.getName());
			if ((index + 1) != parameterFieldInfos.size()) {
				paramNames.append(",");
			}
		}
		return paramNames;
	}

	public void populateExcelfunctionsList() {
		if (excelFunctionsList.isEmpty()) {
			ExcelFormulaContentProvider excelFormulaContentProvider = ExcelFormulaContentProvider.getInstance();
			for (ExcelFunctionInfo excelFunctionInfo : excelFormulaContentProvider.getInBuildFunction()) {
				if (!excelFunctionInfo.getName().equals("IF") && !excelFunctionInfo.getName().equals("AND")
						&& !excelFunctionInfo.getName().equals("OR") && !excelFunctionInfo.getName().equals("SWITCH")) {
					excelFunctionsList.add(excelFunctionInfo.getName());
				}
			}
		}
	}

}
