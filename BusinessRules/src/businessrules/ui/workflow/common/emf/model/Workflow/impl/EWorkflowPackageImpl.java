/**
 */
package businessrules.ui.workflow.common.emf.model.Workflow.impl;

import businessrules.ui.workflow.common.emf.model.Workflow.EBaseStep;
import businessrules.ui.workflow.common.emf.model.Workflow.EWorkflowFactory;
import businessrules.ui.workflow.common.emf.model.Workflow.EWorkflowPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EWorkflowPackageImpl extends EPackageImpl implements EWorkflowPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eBaseStepEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see businessrules.ui.workflow.common.emf.model.Workflow.EWorkflowPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EWorkflowPackageImpl() {
		super(eNS_URI, EWorkflowFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link EWorkflowPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EWorkflowPackage init() {
		if (isInited) return (EWorkflowPackage)EPackage.Registry.INSTANCE.getEPackage(EWorkflowPackage.eNS_URI);

		// Obtain or create and register package
		EWorkflowPackageImpl theEWorkflowPackage = (EWorkflowPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EWorkflowPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EWorkflowPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theEWorkflowPackage.createPackageContents();

		// Initialize created meta-data
		theEWorkflowPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEWorkflowPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EWorkflowPackage.eNS_URI, theEWorkflowPackage);
		return theEWorkflowPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEBaseStep() {
		return eBaseStepEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEBaseStep_DiagramType() {
		return (EAttribute)eBaseStepEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEBaseStep_StepInstance() {
		return (EAttribute)eBaseStepEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEBaseStep_Name() {
		return (EAttribute)eBaseStepEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EWorkflowFactory getEWorkflowFactory() {
		return (EWorkflowFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		eBaseStepEClass = createEClass(EBASE_STEP);
		createEAttribute(eBaseStepEClass, EBASE_STEP__DIAGRAM_TYPE);
		createEAttribute(eBaseStepEClass, EBASE_STEP__STEP_INSTANCE);
		createEAttribute(eBaseStepEClass, EBASE_STEP__NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(eBaseStepEClass, EBaseStep.class, "EBaseStep", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEBaseStep_DiagramType(), ecorePackage.getEString(), "diagramType", null, 0, 1, EBaseStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEBaseStep_StepInstance(), ecorePackage.getEJavaObject(), "stepInstance", null, 0, 1, EBaseStep.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEBaseStep_Name(), ecorePackage.getEString(), "name", null, 0, 1, EBaseStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //EWorkflowPackageImpl
