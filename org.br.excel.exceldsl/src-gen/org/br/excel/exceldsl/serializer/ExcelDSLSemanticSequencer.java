package org.br.excel.exceldsl.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.br.excel.exceldsl.excelDSL.BasicExpression;
import org.br.excel.exceldsl.excelDSL.DataType;
import org.br.excel.exceldsl.excelDSL.Excel;
import org.br.excel.exceldsl.excelDSL.ExcelDSLPackage;
import org.br.excel.exceldsl.excelDSL.ExcelFunction;
import org.br.excel.exceldsl.excelDSL.Expression;
import org.br.excel.exceldsl.excelDSL.FunctionParameters;
import org.br.excel.exceldsl.excelDSL.InBuiltFunctionCall;
import org.br.excel.exceldsl.excelDSL.JavaClass;
import org.br.excel.exceldsl.excelDSL.JavaMemberCall;
import org.br.excel.exceldsl.excelDSL.JavaMethodCall;
import org.br.excel.exceldsl.excelDSL.Operator;
import org.br.excel.exceldsl.excelDSL.Primitive;
import org.br.excel.exceldsl.excelDSL.Statement;
import org.br.excel.exceldsl.excelDSL.Variable;
import org.br.excel.exceldsl.services.ExcelDSLGrammarAccess;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class ExcelDSLSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private ExcelDSLGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == ExcelDSLPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case ExcelDSLPackage.BASIC_EXPRESSION:
				if(context == grammarAccess.getBasicExpressionRule()) {
					sequence_BasicExpression(context, (BasicExpression) semanticObject); 
					return; 
				}
				else break;
			case ExcelDSLPackage.DATA_TYPE:
				if(context == grammarAccess.getDataTypeRule()) {
					sequence_DataType(context, (DataType) semanticObject); 
					return; 
				}
				else break;
			case ExcelDSLPackage.EXCEL:
				if(context == grammarAccess.getExcelRule()) {
					sequence_Excel(context, (Excel) semanticObject); 
					return; 
				}
				else break;
			case ExcelDSLPackage.EXCEL_FUNCTION:
				if(context == grammarAccess.getExcelFunctionRule()) {
					sequence_ExcelFunction(context, (ExcelFunction) semanticObject); 
					return; 
				}
				else break;
			case ExcelDSLPackage.EXPRESSION:
				if(context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getExpressionGroupRule()) {
					sequence_Expression(context, (Expression) semanticObject); 
					return; 
				}
				else break;
			case ExcelDSLPackage.FUNCTION_PARAMETERS:
				if(context == grammarAccess.getFunctionParametersRule()) {
					sequence_FunctionParameters(context, (FunctionParameters) semanticObject); 
					return; 
				}
				else break;
			case ExcelDSLPackage.IN_BUILT_FUNCTION_CALL:
				if(context == grammarAccess.getInBuiltFunctionCallRule()) {
					sequence_InBuiltFunctionCall(context, (InBuiltFunctionCall) semanticObject); 
					return; 
				}
				else break;
			case ExcelDSLPackage.JAVA_CLASS:
				if(context == grammarAccess.getJavaClassRule()) {
					sequence_JavaClass(context, (JavaClass) semanticObject); 
					return; 
				}
				else break;
			case ExcelDSLPackage.JAVA_MEMBER_CALL:
				if(context == grammarAccess.getJavaMemberCallRule()) {
					sequence_JavaMemberCall(context, (JavaMemberCall) semanticObject); 
					return; 
				}
				else break;
			case ExcelDSLPackage.JAVA_METHOD_CALL:
				if(context == grammarAccess.getJavaMethodCallRule()) {
					sequence_JavaMethodCall(context, (JavaMethodCall) semanticObject); 
					return; 
				}
				else break;
			case ExcelDSLPackage.OPERATOR:
				if(context == grammarAccess.getOperatorRule()) {
					sequence_Operator(context, (Operator) semanticObject); 
					return; 
				}
				else break;
			case ExcelDSLPackage.PRIMITIVE:
				if(context == grammarAccess.getPrimitiveRule()) {
					sequence_Primitive(context, (Primitive) semanticObject); 
					return; 
				}
				else break;
			case ExcelDSLPackage.STATEMENT:
				if(context == grammarAccess.getStatementRule()) {
					sequence_Statement(context, (Statement) semanticObject); 
					return; 
				}
				else break;
			case ExcelDSLPackage.VARIABLE:
				if(context == grammarAccess.getVariableRule()) {
					sequence_Variable(context, (Variable) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (primitive=Primitive | variable=Variable | inBuiltFunctionCall=InBuiltFunctionCall | javaClass=JavaClass | expressionGroup=ExpressionGroup)
	 */
	protected void sequence_BasicExpression(EObject context, BasicExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         datatype='boolean' | 
	 *         datatype='int' | 
	 *         datatype='long' | 
	 *         datatype='float' | 
	 *         datatype='double' | 
	 *         datatype='Boolean' | 
	 *         datatype='Integer' | 
	 *         datatype='Long' | 
	 *         datatype='Float' | 
	 *         datatype='Double' | 
	 *         datatype='String' | 
	 *         datatype='Object' | 
	 *         datatype='short' | 
	 *         datatype='Short' | 
	 *         datatype='byte' | 
	 *         datatype='Byte' | 
	 *         datatype='char' | 
	 *         datatype='Charater'
	 *     )
	 */
	protected void sequence_DataType(EObject context, DataType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     excelFunctionName=ID
	 */
	protected void sequence_ExcelFunction(EObject context, ExcelFunction semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ExcelDSLPackage.Literals.EXCEL_FUNCTION__EXCEL_FUNCTION_NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExcelDSLPackage.Literals.EXCEL_FUNCTION__EXCEL_FUNCTION_NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getExcelFunctionAccess().getExcelFunctionNameIDTerminalRuleCall_0(), semanticObject.getExcelFunctionName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (statements+=Statement* expression=Expression?)
	 */
	protected void sequence_Excel(EObject context, Excel semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (expression+=BasicExpression (operator=Operator expression+=Expression)?)
	 */
	protected void sequence_Expression(EObject context, Expression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (parameter+=Expression parameter+=Expression*)
	 */
	protected void sequence_FunctionParameters(EObject context, FunctionParameters semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (excelFunction=ExcelFunction functionParameters=FunctionParameters?)
	 */
	protected void sequence_InBuiltFunctionCall(EObject context, InBuiltFunctionCall semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (javaObjectName=ID (javaMemberCall=JavaMemberCall | javaMethodCall=JavaMethodCall))
	 */
	protected void sequence_JavaClass(EObject context, JavaClass semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     accessName=ID
	 */
	protected void sequence_JavaMemberCall(EObject context, JavaMemberCall semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ExcelDSLPackage.Literals.JAVA_MEMBER_CALL__ACCESS_NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExcelDSLPackage.Literals.JAVA_MEMBER_CALL__ACCESS_NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getJavaMemberCallAccess().getAccessNameIDTerminalRuleCall_1_0(), semanticObject.getAccessName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (accessName+=ID accessName+=ID* functionParameters=FunctionParameters? javaMethodCall+=JavaMethodCall*)
	 */
	protected void sequence_JavaMethodCall(EObject context, JavaMethodCall semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         operator='&&' | 
	 *         operator='||' | 
	 *         operator='=' | 
	 *         operator='+' | 
	 *         operator='-' | 
	 *         operator='*' | 
	 *         operator='/' | 
	 *         operator='==' | 
	 *         operator='>' | 
	 *         operator='<' | 
	 *         operator='>=' | 
	 *         operator='<=' | 
	 *         operator='!='
	 *     )
	 */
	protected void sequence_Operator(EObject context, Operator semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (strValue=StringVal | intValue=IntVal | doubleValue=Double | floatValue=Float | booleanValue=Boolean)
	 */
	protected void sequence_Primitive(EObject context, Primitive semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (dataType=DataType variable=Variable expression=Expression)
	 */
	protected void sequence_Statement(EObject context, Statement semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ExcelDSLPackage.Literals.STATEMENT__DATA_TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExcelDSLPackage.Literals.STATEMENT__DATA_TYPE));
			if(transientValues.isValueTransient(semanticObject, ExcelDSLPackage.Literals.STATEMENT__VARIABLE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExcelDSLPackage.Literals.STATEMENT__VARIABLE));
			if(transientValues.isValueTransient(semanticObject, ExcelDSLPackage.Literals.STATEMENT__EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExcelDSLPackage.Literals.STATEMENT__EXPRESSION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getStatementAccess().getDataTypeDataTypeParserRuleCall_0_0(), semanticObject.getDataType());
		feeder.accept(grammarAccess.getStatementAccess().getVariableVariableParserRuleCall_1_0(), semanticObject.getVariable());
		feeder.accept(grammarAccess.getStatementAccess().getExpressionExpressionParserRuleCall_3_0(), semanticObject.getExpression());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     variableName=ID
	 */
	protected void sequence_Variable(EObject context, Variable semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ExcelDSLPackage.Literals.VARIABLE__VARIABLE_NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExcelDSLPackage.Literals.VARIABLE__VARIABLE_NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getVariableAccess().getVariableNameIDTerminalRuleCall_0(), semanticObject.getVariableName());
		feeder.finish();
	}
}
