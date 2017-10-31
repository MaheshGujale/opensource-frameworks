/**
 */
package businessrules.ui.workflow.common.emf.model.Workflow.impl;

import businessrules.ui.workflow.common.emf.model.Workflow.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EWorkflowFactoryImpl extends EFactoryImpl implements EWorkflowFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EWorkflowFactory init() {
		try {
			EWorkflowFactory theEWorkflowFactory = (EWorkflowFactory)EPackage.Registry.INSTANCE.getEFactory(EWorkflowPackage.eNS_URI);
			if (theEWorkflowFactory != null) {
				return theEWorkflowFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EWorkflowFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EWorkflowFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case EWorkflowPackage.EBASE_STEP: return createEBaseStep();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EBaseStep createEBaseStep() {
		EBaseStepImpl eBaseStep = new EBaseStepImpl();
		return eBaseStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EWorkflowPackage getEWorkflowPackage() {
		return (EWorkflowPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EWorkflowPackage getPackage() {
		return EWorkflowPackage.eINSTANCE;
	}

} //EWorkflowFactoryImpl
