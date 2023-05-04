/**
 * generated by Xtext 2.30.0
 */
package su.nsk.iae.post.poST.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import su.nsk.iae.post.poST.PoSTPackage;
import su.nsk.iae.post.poST.ProcessStatusExpression;
import su.nsk.iae.post.poST.Variable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Process Status Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link su.nsk.iae.post.poST.impl.ProcessStatusExpressionImpl#getProcess <em>Process</em>}</li>
 *   <li>{@link su.nsk.iae.post.poST.impl.ProcessStatusExpressionImpl#isActive <em>Active</em>}</li>
 *   <li>{@link su.nsk.iae.post.poST.impl.ProcessStatusExpressionImpl#isInactive <em>Inactive</em>}</li>
 *   <li>{@link su.nsk.iae.post.poST.impl.ProcessStatusExpressionImpl#isStop <em>Stop</em>}</li>
 *   <li>{@link su.nsk.iae.post.poST.impl.ProcessStatusExpressionImpl#isError <em>Error</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProcessStatusExpressionImpl extends MinimalEObjectImpl.Container implements ProcessStatusExpression
{
  /**
   * The cached value of the '{@link #getProcess() <em>Process</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProcess()
   * @generated
   * @ordered
   */
  protected Variable process;

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
   * The default value of the '{@link #isInactive() <em>Inactive</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isInactive()
   * @generated
   * @ordered
   */
  protected static final boolean INACTIVE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isInactive() <em>Inactive</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isInactive()
   * @generated
   * @ordered
   */
  protected boolean inactive = INACTIVE_EDEFAULT;

  /**
   * The default value of the '{@link #isStop() <em>Stop</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isStop()
   * @generated
   * @ordered
   */
  protected static final boolean STOP_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isStop() <em>Stop</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isStop()
   * @generated
   * @ordered
   */
  protected boolean stop = STOP_EDEFAULT;

  /**
   * The default value of the '{@link #isError() <em>Error</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isError()
   * @generated
   * @ordered
   */
  protected static final boolean ERROR_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isError() <em>Error</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isError()
   * @generated
   * @ordered
   */
  protected boolean error = ERROR_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ProcessStatusExpressionImpl()
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
    return PoSTPackage.Literals.PROCESS_STATUS_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Variable getProcess()
  {
    if (process != null && process.eIsProxy())
    {
      InternalEObject oldProcess = (InternalEObject)process;
      process = (Variable)eResolveProxy(oldProcess);
      if (process != oldProcess)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, PoSTPackage.PROCESS_STATUS_EXPRESSION__PROCESS, oldProcess, process));
      }
    }
    return process;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Variable basicGetProcess()
  {
    return process;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setProcess(Variable newProcess)
  {
    Variable oldProcess = process;
    process = newProcess;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PoSTPackage.PROCESS_STATUS_EXPRESSION__PROCESS, oldProcess, process));
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
      eNotify(new ENotificationImpl(this, Notification.SET, PoSTPackage.PROCESS_STATUS_EXPRESSION__ACTIVE, oldActive, active));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isInactive()
  {
    return inactive;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setInactive(boolean newInactive)
  {
    boolean oldInactive = inactive;
    inactive = newInactive;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PoSTPackage.PROCESS_STATUS_EXPRESSION__INACTIVE, oldInactive, inactive));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isStop()
  {
    return stop;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setStop(boolean newStop)
  {
    boolean oldStop = stop;
    stop = newStop;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PoSTPackage.PROCESS_STATUS_EXPRESSION__STOP, oldStop, stop));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isError()
  {
    return error;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setError(boolean newError)
  {
    boolean oldError = error;
    error = newError;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PoSTPackage.PROCESS_STATUS_EXPRESSION__ERROR, oldError, error));
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
      case PoSTPackage.PROCESS_STATUS_EXPRESSION__PROCESS:
        if (resolve) return getProcess();
        return basicGetProcess();
      case PoSTPackage.PROCESS_STATUS_EXPRESSION__ACTIVE:
        return isActive();
      case PoSTPackage.PROCESS_STATUS_EXPRESSION__INACTIVE:
        return isInactive();
      case PoSTPackage.PROCESS_STATUS_EXPRESSION__STOP:
        return isStop();
      case PoSTPackage.PROCESS_STATUS_EXPRESSION__ERROR:
        return isError();
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
      case PoSTPackage.PROCESS_STATUS_EXPRESSION__PROCESS:
        setProcess((Variable)newValue);
        return;
      case PoSTPackage.PROCESS_STATUS_EXPRESSION__ACTIVE:
        setActive((Boolean)newValue);
        return;
      case PoSTPackage.PROCESS_STATUS_EXPRESSION__INACTIVE:
        setInactive((Boolean)newValue);
        return;
      case PoSTPackage.PROCESS_STATUS_EXPRESSION__STOP:
        setStop((Boolean)newValue);
        return;
      case PoSTPackage.PROCESS_STATUS_EXPRESSION__ERROR:
        setError((Boolean)newValue);
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
      case PoSTPackage.PROCESS_STATUS_EXPRESSION__PROCESS:
        setProcess((Variable)null);
        return;
      case PoSTPackage.PROCESS_STATUS_EXPRESSION__ACTIVE:
        setActive(ACTIVE_EDEFAULT);
        return;
      case PoSTPackage.PROCESS_STATUS_EXPRESSION__INACTIVE:
        setInactive(INACTIVE_EDEFAULT);
        return;
      case PoSTPackage.PROCESS_STATUS_EXPRESSION__STOP:
        setStop(STOP_EDEFAULT);
        return;
      case PoSTPackage.PROCESS_STATUS_EXPRESSION__ERROR:
        setError(ERROR_EDEFAULT);
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
      case PoSTPackage.PROCESS_STATUS_EXPRESSION__PROCESS:
        return process != null;
      case PoSTPackage.PROCESS_STATUS_EXPRESSION__ACTIVE:
        return active != ACTIVE_EDEFAULT;
      case PoSTPackage.PROCESS_STATUS_EXPRESSION__INACTIVE:
        return inactive != INACTIVE_EDEFAULT;
      case PoSTPackage.PROCESS_STATUS_EXPRESSION__STOP:
        return stop != STOP_EDEFAULT;
      case PoSTPackage.PROCESS_STATUS_EXPRESSION__ERROR:
        return error != ERROR_EDEFAULT;
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
    result.append(", inactive: ");
    result.append(inactive);
    result.append(", stop: ");
    result.append(stop);
    result.append(", error: ");
    result.append(error);
    result.append(')');
    return result.toString();
  }

} //ProcessStatusExpressionImpl
