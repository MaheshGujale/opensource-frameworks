/**
 */
package org.br.excel.exceldsl.excelDSL;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>In Built Function Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.br.excel.exceldsl.excelDSL.InBuiltFunctionCall#getExcelFunction <em>Excel Function</em>}</li>
 *   <li>{@link org.br.excel.exceldsl.excelDSL.InBuiltFunctionCall#getFunctionParameters <em>Function Parameters</em>}</li>
 * </ul>
 *
 * @see org.br.excel.exceldsl.excelDSL.ExcelDSLPackage#getInBuiltFunctionCall()
 * @model
 * @generated
 */
public interface InBuiltFunctionCall extends EObject
{
  /**
   * Returns the value of the '<em><b>Excel Function</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Excel Function</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Excel Function</em>' containment reference.
   * @see #setExcelFunction(ExcelFunction)
   * @see org.br.excel.exceldsl.excelDSL.ExcelDSLPackage#getInBuiltFunctionCall_ExcelFunction()
   * @model containment="true"
   * @generated
   */
  ExcelFunction getExcelFunction();

  /**
   * Sets the value of the '{@link org.br.excel.exceldsl.excelDSL.InBuiltFunctionCall#getExcelFunction <em>Excel Function</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Excel Function</em>' containment reference.
   * @see #getExcelFunction()
   * @generated
   */
  void setExcelFunction(ExcelFunction value);

  /**
   * Returns the value of the '<em><b>Function Parameters</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Function Parameters</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Function Parameters</em>' containment reference.
   * @see #setFunctionParameters(FunctionParameters)
   * @see org.br.excel.exceldsl.excelDSL.ExcelDSLPackage#getInBuiltFunctionCall_FunctionParameters()
   * @model containment="true"
   * @generated
   */
  FunctionParameters getFunctionParameters();

  /**
   * Sets the value of the '{@link org.br.excel.exceldsl.excelDSL.InBuiltFunctionCall#getFunctionParameters <em>Function Parameters</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Function Parameters</em>' containment reference.
   * @see #getFunctionParameters()
   * @generated
   */
  void setFunctionParameters(FunctionParameters value);

} // InBuiltFunctionCall
