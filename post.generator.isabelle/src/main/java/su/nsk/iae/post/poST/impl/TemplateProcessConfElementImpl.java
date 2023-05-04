/**
 * generated by Xtext 2.30.0
 */
package su.nsk.iae.post.poST.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import su.nsk.iae.post.poST.PoSTPackage;
import su.nsk.iae.post.poST.TemplateProcessConfElement;
import su.nsk.iae.post.poST.TemplateProcessElements;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Template Process Conf Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link su.nsk.iae.post.poST.impl.TemplateProcessConfElementImpl#isActive <em>Active</em>}</li>
 *   <li>{@link su.nsk.iae.post.poST.impl.TemplateProcessConfElementImpl#getProcess <em>Process</em>}</li>
 *   <li>{@link su.nsk.iae.post.poST.impl.TemplateProcessConfElementImpl#getArgs <em>Args</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TemplateProcessConfElementImpl extends VariableImpl implements TemplateProcessConfElement
{
  /**
   * The default value of the '{@link #isActive() <em>Active</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isActive()
   * @generated
   * @ordered
   */
  protected static final boolean ACTIVE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isActive() <em>Active</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isActive()
   * @generated
   * @ordered
   */
  protected boolean active = ACTIVE_EDEFAULT;

  /**
   * The cached value of the '{@link #getProcess() <em>Process</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProcess()
   * @generated
   * @ordered
   */
  protected su.nsk.iae.post.poST.Process process;

  /**
   * The cached value of the '{@link #getArgs() <em>Args</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArgs()
   * @generated
   * @ordered
   */
  protected TemplateProcessElements args;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TemplateProcessConfElementImpl()
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
    return PoSTPackage.Literals.TEMPLATE_PROCESS_CONF_ELEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isActive()
  {
    return active;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setActive(boolean newActive)
  {
    boolean oldActive = active;
    active = newActive;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PoSTPackage.TEMPLATE_PROCESS_CONF_ELEMENT__ACTIVE, oldActive, active));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public su.nsk.iae.post.poST.Process getProcess()
  {
    if (process != null && process.eIsProxy())
    {
      InternalEObject oldProcess = (InternalEObject)process;
      process = (su.nsk.iae.post.poST.Process)eResolveProxy(oldProcess);
      if (process != oldProcess)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, PoSTPackage.TEMPLATE_PROCESS_CONF_ELEMENT__PROCESS, oldProcess, process));
      }
    }
    return process;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public su.nsk.iae.post.poST.Process basicGetProcess()
  {
    return process;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setProcess(su.nsk.iae.post.poST.Process newProcess)
  {
    su.nsk.iae.post.poST.Process oldProcess = process;
    process = newProcess;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PoSTPackage.TEMPLATE_PROCESS_CONF_ELEMENT__PROCESS, oldProcess, process));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TemplateProcessElements getArgs()
  {
    return args;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetArgs(TemplateProcessElements newArgs, NotificationChain msgs)
  {
    TemplateProcessElements oldArgs = args;
    args = newArgs;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PoSTPackage.TEMPLATE_PROCESS_CONF_ELEMENT__ARGS, oldArgs, newArgs);
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
  public void setArgs(TemplateProcessElements newArgs)
  {
    if (newArgs != args)
    {
      NotificationChain msgs = null;
      if (args != null)
        msgs = ((InternalEObject)args).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PoSTPackage.TEMPLATE_PROCESS_CONF_ELEMENT__ARGS, null, msgs);
      if (newArgs != null)
        msgs = ((InternalEObject)newArgs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PoSTPackage.TEMPLATE_PROCESS_CONF_ELEMENT__ARGS, null, msgs);
      msgs = basicSetArgs(newArgs, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PoSTPackage.TEMPLATE_PROCESS_CONF_ELEMENT__ARGS, newArgs, newArgs));
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
      case PoSTPackage.TEMPLATE_PROCESS_CONF_ELEMENT__ARGS:
        return basicSetArgs(null, msgs);
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
      case PoSTPackage.TEMPLATE_PROCESS_CONF_ELEMENT__ACTIVE:
        return isActive();
      case PoSTPackage.TEMPLATE_PROCESS_CONF_ELEMENT__PROCESS:
        if (resolve) return getProcess();
        return basicGetProcess();
      case PoSTPackage.TEMPLATE_PROCESS_CONF_ELEMENT__ARGS:
        return getArgs();
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
      case PoSTPackage.TEMPLATE_PROCESS_CONF_ELEMENT__ACTIVE:
        setActive((Boolean)newValue);
        return;
      case PoSTPackage.TEMPLATE_PROCESS_CONF_ELEMENT__PROCESS:
        setProcess((su.nsk.iae.post.poST.Process)newValue);
        return;
      case PoSTPackage.TEMPLATE_PROCESS_CONF_ELEMENT__ARGS:
        setArgs((TemplateProcessElements)newValue);
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
      case PoSTPackage.TEMPLATE_PROCESS_CONF_ELEMENT__ACTIVE:
        setActive(ACTIVE_EDEFAULT);
        return;
      case PoSTPackage.TEMPLATE_PROCESS_CONF_ELEMENT__PROCESS:
        setProcess((su.nsk.iae.post.poST.Process)null);
        return;
      case PoSTPackage.TEMPLATE_PROCESS_CONF_ELEMENT__ARGS:
        setArgs((TemplateProcessElements)null);
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
      case PoSTPackage.TEMPLATE_PROCESS_CONF_ELEMENT__ACTIVE:
        return active != ACTIVE_EDEFAULT;
      case PoSTPackage.TEMPLATE_PROCESS_CONF_ELEMENT__PROCESS:
        return process != null;
      case PoSTPackage.TEMPLATE_PROCESS_CONF_ELEMENT__ARGS:
        return args != null;
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
    result.append(" (active: ");
    result.append(active);
    result.append(')');
    return result.toString();
  }

} //TemplateProcessConfElementImpl
