/**
 */
package businessrules.ui.workflow.common.emf.model.Workflow;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see businessrules.ui.workflow.common.emf.model.Workflow.EWorkflowPackage
 * @generated
 */
public interface EWorkflowFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EWorkflowFactory eINSTANCE = businessrules.ui.workflow.common.emf.model.Workflow.impl.EWorkflowFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>EBase Step</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EBase Step</em>'.
	 * @generated
	 */
	EBaseStep createEBaseStep();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EWorkflowPackage getEWorkflowPackage();

} //EWorkflowFactory
