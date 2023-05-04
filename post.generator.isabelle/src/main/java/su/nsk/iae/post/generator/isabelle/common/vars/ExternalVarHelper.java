package su.nsk.iae.post.generator.isabelle.common.vars;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import su.nsk.iae.post.generator.isabelle.common.vars.data.VarData;
import su.nsk.iae.post.poST.ExternalVarDeclaration;
import su.nsk.iae.post.poST.ExternalVarInitDeclaration;
import su.nsk.iae.post.poST.SymbolicVariable;

@SuppressWarnings("all")
public class ExternalVarHelper extends VarHelper {
  public ExternalVarHelper() {
    this.varType = "ExtVar";
  }

  @Override
  public void add(final EObject varDecl, final String level) {
    if ((varDecl instanceof ExternalVarDeclaration)) {
      this.parseExternVar(((ExternalVarDeclaration)varDecl).getVars(), ((ExternalVarDeclaration)varDecl).isConst(), level);
    }
  }

  private void parseExternVar(final EList<ExternalVarInitDeclaration> varList, final boolean isConst, final String level) {
    for (final ExternalVarInitDeclaration v : varList) {
      {
        final String type = v.getType();
        EList<SymbolicVariable> _vars = v.getVarList().getVars();
        for (final SymbolicVariable e : _vars) {
          String _name = e.getName();
          String _transformType = VarHelper.transformType(type);
          VarData _varData = new VarData(_name, _transformType, null, isConst, level);
          this.listDecl.add(_varData);
        }
      }
    }
  }
}
