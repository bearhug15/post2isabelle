/**
 * generated by Xtext 2.30.0
 */
package su.nsk.iae.post.poST;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link su.nsk.iae.post.poST.Resource#getName <em>Name</em>}</li>
 *   <li>{@link su.nsk.iae.post.poST.Resource#getType <em>Type</em>}</li>
 *   <li>{@link su.nsk.iae.post.poST.Resource#getResGlobVars <em>Res Glob Vars</em>}</li>
 *   <li>{@link su.nsk.iae.post.poST.Resource#getResStatement <em>Res Statement</em>}</li>
 * </ul>
 *
 * @see su.nsk.iae.post.poST.PoSTPackage#getResource()
 * @model
 * @generated
 */
public interface Resource extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see su.nsk.iae.post.poST.PoSTPackage#getResource_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link su.nsk.iae.post.poST.Resource#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see #setType(String)
   * @see su.nsk.iae.post.poST.PoSTPackage#getResource_Type()
   * @model
   * @generated
   */
  String getType();

  /**
   * Sets the value of the '{@link su.nsk.iae.post.poST.Resource#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see #getType()
   * @generated
   */
  void setType(String value);

  /**
   * Returns the value of the '<em><b>Res Glob Vars</b></em>' containment reference list.
   * The list contents are of type {@link su.nsk.iae.post.poST.GlobalVarDeclaration}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Res Glob Vars</em>' containment reference list.
   * @see su.nsk.iae.post.poST.PoSTPackage#getResource_ResGlobVars()
   * @model containment="true"
   * @generated
   */
  EList<GlobalVarDeclaration> getResGlobVars();

  /**
   * Returns the value of the '<em><b>Res Statement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Res Statement</em>' containment reference.
   * @see #setResStatement(SingleResource)
   * @see su.nsk.iae.post.poST.PoSTPackage#getResource_ResStatement()
   * @model containment="true"
   * @generated
   */
  SingleResource getResStatement();

  /**
   * Sets the value of the '{@link su.nsk.iae.post.poST.Resource#getResStatement <em>Res Statement</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Res Statement</em>' containment reference.
   * @see #getResStatement()
   * @generated
   */
  void setResStatement(SingleResource value);

} // Resource