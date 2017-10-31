/**
 */
package businessrules.ui.workflow.common.emf.model.Workflow.impl;

import businessrules.ui.workflow.common.emf.model.Workflow.EBaseStep;
import businessrules.ui.workflow.common.emf.model.Workflow.EWorkflowPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EBase Step</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link businessrules.ui.workflow.common.emf.model.Workflow.impl.EBaseStepImpl#getDiagramType <em>Diagram Type</em>}</li>
 *   <li>{@link businessrules.ui.workflow.common.emf.model.Workflow.impl.EBaseStepImpl#getStepInstance <em>Step Instance</em>}</li>
 *   <li>{@link businessrules.ui.workflow.common.emf.model.Workflow.impl.EBaseStepImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EBaseStepImpl extends EObjectImpl implements EBaseStep {
	/**
	 * The default value of the '{@link #getDiagramType() <em>Diagram Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagramType()
	 * @generated
	 * @ordered
	 */
	protected static final String DIAGRAM_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDiagramType() <em>Diagram Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagramType()
	 * @generated
	 * @ordered
	 */
	protected String diagramType = DIAGRAM_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getStepInstance() <em>Step Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStepInstance()
	 * @generated
	 * @ordered
	 */
	protected static final Object STEP_INSTANCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStepInstance() <em>Step Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStepInstance()
	 * @generated
	 * @ordered
	 */
	protected Object stepInstance = STEP_INSTANCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EBaseStepImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EWorkflowPackage.Literals.EBASE_STEP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDiagramType() {
		return diagramType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDiagramType(String newDiagramType) {
		String oldDiagramType = diagramType;
		diagramType = newDiagramType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EWorkflowPackage.EBASE_STEP__DIAGRAM_TYPE, oldDiagramType, diagramType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getStepInstance() {
		return stepInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStepInstance(Object newStepInstance) {
		Object oldStepInstance = stepInstance;
		stepInstance = newStepInstance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EWorkflowPackage.EBASE_STEP__STEP_INSTANCE, oldStepInstance, stepInstance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EWorkflowPackage.EBASE_STEP__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EWorkflowPackage.EBASE_STEP__DIAGRAM_TYPE:
				return getDiagramType();
			case EWorkflowPackage.EBASE_STEP__STEP_INSTANCE:
				return getStepInstance();
			case EWorkflowPackage.EBASE_STEP__NAME:
				return getName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EWorkflowPackage.EBASE_STEP__DIAGRAM_TYPE:
				setDiagramType((String)newValue);
				return;
			case EWorkflowPackage.EBASE_STEP__STEP_INSTANCE:
				setStepInstance(newValue);
				return;
			case EWorkflowPackage.EBASE_STEP__NAME:
				setName((String)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case EWorkflowPackage.EBASE_STEP__DIAGRAM_TYPE:
				setDiagramType(DIAGRAM_TYPE_EDEFAULT);
				return;
			case EWorkflowPackage.EBASE_STEP__STEP_INSTANCE:
				setStepInstance(STEP_INSTANCE_EDEFAULT);
				return;
			case EWorkflowPackage.EBASE_STEP__NAME:
				setName(NAME_EDEFAULT);
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EWorkflowPackage.EBASE_STEP__DIAGRAM_TYPE:
				return DIAGRAM_TYPE_EDEFAULT == null ? diagramType != null : !DIAGRAM_TYPE_EDEFAULT.equals(diagramType);
			case EWorkflowPackage.EBASE_STEP__STEP_INSTANCE:
				return STEP_INSTANCE_EDEFAULT == null ? stepInstance != null : !STEP_INSTANCE_EDEFAULT.equals(stepInstance);
			case EWorkflowPackage.EBASE_STEP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (diagramType: ");
		result.append(diagramType);
		result.append(", stepInstance: ");
		result.append(stepInstance);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //EBaseStepImpl
