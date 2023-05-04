package su.nsk.iae.post.generator.isabelle.common.statement;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import su.nsk.iae.post.generator.isabelle.common.StatementListGenerator;
import su.nsk.iae.post.generator.isabelle.common.util.GeneratorUtil;
import su.nsk.iae.post.poST.CaseElement;
import su.nsk.iae.post.poST.CaseList;
import su.nsk.iae.post.poST.CaseListElement;
import su.nsk.iae.post.poST.CaseStatement;
import su.nsk.iae.post.poST.SignedInteger;
import su.nsk.iae.post.poST.Statement;
import su.nsk.iae.post.poST.StatementList;

@SuppressWarnings("all")
public class CaseStatementGenerator extends IStatementGenerator {
  /**
   * new(ProgramGenerator program, ProcessGenerator process, StateGenerator state, StatementListGenerator context) {
   * super(program, process, state, context)
   * }
   */
  public CaseStatementGenerator(final StatementListGenerator context) {
    super(context);
  }

  @Override
  public boolean checkStatement(final Statement statement) {
    return (statement instanceof CaseStatement);
  }

  @Override
  public String generateStatement(final Statement statement) {
    final CaseStatement s = ((CaseStatement) statement);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(statement.SelectSt (select_statement.CaseSt ");
    _builder.newLine();
    _builder.append("\t");
    String _generateExpression = this.context.generateExpression(s.getCond());
    _builder.append(_generateExpression, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("[");
    CharSequence _generateCases = this.generateCases(s);
    _builder.append(_generateCases, "\t");
    _builder.append("]");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    {
      StatementList _elseStatement = s.getElseStatement();
      boolean _tripleNotEquals = (_elseStatement != null);
      if (_tripleNotEquals) {
        _builder.append("(Some ");
        String _generateStatementList = this.context.generateStatementList(s.getElseStatement());
        _builder.append(_generateStatementList, "\t");
        _builder.append(")");
      } else {
        _builder.append("None");
      }
    }
    _builder.append("))");
    return _builder.toString();
  }

  private String generateCaseListElement(final CaseListElement e) {
    StringConcatenation _builder = new StringConcatenation();
    {
      SignedInteger _num = e.getNum();
      boolean _tripleNotEquals = (_num != null);
      if (_tripleNotEquals) {
        String _generateSignedInteger = GeneratorUtil.generateSignedInteger(e.getNum());
        _builder.append(_generateSignedInteger);
      }
    }
    return _builder.toString();
  }

  private CharSequence generateCaseList(final CaseList list) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<CaseListElement> _caseListElement = list.getCaseListElement();
      boolean _hasElements = false;
      for(final CaseListElement e : _caseListElement) {
        if (!_hasElements) {
          _hasElements = true;
          _builder.append("[");
        } else {
          _builder.appendImmediate(", ", "");
        }
        String _generateCaseListElement = this.generateCaseListElement(e);
        _builder.append(_generateCaseListElement);
      }
      if (_hasElements) {
        _builder.append("]");
      }
    }
    return _builder;
  }

  private CharSequence generateCases(final CaseStatement s) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<CaseElement> _caseElements = s.getCaseElements();
      boolean _hasElements = false;
      for(final CaseElement e : _caseElements) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", \n", "");
        }
        _builder.append(" ");
        _builder.newLineIfNotEmpty();
        _builder.append("(");
        CharSequence _generateCaseList = this.generateCaseList(e.getCaseList());
        _builder.append(_generateCaseList);
        _builder.append(",");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        String _generateStatementList = this.context.generateStatementList(e.getStatement());
        _builder.append(_generateStatementList, "  ");
        _builder.append(")");
      }
    }
    return _builder;
  }
}
