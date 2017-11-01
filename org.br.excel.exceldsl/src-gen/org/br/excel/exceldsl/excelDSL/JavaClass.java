/**
 */
package org.br.excel.exceldsl.excelDSL;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Java Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.br.excel.exceldsl.excelDSL.JavaClass#getJavaObjectName <em>Java Object Name</em>}</li>
 *   <li>{@link org.br.excel.exceldsl.excelDSL.JavaClass#getJavaMemberCall <em>Java Member Call</em>}</li>
 *   <li>{@link org.br.excel.exceldsl.excelDSL.JavaClass#getJavaMethodCall <em>Java Method Call</em>}</li>
 * </ul>
 *
 * @see org.br.excel.exceldsl.excelDSL.ExcelDSLPackage#getJavaClass()
 * @model
 * @generated
 */
public interface JavaClass extends EObject
{
  /**
   * Returns the value of the '<em><b>Java Object Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Java Object Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Java Object Name</em>' attribute.
   * @see #setJavaObjectName(String)
   * @see org.br.excel.exceldsl.excelDSL.ExcelDSLPackage#getJavaClass_JavaObjectName()
   * @model
   * @generated
   */
  String getJavaObjectName();

  /**
   * Sets the value of the '{@link org.br.excel.exceldsl.excelDSL.JavaClass#getJavaObjectName <em>Java Object Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Java Object Name</em>' attribute.
   * @see #getJavaObjectName()
   * @generated
   */
  void setJavaObjectName(String value);

  /**
   * Returns the value of the '<em><b>Java Member Call</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Java Member Call</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Java Member Call</em>' containment reference.
   * @see #setJavaMemberCall(JavaMemberCall)
   * @see org.br.excel.exceldsl.excelDSL.ExcelDSLPackage#getJavaClass_JavaMemberCall()
   * @model containment="true"
   * @generated
   */
  JavaMemberCall getJavaMemberCall();

  /**
   * Sets the value of the '{@link org.br.excel.exceldsl.excelDSL.JavaClass#getJavaMemberCall <em>Java Member Call</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Java Member Call</em>' containment reference.
   * @see #getJavaMemberCall()
   * @generated
   */
  void setJavaMemberCall(JavaMemberCall value);

  /**
   * Returns the value of the '<em><b>Java Method Call</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Java Method Call</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Java Method Call</em>' containment reference.
   * @see #setJavaMethodCall(JavaMethodCall)
   * @see org.br.excel.exceldsl.excelDSL.ExcelDSLPackage#getJavaClass_JavaMethodCall()
   * @model containment="true"
   * @generated
   */
  JavaMethodCall getJavaMethodCall();

  /**
   * Sets the value of the '{@link org.br.excel.exceldsl.excelDSL.JavaClass#getJavaMethodCall <em>Java Method Call</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Java Method Call</em>' containment reference.
   * @see #getJavaMethodCall()
   * @generated
   */
  void setJavaMethodCall(JavaMethodCall value);

} // JavaClass
