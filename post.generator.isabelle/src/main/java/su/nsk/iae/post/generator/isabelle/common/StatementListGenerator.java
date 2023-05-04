package su.nsk.iae.post.generator.isabelle.common;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import su.nsk.iae.post.generator.isabelle.common.statement.AssignmentStatementGenerator;
import su.nsk.iae.post.generator.isabelle.common.statement.CaseStatementGenerator;
import su.nsk.iae.post.generator.isabelle.common.statement.ErrorProcessStatementGenerator;
import su.nsk.iae.post.generator.isabelle.common.statement.ExitStatementGenerator;
import su.nsk.iae.post.generator.isabelle.common.statement.FBInvocationGenerator;
import su.nsk.iae.post.generator.isabelle.common.statement.ForStatementGenerator;
import su.nsk.iae.post.generator.isabelle.common.statement.IStatementGenerator;
import su.nsk.iae.post.generator.isabelle.common.statement.IfStatementGenerator;
import su.nsk.iae.post.generator.isabelle.common.statement.RepeatStatementGenerator;
import su.nsk.iae.post.generator.isabelle.common.statement.ResetTimerStatementGenerator;
import su.nsk.iae.post.generator.isabelle.common.statement.SetStateStatementGenerator;
import su.nsk.iae.post.generator.isabelle.common.statement.StartProcessStatementGenerator;
import su.nsk.iae.post.generator.isabelle.common.statement.StopProcessStatementGenerator;
import su.nsk.iae.post.generator.isabelle.common.statement.SubprogramControlStatementGenerator;
import su.nsk.iae.post.generator.isabelle.common.statement.WhileStatementGenerator;
import su.nsk.iae.post.generator.isabelle.common.util.GeneratorUtil;
import su.nsk.iae.post.poST.Expression;
import su.nsk.iae.post.poST.ParamAssignmentElements;
import su.nsk.iae.post.poST.Statement;
import su.nsk.iae.post.poST.StatementList;

@SuppressWarnings("all")
public class StatementListGenerator {
  private List<IStatementGenerator> statementGenerators;

  public StatementListGenerator() {
    this.statementGenerators = this.initStatementGenerators();
  }

  public String generateStatementList(final StatementList statementList) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[");
    {
      EList<Statement> _statements = statementList.getStatements();
      boolean _hasElements = false;
      for(final Statement s : _statements) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", \n ", "");
        }
        String _generateStatement = this.generateStatement(s);
        _builder.append(_generateStatement);
      }
    }
    _builder.append("]");
    return _builder.toString();
  }

  public String generateStatement(final Statement statement) {
    for (final IStatementGenerator sg : this.statementGenerators) {
      boolean _checkStatement = sg.checkStatement(statement);
      if (_checkStatement) {
        return sg.generateStatement(statement);
      }
    }
    return "";
  }

  public String generateExpression(final Expression exp) {
    return GeneratorUtil.generateExpression(exp);
  }

  public String generateParamAssignmentElements(final ParamAssignmentElements elements) {
    final Function<Expression, String> _function = (Expression x) -> {
      return this.generateExpression(x);
    };
    return GeneratorUtil.generateParamAssignmentElements(elements, _function);
  }

  private List<IStatementGenerator> initStatementGenerators() {
    AssignmentStatementGenerator _assignmentStatementGenerator = new AssignmentStatementGenerator(this);
    IfStatementGenerator _ifStatementGenerator = new IfStatementGenerator(this);
    CaseStatementGenerator _caseStatementGenerator = new CaseStatementGenerator(this);
    ForStatementGenerator _forStatementGenerator = new ForStatementGenerator(this);
    WhileStatementGenerator _whileStatementGenerator = new WhileStatementGenerator(this);
    RepeatStatementGenerator _repeatStatementGenerator = new RepeatStatementGenerator(this);
    FBInvocationGenerator _fBInvocationGenerator = new FBInvocationGenerator(this);
    StartProcessStatementGenerator _startProcessStatementGenerator = new StartProcessStatementGenerator(this);
    StopProcessStatementGenerator _stopProcessStatementGenerator = new StopProcessStatementGenerator(this);
    ErrorProcessStatementGenerator _errorProcessStatementGenerator = new ErrorProcessStatementGenerator(this);
    SetStateStatementGenerator _setStateStatementGenerator = new SetStateStatementGenerator(this);
    ResetTimerStatementGenerator _resetTimerStatementGenerator = new ResetTimerStatementGenerator(this);
    SubprogramControlStatementGenerator _subprogramControlStatementGenerator = new SubprogramControlStatementGenerator(this);
    ExitStatementGenerator _exitStatementGenerator = new ExitStatementGenerator(this);
    return Arrays.<IStatementGenerator>asList(_assignmentStatementGenerator, _ifStatementGenerator, _caseStatementGenerator, _forStatementGenerator, _whileStatementGenerator, _repeatStatementGenerator, _fBInvocationGenerator, _startProcessStatementGenerator, _stopProcessStatementGenerator, _errorProcessStatementGenerator, _setStateStatementGenerator, _resetTimerStatementGenerator, _subprogramControlStatementGenerator, _exitStatementGenerator);
  }
}
