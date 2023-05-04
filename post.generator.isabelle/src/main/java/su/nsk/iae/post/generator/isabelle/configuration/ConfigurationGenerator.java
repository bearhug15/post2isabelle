package su.nsk.iae.post.generator.isabelle.configuration;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import su.nsk.iae.post.generator.isabelle.common.vars.GlobalVarHelper;
import su.nsk.iae.post.generator.isabelle.common.vars.VarHelper;
import su.nsk.iae.post.poST.Configuration;
import su.nsk.iae.post.poST.GlobalVarDeclaration;
import su.nsk.iae.post.poST.Resource;

@SuppressWarnings("all")
public class ConfigurationGenerator {
  private Configuration configuration;

  private VarHelper confVarList = new GlobalVarHelper();

  private List<ResourceGenerator> resources = new LinkedList<ResourceGenerator>();

  public ConfigurationGenerator(final Configuration configuration) {
    this.configuration = configuration;
    final Consumer<GlobalVarDeclaration> _function = (GlobalVarDeclaration v) -> {
      this.confVarList.add(v, "Global");
    };
    configuration.getConfGlobVars().stream().forEach(_function);
    final Consumer<Resource> _function_1 = (Resource r) -> {
      ResourceGenerator _resourceGenerator = new ResourceGenerator(r);
      this.resources.add(_resourceGenerator);
    };
    configuration.getResources().stream().forEach(_function_1);
  }

  public String generateConfiguration() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(\'\'");
    String _name = this.configuration.getName();
    _builder.append(_name);
    _builder.append("\'\',");
    _builder.newLineIfNotEmpty();
    _builder.append("[");
    String _generateVar = this.confVarList.generateVar();
    _builder.append(_generateVar);
    _builder.append("]");
    _builder.newLineIfNotEmpty();
    {
      boolean _hasElements = false;
      for(final ResourceGenerator res : this.resources) {
        if (!_hasElements) {
          _hasElements = true;
          _builder.append("[", " ");
        } else {
          _builder.appendImmediate(",", " ");
        }
        _builder.append(" ");
        String _generateResource = res.generateResource();
        _builder.append(_generateResource, " ");
      }
      if (_hasElements) {
        _builder.append("]", " ");
      }
    }
    _builder.append(")");
    return _builder.toString();
  }

  public EList<Resource> getResources() {
    return this.configuration.getResources();
  }
}
