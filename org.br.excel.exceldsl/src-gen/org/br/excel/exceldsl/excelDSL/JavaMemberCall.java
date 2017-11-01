/**
 */
package org.br.excel.exceldsl.excelDSL;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Java Member Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.br.excel.exceldsl.excelDSL.JavaMemberCall#getAccessName <em>Access Name</em>}</li>
 * </ul>
 *
 * @see org.br.excel.exceldsl.excelDSL.ExcelDSLPackage#getJavaMemberCall()
 * @model
 * @generated
 */
public interface JavaMemberCall extends EObject
{
  /**
   * Returns the value of the '<em><b>Access Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Access Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Access Name</em>' attribute.
   * @see #setAccessName(String)
   * @see org.br.excel.exceldsl.excelDSL.ExcelDSLPackage#getJavaMemberCall_AccessName()
   * @model
   * @generated
   */
  String getAccessName();

  /**
   * Sets the value of the '{@link org.br.excel.exceldsl.excelDSL.JavaMemberCall#getAccessName <em>Access Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Access Name</em>' attribute.
   * @see #getAccessName()
   * @generated
   */
  void setAccessName(String value);

} // JavaMemberCall
