/**
 */
package org.br.excel.exceldsl.excelDSL.impl;

import org.br.excel.exceldsl.excelDSL.BasicExpression;
import org.br.excel.exceldsl.excelDSL.ExcelDSLPackage;
import org.br.excel.exceldsl.excelDSL.ExpressionGroup;
import org.br.excel.exceldsl.excelDSL.InBuiltFunctionCall;
import org.br.excel.exceldsl.excelDSL.JavaClass;
import org.br.excel.exceldsl.excelDSL.Primitive;
import org.br.excel.exceldsl.excelDSL.Variable;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Basic Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.br.excel.exceldsl.excelDSL.impl.BasicExpressionImpl#getPrimitive <em>Primitive</em>}</li>
 *   <li>{@link org.br.excel.exceldsl.excelDSL.impl.BasicExpressionImpl#getVariable <em>Variable</em>}</li>
 *   <li>{@link org.br.excel.exceldsl.excelDSL.impl.BasicExpressionImpl#getInBuiltFunctionCall <em>In Built Function Call</em>}</li>
 *   <li>{@link org.br.excel.exceldsl.excelDSL.impl.BasicExpressionImpl#getJavaClass <em>Java Class</em>}</li>
 *   <li>{@link org.br.excel.exceldsl.excelDSL.impl.BasicExpressionImpl#getExpressionGroup <em>Expression Group</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BasicExpressionImpl extends MinimalEObjectImpl.Container implements BasicExpression
{
  /**
   * The cached value of the '{@link #getPrimitive() <em>Primitive</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrimitive()
   * @generated
   * @ordered
   */
  protected Primitive primitive;

  /**
   * The cached value of the '{@link #getVariable() <em>Variable</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVariable()
   * @generated
   * @ordered
   */
  protected Variable variable;

  /**
   * The cached value of the '{@link #getInBuiltFunctionCall() <em>In Built Function Call</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInBuiltFunctionCall()
   * @generated
   * @ordered
   */
  protected InBuiltFunctionCall inBuiltFunctionCall;

  /**
   * The cached value of the '{@link #getJavaClass() <em>Java Class</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getJavaClass()
   * @generated
   * @ordered
   */
  protected JavaClass javaClass;

  /**
   * The cached value of the '{@link #getExpressionGroup() <em>Expression Group</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpressionGroup()
   * @generated
   * @ordered
   */
  protected ExpressionGroup expressionGroup;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BasicExpressionImpl()
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
    return ExcelDSLPackage.Literals.BASIC_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Primitive getPrimitive()
  {
    return primitive;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPrimitive(Primitive newPrimitive, NotificationChain msgs)
  {
    Primitive oldPrimitive = primitive;
    primitive = newPrimitive;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExcelDSLPackage.BASIC_EXPRESSION__PRIMITIVE, oldPrimitive, newPrimitive);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPrimitive(Primitive newPrimitive)
  {
    if (newPrimitive != primitive)
    {
      NotificationChain msgs = null;
      if (primitive != null)
        msgs = ((InternalEObject)primitive).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExcelDSLPackage.BASIC_EXPRESSION__PRIMITIVE, null, msgs);
      if (newPrimitive != null)
        msgs = ((InternalEObject)newPrimitive).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExcelDSLPackage.BASIC_EXPRESSION__PRIMITIVE, null, msgs);
      msgs = basicSetPrimitive(newPrimitive, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExcelDSLPackage.BASIC_EXPRESSION__PRIMITIVE, newPrimitive, newPrimitive));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Variable getVariable()
  {
    return variable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetVariable(Variable newVariable, NotificationChain msgs)
  {
    Variable oldVariable = variable;
    variable = newVariable;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExcelDSLPackage.BASIC_EXPRESSION__VARIABLE, oldVariable, newVariable);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVariable(Variable newVariable)
  {
    if (newVariable != variable)
    {
      NotificationChain msgs = null;
      if (variable != null)
        msgs = ((InternalEObject)variable).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExcelDSLPackage.BASIC_EXPRESSION__VARIABLE, null, msgs);
      if (newVariable != null)
        msgs = ((InternalEObject)newVariable).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExcelDSLPackage.BASIC_EXPRESSION__VARIABLE, null, msgs);
      msgs = basicSetVariable(newVariable, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExcelDSLPackage.BASIC_EXPRESSION__VARIABLE, newVariable, newVariable));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InBuiltFunctionCall getInBuiltFunctionCall()
  {
    return inBuiltFunctionCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInBuiltFunctionCall(InBuiltFunctionCall newInBuiltFunctionCall, NotificationChain msgs)
  {
    InBuiltFunctionCall oldInBuiltFunctionCall = inBuiltFunctionCall;
    inBuiltFunctionCall = newInBuiltFunctionCall;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExcelDSLPackage.BASIC_EXPRESSION__IN_BUILT_FUNCTION_CALL, oldInBuiltFunctionCall, newInBuiltFunctionCall);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInBuiltFunctionCall(InBuiltFunctionCall newInBuiltFunctionCall)
  {
    if (newInBuiltFunctionCall != inBuiltFunctionCall)
    {
      NotificationChain msgs = null;
      if (inBuiltFunctionCall != null)
        msgs = ((InternalEObject)inBuiltFunctionCall).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExcelDSLPackage.BASIC_EXPRESSION__IN_BUILT_FUNCTION_CALL, null, msgs);
      if (newInBuiltFunctionCall != null)
        msgs = ((InternalEObject)newInBuiltFunctionCall).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExcelDSLPackage.BASIC_EXPRESSION__IN_BUILT_FUNCTION_CALL, null, msgs);
      msgs = basicSetInBuiltFunctionCall(newInBuiltFunctionCall, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExcelDSLPackage.BASIC_EXPRESSION__IN_BUILT_FUNCTION_CALL, newInBuiltFunctionCall, newInBuiltFunctionCall));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JavaClass getJavaClass()
  {
    return javaClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetJavaClass(JavaClass newJavaClass, NotificationChain msgs)
  {
    JavaClass oldJavaClass = javaClass;
    javaClass = newJavaClass;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExcelDSLPackage.BASIC_EXPRESSION__JAVA_CLASS, oldJavaClass, newJavaClass);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setJavaClass(JavaClass newJavaClass)
  {
    if (newJavaClass != javaClass)
    {
      NotificationChain msgs = null;
      if (javaClass != null)
        msgs = ((InternalEObject)javaClass).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExcelDSLPackage.BASIC_EXPRESSION__JAVA_CLASS, null, msgs);
      if (newJavaClass != null)
        msgs = ((InternalEObject)newJavaClass).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExcelDSLPackage.BASIC_EXPRESSION__JAVA_CLASS, null, msgs);
      msgs = basicSetJavaClass(newJavaClass, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExcelDSLPackage.BASIC_EXPRESSION__JAVA_CLASS, newJavaClass, newJavaClass));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExpressionGroup getExpressionGroup()
  {
    return expressionGroup;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExpressionGroup(ExpressionGroup newExpressionGroup, NotificationChain msgs)
  {
    ExpressionGroup oldExpressionGroup = expressionGroup;
    expressionGroup = newExpressionGroup;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExcelDSLPackage.BASIC_EXPRESSION__EXPRESSION_GROUP, oldExpressionGroup, newExpressionGroup);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExpressionGroup(ExpressionGroup newExpressionGroup)
  {
    if (newExpressionGroup != expressionGroup)
    {
      NotificationChain msgs = null;
      if (expressionGroup != null)
        msgs = ((InternalEObject)expressionGroup).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExcelDSLPackage.BASIC_EXPRESSION__EXPRESSION_GROUP, null, msgs);
      if (newExpressionGroup != null)
        msgs = ((InternalEObject)newExpressionGroup).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExcelDSLPackage.BASIC_EXPRESSION__EXPRESSION_GROUP, null, msgs);
      msgs = basicSetExpressionGroup(newExpressionGroup, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExcelDSLPackage.BASIC_EXPRESSION__EXPRESSION_GROUP, newExpressionGroup, newExpressionGroup));
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
      case ExcelDSLPackage.BASIC_EXPRESSION__PRIMITIVE:
        return basicSetPrimitive(null, msgs);
      case ExcelDSLPackage.BASIC_EXPRESSION__VARIABLE:
        return basicSetVariable(null, msgs);
      case ExcelDSLPackage.BASIC_EXPRESSION__IN_BUILT_FUNCTION_CALL:
        return basicSetInBuiltFunctionCall(null, msgs);
      case ExcelDSLPackage.BASIC_EXPRESSION__JAVA_CLASS:
        return basicSetJavaClass(null, msgs);
      case ExcelDSLPackage.BASIC_EXPRESSION__EXPRESSION_GROUP:
        return basicSetExpressionGroup(null, msgs);
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
      case ExcelDSLPackage.BASIC_EXPRESSION__PRIMITIVE:
        return getPrimitive();
      case ExcelDSLPackage.BASIC_EXPRESSION__VARIABLE:
        return getVariable();
      case ExcelDSLPackage.BASIC_EXPRESSION__IN_BUILT_FUNCTION_CALL:
        return getInBuiltFunctionCall();
      case ExcelDSLPackage.BASIC_EXPRESSION__JAVA_CLASS:
        return getJavaClass();
      case ExcelDSLPackage.BASIC_EXPRESSION__EXPRESSION_GROUP:
        return getExpressionGroup();
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
      case ExcelDSLPackage.BASIC_EXPRESSION__PRIMITIVE:
        setPrimitive((Primitive)newValue);
        return;
      case ExcelDSLPackage.BASIC_EXPRESSION__VARIABLE:
        setVariable((Variable)newValue);
        return;
      case ExcelDSLPackage.BASIC_EXPRESSION__IN_BUILT_FUNCTION_CALL:
        setInBuiltFunctionCall((InBuiltFunctionCall)newValue);
        return;
      case ExcelDSLPackage.BASIC_EXPRESSION__JAVA_CLASS:
        setJavaClass((JavaClass)newValue);
        return;
      case ExcelDSLPackage.BASIC_EXPRESSION__EXPRESSION_GROUP:
        setExpressionGroup((ExpressionGroup)newValue);
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
      case ExcelDSLPackage.BASIC_EXPRESSION__PRIMITIVE:
        setPrimitive((Primitive)null);
        return;
      case ExcelDSLPackage.BASIC_EXPRESSION__VARIABLE:
        setVariable((Variable)null);
        return;
      case ExcelDSLPackage.BASIC_EXPRESSION__IN_BUILT_FUNCTION_CALL:
        setInBuiltFunctionCall((InBuiltFunctionCall)null);
        return;
      case ExcelDSLPackage.BASIC_EXPRESSION__JAVA_CLASS:
        setJavaClass((JavaClass)null);
        return;
      case ExcelDSLPackage.BASIC_EXPRESSION__EXPRESSION_GROUP:
        setExpressionGroup((ExpressionGroup)null);
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
      case ExcelDSLPackage.BASIC_EXPRESSION__PRIMITIVE:
        return primitive != null;
      case ExcelDSLPackage.BASIC_EXPRESSION__VARIABLE:
        return variable != null;
      case ExcelDSLPackage.BASIC_EXPRESSION__IN_BUILT_FUNCTION_CALL:
        return inBuiltFunctionCall != null;
      case ExcelDSLPackage.BASIC_EXPRESSION__JAVA_CLASS:
        return javaClass != null;
      case ExcelDSLPackage.BASIC_EXPRESSION__EXPRESSION_GROUP:
        return expressionGroup != null;
    }
    return super.eIsSet(featureID);
  }

} //BasicExpressionImpl
