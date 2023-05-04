package su.nsk.iae.post.generator.isabelle.common.statement;

import org.eclipse.xtend2.lib.StringConcatenation;
import su.nsk.iae.post.generator.isabelle.common.StatementListGenerator;
import su.nsk.iae.post.poST.RepeatStatement;
import su.nsk.iae.post.poST.Statement;

@SuppressWarnings("all")
public class RepeatStatementGenerator extends IStatementGenerator {
  public RepeatStatementGenerator(final StatementListGenerator context) {
    super(context);
  }

  @Override
  public boolean checkStatement(final Statement statement) {
    return (statement instanceof RepeatStatement);
  }

  @Override
  public String generateStatement(final Statement statement) {
    final RepeatStatement s = ((RepeatStatement) statement);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(statement.IterSt (iter_statement.RepeatSt");
    _builder.newLine();
    _builder.append("\t");
    String _generateStatementList = this.context.generateStatementList(s.getStatement());
    _builder.append(_generateStatementList, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    String _generateExpression = this.context.generateExpression(s.getCond());
    _builder.append(_generateExpression, "\t");
    _builder.append("))");
    return _builder.toString();
  }
}
