package su.nsk.iae.post.generator.isabelle.common.statement;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import su.nsk.iae.post.generator.isabelle.common.StatementListGenerator;
import su.nsk.iae.post.poST.IfStatement;
import su.nsk.iae.post.poST.Statement;
import su.nsk.iae.post.poST.StatementList;

@SuppressWarnings("all")
public class IfStatementGenerator extends IStatementGenerator {
  /**
   * new(ProgramGenerator program, ProcessGenerator process, StateGenerator state, StatementListGenerator context) {
   * super(program, process, state, context)
   * }
   */
  public IfStatementGenerator(final StatementListGenerator context) {
    super(context);
  }

  @Override
  public boolean checkStatement(final Statement statement) {
    return (statement instanceof IfStatement);
  }

  @Override
  public String generateStatement(final Statement statement) {
    final IfStatement s = ((IfStatement) statement);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(statement.SelectSt (select_statement.IfSt ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("[(");
    String _generateExpression = this.context.generateExpression(s.getMainCond());
    _builder.append(_generateExpression, "\t");
    _builder.append(", ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t  ");
    String _generateStatementList = this.context.generateStatementList(s.getMainStatement());
    _builder.append(_generateStatementList, "\t  ");
    _builder.append(")");
    {
      boolean _isEmpty = s.getElseIfCond().isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        String _printElseIfs = this.printElseIfs(s);
        _builder.append(_printElseIfs, "\t  ");
      }
    }
    _builder.append("]");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    String _printElse = this.printElse(s);
    _builder.append(_printElse, "\t");
    _builder.append("))");
    return _builder.toString();
  }

  public String printElseIfs(final IfStatement s) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(",");
    _builder.newLine();
    {
      int _length = ((Object[])Conversions.unwrapArray(s.getElseIfCond(), Object.class)).length;
      int _minus = (_length - 1);
      IntegerRange _upTo = new IntegerRange(0, _minus);
      boolean _hasElements = false;
      for(final Integer i : _upTo) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", \n", "\t");
        }
        _builder.append("\t");
        _builder.append("(");
        String _generateExpression = this.context.generateExpression(s.getElseIfCond().get((i).intValue()));
        _builder.append(_generateExpression, "\t");
        _builder.append(", ");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("  ");
        String _generateStatementList = this.context.generateStatementList(s.getElseIfStatements().get((i).intValue()));
        _builder.append(_generateStatementList, "\t  ");
        _builder.append(")");
      }
    }
    return _builder.toString();
  }

  public String printElse(final IfStatement s) {
    StringConcatenation _builder = new StringConcatenation();
    {
      StatementList _elseStatement = s.getElseStatement();
      boolean _tripleNotEquals = (_elseStatement != null);
      if (_tripleNotEquals) {
        _builder.append("(Some ");
        String _generateStatementList = this.context.generateStatementList(s.getElseStatement());
        _builder.append(_generateStatementList);
        _builder.append(")");
      } else {
        _builder.append("None");
      }
    }
    return _builder.toString();
  }
}
