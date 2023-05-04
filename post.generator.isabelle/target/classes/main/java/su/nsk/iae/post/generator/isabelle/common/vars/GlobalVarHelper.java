package su.nsk.iae.post.generator.isabelle.common.vars;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import su.nsk.iae.post.generator.isabelle.common.vars.data.VarData;
import su.nsk.iae.post.poST.GlobalVarDeclaration;
import su.nsk.iae.post.poST.GlobalVarInitDeclaration;
import su.nsk.iae.post.poST.SymbolicVariable;

@SuppressWarnings("all")
public class GlobalVarHelper extends VarHelper {
  public GlobalVarHelper() {
    this.varType = "GlobalVar";
  }

  @Override
  public void add(final EObject varDecl, final String level) {
    if ((varDecl instanceof GlobalVarDeclaration)) {
      this.parseDirectVars(((GlobalVarDeclaration)varDecl).getVarsAs());
      this.parseSimpleVar(((GlobalVarDeclaration)varDecl).getVarsSimple(), ((GlobalVarDeclaration)varDecl).isConst(), "Global");
    }
  }

  private void parseDirectVars(final EList<GlobalVarInitDeclaration> varList) {
    for (final GlobalVarInitDeclaration v : varList) {
      {
        final String type = v.getType();
        EList<SymbolicVariable> _vars = v.getVarList().getVars();
        for (final SymbolicVariable e : _vars) {
          String _name = e.getName();
          String _location = v.getLocation();
          VarData _varData = new VarData(_name, type, null, false, "Global", _location);
          this.listDecl.add(_varData);
        }
      }
    }
  }
}
