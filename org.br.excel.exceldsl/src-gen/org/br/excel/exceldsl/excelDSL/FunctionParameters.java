/**
 */
package org.br.excel.exceldsl.excelDSL;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Parameters</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.br.excel.exceldsl.excelDSL.FunctionParameters#getParameter <em>Parameter</em>}</li>
 * </ul>
 *
 * @see org.br.excel.exceldsl.excelDSL.ExcelDSLPackage#getFunctionParameters()
 * @model
 * @generated
 */
public interface FunctionParameters extends EObject
{
  /**
   * Returns the value of the '<em><b>Parameter</b></em>' containment reference list.
   * The list contents are of type {@link org.br.excel.exceldsl.excelDSL.Expression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameter</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameter</em>' containment reference list.
   * @see org.br.excel.exceldsl.excelDSL.ExcelDSLPackage#getFunctionParameters_Parameter()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getParameter();

} // FunctionParameters
