package su.nsk.iae.post.generator.isabelle.common.statement;

import org.eclipse.xtend2.lib.StringConcatenation;
import su.nsk.iae.post.generator.isabelle.common.StatementListGenerator;
import su.nsk.iae.post.poST.ArrayVariable;
import su.nsk.iae.post.poST.AssignmentStatement;
import su.nsk.iae.post.poST.Statement;
import su.nsk.iae.post.poST.SymbolicVariable;

@SuppressWarnings("all")
public class AssignmentStatementGenerator extends IStatementGenerator {
  /**
   * new(ProgramGenerator program, ProcessGenerator process, StateGenerator state, StatementListGenerator context) {
   * super(program, process, state, context)
   * }
   */
  public AssignmentStatementGenerator(final StatementListGenerator context) {
    super(context);
  }

  @Override
  public boolean checkStatement(final Statement statement) {
    return (statement instanceof AssignmentStatement);
  }

  @Override
  public String generateStatement(final Statement statement) {
    final AssignmentStatement s = ((AssignmentStatement) statement);
    SymbolicVariable _variable = s.getVariable();
    boolean _tripleNotEquals = (_variable != null);
    if (_tripleNotEquals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("(statement.AssignSt (common_var.Symbolic \'\'");
      String _name = s.getVariable().getName();
      _builder.append(_name);
      _builder.append("\'\') ");
      String _generateExpression = this.context.generateExpression(s.getValue());
      _builder.append(_generateExpression);
      _builder.append(")");
      return _builder.toString();
    } else {
      ArrayVariable _array = s.getArray();
      boolean _tripleNotEquals_1 = (_array != null);
      if (_tripleNotEquals_1) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("(statement.AssignSt (common_var.Array \'\'");
        String _name_1 = s.getArray().getVariable().getName();
        _builder_1.append(_name_1);
        _builder_1.append("\'\' ");
        String _generateExpression_1 = this.context.generateExpression(s.getArray().getIndex());
        _builder_1.append(_generateExpression_1);
        _builder_1.append(") ");
        String _generateExpression_2 = this.context.generateExpression(s.getValue());
        _builder_1.append(_generateExpression_2);
        _builder_1.append(")");
        return _builder_1.toString();
      }
    }
    return null;
  }
}
