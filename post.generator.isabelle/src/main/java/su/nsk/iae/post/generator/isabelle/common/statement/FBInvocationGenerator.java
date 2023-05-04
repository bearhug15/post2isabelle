package su.nsk.iae.post.generator.isabelle.common.statement;

import org.eclipse.xtend2.lib.StringConcatenation;
import su.nsk.iae.post.generator.isabelle.common.StatementListGenerator;
import su.nsk.iae.post.poST.FBInvocation;
import su.nsk.iae.post.poST.Statement;

@SuppressWarnings("all")
public class FBInvocationGenerator extends IStatementGenerator {
  /**
   * new(ProgramGenerator program, ProcessGenerator process, StateGenerator state, StatementListGenerator context) {
   * super(program, process, state, context)
   * }
   */
  public FBInvocationGenerator(final StatementListGenerator context) {
    super(context);
  }

  @Override
  public boolean checkStatement(final Statement statement) {
    return (statement instanceof FBInvocation);
  }

  @Override
  public String generateStatement(final Statement statement) {
    final FBInvocation s = ((FBInvocation) statement);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(statement.FBInvocation ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\'\'");
    String _name = s.getFb().getName();
    _builder.append(_name, "\t");
    _builder.append("\'\' ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("(");
    String _generateParamAssignmentElements = this.context.generateParamAssignmentElements(s.getArgs());
    _builder.append(_generateParamAssignmentElements, "\t");
    _builder.append("))");
    return _builder.toString();
  }
}
