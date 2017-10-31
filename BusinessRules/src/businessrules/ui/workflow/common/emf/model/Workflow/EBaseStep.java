/**
 */
package businessrules.ui.workflow.common.emf.model.Workflow;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EBase Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link businessrules.ui.workflow.common.emf.model.Workflow.EBaseStep#getDiagramType <em>Diagram Type</em>}</li>
 *   <li>{@link businessrules.ui.workflow.common.emf.model.Workflow.EBaseStep#getStepInstance <em>Step Instance</em>}</li>
 *   <li>{@link businessrules.ui.workflow.common.emf.model.Workflow.EBaseStep#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see businessrules.ui.workflow.common.emf.model.Workflow.EWorkflowPackage#getEBaseStep()
 * @model
 * @generated
 */
public interface EBaseStep extends EObject {
	/**
	 * Returns the value of the '<em><b>Diagram Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diagram Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Diagram Type</em>' attribute.
	 * @see #setDiagramType(String)
	 * @see businessrules.ui.workflow.common.emf.model.Workflow.EWorkflowPackage#getEBaseStep_DiagramType()
	 * @model
	 * @generated
	 */
	String getDiagramType();

	/**
	 * Sets the value of the '{@link businessrules.ui.workflow.common.emf.model.Workflow.EBaseStep#getDiagramType <em>Diagram Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Diagram Type</em>' attribute.
	 * @see #getDiagramType()
	 * @generated
	 */
	void setDiagramType(String value);

	/**
	 * Returns the value of the '<em><b>Step Instance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Step Instance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Step Instance</em>' attribute.
	 * @see #setStepInstance(Object)
	 * @see businessrules.ui.workflow.common.emf.model.Workflow.EWorkflowPackage#getEBaseStep_StepInstance()
	 * @model transient="true"
	 * @generated
	 */
	Object getStepInstance();

	/**
	 * Sets the value of the '{@link businessrules.ui.workflow.common.emf.model.Workflow.EBaseStep#getStepInstance <em>Step Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Step Instance</em>' attribute.
	 * @see #getStepInstance()
	 * @generated
	 */
	void setStepInstance(Object value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see businessrules.ui.workflow.common.emf.model.Workflow.EWorkflowPackage#getEBaseStep_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link businessrules.ui.workflow.common.emf.model.Workflow.EBaseStep#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // EBaseStep
