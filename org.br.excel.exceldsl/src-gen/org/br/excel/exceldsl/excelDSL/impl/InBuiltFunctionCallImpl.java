/**
 */
package org.br.excel.exceldsl.excelDSL.impl;

import org.br.excel.exceldsl.excelDSL.ExcelDSLPackage;
import org.br.excel.exceldsl.excelDSL.ExcelFunction;
import org.br.excel.exceldsl.excelDSL.FunctionParameters;
import org.br.excel.exceldsl.excelDSL.InBuiltFunctionCall;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>In Built Function Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.br.excel.exceldsl.excelDSL.impl.InBuiltFunctionCallImpl#getExcelFunction <em>Excel Function</em>}</li>
 *   <li>{@link org.br.excel.exceldsl.excelDSL.impl.InBuiltFunctionCallImpl#getFunctionParameters <em>Function Parameters</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InBuiltFunctionCallImpl extends MinimalEObjectImpl.Container implements InBuiltFunctionCall
{
  /**
   * The cached value of the '{@link #getExcelFunction() <em>Excel Function</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExcelFunction()
   * @generated
   * @ordered
   */
  protected ExcelFunction excelFunction;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InBuiltFunctionCallImpl()
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
    return ExcelDSLPackage.Literals.IN_BUILT_FUNCTION_CALL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExcelFunction getExcelFunction()
  {
    return excelFunction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExcelFunction(ExcelFunction newExcelFunction, NotificationChain msgs)
  {
    ExcelFunction oldExcelFunction = excelFunction;
    excelFunction = newExcelFunction;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExcelDSLPackage.IN_BUILT_FUNCTION_CALL__EXCEL_FUNCTION, oldExcelFunction, newExcelFunction);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExcelFunction(ExcelFunction newExcelFunction)
  {
    if (newExcelFunction != excelFunction)
    {
      NotificationChain msgs = null;
      if (excelFunction != null)
        msgs = ((InternalEObject)excelFunction).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExcelDSLPackage.IN_BUILT_FUNCTION_CALL__EXCEL_FUNCTION, null, msgs);
      if (newExcelFunction != null)
        msgs = ((InternalEObject)newExcelFunction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExcelDSLPackage.IN_BUILT_FUNCTION_CALL__EXCEL_FUNCTION, null, msgs);
      msgs = basicSetExcelFunction(newExcelFunction, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExcelDSLPackage.IN_BUILT_FUNCTION_CALL__EXCEL_FUNCTION, newExcelFunction, newExcelFunction));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExcelDSLPackage.IN_BUILT_FUNCTION_CALL__FUNCTION_PARAMETERS, oldFunctionParameters, newFunctionParameters);
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
        msgs = ((InternalEObject)functionParameters).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExcelDSLPackage.IN_BUILT_FUNCTION_CALL__FUNCTION_PARAMETERS, null, msgs);
      if (newFunctionParameters != null)
        msgs = ((InternalEObject)newFunctionParameters).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExcelDSLPackage.IN_BUILT_FUNCTION_CALL__FUNCTION_PARAMETERS, null, msgs);
      msgs = basicSetFunctionParameters(newFunctionParameters, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExcelDSLPackage.IN_BUILT_FUNCTION_CALL__FUNCTION_PARAMETERS, newFunctionParameters, newFunctionParameters));
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
      case ExcelDSLPackage.IN_BUILT_FUNCTION_CALL__EXCEL_FUNCTION:
        return basicSetExcelFunction(null, msgs);
      case ExcelDSLPackage.IN_BUILT_FUNCTION_CALL__FUNCTION_PARAMETERS:
        return basicSetFunctionParameters(null, msgs);
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
      case ExcelDSLPackage.IN_BUILT_FUNCTION_CALL__EXCEL_FUNCTION:
        return getExcelFunction();
      case ExcelDSLPackage.IN_BUILT_FUNCTION_CALL__FUNCTION_PARAMETERS:
        return getFunctionParameters();
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
      case ExcelDSLPackage.IN_BUILT_FUNCTION_CALL__EXCEL_FUNCTION:
        setExcelFunction((ExcelFunction)newValue);
        return;
      case ExcelDSLPackage.IN_BUILT_FUNCTION_CALL__FUNCTION_PARAMETERS:
        setFunctionParameters((FunctionParameters)newValue);
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
      case ExcelDSLPackage.IN_BUILT_FUNCTION_CALL__EXCEL_FUNCTION:
        setExcelFunction((ExcelFunction)null);
        return;
      case ExcelDSLPackage.IN_BUILT_FUNCTION_CALL__FUNCTION_PARAMETERS:
        setFunctionParameters((FunctionParameters)null);
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
      case ExcelDSLPackage.IN_BUILT_FUNCTION_CALL__EXCEL_FUNCTION:
        return excelFunction != null;
      case ExcelDSLPackage.IN_BUILT_FUNCTION_CALL__FUNCTION_PARAMETERS:
        return functionParameters != null;
    }
    return super.eIsSet(featureID);
  }

} //InBuiltFunctionCallImpl
