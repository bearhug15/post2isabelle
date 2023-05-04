/**
 * generated by Xtext 2.30.0
 */
package su.nsk.iae.post.poST.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import su.nsk.iae.post.poST.Expression;
import su.nsk.iae.post.poST.IfStatement;
import su.nsk.iae.post.poST.PoSTPackage;
import su.nsk.iae.post.poST.StatementList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>If Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link su.nsk.iae.post.poST.impl.IfStatementImpl#getMainCond <em>Main Cond</em>}</li>
 *   <li>{@link su.nsk.iae.post.poST.impl.IfStatementImpl#getMainStatement <em>Main Statement</em>}</li>
 *   <li>{@link su.nsk.iae.post.poST.impl.IfStatementImpl#getElseIfCond <em>Else If Cond</em>}</li>
 *   <li>{@link su.nsk.iae.post.poST.impl.IfStatementImpl#getElseIfStatements <em>Else If Statements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfStatementImpl extends SelectionStatementImpl implements IfStatement
{
  /**
   * The cached value of the '{@link #getMainCond() <em>Main Cond</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMainCond()
   * @generated
   * @ordered
   */
  protected Expression mainCond;

  /**
   * The cached value of the '{@link #getMainStatement() <em>Main Statement</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMainStatement()
   * @generated
   * @ordered
   */
  protected StatementList mainStatement;

  /**
   * The cached value of the '{@link #getElseIfCond() <em>Else If Cond</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElseIfCond()
   * @generated
   * @ordered
   */
  protected EList<Expression> elseIfCond;

  /**
   * The cached value of the '{@link #getElseIfStatements() <em>Else If Statements</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElseIfStatements()
   * @generated
   * @ordered
   */
  protected EList<StatementList> elseIfStatements;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IfStatementImpl()
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
    return PoSTPackage.Literals.IF_STATEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Expression getMainCond()
  {
    return mainCond;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMainCond(Expression newMainCond, NotificationChain msgs)
  {
    Expression oldMainCond = mainCond;
    mainCond = newMainCond;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PoSTPackage.IF_STATEMENT__MAIN_COND, oldMainCond, newMainCond);
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
  public void setMainCond(Expression newMainCond)
  {
    if (newMainCond != mainCond)
    {
      NotificationChain msgs = null;
      if (mainCond != null)
        msgs = ((InternalEObject)mainCond).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PoSTPackage.IF_STATEMENT__MAIN_COND, null, msgs);
      if (newMainCond != null)
        msgs = ((InternalEObject)newMainCond).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PoSTPackage.IF_STATEMENT__MAIN_COND, null, msgs);
      msgs = basicSetMainCond(newMainCond, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PoSTPackage.IF_STATEMENT__MAIN_COND, newMainCond, newMainCond));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public StatementList getMainStatement()
  {
    return mainStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMainStatement(StatementList newMainStatement, NotificationChain msgs)
  {
    StatementList oldMainStatement = mainStatement;
    mainStatement = newMainStatement;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PoSTPackage.IF_STATEMENT__MAIN_STATEMENT, oldMainStatement, newMainStatement);
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
  public void setMainStatement(StatementList newMainStatement)
  {
    if (newMainStatement != mainStatement)
    {
      NotificationChain msgs = null;
      if (mainStatement != null)
        msgs = ((InternalEObject)mainStatement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PoSTPackage.IF_STATEMENT__MAIN_STATEMENT, null, msgs);
      if (newMainStatement != null)
        msgs = ((InternalEObject)newMainStatement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PoSTPackage.IF_STATEMENT__MAIN_STATEMENT, null, msgs);
      msgs = basicSetMainStatement(newMainStatement, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PoSTPackage.IF_STATEMENT__MAIN_STATEMENT, newMainStatement, newMainStatement));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Expression> getElseIfCond()
  {
    if (elseIfCond == null)
    {
      elseIfCond = new EObjectContainmentEList<Expression>(Expression.class, this, PoSTPackage.IF_STATEMENT__ELSE_IF_COND);
    }
    return elseIfCond;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<StatementList> getElseIfStatements()
  {
    if (elseIfStatements == null)
    {
      elseIfStatements = new EObjectContainmentEList<StatementList>(StatementList.class, this, PoSTPackage.IF_STATEMENT__ELSE_IF_STATEMENTS);
    }
    return elseIfStatements;
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
      case PoSTPackage.IF_STATEMENT__MAIN_COND:
        return basicSetMainCond(null, msgs);
      case PoSTPackage.IF_STATEMENT__MAIN_STATEMENT:
        return basicSetMainStatement(null, msgs);
      case PoSTPackage.IF_STATEMENT__ELSE_IF_COND:
        return ((InternalEList<?>)getElseIfCond()).basicRemove(otherEnd, msgs);
      case PoSTPackage.IF_STATEMENT__ELSE_IF_STATEMENTS:
        return ((InternalEList<?>)getElseIfStatements()).basicRemove(otherEnd, msgs);
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
      case PoSTPackage.IF_STATEMENT__MAIN_COND:
        return getMainCond();
      case PoSTPackage.IF_STATEMENT__MAIN_STATEMENT:
        return getMainStatement();
      case PoSTPackage.IF_STATEMENT__ELSE_IF_COND:
        return getElseIfCond();
      case PoSTPackage.IF_STATEMENT__ELSE_IF_STATEMENTS:
        return getElseIfStatements();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case PoSTPackage.IF_STATEMENT__MAIN_COND:
        setMainCond((Expression)newValue);
        return;
      case PoSTPackage.IF_STATEMENT__MAIN_STATEMENT:
        setMainStatement((StatementList)newValue);
        return;
      case PoSTPackage.IF_STATEMENT__ELSE_IF_COND:
        getElseIfCond().clear();
        getElseIfCond().addAll((Collection<? extends Expression>)newValue);
        return;
      case PoSTPackage.IF_STATEMENT__ELSE_IF_STATEMENTS:
        getElseIfStatements().clear();
        getElseIfStatements().addAll((Collection<? extends StatementList>)newValue);
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
      case PoSTPackage.IF_STATEMENT__MAIN_COND:
        setMainCond((Expression)null);
        return;
      case PoSTPackage.IF_STATEMENT__MAIN_STATEMENT:
        setMainStatement((StatementList)null);
        return;
      case PoSTPackage.IF_STATEMENT__ELSE_IF_COND:
        getElseIfCond().clear();
        return;
      case PoSTPackage.IF_STATEMENT__ELSE_IF_STATEMENTS:
        getElseIfStatements().clear();
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
      case PoSTPackage.IF_STATEMENT__MAIN_COND:
        return mainCond != null;
      case PoSTPackage.IF_STATEMENT__MAIN_STATEMENT:
        return mainStatement != null;
      case PoSTPackage.IF_STATEMENT__ELSE_IF_COND:
        return elseIfCond != null && !elseIfCond.isEmpty();
      case PoSTPackage.IF_STATEMENT__ELSE_IF_STATEMENTS:
        return elseIfStatements != null && !elseIfStatements.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //IfStatementImpl
