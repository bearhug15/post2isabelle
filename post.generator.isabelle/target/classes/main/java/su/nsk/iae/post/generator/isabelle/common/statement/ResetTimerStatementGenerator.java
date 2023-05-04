package su.nsk.iae.post.generator.isabelle.common.statement;

import org.eclipse.xtend2.lib.StringConcatenation;
import su.nsk.iae.post.generator.isabelle.common.StatementListGenerator;
import su.nsk.iae.post.poST.ResetTimerStatement;
import su.nsk.iae.post.poST.Statement;

@SuppressWarnings("all")
public class ResetTimerStatementGenerator extends IStatementGenerator {
  /**
   * new(ProgramGenerator program, ProcessGenerator process, StateGenerator state, StatementListGenerator context) {
   * super(program, process, state, context)
   * }
   */
  public ResetTimerStatementGenerator(final StatementListGenerator context) {
    super(context);
  }

  @Override
  public boolean checkStatement(final Statement statement) {
    return (statement instanceof ResetTimerStatement);
  }

  @Override
  public String generateStatement(final Statement statement) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(statement.ResetSt)");
    return _builder.toString();
  }
}
