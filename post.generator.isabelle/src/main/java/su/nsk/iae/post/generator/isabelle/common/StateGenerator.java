package su.nsk.iae.post.generator.isabelle.common;

import org.eclipse.xtend2.lib.StringConcatenation;
import su.nsk.iae.post.generator.isabelle.common.util.GeneratorUtil;
import su.nsk.iae.post.poST.Constant;
import su.nsk.iae.post.poST.State;
import su.nsk.iae.post.poST.TimeoutStatement;

@SuppressWarnings("all")
public class StateGenerator {
  private State state;

  private StatementListGenerator statementList;

  /**
   * new(ProgramGenerator program, ProcessGenerator process, State state) {
   * this.process = process
   * this.state = state
   * statementList = new StatementListGenerator(program, process, this)
   * }
   */
  public StateGenerator(final State state) {
    this.state = state;
    StatementListGenerator _statementListGenerator = new StatementListGenerator();
    this.statementList = _statementListGenerator;
  }

  public String generateBody() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(\'\'");
    String _name = this.state.getName();
    _builder.append(_name);
    _builder.append("\'\', ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    {
      boolean _isLooped = this.state.isLooped();
      if (_isLooped) {
        _builder.append("True");
      } else {
        _builder.append("False");
      }
    }
    _builder.append(", ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    String _generateStatementList = this.statementList.generateStatementList(this.state.getStatement());
    _builder.append(_generateStatementList, "\t");
    _builder.append(", ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    String _generateTimeout = this.generateTimeout();
    _builder.append(_generateTimeout, "\t");
    _builder.append(")");
    return _builder.toString();
  }

  public String getName() {
    return this.state.getName();
  }

  public boolean hasTimeout() {
    TimeoutStatement _timeout = this.state.getTimeout();
    return (_timeout != null);
  }

  private String generateTimeout() {
    StringConcatenation _builder = new StringConcatenation();
    {
      TimeoutStatement _timeout = this.state.getTimeout();
      boolean _tripleNotEquals = (_timeout != null);
      if (_tripleNotEquals) {
        _builder.append("(Some ");
        {
          Constant _const = this.state.getTimeout().getConst();
          boolean _tripleNotEquals_1 = (_const != null);
          if (_tripleNotEquals_1) {
            _builder.append("(timeout_statement.Const ");
            String _generateConstant = GeneratorUtil.generateConstant(this.state.getTimeout().getConst());
            _builder.append(_generateConstant);
          } else {
            _builder.append("(timeout_statement.SymbolicVar \'\'");
            String _name = this.state.getTimeout().getVariable().getName();
            _builder.append(_name);
            _builder.append("\'\' ");
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        String _generateStatementList = this.statementList.generateStatementList(this.state.getTimeout().getStatement());
        _builder.append(_generateStatementList, "\t");
        _builder.append("))");
      } else {
        _builder.append("None");
      }
    }
    return _builder.toString();
  }

  private String generateTimeoutArg(final TimeoutStatement ts) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder.toString();
  }
}
