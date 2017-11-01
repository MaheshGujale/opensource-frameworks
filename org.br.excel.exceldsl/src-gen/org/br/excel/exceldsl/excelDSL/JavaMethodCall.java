/**
 */
package org.br.excel.exceldsl.excelDSL;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Java Method Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.br.excel.exceldsl.excelDSL.JavaMethodCall#getAccessName <em>Access Name</em>}</li>
 *   <li>{@link org.br.excel.exceldsl.excelDSL.JavaMethodCall#getFunctionParameters <em>Function Parameters</em>}</li>
 *   <li>{@link org.br.excel.exceldsl.excelDSL.JavaMethodCall#getJavaMethodCall <em>Java Method Call</em>}</li>
 * </ul>
 *
 * @see org.br.excel.exceldsl.excelDSL.ExcelDSLPackage#getJavaMethodCall()
 * @model
 * @generated
 */
public interface JavaMethodCall extends EObject
{
  /**
   * Returns the value of the '<em><b>Access Name</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Access Name</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Access Name</em>' attribute list.
   * @see org.br.excel.exceldsl.excelDSL.ExcelDSLPackage#getJavaMethodCall_AccessName()
   * @model unique="false"
   * @generated
   */
  EList<String> getAccessName();

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
   * @see org.br.excel.exceldsl.excelDSL.ExcelDSLPackage#getJavaMethodCall_FunctionParameters()
   * @model containment="true"
   * @generated
   */
  FunctionParameters getFunctionParameters();

  /**
   * Sets the value of the '{@link org.br.excel.exceldsl.excelDSL.JavaMethodCall#getFunctionParameters <em>Function Parameters</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Function Parameters</em>' containment reference.
   * @see #getFunctionParameters()
   * @generated
   */
  void setFunctionParameters(FunctionParameters value);

  /**
   * Returns the value of the '<em><b>Java Method Call</b></em>' containment reference list.
   * The list contents are of type {@link org.br.excel.exceldsl.excelDSL.JavaMethodCall}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Java Method Call</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Java Method Call</em>' containment reference list.
   * @see org.br.excel.exceldsl.excelDSL.ExcelDSLPackage#getJavaMethodCall_JavaMethodCall()
   * @model containment="true"
   * @generated
   */
  EList<JavaMethodCall> getJavaMethodCall();

} // JavaMethodCall
