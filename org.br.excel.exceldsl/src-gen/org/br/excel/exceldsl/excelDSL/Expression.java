/**
 */
package org.br.excel.exceldsl.excelDSL;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.br.excel.exceldsl.excelDSL.Expression#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.br.excel.exceldsl.excelDSL.Expression#getOperator <em>Operator</em>}</li>
 * </ul>
 *
 * @see org.br.excel.exceldsl.excelDSL.ExcelDSLPackage#getExpression()
 * @model
 * @generated
 */
public interface Expression extends ExpressionGroup
{
  /**
   * Returns the value of the '<em><b>Expression</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expression</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression</em>' containment reference list.
   * @see org.br.excel.exceldsl.excelDSL.ExcelDSLPackage#getExpression_Expression()
   * @model containment="true"
   * @generated
   */
  EList<EObject> getExpression();

  /**
   * Returns the value of the '<em><b>Operator</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operator</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operator</em>' containment reference.
   * @see #setOperator(Operator)
   * @see org.br.excel.exceldsl.excelDSL.ExcelDSLPackage#getExpression_Operator()
   * @model containment="true"
   * @generated
   */
  Operator getOperator();

  /**
   * Sets the value of the '{@link org.br.excel.exceldsl.excelDSL.Expression#getOperator <em>Operator</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operator</em>' containment reference.
   * @see #getOperator()
   * @generated
   */
  void setOperator(Operator value);

} // Expression
