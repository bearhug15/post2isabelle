package su.nsk.iae.post.generator.isabelle.common.statement;

import org.eclipse.xtend2.lib.StringConcatenation;
import su.nsk.iae.post.generator.isabelle.common.StatementListGenerator;
import su.nsk.iae.post.poST.Expression;
import su.nsk.iae.post.poST.ForStatement;
import su.nsk.iae.post.poST.Statement;

@SuppressWarnings("all")
public class ForStatementGenerator extends IStatementGenerator {
  /**
   * new(ProgramGenerator program, ProcessGenerator process, StateGenerator state, StatementListGenerator context) {
   * super(program, process, state, context)
   * }
   */
  public ForStatementGenerator(final StatementListGenerator context) {
    super(context);
  }

  @Override
  public boolean checkStatement(final Statement statement) {
    return (statement instanceof ForStatement);
  }

  @Override
  public String generateStatement(final Statement statement) {
    final ForStatement s = ((ForStatement) statement);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(statement.IterSt (iter_statement.ForSt");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\'\'");
    String _name = s.getVariable().getName();
    _builder.append(_name, "\t");
    _builder.append("\'\'");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("(");
    String _generateExpression = this.context.generateExpression(s.getForList().getStart());
    _builder.append(_generateExpression, "\t");
    _builder.append(", ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t ");
    String _generateExpression_1 = this.context.generateExpression(s.getForList().getEnd());
    _builder.append(_generateExpression_1, "\t ");
    _builder.append(", ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t ");
    {
      Expression _step = s.getForList().getStep();
      boolean _tripleNotEquals = (_step != null);
      if (_tripleNotEquals) {
        _builder.append("(Some ");
        String _generateExpression_2 = this.context.generateExpression(s.getForList().getStep());
        _builder.append(_generateExpression_2, "\t ");
        _builder.append(")");
      } else {
        _builder.append("None");
      }
    }
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    String _generateStatementList = this.context.generateStatementList(s.getStatement());
    _builder.append(_generateStatementList, "\t");
    _builder.append("))");
    return _builder.toString();
  }
}
