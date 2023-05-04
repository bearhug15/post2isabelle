package su.nsk.iae.post.generator.isabelle.common.vars;

import org.eclipse.emf.ecore.EObject;
import su.nsk.iae.post.poST.VarDeclaration;

@SuppressWarnings("all")
public class SimpleVarHelper extends VarHelper {
  public SimpleVarHelper() {
    this.varType = "Var";
  }

  @Override
  public void add(final EObject varDecl, final String level) {
    if ((varDecl instanceof VarDeclaration)) {
      this.parseSimpleVar(((VarDeclaration)varDecl).getVars(), ((VarDeclaration)varDecl).isConst(), level);
    }
  }
}
