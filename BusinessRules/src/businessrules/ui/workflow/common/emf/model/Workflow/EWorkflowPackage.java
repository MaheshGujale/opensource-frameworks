/**
 */
package businessrules.ui.workflow.common.emf.model.Workflow;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see businessrules.ui.workflow.common.emf.model.Workflow.EWorkflowFactory
 * @model kind="package"
 * @generated
 */
public interface EWorkflowPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "Workflow";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "www.opussoft.com";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "com.ecs.bizrules.ui.workflow.emf.model";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EWorkflowPackage eINSTANCE = businessrules.ui.workflow.common.emf.model.Workflow.impl.EWorkflowPackageImpl.init();

	/**
	 * The meta object id for the '{@link businessrules.ui.workflow.common.emf.model.Workflow.impl.EBaseStepImpl <em>EBase Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see businessrules.ui.workflow.common.emf.model.Workflow.impl.EBaseStepImpl
	 * @see businessrules.ui.workflow.common.emf.model.Workflow.impl.EWorkflowPackageImpl#getEBaseStep()
	 * @generated
	 */
	int EBASE_STEP = 0;

	/**
	 * The feature id for the '<em><b>Diagram Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EBASE_STEP__DIAGRAM_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Step Instance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EBASE_STEP__STEP_INSTANCE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EBASE_STEP__NAME = 2;

	/**
	 * The number of structural features of the '<em>EBase Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EBASE_STEP_FEATURE_COUNT = 3;


	/**
	 * Returns the meta object for class '{@link businessrules.ui.workflow.common.emf.model.Workflow.EBaseStep <em>EBase Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EBase Step</em>'.
	 * @see businessrules.ui.workflow.common.emf.model.Workflow.EBaseStep
	 * @generated
	 */
	EClass getEBaseStep();

	/**
	 * Returns the meta object for the attribute '{@link businessrules.ui.workflow.common.emf.model.Workflow.EBaseStep#getDiagramType <em>Diagram Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Diagram Type</em>'.
	 * @see businessrules.ui.workflow.common.emf.model.Workflow.EBaseStep#getDiagramType()
	 * @see #getEBaseStep()
	 * @generated
	 */
	EAttribute getEBaseStep_DiagramType();

	/**
	 * Returns the meta object for the attribute '{@link businessrules.ui.workflow.common.emf.model.Workflow.EBaseStep#getStepInstance <em>Step Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Step Instance</em>'.
	 * @see businessrules.ui.workflow.common.emf.model.Workflow.EBaseStep#getStepInstance()
	 * @see #getEBaseStep()
	 * @generated
	 */
	EAttribute getEBaseStep_StepInstance();

	/**
	 * Returns the meta object for the attribute '{@link businessrules.ui.workflow.common.emf.model.Workflow.EBaseStep#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see businessrules.ui.workflow.common.emf.model.Workflow.EBaseStep#getName()
	 * @see #getEBaseStep()
	 * @generated
	 */
	EAttribute getEBaseStep_Name();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EWorkflowFactory getEWorkflowFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link businessrules.ui.workflow.common.emf.model.Workflow.impl.EBaseStepImpl <em>EBase Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see businessrules.ui.workflow.common.emf.model.Workflow.impl.EBaseStepImpl
		 * @see businessrules.ui.workflow.common.emf.model.Workflow.impl.EWorkflowPackageImpl#getEBaseStep()
		 * @generated
		 */
		EClass EBASE_STEP = eINSTANCE.getEBaseStep();

		/**
		 * The meta object literal for the '<em><b>Diagram Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EBASE_STEP__DIAGRAM_TYPE = eINSTANCE.getEBaseStep_DiagramType();

		/**
		 * The meta object literal for the '<em><b>Step Instance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EBASE_STEP__STEP_INSTANCE = eINSTANCE.getEBaseStep_StepInstance();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EBASE_STEP__NAME = eINSTANCE.getEBaseStep_Name();

	}

} //EWorkflowPackage
