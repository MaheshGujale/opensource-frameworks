/**
 */
package org.br.excel.exceldsl.excelDSL;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.br.excel.exceldsl.excelDSL.ExcelDSLFactory
 * @model kind="package"
 * @generated
 */
public interface ExcelDSLPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "excelDSL";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.br.org/excel/exceldsl/ExcelDSL";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "excelDSL";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ExcelDSLPackage eINSTANCE = org.br.excel.exceldsl.excelDSL.impl.ExcelDSLPackageImpl.init();

  /**
   * The meta object id for the '{@link org.br.excel.exceldsl.excelDSL.impl.ExcelImpl <em>Excel</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.br.excel.exceldsl.excelDSL.impl.ExcelImpl
   * @see org.br.excel.exceldsl.excelDSL.impl.ExcelDSLPackageImpl#getExcel()
   * @generated
   */
  int EXCEL = 0;

  /**
   * The feature id for the '<em><b>Statements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXCEL__STATEMENTS = 0;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXCEL__EXPRESSION = 1;

  /**
   * The number of structural features of the '<em>Excel</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXCEL_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.br.excel.exceldsl.excelDSL.impl.StatementImpl <em>Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.br.excel.exceldsl.excelDSL.impl.StatementImpl
   * @see org.br.excel.exceldsl.excelDSL.impl.ExcelDSLPackageImpl#getStatement()
   * @generated
   */
  int STATEMENT = 1;

  /**
   * The feature id for the '<em><b>Data Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT__DATA_TYPE = 0;

  /**
   * The feature id for the '<em><b>Variable</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT__VARIABLE = 1;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT__EXPRESSION = 2;

  /**
   * The number of structural features of the '<em>Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.br.excel.exceldsl.excelDSL.impl.ExpressionGroupImpl <em>Expression Group</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.br.excel.exceldsl.excelDSL.impl.ExpressionGroupImpl
   * @see org.br.excel.exceldsl.excelDSL.impl.ExcelDSLPackageImpl#getExpressionGroup()
   * @generated
   */
  int EXPRESSION_GROUP = 3;

  /**
   * The number of structural features of the '<em>Expression Group</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_GROUP_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.br.excel.exceldsl.excelDSL.impl.ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.br.excel.exceldsl.excelDSL.impl.ExpressionImpl
   * @see org.br.excel.exceldsl.excelDSL.impl.ExcelDSLPackageImpl#getExpression()
   * @generated
   */
  int EXPRESSION = 2;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__EXPRESSION = EXPRESSION_GROUP_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__OPERATOR = EXPRESSION_GROUP_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = EXPRESSION_GROUP_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.br.excel.exceldsl.excelDSL.impl.OperatorImpl <em>Operator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.br.excel.exceldsl.excelDSL.impl.OperatorImpl
   * @see org.br.excel.exceldsl.excelDSL.impl.ExcelDSLPackageImpl#getOperator()
   * @generated
   */
  int OPERATOR = 4;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATOR__OPERATOR = 0;

  /**
   * The number of structural features of the '<em>Operator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATOR_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.br.excel.exceldsl.excelDSL.impl.BasicExpressionImpl <em>Basic Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.br.excel.exceldsl.excelDSL.impl.BasicExpressionImpl
   * @see org.br.excel.exceldsl.excelDSL.impl.ExcelDSLPackageImpl#getBasicExpression()
   * @generated
   */
  int BASIC_EXPRESSION = 5;

  /**
   * The feature id for the '<em><b>Primitive</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_EXPRESSION__PRIMITIVE = 0;

  /**
   * The feature id for the '<em><b>Variable</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_EXPRESSION__VARIABLE = 1;

  /**
   * The feature id for the '<em><b>In Built Function Call</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_EXPRESSION__IN_BUILT_FUNCTION_CALL = 2;

  /**
   * The feature id for the '<em><b>Java Class</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_EXPRESSION__JAVA_CLASS = 3;

  /**
   * The feature id for the '<em><b>Expression Group</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_EXPRESSION__EXPRESSION_GROUP = 4;

  /**
   * The number of structural features of the '<em>Basic Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_EXPRESSION_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link org.br.excel.exceldsl.excelDSL.impl.PrimitiveImpl <em>Primitive</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.br.excel.exceldsl.excelDSL.impl.PrimitiveImpl
   * @see org.br.excel.exceldsl.excelDSL.impl.ExcelDSLPackageImpl#getPrimitive()
   * @generated
   */
  int PRIMITIVE = 6;

  /**
   * The feature id for the '<em><b>Str Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE__STR_VALUE = 0;

  /**
   * The feature id for the '<em><b>Int Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE__INT_VALUE = 1;

  /**
   * The feature id for the '<em><b>Double Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE__DOUBLE_VALUE = 2;

  /**
   * The feature id for the '<em><b>Float Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE__FLOAT_VALUE = 3;

  /**
   * The feature id for the '<em><b>Boolean Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE__BOOLEAN_VALUE = 4;

  /**
   * The number of structural features of the '<em>Primitive</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link org.br.excel.exceldsl.excelDSL.impl.DataTypeImpl <em>Data Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.br.excel.exceldsl.excelDSL.impl.DataTypeImpl
   * @see org.br.excel.exceldsl.excelDSL.impl.ExcelDSLPackageImpl#getDataType()
   * @generated
   */
  int DATA_TYPE = 7;

  /**
   * The feature id for the '<em><b>Datatype</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_TYPE__DATATYPE = 0;

  /**
   * The number of structural features of the '<em>Data Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_TYPE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.br.excel.exceldsl.excelDSL.impl.VariableImpl <em>Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.br.excel.exceldsl.excelDSL.impl.VariableImpl
   * @see org.br.excel.exceldsl.excelDSL.impl.ExcelDSLPackageImpl#getVariable()
   * @generated
   */
  int VARIABLE = 8;

  /**
   * The feature id for the '<em><b>Variable Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__VARIABLE_NAME = 0;

  /**
   * The number of structural features of the '<em>Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.br.excel.exceldsl.excelDSL.impl.InBuiltFunctionCallImpl <em>In Built Function Call</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.br.excel.exceldsl.excelDSL.impl.InBuiltFunctionCallImpl
   * @see org.br.excel.exceldsl.excelDSL.impl.ExcelDSLPackageImpl#getInBuiltFunctionCall()
   * @generated
   */
  int IN_BUILT_FUNCTION_CALL = 9;

  /**
   * The feature id for the '<em><b>Excel Function</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IN_BUILT_FUNCTION_CALL__EXCEL_FUNCTION = 0;

  /**
   * The feature id for the '<em><b>Function Parameters</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IN_BUILT_FUNCTION_CALL__FUNCTION_PARAMETERS = 1;

  /**
   * The number of structural features of the '<em>In Built Function Call</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IN_BUILT_FUNCTION_CALL_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.br.excel.exceldsl.excelDSL.impl.ExcelFunctionImpl <em>Excel Function</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.br.excel.exceldsl.excelDSL.impl.ExcelFunctionImpl
   * @see org.br.excel.exceldsl.excelDSL.impl.ExcelDSLPackageImpl#getExcelFunction()
   * @generated
   */
  int EXCEL_FUNCTION = 10;

  /**
   * The feature id for the '<em><b>Excel Function Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXCEL_FUNCTION__EXCEL_FUNCTION_NAME = 0;

  /**
   * The number of structural features of the '<em>Excel Function</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXCEL_FUNCTION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.br.excel.exceldsl.excelDSL.impl.JavaClassImpl <em>Java Class</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.br.excel.exceldsl.excelDSL.impl.JavaClassImpl
   * @see org.br.excel.exceldsl.excelDSL.impl.ExcelDSLPackageImpl#getJavaClass()
   * @generated
   */
  int JAVA_CLASS = 11;

  /**
   * The feature id for the '<em><b>Java Object Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_CLASS__JAVA_OBJECT_NAME = 0;

  /**
   * The feature id for the '<em><b>Java Member Call</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_CLASS__JAVA_MEMBER_CALL = 1;

  /**
   * The feature id for the '<em><b>Java Method Call</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_CLASS__JAVA_METHOD_CALL = 2;

  /**
   * The number of structural features of the '<em>Java Class</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_CLASS_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.br.excel.exceldsl.excelDSL.impl.JavaMemberCallImpl <em>Java Member Call</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.br.excel.exceldsl.excelDSL.impl.JavaMemberCallImpl
   * @see org.br.excel.exceldsl.excelDSL.impl.ExcelDSLPackageImpl#getJavaMemberCall()
   * @generated
   */
  int JAVA_MEMBER_CALL = 12;

  /**
   * The feature id for the '<em><b>Access Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_MEMBER_CALL__ACCESS_NAME = 0;

  /**
   * The number of structural features of the '<em>Java Member Call</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_MEMBER_CALL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.br.excel.exceldsl.excelDSL.impl.JavaMethodCallImpl <em>Java Method Call</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.br.excel.exceldsl.excelDSL.impl.JavaMethodCallImpl
   * @see org.br.excel.exceldsl.excelDSL.impl.ExcelDSLPackageImpl#getJavaMethodCall()
   * @generated
   */
  int JAVA_METHOD_CALL = 13;

  /**
   * The feature id for the '<em><b>Access Name</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_METHOD_CALL__ACCESS_NAME = 0;

  /**
   * The feature id for the '<em><b>Function Parameters</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_METHOD_CALL__FUNCTION_PARAMETERS = 1;

  /**
   * The feature id for the '<em><b>Java Method Call</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_METHOD_CALL__JAVA_METHOD_CALL = 2;

  /**
   * The number of structural features of the '<em>Java Method Call</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_METHOD_CALL_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.br.excel.exceldsl.excelDSL.impl.FunctionParametersImpl <em>Function Parameters</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.br.excel.exceldsl.excelDSL.impl.FunctionParametersImpl
   * @see org.br.excel.exceldsl.excelDSL.impl.ExcelDSLPackageImpl#getFunctionParameters()
   * @generated
   */
  int FUNCTION_PARAMETERS = 14;

  /**
   * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_PARAMETERS__PARAMETER = 0;

  /**
   * The number of structural features of the '<em>Function Parameters</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_PARAMETERS_FEATURE_COUNT = 1;


  /**
   * Returns the meta object for class '{@link org.br.excel.exceldsl.excelDSL.Excel <em>Excel</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Excel</em>'.
   * @see org.br.excel.exceldsl.excelDSL.Excel
   * @generated
   */
  EClass getExcel();

  /**
   * Returns the meta object for the containment reference list '{@link org.br.excel.exceldsl.excelDSL.Excel#getStatements <em>Statements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Statements</em>'.
   * @see org.br.excel.exceldsl.excelDSL.Excel#getStatements()
   * @see #getExcel()
   * @generated
   */
  EReference getExcel_Statements();

  /**
   * Returns the meta object for the containment reference '{@link org.br.excel.exceldsl.excelDSL.Excel#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.br.excel.exceldsl.excelDSL.Excel#getExpression()
   * @see #getExcel()
   * @generated
   */
  EReference getExcel_Expression();

  /**
   * Returns the meta object for class '{@link org.br.excel.exceldsl.excelDSL.Statement <em>Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Statement</em>'.
   * @see org.br.excel.exceldsl.excelDSL.Statement
   * @generated
   */
  EClass getStatement();

  /**
   * Returns the meta object for the containment reference '{@link org.br.excel.exceldsl.excelDSL.Statement#getDataType <em>Data Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Data Type</em>'.
   * @see org.br.excel.exceldsl.excelDSL.Statement#getDataType()
   * @see #getStatement()
   * @generated
   */
  EReference getStatement_DataType();

  /**
   * Returns the meta object for the containment reference '{@link org.br.excel.exceldsl.excelDSL.Statement#getVariable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Variable</em>'.
   * @see org.br.excel.exceldsl.excelDSL.Statement#getVariable()
   * @see #getStatement()
   * @generated
   */
  EReference getStatement_Variable();

  /**
   * Returns the meta object for the containment reference '{@link org.br.excel.exceldsl.excelDSL.Statement#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.br.excel.exceldsl.excelDSL.Statement#getExpression()
   * @see #getStatement()
   * @generated
   */
  EReference getStatement_Expression();

  /**
   * Returns the meta object for class '{@link org.br.excel.exceldsl.excelDSL.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression</em>'.
   * @see org.br.excel.exceldsl.excelDSL.Expression
   * @generated
   */
  EClass getExpression();

  /**
   * Returns the meta object for the containment reference list '{@link org.br.excel.exceldsl.excelDSL.Expression#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expression</em>'.
   * @see org.br.excel.exceldsl.excelDSL.Expression#getExpression()
   * @see #getExpression()
   * @generated
   */
  EReference getExpression_Expression();

  /**
   * Returns the meta object for the containment reference '{@link org.br.excel.exceldsl.excelDSL.Expression#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operator</em>'.
   * @see org.br.excel.exceldsl.excelDSL.Expression#getOperator()
   * @see #getExpression()
   * @generated
   */
  EReference getExpression_Operator();

  /**
   * Returns the meta object for class '{@link org.br.excel.exceldsl.excelDSL.ExpressionGroup <em>Expression Group</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression Group</em>'.
   * @see org.br.excel.exceldsl.excelDSL.ExpressionGroup
   * @generated
   */
  EClass getExpressionGroup();

  /**
   * Returns the meta object for class '{@link org.br.excel.exceldsl.excelDSL.Operator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Operator</em>'.
   * @see org.br.excel.exceldsl.excelDSL.Operator
   * @generated
   */
  EClass getOperator();

  /**
   * Returns the meta object for the attribute '{@link org.br.excel.exceldsl.excelDSL.Operator#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see org.br.excel.exceldsl.excelDSL.Operator#getOperator()
   * @see #getOperator()
   * @generated
   */
  EAttribute getOperator_Operator();

  /**
   * Returns the meta object for class '{@link org.br.excel.exceldsl.excelDSL.BasicExpression <em>Basic Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Basic Expression</em>'.
   * @see org.br.excel.exceldsl.excelDSL.BasicExpression
   * @generated
   */
  EClass getBasicExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.br.excel.exceldsl.excelDSL.BasicExpression#getPrimitive <em>Primitive</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Primitive</em>'.
   * @see org.br.excel.exceldsl.excelDSL.BasicExpression#getPrimitive()
   * @see #getBasicExpression()
   * @generated
   */
  EReference getBasicExpression_Primitive();

  /**
   * Returns the meta object for the containment reference '{@link org.br.excel.exceldsl.excelDSL.BasicExpression#getVariable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Variable</em>'.
   * @see org.br.excel.exceldsl.excelDSL.BasicExpression#getVariable()
   * @see #getBasicExpression()
   * @generated
   */
  EReference getBasicExpression_Variable();

  /**
   * Returns the meta object for the containment reference '{@link org.br.excel.exceldsl.excelDSL.BasicExpression#getInBuiltFunctionCall <em>In Built Function Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>In Built Function Call</em>'.
   * @see org.br.excel.exceldsl.excelDSL.BasicExpression#getInBuiltFunctionCall()
   * @see #getBasicExpression()
   * @generated
   */
  EReference getBasicExpression_InBuiltFunctionCall();

  /**
   * Returns the meta object for the containment reference '{@link org.br.excel.exceldsl.excelDSL.BasicExpression#getJavaClass <em>Java Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Java Class</em>'.
   * @see org.br.excel.exceldsl.excelDSL.BasicExpression#getJavaClass()
   * @see #getBasicExpression()
   * @generated
   */
  EReference getBasicExpression_JavaClass();

  /**
   * Returns the meta object for the containment reference '{@link org.br.excel.exceldsl.excelDSL.BasicExpression#getExpressionGroup <em>Expression Group</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression Group</em>'.
   * @see org.br.excel.exceldsl.excelDSL.BasicExpression#getExpressionGroup()
   * @see #getBasicExpression()
   * @generated
   */
  EReference getBasicExpression_ExpressionGroup();

  /**
   * Returns the meta object for class '{@link org.br.excel.exceldsl.excelDSL.Primitive <em>Primitive</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Primitive</em>'.
   * @see org.br.excel.exceldsl.excelDSL.Primitive
   * @generated
   */
  EClass getPrimitive();

  /**
   * Returns the meta object for the attribute '{@link org.br.excel.exceldsl.excelDSL.Primitive#getStrValue <em>Str Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Str Value</em>'.
   * @see org.br.excel.exceldsl.excelDSL.Primitive#getStrValue()
   * @see #getPrimitive()
   * @generated
   */
  EAttribute getPrimitive_StrValue();

  /**
   * Returns the meta object for the attribute '{@link org.br.excel.exceldsl.excelDSL.Primitive#getIntValue <em>Int Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Int Value</em>'.
   * @see org.br.excel.exceldsl.excelDSL.Primitive#getIntValue()
   * @see #getPrimitive()
   * @generated
   */
  EAttribute getPrimitive_IntValue();

  /**
   * Returns the meta object for the attribute '{@link org.br.excel.exceldsl.excelDSL.Primitive#getDoubleValue <em>Double Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Double Value</em>'.
   * @see org.br.excel.exceldsl.excelDSL.Primitive#getDoubleValue()
   * @see #getPrimitive()
   * @generated
   */
  EAttribute getPrimitive_DoubleValue();

  /**
   * Returns the meta object for the attribute '{@link org.br.excel.exceldsl.excelDSL.Primitive#getFloatValue <em>Float Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Float Value</em>'.
   * @see org.br.excel.exceldsl.excelDSL.Primitive#getFloatValue()
   * @see #getPrimitive()
   * @generated
   */
  EAttribute getPrimitive_FloatValue();

  /**
   * Returns the meta object for the attribute '{@link org.br.excel.exceldsl.excelDSL.Primitive#getBooleanValue <em>Boolean Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Boolean Value</em>'.
   * @see org.br.excel.exceldsl.excelDSL.Primitive#getBooleanValue()
   * @see #getPrimitive()
   * @generated
   */
  EAttribute getPrimitive_BooleanValue();

  /**
   * Returns the meta object for class '{@link org.br.excel.exceldsl.excelDSL.DataType <em>Data Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Data Type</em>'.
   * @see org.br.excel.exceldsl.excelDSL.DataType
   * @generated
   */
  EClass getDataType();

  /**
   * Returns the meta object for the attribute '{@link org.br.excel.exceldsl.excelDSL.DataType#getDatatype <em>Datatype</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Datatype</em>'.
   * @see org.br.excel.exceldsl.excelDSL.DataType#getDatatype()
   * @see #getDataType()
   * @generated
   */
  EAttribute getDataType_Datatype();

  /**
   * Returns the meta object for class '{@link org.br.excel.exceldsl.excelDSL.Variable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable</em>'.
   * @see org.br.excel.exceldsl.excelDSL.Variable
   * @generated
   */
  EClass getVariable();

  /**
   * Returns the meta object for the attribute '{@link org.br.excel.exceldsl.excelDSL.Variable#getVariableName <em>Variable Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Variable Name</em>'.
   * @see org.br.excel.exceldsl.excelDSL.Variable#getVariableName()
   * @see #getVariable()
   * @generated
   */
  EAttribute getVariable_VariableName();

  /**
   * Returns the meta object for class '{@link org.br.excel.exceldsl.excelDSL.InBuiltFunctionCall <em>In Built Function Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>In Built Function Call</em>'.
   * @see org.br.excel.exceldsl.excelDSL.InBuiltFunctionCall
   * @generated
   */
  EClass getInBuiltFunctionCall();

  /**
   * Returns the meta object for the containment reference '{@link org.br.excel.exceldsl.excelDSL.InBuiltFunctionCall#getExcelFunction <em>Excel Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Excel Function</em>'.
   * @see org.br.excel.exceldsl.excelDSL.InBuiltFunctionCall#getExcelFunction()
   * @see #getInBuiltFunctionCall()
   * @generated
   */
  EReference getInBuiltFunctionCall_ExcelFunction();

  /**
   * Returns the meta object for the containment reference '{@link org.br.excel.exceldsl.excelDSL.InBuiltFunctionCall#getFunctionParameters <em>Function Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Function Parameters</em>'.
   * @see org.br.excel.exceldsl.excelDSL.InBuiltFunctionCall#getFunctionParameters()
   * @see #getInBuiltFunctionCall()
   * @generated
   */
  EReference getInBuiltFunctionCall_FunctionParameters();

  /**
   * Returns the meta object for class '{@link org.br.excel.exceldsl.excelDSL.ExcelFunction <em>Excel Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Excel Function</em>'.
   * @see org.br.excel.exceldsl.excelDSL.ExcelFunction
   * @generated
   */
  EClass getExcelFunction();

  /**
   * Returns the meta object for the attribute '{@link org.br.excel.exceldsl.excelDSL.ExcelFunction#getExcelFunctionName <em>Excel Function Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Excel Function Name</em>'.
   * @see org.br.excel.exceldsl.excelDSL.ExcelFunction#getExcelFunctionName()
   * @see #getExcelFunction()
   * @generated
   */
  EAttribute getExcelFunction_ExcelFunctionName();

  /**
   * Returns the meta object for class '{@link org.br.excel.exceldsl.excelDSL.JavaClass <em>Java Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Java Class</em>'.
   * @see org.br.excel.exceldsl.excelDSL.JavaClass
   * @generated
   */
  EClass getJavaClass();

  /**
   * Returns the meta object for the attribute '{@link org.br.excel.exceldsl.excelDSL.JavaClass#getJavaObjectName <em>Java Object Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Java Object Name</em>'.
   * @see org.br.excel.exceldsl.excelDSL.JavaClass#getJavaObjectName()
   * @see #getJavaClass()
   * @generated
   */
  EAttribute getJavaClass_JavaObjectName();

  /**
   * Returns the meta object for the containment reference '{@link org.br.excel.exceldsl.excelDSL.JavaClass#getJavaMemberCall <em>Java Member Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Java Member Call</em>'.
   * @see org.br.excel.exceldsl.excelDSL.JavaClass#getJavaMemberCall()
   * @see #getJavaClass()
   * @generated
   */
  EReference getJavaClass_JavaMemberCall();

  /**
   * Returns the meta object for the containment reference '{@link org.br.excel.exceldsl.excelDSL.JavaClass#getJavaMethodCall <em>Java Method Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Java Method Call</em>'.
   * @see org.br.excel.exceldsl.excelDSL.JavaClass#getJavaMethodCall()
   * @see #getJavaClass()
   * @generated
   */
  EReference getJavaClass_JavaMethodCall();

  /**
   * Returns the meta object for class '{@link org.br.excel.exceldsl.excelDSL.JavaMemberCall <em>Java Member Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Java Member Call</em>'.
   * @see org.br.excel.exceldsl.excelDSL.JavaMemberCall
   * @generated
   */
  EClass getJavaMemberCall();

  /**
   * Returns the meta object for the attribute '{@link org.br.excel.exceldsl.excelDSL.JavaMemberCall#getAccessName <em>Access Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Access Name</em>'.
   * @see org.br.excel.exceldsl.excelDSL.JavaMemberCall#getAccessName()
   * @see #getJavaMemberCall()
   * @generated
   */
  EAttribute getJavaMemberCall_AccessName();

  /**
   * Returns the meta object for class '{@link org.br.excel.exceldsl.excelDSL.JavaMethodCall <em>Java Method Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Java Method Call</em>'.
   * @see org.br.excel.exceldsl.excelDSL.JavaMethodCall
   * @generated
   */
  EClass getJavaMethodCall();

  /**
   * Returns the meta object for the attribute list '{@link org.br.excel.exceldsl.excelDSL.JavaMethodCall#getAccessName <em>Access Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Access Name</em>'.
   * @see org.br.excel.exceldsl.excelDSL.JavaMethodCall#getAccessName()
   * @see #getJavaMethodCall()
   * @generated
   */
  EAttribute getJavaMethodCall_AccessName();

  /**
   * Returns the meta object for the containment reference '{@link org.br.excel.exceldsl.excelDSL.JavaMethodCall#getFunctionParameters <em>Function Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Function Parameters</em>'.
   * @see org.br.excel.exceldsl.excelDSL.JavaMethodCall#getFunctionParameters()
   * @see #getJavaMethodCall()
   * @generated
   */
  EReference getJavaMethodCall_FunctionParameters();

  /**
   * Returns the meta object for the containment reference list '{@link org.br.excel.exceldsl.excelDSL.JavaMethodCall#getJavaMethodCall <em>Java Method Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Java Method Call</em>'.
   * @see org.br.excel.exceldsl.excelDSL.JavaMethodCall#getJavaMethodCall()
   * @see #getJavaMethodCall()
   * @generated
   */
  EReference getJavaMethodCall_JavaMethodCall();

  /**
   * Returns the meta object for class '{@link org.br.excel.exceldsl.excelDSL.FunctionParameters <em>Function Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Function Parameters</em>'.
   * @see org.br.excel.exceldsl.excelDSL.FunctionParameters
   * @generated
   */
  EClass getFunctionParameters();

  /**
   * Returns the meta object for the containment reference list '{@link org.br.excel.exceldsl.excelDSL.FunctionParameters#getParameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameter</em>'.
   * @see org.br.excel.exceldsl.excelDSL.FunctionParameters#getParameter()
   * @see #getFunctionParameters()
   * @generated
   */
  EReference getFunctionParameters_Parameter();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ExcelDSLFactory getExcelDSLFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.br.excel.exceldsl.excelDSL.impl.ExcelImpl <em>Excel</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.br.excel.exceldsl.excelDSL.impl.ExcelImpl
     * @see org.br.excel.exceldsl.excelDSL.impl.ExcelDSLPackageImpl#getExcel()
     * @generated
     */
    EClass EXCEL = eINSTANCE.getExcel();

    /**
     * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXCEL__STATEMENTS = eINSTANCE.getExcel_Statements();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXCEL__EXPRESSION = eINSTANCE.getExcel_Expression();

    /**
     * The meta object literal for the '{@link org.br.excel.exceldsl.excelDSL.impl.StatementImpl <em>Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.br.excel.exceldsl.excelDSL.impl.StatementImpl
     * @see org.br.excel.exceldsl.excelDSL.impl.ExcelDSLPackageImpl#getStatement()
     * @generated
     */
    EClass STATEMENT = eINSTANCE.getStatement();

    /**
     * The meta object literal for the '<em><b>Data Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATEMENT__DATA_TYPE = eINSTANCE.getStatement_DataType();

    /**
     * The meta object literal for the '<em><b>Variable</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATEMENT__VARIABLE = eINSTANCE.getStatement_Variable();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATEMENT__EXPRESSION = eINSTANCE.getStatement_Expression();

    /**
     * The meta object literal for the '{@link org.br.excel.exceldsl.excelDSL.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.br.excel.exceldsl.excelDSL.impl.ExpressionImpl
     * @see org.br.excel.exceldsl.excelDSL.impl.ExcelDSLPackageImpl#getExpression()
     * @generated
     */
    EClass EXPRESSION = eINSTANCE.getExpression();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION__EXPRESSION = eINSTANCE.getExpression_Expression();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION__OPERATOR = eINSTANCE.getExpression_Operator();

    /**
     * The meta object literal for the '{@link org.br.excel.exceldsl.excelDSL.impl.ExpressionGroupImpl <em>Expression Group</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.br.excel.exceldsl.excelDSL.impl.ExpressionGroupImpl
     * @see org.br.excel.exceldsl.excelDSL.impl.ExcelDSLPackageImpl#getExpressionGroup()
     * @generated
     */
    EClass EXPRESSION_GROUP = eINSTANCE.getExpressionGroup();

    /**
     * The meta object literal for the '{@link org.br.excel.exceldsl.excelDSL.impl.OperatorImpl <em>Operator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.br.excel.exceldsl.excelDSL.impl.OperatorImpl
     * @see org.br.excel.exceldsl.excelDSL.impl.ExcelDSLPackageImpl#getOperator()
     * @generated
     */
    EClass OPERATOR = eINSTANCE.getOperator();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPERATOR__OPERATOR = eINSTANCE.getOperator_Operator();

    /**
     * The meta object literal for the '{@link org.br.excel.exceldsl.excelDSL.impl.BasicExpressionImpl <em>Basic Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.br.excel.exceldsl.excelDSL.impl.BasicExpressionImpl
     * @see org.br.excel.exceldsl.excelDSL.impl.ExcelDSLPackageImpl#getBasicExpression()
     * @generated
     */
    EClass BASIC_EXPRESSION = eINSTANCE.getBasicExpression();

    /**
     * The meta object literal for the '<em><b>Primitive</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BASIC_EXPRESSION__PRIMITIVE = eINSTANCE.getBasicExpression_Primitive();

    /**
     * The meta object literal for the '<em><b>Variable</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BASIC_EXPRESSION__VARIABLE = eINSTANCE.getBasicExpression_Variable();

    /**
     * The meta object literal for the '<em><b>In Built Function Call</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BASIC_EXPRESSION__IN_BUILT_FUNCTION_CALL = eINSTANCE.getBasicExpression_InBuiltFunctionCall();

    /**
     * The meta object literal for the '<em><b>Java Class</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BASIC_EXPRESSION__JAVA_CLASS = eINSTANCE.getBasicExpression_JavaClass();

    /**
     * The meta object literal for the '<em><b>Expression Group</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BASIC_EXPRESSION__EXPRESSION_GROUP = eINSTANCE.getBasicExpression_ExpressionGroup();

    /**
     * The meta object literal for the '{@link org.br.excel.exceldsl.excelDSL.impl.PrimitiveImpl <em>Primitive</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.br.excel.exceldsl.excelDSL.impl.PrimitiveImpl
     * @see org.br.excel.exceldsl.excelDSL.impl.ExcelDSLPackageImpl#getPrimitive()
     * @generated
     */
    EClass PRIMITIVE = eINSTANCE.getPrimitive();

    /**
     * The meta object literal for the '<em><b>Str Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PRIMITIVE__STR_VALUE = eINSTANCE.getPrimitive_StrValue();

    /**
     * The meta object literal for the '<em><b>Int Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PRIMITIVE__INT_VALUE = eINSTANCE.getPrimitive_IntValue();

    /**
     * The meta object literal for the '<em><b>Double Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PRIMITIVE__DOUBLE_VALUE = eINSTANCE.getPrimitive_DoubleValue();

    /**
     * The meta object literal for the '<em><b>Float Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PRIMITIVE__FLOAT_VALUE = eINSTANCE.getPrimitive_FloatValue();

    /**
     * The meta object literal for the '<em><b>Boolean Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PRIMITIVE__BOOLEAN_VALUE = eINSTANCE.getPrimitive_BooleanValue();

    /**
     * The meta object literal for the '{@link org.br.excel.exceldsl.excelDSL.impl.DataTypeImpl <em>Data Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.br.excel.exceldsl.excelDSL.impl.DataTypeImpl
     * @see org.br.excel.exceldsl.excelDSL.impl.ExcelDSLPackageImpl#getDataType()
     * @generated
     */
    EClass DATA_TYPE = eINSTANCE.getDataType();

    /**
     * The meta object literal for the '<em><b>Datatype</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DATA_TYPE__DATATYPE = eINSTANCE.getDataType_Datatype();

    /**
     * The meta object literal for the '{@link org.br.excel.exceldsl.excelDSL.impl.VariableImpl <em>Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.br.excel.exceldsl.excelDSL.impl.VariableImpl
     * @see org.br.excel.exceldsl.excelDSL.impl.ExcelDSLPackageImpl#getVariable()
     * @generated
     */
    EClass VARIABLE = eINSTANCE.getVariable();

    /**
     * The meta object literal for the '<em><b>Variable Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE__VARIABLE_NAME = eINSTANCE.getVariable_VariableName();

    /**
     * The meta object literal for the '{@link org.br.excel.exceldsl.excelDSL.impl.InBuiltFunctionCallImpl <em>In Built Function Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.br.excel.exceldsl.excelDSL.impl.InBuiltFunctionCallImpl
     * @see org.br.excel.exceldsl.excelDSL.impl.ExcelDSLPackageImpl#getInBuiltFunctionCall()
     * @generated
     */
    EClass IN_BUILT_FUNCTION_CALL = eINSTANCE.getInBuiltFunctionCall();

    /**
     * The meta object literal for the '<em><b>Excel Function</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IN_BUILT_FUNCTION_CALL__EXCEL_FUNCTION = eINSTANCE.getInBuiltFunctionCall_ExcelFunction();

    /**
     * The meta object literal for the '<em><b>Function Parameters</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IN_BUILT_FUNCTION_CALL__FUNCTION_PARAMETERS = eINSTANCE.getInBuiltFunctionCall_FunctionParameters();

    /**
     * The meta object literal for the '{@link org.br.excel.exceldsl.excelDSL.impl.ExcelFunctionImpl <em>Excel Function</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.br.excel.exceldsl.excelDSL.impl.ExcelFunctionImpl
     * @see org.br.excel.exceldsl.excelDSL.impl.ExcelDSLPackageImpl#getExcelFunction()
     * @generated
     */
    EClass EXCEL_FUNCTION = eINSTANCE.getExcelFunction();

    /**
     * The meta object literal for the '<em><b>Excel Function Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXCEL_FUNCTION__EXCEL_FUNCTION_NAME = eINSTANCE.getExcelFunction_ExcelFunctionName();

    /**
     * The meta object literal for the '{@link org.br.excel.exceldsl.excelDSL.impl.JavaClassImpl <em>Java Class</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.br.excel.exceldsl.excelDSL.impl.JavaClassImpl
     * @see org.br.excel.exceldsl.excelDSL.impl.ExcelDSLPackageImpl#getJavaClass()
     * @generated
     */
    EClass JAVA_CLASS = eINSTANCE.getJavaClass();

    /**
     * The meta object literal for the '<em><b>Java Object Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute JAVA_CLASS__JAVA_OBJECT_NAME = eINSTANCE.getJavaClass_JavaObjectName();

    /**
     * The meta object literal for the '<em><b>Java Member Call</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference JAVA_CLASS__JAVA_MEMBER_CALL = eINSTANCE.getJavaClass_JavaMemberCall();

    /**
     * The meta object literal for the '<em><b>Java Method Call</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference JAVA_CLASS__JAVA_METHOD_CALL = eINSTANCE.getJavaClass_JavaMethodCall();

    /**
     * The meta object literal for the '{@link org.br.excel.exceldsl.excelDSL.impl.JavaMemberCallImpl <em>Java Member Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.br.excel.exceldsl.excelDSL.impl.JavaMemberCallImpl
     * @see org.br.excel.exceldsl.excelDSL.impl.ExcelDSLPackageImpl#getJavaMemberCall()
     * @generated
     */
    EClass JAVA_MEMBER_CALL = eINSTANCE.getJavaMemberCall();

    /**
     * The meta object literal for the '<em><b>Access Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute JAVA_MEMBER_CALL__ACCESS_NAME = eINSTANCE.getJavaMemberCall_AccessName();

    /**
     * The meta object literal for the '{@link org.br.excel.exceldsl.excelDSL.impl.JavaMethodCallImpl <em>Java Method Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.br.excel.exceldsl.excelDSL.impl.JavaMethodCallImpl
     * @see org.br.excel.exceldsl.excelDSL.impl.ExcelDSLPackageImpl#getJavaMethodCall()
     * @generated
     */
    EClass JAVA_METHOD_CALL = eINSTANCE.getJavaMethodCall();

    /**
     * The meta object literal for the '<em><b>Access Name</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute JAVA_METHOD_CALL__ACCESS_NAME = eINSTANCE.getJavaMethodCall_AccessName();

    /**
     * The meta object literal for the '<em><b>Function Parameters</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference JAVA_METHOD_CALL__FUNCTION_PARAMETERS = eINSTANCE.getJavaMethodCall_FunctionParameters();

    /**
     * The meta object literal for the '<em><b>Java Method Call</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference JAVA_METHOD_CALL__JAVA_METHOD_CALL = eINSTANCE.getJavaMethodCall_JavaMethodCall();

    /**
     * The meta object literal for the '{@link org.br.excel.exceldsl.excelDSL.impl.FunctionParametersImpl <em>Function Parameters</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.br.excel.exceldsl.excelDSL.impl.FunctionParametersImpl
     * @see org.br.excel.exceldsl.excelDSL.impl.ExcelDSLPackageImpl#getFunctionParameters()
     * @generated
     */
    EClass FUNCTION_PARAMETERS = eINSTANCE.getFunctionParameters();

    /**
     * The meta object literal for the '<em><b>Parameter</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION_PARAMETERS__PARAMETER = eINSTANCE.getFunctionParameters_Parameter();

  }

} //ExcelDSLPackage
