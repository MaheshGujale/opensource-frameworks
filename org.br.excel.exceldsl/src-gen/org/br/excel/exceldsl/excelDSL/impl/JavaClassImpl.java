/**
 */
package org.br.excel.exceldsl.excelDSL.impl;

import org.br.excel.exceldsl.excelDSL.ExcelDSLPackage;
import org.br.excel.exceldsl.excelDSL.JavaClass;
import org.br.excel.exceldsl.excelDSL.JavaMemberCall;
import org.br.excel.exceldsl.excelDSL.JavaMethodCall;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Java Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.br.excel.exceldsl.excelDSL.impl.JavaClassImpl#getJavaObjectName <em>Java Object Name</em>}</li>
 *   <li>{@link org.br.excel.exceldsl.excelDSL.impl.JavaClassImpl#getJavaMemberCall <em>Java Member Call</em>}</li>
 *   <li>{@link org.br.excel.exceldsl.excelDSL.impl.JavaClassImpl#getJavaMethodCall <em>Java Method Call</em>}</li>
 * </ul>
 *
 * @generated
 */
public class JavaClassImpl extends MinimalEObjectImpl.Container implements JavaClass
{
  /**
   * The default value of the '{@link #getJavaObjectName() <em>Java Object Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getJavaObjectName()
   * @generated
   * @ordered
   */
  protected static final String JAVA_OBJECT_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getJavaObjectName() <em>Java Object Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getJavaObjectName()
   * @generated
   * @ordered
   */
  protected String javaObjectName = JAVA_OBJECT_NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getJavaMemberCall() <em>Java Member Call</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getJavaMemberCall()
   * @generated
   * @ordered
   */
  protected JavaMemberCall javaMemberCall;

  /**
   * The cached value of the '{@link #getJavaMethodCall() <em>Java Method Call</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getJavaMethodCall()
   * @generated
   * @ordered
   */
  protected JavaMethodCall javaMethodCall;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected JavaClassImpl()
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
    return ExcelDSLPackage.Literals.JAVA_CLASS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getJavaObjectName()
  {
    return javaObjectName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setJavaObjectName(String newJavaObjectName)
  {
    String oldJavaObjectName = javaObjectName;
    javaObjectName = newJavaObjectName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExcelDSLPackage.JAVA_CLASS__JAVA_OBJECT_NAME, oldJavaObjectName, javaObjectName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JavaMemberCall getJavaMemberCall()
  {
    return javaMemberCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetJavaMemberCall(JavaMemberCall newJavaMemberCall, NotificationChain msgs)
  {
    JavaMemberCall oldJavaMemberCall = javaMemberCall;
    javaMemberCall = newJavaMemberCall;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExcelDSLPackage.JAVA_CLASS__JAVA_MEMBER_CALL, oldJavaMemberCall, newJavaMemberCall);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setJavaMemberCall(JavaMemberCall newJavaMemberCall)
  {
    if (newJavaMemberCall != javaMemberCall)
    {
      NotificationChain msgs = null;
      if (javaMemberCall != null)
        msgs = ((InternalEObject)javaMemberCall).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExcelDSLPackage.JAVA_CLASS__JAVA_MEMBER_CALL, null, msgs);
      if (newJavaMemberCall != null)
        msgs = ((InternalEObject)newJavaMemberCall).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExcelDSLPackage.JAVA_CLASS__JAVA_MEMBER_CALL, null, msgs);
      msgs = basicSetJavaMemberCall(newJavaMemberCall, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExcelDSLPackage.JAVA_CLASS__JAVA_MEMBER_CALL, newJavaMemberCall, newJavaMemberCall));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JavaMethodCall getJavaMethodCall()
  {
    return javaMethodCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetJavaMethodCall(JavaMethodCall newJavaMethodCall, NotificationChain msgs)
  {
    JavaMethodCall oldJavaMethodCall = javaMethodCall;
    javaMethodCall = newJavaMethodCall;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExcelDSLPackage.JAVA_CLASS__JAVA_METHOD_CALL, oldJavaMethodCall, newJavaMethodCall);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setJavaMethodCall(JavaMethodCall newJavaMethodCall)
  {
    if (newJavaMethodCall != javaMethodCall)
    {
      NotificationChain msgs = null;
      if (javaMethodCall != null)
        msgs = ((InternalEObject)javaMethodCall).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExcelDSLPackage.JAVA_CLASS__JAVA_METHOD_CALL, null, msgs);
      if (newJavaMethodCall != null)
        msgs = ((InternalEObject)newJavaMethodCall).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExcelDSLPackage.JAVA_CLASS__JAVA_METHOD_CALL, null, msgs);
      msgs = basicSetJavaMethodCall(newJavaMethodCall, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExcelDSLPackage.JAVA_CLASS__JAVA_METHOD_CALL, newJavaMethodCall, newJavaMethodCall));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case ExcelDSLPackage.JAVA_CLASS__JAVA_MEMBER_CALL:
        return basicSetJavaMemberCall(null, msgs);
      case ExcelDSLPackage.JAVA_CLASS__JAVA_METHOD_CALL:
        return basicSetJavaMethodCall(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case ExcelDSLPackage.JAVA_CLASS__JAVA_OBJECT_NAME:
        return getJavaObjectName();
      case ExcelDSLPackage.JAVA_CLASS__JAVA_MEMBER_CALL:
        return getJavaMemberCall();
      case ExcelDSLPackage.JAVA_CLASS__JAVA_METHOD_CALL:
        return getJavaMethodCall();
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
      case ExcelDSLPackage.JAVA_CLASS__JAVA_OBJECT_NAME:
        setJavaObjectName((String)newValue);
        return;
      case ExcelDSLPackage.JAVA_CLASS__JAVA_MEMBER_CALL:
        setJavaMemberCall((JavaMemberCall)newValue);
        return;
      case ExcelDSLPackage.JAVA_CLASS__JAVA_METHOD_CALL:
        setJavaMethodCall((JavaMethodCall)newValue);
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
      case ExcelDSLPackage.JAVA_CLASS__JAVA_OBJECT_NAME:
        setJavaObjectName(JAVA_OBJECT_NAME_EDEFAULT);
        return;
      case ExcelDSLPackage.JAVA_CLASS__JAVA_MEMBER_CALL:
        setJavaMemberCall((JavaMemberCall)null);
        return;
      case ExcelDSLPackage.JAVA_CLASS__JAVA_METHOD_CALL:
        setJavaMethodCall((JavaMethodCall)null);
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
      case ExcelDSLPackage.JAVA_CLASS__JAVA_OBJECT_NAME:
        return JAVA_OBJECT_NAME_EDEFAULT == null ? javaObjectName != null : !JAVA_OBJECT_NAME_EDEFAULT.equals(javaObjectName);
      case ExcelDSLPackage.JAVA_CLASS__JAVA_MEMBER_CALL:
        return javaMemberCall != null;
      case ExcelDSLPackage.JAVA_CLASS__JAVA_METHOD_CALL:
        return javaMethodCall != null;
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
    result.append(" (javaObjectName: ");
    result.append(javaObjectName);
    result.append(')');
    return result.toString();
  }

} //JavaClassImpl
