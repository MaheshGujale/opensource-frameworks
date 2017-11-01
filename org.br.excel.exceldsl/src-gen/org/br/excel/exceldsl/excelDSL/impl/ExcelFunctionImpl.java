/**
 */
package org.br.excel.exceldsl.excelDSL.impl;

import org.br.excel.exceldsl.excelDSL.ExcelDSLPackage;
import org.br.excel.exceldsl.excelDSL.ExcelFunction;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Excel Function</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.br.excel.exceldsl.excelDSL.impl.ExcelFunctionImpl#getExcelFunctionName <em>Excel Function Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExcelFunctionImpl extends MinimalEObjectImpl.Container implements ExcelFunction
{
  /**
   * The default value of the '{@link #getExcelFunctionName() <em>Excel Function Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExcelFunctionName()
   * @generated
   * @ordered
   */
  protected static final String EXCEL_FUNCTION_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getExcelFunctionName() <em>Excel Function Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExcelFunctionName()
   * @generated
   * @ordered
   */
  protected String excelFunctionName = EXCEL_FUNCTION_NAME_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExcelFunctionImpl()
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
    return ExcelDSLPackage.Literals.EXCEL_FUNCTION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getExcelFunctionName()
  {
    return excelFunctionName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExcelFunctionName(String newExcelFunctionName)
  {
    String oldExcelFunctionName = excelFunctionName;
    excelFunctionName = newExcelFunctionName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExcelDSLPackage.EXCEL_FUNCTION__EXCEL_FUNCTION_NAME, oldExcelFunctionName, excelFunctionName));
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
      case ExcelDSLPackage.EXCEL_FUNCTION__EXCEL_FUNCTION_NAME:
        return getExcelFunctionName();
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
      case ExcelDSLPackage.EXCEL_FUNCTION__EXCEL_FUNCTION_NAME:
        setExcelFunctionName((String)newValue);
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
      case ExcelDSLPackage.EXCEL_FUNCTION__EXCEL_FUNCTION_NAME:
        setExcelFunctionName(EXCEL_FUNCTION_NAME_EDEFAULT);
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
      case ExcelDSLPackage.EXCEL_FUNCTION__EXCEL_FUNCTION_NAME:
        return EXCEL_FUNCTION_NAME_EDEFAULT == null ? excelFunctionName != null : !EXCEL_FUNCTION_NAME_EDEFAULT.equals(excelFunctionName);
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
    result.append(" (excelFunctionName: ");
    result.append(excelFunctionName);
    result.append(')');
    return result.toString();
  }

} //ExcelFunctionImpl
