/**
 */
package org.br.excel.exceldsl.excelDSL.impl;

import java.util.Collection;

import org.br.excel.exceldsl.excelDSL.ExcelDSLPackage;
import org.br.excel.exceldsl.excelDSL.FunctionParameters;
import org.br.excel.exceldsl.excelDSL.JavaMethodCall;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Java Method Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.br.excel.exceldsl.excelDSL.impl.JavaMethodCallImpl#getAccessName <em>Access Name</em>}</li>
 *   <li>{@link org.br.excel.exceldsl.excelDSL.impl.JavaMethodCallImpl#getFunctionParameters <em>Function Parameters</em>}</li>
 *   <li>{@link org.br.excel.exceldsl.excelDSL.impl.JavaMethodCallImpl#getJavaMethodCall <em>Java Method Call</em>}</li>
 * </ul>
 *
 * @generated
 */
public class JavaMethodCallImpl extends MinimalEObjectImpl.Container implements JavaMethodCall
{
  /**
   * The cached value of the '{@link #getAccessName() <em>Access Name</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAccessName()
   * @generated
   * @ordered
   */
  protected EList<String> accessName;

  /**
   * The cached value of the '{@link #getFunctionParameters() <em>Function Parameters</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFunctionParameters()
   * @generated
   * @ordered
   */
  protected FunctionParameters functionParameters;

  /**
   * The cached value of the '{@link #getJavaMethodCall() <em>Java Method Call</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getJavaMethodCall()
   * @generated
   * @ordered
   */
  protected EList<JavaMethodCall> javaMethodCall;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected JavaMethodCallImpl()
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
    return ExcelDSLPackage.Literals.JAVA_METHOD_CALL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getAccessName()
  {
    if (accessName == null)
    {
      accessName = new EDataTypeEList<String>(String.class, this, ExcelDSLPackage.JAVA_METHOD_CALL__ACCESS_NAME);
    }
    return accessName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunctionParameters getFunctionParameters()
  {
    return functionParameters;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFunctionParameters(FunctionParameters newFunctionParameters, NotificationChain msgs)
  {
    FunctionParameters oldFunctionParameters = functionParameters;
    functionParameters = newFunctionParameters;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExcelDSLPackage.JAVA_METHOD_CALL__FUNCTION_PARAMETERS, oldFunctionParameters, newFunctionParameters);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFunctionParameters(FunctionParameters newFunctionParameters)
  {
    if (newFunctionParameters != functionParameters)
    {
      NotificationChain msgs = null;
      if (functionParameters != null)
        msgs = ((InternalEObject)functionParameters).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExcelDSLPackage.JAVA_METHOD_CALL__FUNCTION_PARAMETERS, null, msgs);
      if (newFunctionParameters != null)
        msgs = ((InternalEObject)newFunctionParameters).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExcelDSLPackage.JAVA_METHOD_CALL__FUNCTION_PARAMETERS, null, msgs);
      msgs = basicSetFunctionParameters(newFunctionParameters, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExcelDSLPackage.JAVA_METHOD_CALL__FUNCTION_PARAMETERS, newFunctionParameters, newFunctionParameters));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<JavaMethodCall> getJavaMethodCall()
  {
    if (javaMethodCall == null)
    {
      javaMethodCall = new EObjectContainmentEList<JavaMethodCall>(JavaMethodCall.class, this, ExcelDSLPackage.JAVA_METHOD_CALL__JAVA_METHOD_CALL);
    }
    return javaMethodCall;
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
      case ExcelDSLPackage.JAVA_METHOD_CALL__FUNCTION_PARAMETERS:
        return basicSetFunctionParameters(null, msgs);
      case ExcelDSLPackage.JAVA_METHOD_CALL__JAVA_METHOD_CALL:
        return ((InternalEList<?>)getJavaMethodCall()).basicRemove(otherEnd, msgs);
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
      case ExcelDSLPackage.JAVA_METHOD_CALL__ACCESS_NAME:
        return getAccessName();
      case ExcelDSLPackage.JAVA_METHOD_CALL__FUNCTION_PARAMETERS:
        return getFunctionParameters();
      case ExcelDSLPackage.JAVA_METHOD_CALL__JAVA_METHOD_CALL:
        return getJavaMethodCall();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ExcelDSLPackage.JAVA_METHOD_CALL__ACCESS_NAME:
        getAccessName().clear();
        getAccessName().addAll((Collection<? extends String>)newValue);
        return;
      case ExcelDSLPackage.JAVA_METHOD_CALL__FUNCTION_PARAMETERS:
        setFunctionParameters((FunctionParameters)newValue);
        return;
      case ExcelDSLPackage.JAVA_METHOD_CALL__JAVA_METHOD_CALL:
        getJavaMethodCall().clear();
        getJavaMethodCall().addAll((Collection<? extends JavaMethodCall>)newValue);
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
      case ExcelDSLPackage.JAVA_METHOD_CALL__ACCESS_NAME:
        getAccessName().clear();
        return;
      case ExcelDSLPackage.JAVA_METHOD_CALL__FUNCTION_PARAMETERS:
        setFunctionParameters((FunctionParameters)null);
        return;
      case ExcelDSLPackage.JAVA_METHOD_CALL__JAVA_METHOD_CALL:
        getJavaMethodCall().clear();
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
      case ExcelDSLPackage.JAVA_METHOD_CALL__ACCESS_NAME:
        return accessName != null && !accessName.isEmpty();
      case ExcelDSLPackage.JAVA_METHOD_CALL__FUNCTION_PARAMETERS:
        return functionParameters != null;
      case ExcelDSLPackage.JAVA_METHOD_CALL__JAVA_METHOD_CALL:
        return javaMethodCall != null && !javaMethodCall.isEmpty();
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

} //JavaMethodCallImpl
