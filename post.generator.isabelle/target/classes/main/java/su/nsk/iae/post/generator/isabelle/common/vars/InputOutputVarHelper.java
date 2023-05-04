package su.nsk.iae.post.generator.isabelle.common.vars;

import org.eclipse.emf.ecore.EObject;
import su.nsk.iae.post.poST.InputOutputVarDeclaration;

@SuppressWarnings("all")
public class InputOutputVarHelper extends VarHelper {
  public InputOutputVarHelper() {
    this.varType = "InOutVar";
  }

  @Override
  public void add(final EObject varDecl, final String level) {
    if ((varDecl instanceof InputOutputVarDeclaration)) {
      this.parseSimpleVar(((InputOutputVarDeclaration)varDecl).getVars(), level);
    }
  }
}
