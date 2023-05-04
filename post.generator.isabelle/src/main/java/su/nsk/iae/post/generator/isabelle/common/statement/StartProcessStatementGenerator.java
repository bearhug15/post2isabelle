package su.nsk.iae.post.generator.isabelle.common.statement;

import org.eclipse.xtend2.lib.StringConcatenation;
import su.nsk.iae.post.generator.isabelle.common.StatementListGenerator;
import su.nsk.iae.post.poST.StartProcessStatement;
import su.nsk.iae.post.poST.Statement;
import su.nsk.iae.post.poST.Variable;

@SuppressWarnings("all")
public class StartProcessStatementGenerator extends IStatementGenerator {
  /**
   * new(ProgramGenerator program, ProcessGenerator process, StateGenerator state, StatementListGenerator context) {
   * super(program, process, state, context)
   * }
   */
  public StartProcessStatementGenerator(final StatementListGenerator context) {
    super(context);
  }

  @Override
  public boolean checkStatement(final Statement statement) {
    return (statement instanceof StartProcessStatement);
  }

  @Override
  public String generateStatement(final Statement statement) {
    final StartProcessStatement s = ((StartProcessStatement) statement);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(statement.ProcessSt (process_statement.Start ");
    {
      Variable _process = s.getProcess();
      boolean _tripleNotEquals = (_process != null);
      if (_tripleNotEquals) {
        _builder.append("(Some \'\'");
        String _name = s.getProcess().getName();
        _builder.append(_name);
        _builder.append("\'\')");
      } else {
        _builder.append("None");
      }
    }
    _builder.append("))");
    return _builder.toString();
  }
}
