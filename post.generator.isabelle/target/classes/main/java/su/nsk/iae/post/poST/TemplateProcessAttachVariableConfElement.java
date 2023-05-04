/**
 * generated by Xtext 2.30.0
 */
package su.nsk.iae.post.poST;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template Process Attach Variable Conf Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link su.nsk.iae.post.poST.TemplateProcessAttachVariableConfElement#getProgramVar <em>Program Var</em>}</li>
 *   <li>{@link su.nsk.iae.post.poST.TemplateProcessAttachVariableConfElement#getAssig <em>Assig</em>}</li>
 *   <li>{@link su.nsk.iae.post.poST.TemplateProcessAttachVariableConfElement#getAttVar <em>Att Var</em>}</li>
 *   <li>{@link su.nsk.iae.post.poST.TemplateProcessAttachVariableConfElement#getConst <em>Const</em>}</li>
 * </ul>
 *
 * @see su.nsk.iae.post.poST.PoSTPackage#getTemplateProcessAttachVariableConfElement()
 * @model
 * @generated
 */
public interface TemplateProcessAttachVariableConfElement extends EObject
{
  /**
   * Returns the value of the '<em><b>Program Var</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Program Var</em>' reference.
   * @see #setProgramVar(Variable)
   * @see su.nsk.iae.post.poST.PoSTPackage#getTemplateProcessAttachVariableConfElement_ProgramVar()
   * @model
   * @generated
   */
  Variable getProgramVar();

  /**
   * Sets the value of the '{@link su.nsk.iae.post.poST.TemplateProcessAttachVariableConfElement#getProgramVar <em>Program Var</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Program Var</em>' reference.
   * @see #getProgramVar()
   * @generated
   */
  void setProgramVar(Variable value);

  /**
   * Returns the value of the '<em><b>Assig</b></em>' attribute.
   * The literals are from the enumeration {@link su.nsk.iae.post.poST.AssignmentType}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Assig</em>' attribute.
   * @see su.nsk.iae.post.poST.AssignmentType
   * @see #setAssig(AssignmentType)
   * @see su.nsk.iae.post.poST.PoSTPackage#getTemplateProcessAttachVariableConfElement_Assig()
   * @model
   * @generated
   */
  AssignmentType getAssig();

  /**
   * Sets the value of the '{@link su.nsk.iae.post.poST.TemplateProcessAttachVariableConfElement#getAssig <em>Assig</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Assig</em>' attribute.
   * @see su.nsk.iae.post.poST.AssignmentType
   * @see #getAssig()
   * @generated
   */
  void setAssig(AssignmentType value);

  /**
   * Returns the value of the '<em><b>Att Var</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Att Var</em>' reference.
   * @see #setAttVar(Variable)
   * @see su.nsk.iae.post.poST.PoSTPackage#getTemplateProcessAttachVariableConfElement_AttVar()
   * @model
   * @generated
   */
  Variable getAttVar();

  /**
   * Sets the value of the '{@link su.nsk.iae.post.poST.TemplateProcessAttachVariableConfElement#getAttVar <em>Att Var</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Att Var</em>' reference.
   * @see #getAttVar()
   * @generated
   */
  void setAttVar(Variable value);

  /**
   * Returns the value of the '<em><b>Const</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Const</em>' containment reference.
   * @see #setConst(Constant)
   * @see su.nsk.iae.post.poST.PoSTPackage#getTemplateProcessAttachVariableConfElement_Const()
   * @model containment="true"
   * @generated
   */
  Constant getConst();

  /**
   * Sets the value of the '{@link su.nsk.iae.post.poST.TemplateProcessAttachVariableConfElement#getConst <em>Const</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Const</em>' containment reference.
   * @see #getConst()
   * @generated
   */
  void setConst(Constant value);

} // TemplateProcessAttachVariableConfElement