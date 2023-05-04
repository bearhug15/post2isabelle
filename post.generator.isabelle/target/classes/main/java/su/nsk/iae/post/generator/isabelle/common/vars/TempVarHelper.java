package su.nsk.iae.post.generator.isabelle.common.vars;

import org.eclipse.emf.ecore.EObject;
import su.nsk.iae.post.poST.TempVarDeclaration;

@SuppressWarnings("all")
public class TempVarHelper extends VarHelper {
  public TempVarHelper() {
    this.varType = "VAR_TEMP";
  }

  @Override
  public void add(final EObject varDecl, final String level) {
    if ((varDecl instanceof TempVarDeclaration)) {
      this.parseSimpleVar(((TempVarDeclaration)varDecl).getVars(), level);
    }
  }
}
