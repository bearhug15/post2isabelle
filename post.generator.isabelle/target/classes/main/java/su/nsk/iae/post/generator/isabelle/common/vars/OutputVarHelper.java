package su.nsk.iae.post.generator.isabelle.common.vars;

import org.eclipse.emf.ecore.EObject;
import su.nsk.iae.post.poST.OutputVarDeclaration;

@SuppressWarnings("all")
public class OutputVarHelper extends VarHelper {
  public OutputVarHelper() {
    this.varType = "OutVar";
  }

  @Override
  public void add(final EObject varDecl, final String level) {
    if ((varDecl instanceof OutputVarDeclaration)) {
      this.parseSimpleVar(((OutputVarDeclaration)varDecl).getVars(), level);
    }
  }
}
