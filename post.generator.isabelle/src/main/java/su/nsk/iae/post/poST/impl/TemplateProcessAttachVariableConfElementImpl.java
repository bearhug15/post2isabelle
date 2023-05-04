/**
 * generated by Xtext 2.30.0
 */
package su.nsk.iae.post.poST.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import su.nsk.iae.post.poST.AssignmentType;
import su.nsk.iae.post.poST.Constant;
import su.nsk.iae.post.poST.PoSTPackage;
import su.nsk.iae.post.poST.TemplateProcessAttachVariableConfElement;
import su.nsk.iae.post.poST.Variable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Template Process Attach Variable Conf Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link su.nsk.iae.post.poST.impl.TemplateProcessAttachVariableConfElementImpl#getProgramVar <em>Program Var</em>}</li>
 *   <li>{@link su.nsk.iae.post.poST.impl.TemplateProcessAttachVariableConfElementImpl#getAssig <em>Assig</em>}</li>
 *   <li>{@link su.nsk.iae.post.poST.impl.TemplateProcessAttachVariableConfElementImpl#getAttVar <em>Att Var</em>}</li>
 *   <li>{@link su.nsk.iae.post.poST.impl.TemplateProcessAttachVariableConfElementImpl#getConst <em>Const</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TemplateProcessAttachVariableConfElementImpl extends MinimalEObjectImpl.Container implements TemplateProcessAttachVariableConfElement
{
  /**
   * The cached value of the '{@link #getProgramVar() <em>Program Var</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProgramVar()
   * @generated
   * @ordered
   */
  protected Variable programVar;

  /**
   * The default value of the '{@link #getAssig() <em>Assig</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssig()
   * @generated
   * @ordered
   */
  protected static final AssignmentType ASSIG_EDEFAULT = AssignmentType.IN;

  /**
   * The cached value of the '{@link #getAssig() <em>Assig</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssig()
   * @generated
   * @ordered
   */
  protected AssignmentType assig = ASSIG_EDEFAULT;

  /**
   * The cached value of the '{@link #getAttVar() <em>Att Var</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttVar()
   * @generated
   * @ordered
   */
  protected Variable attVar;

  /**
   * The cached value of the '{@link #getConst() <em>Const</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConst()
   * @generated
   * @ordered
   */
  protected Constant const_;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TemplateProcessAttachVariableConfElementImpl()
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
    return PoSTPackage.Literals.TEMPLATE_PROCESS_ATTACH_VARIABLE_CONF_ELEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Variable getProgramVar()
  {
    if (programVar != null && programVar.eIsProxy())
    {
      InternalEObject oldProgramVar = (InternalEObject)programVar;
      programVar = (Variable)eResolveProxy(oldProgramVar);
      if (programVar != oldProgramVar)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, PoSTPackage.TEMPLATE_PROCESS_ATTACH_VARIABLE_CONF_ELEMENT__PROGRAM_VAR, oldProgramVar, programVar));
      }
    }
    return programVar;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Variable basicGetProgramVar()
  {
    return programVar;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setProgramVar(Variable newProgramVar)
  {
    Variable oldProgramVar = programVar;
    programVar = newProgramVar;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PoSTPackage.TEMPLATE_PROCESS_ATTACH_VARIABLE_CONF_ELEMENT__PROGRAM_VAR, oldProgramVar, programVar));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AssignmentType getAssig()
  {
    return assig;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setAssig(AssignmentType newAssig)
  {
    AssignmentType oldAssig = assig;
    assig = newAssig == null ? ASSIG_EDEFAULT : newAssig;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PoSTPackage.TEMPLATE_PROCESS_ATTACH_VARIABLE_CONF_ELEMENT__ASSIG, oldAssig, assig));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Variable getAttVar()
  {
    if (attVar != null && attVar.eIsProxy())
    {
      InternalEObject oldAttVar = (InternalEObject)attVar;
      attVar = (Variable)eResolveProxy(oldAttVar);
      if (attVar != oldAttVar)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, PoSTPackage.TEMPLATE_PROCESS_ATTACH_VARIABLE_CONF_ELEMENT__ATT_VAR, oldAttVar, attVar));
      }
    }
    return attVar;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Variable basicGetAttVar()
  {
    return attVar;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setAttVar(Variable newAttVar)
  {
    Variable oldAttVar = attVar;
    attVar = newAttVar;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PoSTPackage.TEMPLATE_PROCESS_ATTACH_VARIABLE_CONF_ELEMENT__ATT_VAR, oldAttVar, attVar));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Constant getConst()
  {
    return const_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetConst(Constant newConst, NotificationChain msgs)
  {
    Constant oldConst = const_;
    const_ = newConst;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PoSTPackage.TEMPLATE_PROCESS_ATTACH_VARIABLE_CONF_ELEMENT__CONST, oldConst, newConst);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setConst(Constant newConst)
  {
    if (newConst != const_)
    {
      NotificationChain msgs = null;
      if (const_ != null)
        msgs = ((InternalEObject)const_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PoSTPackage.TEMPLATE_PROCESS_ATTACH_VARIABLE_CONF_ELEMENT__CONST, null, msgs);
      if (newConst != null)
        msgs = ((InternalEObject)newConst).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PoSTPackage.TEMPLATE_PROCESS_ATTACH_VARIABLE_CONF_ELEMENT__CONST, null, msgs);
      msgs = basicSetConst(newConst, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PoSTPackage.TEMPLATE_PROCESS_ATTACH_VARIABLE_CONF_ELEMENT__CONST, newConst, newConst));
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
      case PoSTPackage.TEMPLATE_PROCESS_ATTACH_VARIABLE_CONF_ELEMENT__CONST:
        return basicSetConst(null, msgs);
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
      case PoSTPackage.TEMPLATE_PROCESS_ATTACH_VARIABLE_CONF_ELEMENT__PROGRAM_VAR:
        if (resolve) return getProgramVar();
        return basicGetProgramVar();
      case PoSTPackage.TEMPLATE_PROCESS_ATTACH_VARIABLE_CONF_ELEMENT__ASSIG:
        return getAssig();
      case PoSTPackage.TEMPLATE_PROCESS_ATTACH_VARIABLE_CONF_ELEMENT__ATT_VAR:
        if (resolve) return getAttVar();
        return basicGetAttVar();
      case PoSTPackage.TEMPLATE_PROCESS_ATTACH_VARIABLE_CONF_ELEMENT__CONST:
        return getConst();
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
      case PoSTPackage.TEMPLATE_PROCESS_ATTACH_VARIABLE_CONF_ELEMENT__PROGRAM_VAR:
        setProgramVar((Variable)newValue);
        return;
      case PoSTPackage.TEMPLATE_PROCESS_ATTACH_VARIABLE_CONF_ELEMENT__ASSIG:
        setAssig((AssignmentType)newValue);
        return;
      case PoSTPackage.TEMPLATE_PROCESS_ATTACH_VARIABLE_CONF_ELEMENT__ATT_VAR:
        setAttVar((Variable)newValue);
        return;
      case PoSTPackage.TEMPLATE_PROCESS_ATTACH_VARIABLE_CONF_ELEMENT__CONST:
        setConst((Constant)newValue);
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
      case PoSTPackage.TEMPLATE_PROCESS_ATTACH_VARIABLE_CONF_ELEMENT__PROGRAM_VAR:
        setProgramVar((Variable)null);
        return;
      case PoSTPackage.TEMPLATE_PROCESS_ATTACH_VARIABLE_CONF_ELEMENT__ASSIG:
        setAssig(ASSIG_EDEFAULT);
        return;
      case PoSTPackage.TEMPLATE_PROCESS_ATTACH_VARIABLE_CONF_ELEMENT__ATT_VAR:
        setAttVar((Variable)null);
        return;
      case PoSTPackage.TEMPLATE_PROCESS_ATTACH_VARIABLE_CONF_ELEMENT__CONST:
        setConst((Constant)null);
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
      case PoSTPackage.TEMPLATE_PROCESS_ATTACH_VARIABLE_CONF_ELEMENT__PROGRAM_VAR:
        return programVar != null;
      case PoSTPackage.TEMPLATE_PROCESS_ATTACH_VARIABLE_CONF_ELEMENT__ASSIG:
        return assig != ASSIG_EDEFAULT;
      case PoSTPackage.TEMPLATE_PROCESS_ATTACH_VARIABLE_CONF_ELEMENT__ATT_VAR:
        return attVar != null;
      case PoSTPackage.TEMPLATE_PROCESS_ATTACH_VARIABLE_CONF_ELEMENT__CONST:
        return const_ != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (assig: ");
    result.append(assig);
    result.append(')');
    return result.toString();
  }

} //TemplateProcessAttachVariableConfElementImpl
