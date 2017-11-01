/**
 */
package org.br.excel.exceldsl.excelDSL.impl;

import org.br.excel.exceldsl.excelDSL.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExcelDSLFactoryImpl extends EFactoryImpl implements ExcelDSLFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ExcelDSLFactory init()
  {
    try
    {
      ExcelDSLFactory theExcelDSLFactory = (ExcelDSLFactory)EPackage.Registry.INSTANCE.getEFactory(ExcelDSLPackage.eNS_URI);
      if (theExcelDSLFactory != null)
      {
        return theExcelDSLFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ExcelDSLFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExcelDSLFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case ExcelDSLPackage.EXCEL: return createExcel();
      case ExcelDSLPackage.STATEMENT: return createStatement();
      case ExcelDSLPackage.EXPRESSION: return createExpression();
      case ExcelDSLPackage.EXPRESSION_GROUP: return createExpressionGroup();
      case ExcelDSLPackage.OPERATOR: return createOperator();
      case ExcelDSLPackage.BASIC_EXPRESSION: return createBasicExpression();
      case ExcelDSLPackage.PRIMITIVE: return createPrimitive();
      case ExcelDSLPackage.DATA_TYPE: return createDataType();
      case ExcelDSLPackage.VARIABLE: return createVariable();
      case ExcelDSLPackage.IN_BUILT_FUNCTION_CALL: return createInBuiltFunctionCall();
      case ExcelDSLPackage.EXCEL_FUNCTION: return createExcelFunction();
      case ExcelDSLPackage.JAVA_CLASS: return createJavaClass();
      case ExcelDSLPackage.JAVA_MEMBER_CALL: return createJavaMemberCall();
      case ExcelDSLPackage.JAVA_METHOD_CALL: return createJavaMethodCall();
      case ExcelDSLPackage.FUNCTION_PARAMETERS: return createFunctionParameters();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Excel createExcel()
  {
    ExcelImpl excel = new ExcelImpl();
    return excel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Statement createStatement()
  {
    StatementImpl statement = new StatementImpl();
    return statement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression createExpression()
  {
    ExpressionImpl expression = new ExpressionImpl();
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExpressionGroup createExpressionGroup()
  {
    ExpressionGroupImpl expressionGroup = new ExpressionGroupImpl();
    return expressionGroup;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Operator createOperator()
  {
    OperatorImpl operator = new OperatorImpl();
    return operator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BasicExpression createBasicExpression()
  {
    BasicExpressionImpl basicExpression = new BasicExpressionImpl();
    return basicExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Primitive createPrimitive()
  {
    PrimitiveImpl primitive = new PrimitiveImpl();
    return primitive;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataType createDataType()
  {
    DataTypeImpl dataType = new DataTypeImpl();
    return dataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Variable createVariable()
  {
    VariableImpl variable = new VariableImpl();
    return variable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InBuiltFunctionCall createInBuiltFunctionCall()
  {
    InBuiltFunctionCallImpl inBuiltFunctionCall = new InBuiltFunctionCallImpl();
    return inBuiltFunctionCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExcelFunction createExcelFunction()
  {
    ExcelFunctionImpl excelFunction = new ExcelFunctionImpl();
    return excelFunction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JavaClass createJavaClass()
  {
    JavaClassImpl javaClass = new JavaClassImpl();
    return javaClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JavaMemberCall createJavaMemberCall()
  {
    JavaMemberCallImpl javaMemberCall = new JavaMemberCallImpl();
    return javaMemberCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JavaMethodCall createJavaMethodCall()
  {
    JavaMethodCallImpl javaMethodCall = new JavaMethodCallImpl();
    return javaMethodCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunctionParameters createFunctionParameters()
  {
    FunctionParametersImpl functionParameters = new FunctionParametersImpl();
    return functionParameters;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExcelDSLPackage getExcelDSLPackage()
  {
    return (ExcelDSLPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static ExcelDSLPackage getPackage()
  {
    return ExcelDSLPackage.eINSTANCE;
  }

} //ExcelDSLFactoryImpl
