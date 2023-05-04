/**
 * generated by Xtext 2.30.0
 */
package su.nsk.iae.post.poST;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Process</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link su.nsk.iae.post.poST.Process#getProcInVars <em>Proc In Vars</em>}</li>
 *   <li>{@link su.nsk.iae.post.poST.Process#getProcOutVars <em>Proc Out Vars</em>}</li>
 *   <li>{@link su.nsk.iae.post.poST.Process#getProcInOutVars <em>Proc In Out Vars</em>}</li>
 *   <li>{@link su.nsk.iae.post.poST.Process#getProcProcessVars <em>Proc Process Vars</em>}</li>
 *   <li>{@link su.nsk.iae.post.poST.Process#getProcVars <em>Proc Vars</em>}</li>
 *   <li>{@link su.nsk.iae.post.poST.Process#getProcTempVars <em>Proc Temp Vars</em>}</li>
 *   <li>{@link su.nsk.iae.post.poST.Process#getStates <em>States</em>}</li>
 * </ul>
 *
 * @see su.nsk.iae.post.poST.PoSTPackage#getProcess()
 * @model
 * @generated
 */
public interface Process extends Variable
{
  /**
   * Returns the value of the '<em><b>Proc In Vars</b></em>' containment reference list.
   * The list contents are of type {@link su.nsk.iae.post.poST.InputVarDeclaration}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Proc In Vars</em>' containment reference list.
   * @see su.nsk.iae.post.poST.PoSTPackage#getProcess_ProcInVars()
   * @model containment="true"
   * @generated
   */
  EList<InputVarDeclaration> getProcInVars();

  /**
   * Returns the value of the '<em><b>Proc Out Vars</b></em>' containment reference list.
   * The list contents are of type {@link su.nsk.iae.post.poST.OutputVarDeclaration}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Proc Out Vars</em>' containment reference list.
   * @see su.nsk.iae.post.poST.PoSTPackage#getProcess_ProcOutVars()
   * @model containment="true"
   * @generated
   */
  EList<OutputVarDeclaration> getProcOutVars();

  /**
   * Returns the value of the '<em><b>Proc In Out Vars</b></em>' containment reference list.
   * The list contents are of type {@link su.nsk.iae.post.poST.InputOutputVarDeclaration}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Proc In Out Vars</em>' containment reference list.
   * @see su.nsk.iae.post.poST.PoSTPackage#getProcess_ProcInOutVars()
   * @model containment="true"
   * @generated
   */
  EList<InputOutputVarDeclaration> getProcInOutVars();

  /**
   * Returns the value of the '<em><b>Proc Process Vars</b></em>' containment reference list.
   * The list contents are of type {@link su.nsk.iae.post.poST.ProcessVarDeclaration}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Proc Process Vars</em>' containment reference list.
   * @see su.nsk.iae.post.poST.PoSTPackage#getProcess_ProcProcessVars()
   * @model containment="true"
   * @generated
   */
  EList<ProcessVarDeclaration> getProcProcessVars();

  /**
   * Returns the value of the '<em><b>Proc Vars</b></em>' containment reference list.
   * The list contents are of type {@link su.nsk.iae.post.poST.VarDeclaration}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Proc Vars</em>' containment reference list.
   * @see su.nsk.iae.post.poST.PoSTPackage#getProcess_ProcVars()
   * @model containment="true"
   * @generated
   */
  EList<VarDeclaration> getProcVars();

  /**
   * Returns the value of the '<em><b>Proc Temp Vars</b></em>' containment reference list.
   * The list contents are of type {@link su.nsk.iae.post.poST.TempVarDeclaration}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Proc Temp Vars</em>' containment reference list.
   * @see su.nsk.iae.post.poST.PoSTPackage#getProcess_ProcTempVars()
   * @model containment="true"
   * @generated
   */
  EList<TempVarDeclaration> getProcTempVars();

  /**
   * Returns the value of the '<em><b>States</b></em>' containment reference list.
   * The list contents are of type {@link su.nsk.iae.post.poST.State}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>States</em>' containment reference list.
   * @see su.nsk.iae.post.poST.PoSTPackage#getProcess_States()
   * @model containment="true"
   * @generated
   */
  EList<State> getStates();

} // Process
