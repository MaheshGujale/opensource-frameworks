/**
 */
package org.br.excel.exceldsl.excelDSL;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Basic Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.br.excel.exceldsl.excelDSL.BasicExpression#getPrimitive <em>Primitive</em>}</li>
 *   <li>{@link org.br.excel.exceldsl.excelDSL.BasicExpression#getVariable <em>Variable</em>}</li>
 *   <li>{@link org.br.excel.exceldsl.excelDSL.BasicExpression#getInBuiltFunctionCall <em>In Built Function Call</em>}</li>
 *   <li>{@link org.br.excel.exceldsl.excelDSL.BasicExpression#getJavaClass <em>Java Class</em>}</li>
 *   <li>{@link org.br.excel.exceldsl.excelDSL.BasicExpression#getExpressionGroup <em>Expression Group</em>}</li>
 * </ul>
 *
 * @see org.br.excel.exceldsl.excelDSL.ExcelDSLPackage#getBasicExpression()
 * @model
 * @generated
 */
public interface BasicExpression extends EObject
{
  /**
   * Returns the value of the '<em><b>Primitive</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Primitive</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Primitive</em>' containment reference.
   * @see #setPrimitive(Primitive)
   * @see org.br.excel.exceldsl.excelDSL.ExcelDSLPackage#getBasicExpression_Primitive()
   * @model containment="true"
   * @generated
   */
  Primitive getPrimitive();

  /**
   * Sets the value of the '{@link org.br.excel.exceldsl.excelDSL.BasicExpression#getPrimitive <em>Primitive</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Primitive</em>' containment reference.
   * @see #getPrimitive()
   * @generated
   */
  void setPrimitive(Primitive value);

  /**
   * Returns the value of the '<em><b>Variable</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Variable</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Variable</em>' containment reference.
   * @see #setVariable(Variable)
   * @see org.br.excel.exceldsl.excelDSL.ExcelDSLPackage#getBasicExpression_Variable()
   * @model containment="true"
   * @generated
   */
  Variable getVariable();

  /**
   * Sets the value of the '{@link org.br.excel.exceldsl.excelDSL.BasicExpression#getVariable <em>Variable</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Variable</em>' containment reference.
   * @see #getVariable()
   * @generated
   */
  void setVariable(Variable value);

  /**
   * Returns the value of the '<em><b>In Built Function Call</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>In Built Function Call</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>In Built Function Call</em>' containment reference.
   * @see #setInBuiltFunctionCall(InBuiltFunctionCall)
   * @see org.br.excel.exceldsl.excelDSL.ExcelDSLPackage#getBasicExpression_InBuiltFunctionCall()
   * @model containment="true"
   * @generated
   */
  InBuiltFunctionCall getInBuiltFunctionCall();

  /**
   * Sets the value of the '{@link org.br.excel.exceldsl.excelDSL.BasicExpression#getInBuiltFunctionCall <em>In Built Function Call</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>In Built Function Call</em>' containment reference.
   * @see #getInBuiltFunctionCall()
   * @generated
   */
  void setInBuiltFunctionCall(InBuiltFunctionCall value);

  /**
   * Returns the value of the '<em><b>Java Class</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Java Class</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Java Class</em>' containment reference.
   * @see #setJavaClass(JavaClass)
   * @see org.br.excel.exceldsl.excelDSL.ExcelDSLPackage#getBasicExpression_JavaClass()
   * @model containment="true"
   * @generated
   */
  JavaClass getJavaClass();

  /**
   * Sets the value of the '{@link org.br.excel.exceldsl.excelDSL.BasicExpression#getJavaClass <em>Java Class</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Java Class</em>' containment reference.
   * @see #getJavaClass()
   * @generated
   */
  void setJavaClass(JavaClass value);

  /**
   * Returns the value of the '<em><b>Expression Group</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expression Group</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression Group</em>' containment reference.
   * @see #setExpressionGroup(ExpressionGroup)
   * @see org.br.excel.exceldsl.excelDSL.ExcelDSLPackage#getBasicExpression_ExpressionGroup()
   * @model containment="true"
   * @generated
   */
  ExpressionGroup getExpressionGroup();

  /**
   * Sets the value of the '{@link org.br.excel.exceldsl.excelDSL.BasicExpression#getExpressionGroup <em>Expression Group</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression Group</em>' containment reference.
   * @see #getExpressionGroup()
   * @generated
   */
  void setExpressionGroup(ExpressionGroup value);

} // BasicExpression
