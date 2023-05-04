package su.nsk.iae.post.generator.isabelle.configuration;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.xtend2.lib.StringConcatenation;
import su.nsk.iae.post.generator.isabelle.common.vars.GlobalVarHelper;
import su.nsk.iae.post.generator.isabelle.common.vars.VarHelper;
import su.nsk.iae.post.poST.GlobalVarDeclaration;
import su.nsk.iae.post.poST.ProgramConfiguration;
import su.nsk.iae.post.poST.Resource;
import su.nsk.iae.post.poST.Task;

@SuppressWarnings("all")
public class ResourceGenerator {
  private Resource resource;

  private VarHelper resVarList = new GlobalVarHelper();

  private List<TaskGenerator> tasks = new LinkedList<TaskGenerator>();

  private List<ProgramConfigurationGenerator> programConfigurationGenerators = new LinkedList<ProgramConfigurationGenerator>();

  public ResourceGenerator(final Resource resource) {
    this.resource = resource;
    final Consumer<GlobalVarDeclaration> _function = (GlobalVarDeclaration v) -> {
      this.resVarList.add(v, "Global");
    };
    resource.getResGlobVars().stream().forEach(_function);
    final Consumer<Task> _function_1 = (Task t) -> {
      TaskGenerator _taskGenerator = new TaskGenerator(t);
      this.tasks.add(_taskGenerator);
    };
    resource.getResStatement().getTasks().stream().forEach(_function_1);
    final Consumer<ProgramConfiguration> _function_2 = (ProgramConfiguration p) -> {
      ProgramConfigurationGenerator _programConfigurationGenerator = new ProgramConfigurationGenerator(p);
      this.programConfigurationGenerators.add(_programConfigurationGenerator);
    };
    resource.getResStatement().getProgramConfs().stream().forEach(_function_2);
  }

  /**
   * def String generateResource()
   * '''
   * (''«resource.name»'',
   * ''«resource.type»'',
   * [«resVarList.generateVar»]
   * «generateSingleResource»)'''
   * 
   * def generateSingleResource()
   * '''
   * [«FOR task : tasks SEPARATOR ', \n'»(single_resource_var.Task «task.generateTask»)«ENDFOR»
   * «IF !tasks.empty && !programConfigurationGenerators.empty»,«ENDIF»
   * «FOR pcg : programConfigurationGenerators SEPARATOR ','»
   * (single_resource_var.ProgConfDecl «pcg.generateProgramConfiguration»)
   * «ENDFOR»]'''
   */
  public String generateResource() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(\'\'");
    String _name = this.resource.getName();
    _builder.append(_name);
    _builder.append("\'\',");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("\'\'");
    String _type = this.resource.getType();
    _builder.append(_type, " ");
    _builder.append("\'\',");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("[");
    String _generateVar = this.resVarList.generateVar();
    _builder.append(_generateVar, " ");
    _builder.append("]");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    CharSequence _generateSingleResource = this.generateSingleResource();
    _builder.append(_generateSingleResource, " ");
    _builder.append(")");
    return _builder.toString();
  }

  public CharSequence generateSingleResource() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[");
    {
      boolean _hasElements = false;
      for(final TaskGenerator task : this.tasks) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", \n", "");
        }
        _builder.append("(single_resource_var.Task ");
        String _generateTask = task.generateTask();
        _builder.append(_generateTask);
        _builder.append(")");
      }
    }
    {
      if (((!this.tasks.isEmpty()) && (!this.programConfigurationGenerators.isEmpty()))) {
        _builder.append(", ");
      }
    }
    _builder.newLineIfNotEmpty();
    {
      boolean _hasElements_1 = false;
      for(final ProgramConfigurationGenerator pcg : this.programConfigurationGenerators) {
        if (!_hasElements_1) {
          _hasElements_1 = true;
        } else {
          _builder.appendImmediate(",", "");
        }
        _builder.append("(single_resource_var.ProgConfDecl ");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        String _generateProgramConfiguration = pcg.generateProgramConfiguration();
        _builder.append(_generateProgramConfiguration, "\t");
        _builder.append(")");
      }
    }
    _builder.append("]");
    return _builder;
  }
}
