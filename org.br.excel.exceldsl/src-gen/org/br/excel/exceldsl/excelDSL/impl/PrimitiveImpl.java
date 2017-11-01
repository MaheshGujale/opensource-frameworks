/**
 */
package org.br.excel.exceldsl.excelDSL.impl;

import org.br.excel.exceldsl.excelDSL.ExcelDSLPackage;
import org.br.excel.exceldsl.excelDSL.Primitive;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primitive</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.br.excel.exceldsl.excelDSL.impl.PrimitiveImpl#getStrValue <em>Str Value</em>}</li>
 *   <li>{@link org.br.excel.exceldsl.excelDSL.impl.PrimitiveImpl#getIntValue <em>Int Value</em>}</li>
 *   <li>{@link org.br.excel.exceldsl.excelDSL.impl.PrimitiveImpl#getDoubleValue <em>Double Value</em>}</li>
 *   <li>{@link org.br.excel.exceldsl.excelDSL.impl.PrimitiveImpl#getFloatValue <em>Float Value</em>}</li>
 *   <li>{@link org.br.excel.exceldsl.excelDSL.impl.PrimitiveImpl#getBooleanValue <em>Boolean Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PrimitiveImpl extends MinimalEObjectImpl.Container implements Primitive
{
  /**
   * The default value of the '{@link #getStrValue() <em>Str Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStrValue()
   * @generated
   * @ordered
   */
  protected static final String STR_VALUE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getStrValue() <em>Str Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStrValue()
   * @generated
   * @ordered
   */
  protected String strValue = STR_VALUE_EDEFAULT;

  /**
   * The default value of the '{@link #getIntValue() <em>Int Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIntValue()
   * @generated
   * @ordered
   */
  protected static final String INT_VALUE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getIntValue() <em>Int Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIntValue()
   * @generated
   * @ordered
   */
  protected String intValue = INT_VALUE_EDEFAULT;

  /**
   * The default value of the '{@link #getDoubleValue() <em>Double Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDoubleValue()
   * @generated
   * @ordered
   */
  protected static final String DOUBLE_VALUE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDoubleValue() <em>Double Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDoubleValue()
   * @generated
   * @ordered
   */
  protected String doubleValue = DOUBLE_VALUE_EDEFAULT;

  /**
   * The default value of the '{@link #getFloatValue() <em>Float Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFloatValue()
   * @generated
   * @ordered
   */
  protected static final String FLOAT_VALUE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFloatValue() <em>Float Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFloatValue()
   * @generated
   * @ordered
   */
  protected String floatValue = FLOAT_VALUE_EDEFAULT;

  /**
   * The default value of the '{@link #getBooleanValue() <em>Boolean Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBooleanValue()
   * @generated
   * @ordered
   */
  protected static final String BOOLEAN_VALUE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getBooleanValue() <em>Boolean Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBooleanValue()
   * @generated
   * @ordered
   */
  protected String booleanValue = BOOLEAN_VALUE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PrimitiveImpl()
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
    return ExcelDSLPackage.Literals.PRIMITIVE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getStrValue()
  {
    return strValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStrValue(String newStrValue)
  {
    String oldStrValue = strValue;
    strValue = newStrValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExcelDSLPackage.PRIMITIVE__STR_VALUE, oldStrValue, strValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getIntValue()
  {
    return intValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIntValue(String newIntValue)
  {
    String oldIntValue = intValue;
    intValue = newIntValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExcelDSLPackage.PRIMITIVE__INT_VALUE, oldIntValue, intValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDoubleValue()
  {
    return doubleValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDoubleValue(String newDoubleValue)
  {
    String oldDoubleValue = doubleValue;
    doubleValue = newDoubleValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExcelDSLPackage.PRIMITIVE__DOUBLE_VALUE, oldDoubleValue, doubleValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getFloatValue()
  {
    return floatValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFloatValue(String newFloatValue)
  {
    String oldFloatValue = floatValue;
    floatValue = newFloatValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExcelDSLPackage.PRIMITIVE__FLOAT_VALUE, oldFloatValue, floatValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getBooleanValue()
  {
    return booleanValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBooleanValue(String newBooleanValue)
  {
    String oldBooleanValue = booleanValue;
    booleanValue = newBooleanValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExcelDSLPackage.PRIMITIVE__BOOLEAN_VALUE, oldBooleanValue, booleanValue));
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
      case ExcelDSLPackage.PRIMITIVE__STR_VALUE:
        return getStrValue();
      case ExcelDSLPackage.PRIMITIVE__INT_VALUE:
        return getIntValue();
      case ExcelDSLPackage.PRIMITIVE__DOUBLE_VALUE:
        return getDoubleValue();
      case ExcelDSLPackage.PRIMITIVE__FLOAT_VALUE:
        return getFloatValue();
      case ExcelDSLPackage.PRIMITIVE__BOOLEAN_VALUE:
        return getBooleanValue();
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
      case ExcelDSLPackage.PRIMITIVE__STR_VALUE:
        setStrValue((String)newValue);
        return;
      case ExcelDSLPackage.PRIMITIVE__INT_VALUE:
        setIntValue((String)newValue);
        return;
      case ExcelDSLPackage.PRIMITIVE__DOUBLE_VALUE:
        setDoubleValue((String)newValue);
        return;
      case ExcelDSLPackage.PRIMITIVE__FLOAT_VALUE:
        setFloatValue((String)newValue);
        return;
      case ExcelDSLPackage.PRIMITIVE__BOOLEAN_VALUE:
        setBooleanValue((String)newValue);
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
      case ExcelDSLPackage.PRIMITIVE__STR_VALUE:
        setStrValue(STR_VALUE_EDEFAULT);
        return;
      case ExcelDSLPackage.PRIMITIVE__INT_VALUE:
        setIntValue(INT_VALUE_EDEFAULT);
        return;
      case ExcelDSLPackage.PRIMITIVE__DOUBLE_VALUE:
        setDoubleValue(DOUBLE_VALUE_EDEFAULT);
        return;
      case ExcelDSLPackage.PRIMITIVE__FLOAT_VALUE:
        setFloatValue(FLOAT_VALUE_EDEFAULT);
        return;
      case ExcelDSLPackage.PRIMITIVE__BOOLEAN_VALUE:
        setBooleanValue(BOOLEAN_VALUE_EDEFAULT);
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
      case ExcelDSLPackage.PRIMITIVE__STR_VALUE:
        return STR_VALUE_EDEFAULT == null ? strValue != null : !STR_VALUE_EDEFAULT.equals(strValue);
      case ExcelDSLPackage.PRIMITIVE__INT_VALUE:
        return INT_VALUE_EDEFAULT == null ? intValue != null : !INT_VALUE_EDEFAULT.equals(intValue);
      case ExcelDSLPackage.PRIMITIVE__DOUBLE_VALUE:
        return DOUBLE_VALUE_EDEFAULT == null ? doubleValue != null : !DOUBLE_VALUE_EDEFAULT.equals(doubleValue);
      case ExcelDSLPackage.PRIMITIVE__FLOAT_VALUE:
        return FLOAT_VALUE_EDEFAULT == null ? floatValue != null : !FLOAT_VALUE_EDEFAULT.equals(floatValue);
      case ExcelDSLPackage.PRIMITIVE__BOOLEAN_VALUE:
        return BOOLEAN_VALUE_EDEFAULT == null ? booleanValue != null : !BOOLEAN_VALUE_EDEFAULT.equals(booleanValue);
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
    result.append(" (strValue: ");
    result.append(strValue);
    result.append(", intValue: ");
    result.append(intValue);
    result.append(", doubleValue: ");
    result.append(doubleValue);
    result.append(", floatValue: ");
    result.append(floatValue);
    result.append(", booleanValue: ");
    result.append(booleanValue);
    result.append(')');
    return result.toString();
  }

} //PrimitiveImpl
