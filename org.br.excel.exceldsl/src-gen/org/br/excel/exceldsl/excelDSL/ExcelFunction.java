/**
 */
package org.br.excel.exceldsl.excelDSL;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Excel Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.br.excel.exceldsl.excelDSL.ExcelFunction#getExcelFunctionName <em>Excel Function Name</em>}</li>
 * </ul>
 *
 * @see org.br.excel.exceldsl.excelDSL.ExcelDSLPackage#getExcelFunction()
 * @model
 * @generated
 */
public interface ExcelFunction extends EObject
{
  /**
   * Returns the value of the '<em><b>Excel Function Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Excel Function Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Excel Function Name</em>' attribute.
   * @see #setExcelFunctionName(String)
   * @see org.br.excel.exceldsl.excelDSL.ExcelDSLPackage#getExcelFunction_ExcelFunctionName()
   * @model
   * @generated
   */
  String getExcelFunctionName();

  /**
   * Sets the value of the '{@link org.br.excel.exceldsl.excelDSL.ExcelFunction#getExcelFunctionName <em>Excel Function Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Excel Function Name</em>' attribute.
   * @see #getExcelFunctionName()
   * @generated
   */
  void setExcelFunctionName(String value);

} // ExcelFunction
