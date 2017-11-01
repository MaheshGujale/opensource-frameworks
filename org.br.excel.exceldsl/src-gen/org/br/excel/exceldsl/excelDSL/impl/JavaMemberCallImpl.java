/**
 */
package org.br.excel.exceldsl.excelDSL.impl;

import org.br.excel.exceldsl.excelDSL.ExcelDSLPackage;
import org.br.excel.exceldsl.excelDSL.JavaMemberCall;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Java Member Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.br.excel.exceldsl.excelDSL.impl.JavaMemberCallImpl#getAccessName <em>Access Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class JavaMemberCallImpl extends MinimalEObjectImpl.Container implements JavaMemberCall
{
  /**
   * The default value of the '{@link #getAccessName() <em>Access Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAccessName()
   * @generated
   * @ordered
   */
  protected static final String ACCESS_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getAccessName() <em>Access Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAccessName()
   * @generated
   * @ordered
   */
  protected String accessName = ACCESS_NAME_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected JavaMemberCallImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ExcelDSLPackage.Literals.JAVA_MEMBER_CALL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getAccessName()
  {
    return accessName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAccessName(String newAccessName)
  {
    String oldAccessName = accessName;
    accessName = newAccessName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExcelDSLPackage.JAVA_MEMBER_CALL__ACCESS_NAME, oldAccessName, accessName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case ExcelDSLPackage.JAVA_MEMBER_CALL__ACCESS_NAME:
        return getAccessName();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ExcelDSLPackage.JAVA_MEMBER_CALL__ACCESS_NAME:
        setAccessName((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case ExcelDSLPackage.JAVA_MEMBER_CALL__ACCESS_NAME:
        setAccessName(ACCESS_NAME_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case ExcelDSLPackage.JAVA_MEMBER_CALL__ACCESS_NAME:
        return ACCESS_NAME_EDEFAULT == null ? accessName != null : !ACCESS_NAME_EDEFAULT.equals(accessName);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (accessName: ");
    result.append(accessName);
    result.append(')');
    return result.toString();
  }

} //JavaMemberCallImpl
