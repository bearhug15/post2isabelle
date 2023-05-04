package su.nsk.iae.post.generator.isabelle.common.vars;

import org.eclipse.emf.ecore.EObject;
import su.nsk.iae.post.poST.ProcessVarDeclaration;

@SuppressWarnings("all")
public class ProcessVarHelper extends VarHelper {
  public ProcessVarHelper() {
    this.varType = "ProcessVar";
  }

  @Override
  public void add(final EObject varDecl, final String level) {
    if ((varDecl instanceof ProcessVarDeclaration)) {
      this.parseProcessVar(((ProcessVarDeclaration)varDecl).getVars(), level);
    }
  }
}
