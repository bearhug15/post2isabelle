package su.nsk.iae.post.generator.isabelle.common.statement;

import su.nsk.iae.post.generator.isabelle.common.StatementListGenerator;
import su.nsk.iae.post.poST.Statement;

@SuppressWarnings("all")
public abstract class IStatementGenerator {
  protected StatementListGenerator context;

  public IStatementGenerator(final StatementListGenerator context) {
    this.context = context;
  }

  public abstract boolean checkStatement(final Statement statement);

  public abstract String generateStatement(final Statement statement);
}
