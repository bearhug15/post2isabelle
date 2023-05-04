package su.nsk.iae.post.generator.isabelle.common.statement;

import org.eclipse.xtend2.lib.StringConcatenation;
import su.nsk.iae.post.generator.isabelle.common.StatementListGenerator;
import su.nsk.iae.post.poST.SetStateStatement;
import su.nsk.iae.post.poST.Statement;

@SuppressWarnings("all")
public class SetStateStatementGenerator extends IStatementGenerator {
  /**
   * new(ProgramGenerator program, ProcessGenerator process, StateGenerator state, StatementListGenerator context) {
   * super(program, process, state, context)
   * }
   */
  public SetStateStatementGenerator(final StatementListGenerator context) {
    super(context);
  }

  @Override
  public boolean checkStatement(final Statement statement) {
    return (statement instanceof SetStateStatement);
  }

  @Override
  public String generateStatement(final Statement statement) {
    final SetStateStatement s = ((SetStateStatement) statement);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(statement.SetStateSt ");
    {
      boolean _isNext = s.isNext();
      if (_isNext) {
        _builder.append("None");
      } else {
        _builder.append("(Some \'\'");
        String _name = s.getState().getName();
        _builder.append(_name);
        _builder.append("\'\')");
      }
    }
    _builder.append(")");
    return _builder.toString();
  }
}
