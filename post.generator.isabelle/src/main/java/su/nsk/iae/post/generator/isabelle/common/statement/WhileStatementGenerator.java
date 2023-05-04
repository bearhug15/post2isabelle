package su.nsk.iae.post.generator.isabelle.common.statement;

import org.eclipse.xtend2.lib.StringConcatenation;
import su.nsk.iae.post.generator.isabelle.common.StatementListGenerator;
import su.nsk.iae.post.poST.Statement;
import su.nsk.iae.post.poST.WhileStatement;

@SuppressWarnings("all")
public class WhileStatementGenerator extends IStatementGenerator {
  /**
   * new(ProgramGenerator program, ProcessGenerator process, StateGenerator state, StatementListGenerator context) {
   * super(program, process, state, context)
   * }
   */
  public WhileStatementGenerator(final StatementListGenerator context) {
    super(context);
  }

  @Override
  public boolean checkStatement(final Statement statement) {
    return (statement instanceof WhileStatement);
  }

  @Override
  public String generateStatement(final Statement statement) {
    final WhileStatement s = ((WhileStatement) statement);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(statement.IterSt (iter_statement.WhileSt");
    _builder.newLine();
    _builder.append("\t");
    String _generateExpression = this.context.generateExpression(s.getCond());
    _builder.append(_generateExpression, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    String _generateStatementList = this.context.generateStatementList(s.getStatement());
    _builder.append(_generateStatementList, "\t");
    _builder.append("))");
    return _builder.toString();
  }
}
