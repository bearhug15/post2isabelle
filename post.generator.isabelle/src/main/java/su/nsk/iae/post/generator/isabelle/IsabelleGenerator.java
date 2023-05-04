package su.nsk.iae.post.generator.isabelle;

import com.google.common.base.Objects;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import su.nsk.iae.post.generator.isabelle.common.FunctionBlockGenerator;
import su.nsk.iae.post.generator.isabelle.common.FunctionGenerator;
import su.nsk.iae.post.generator.isabelle.common.ProgramGenerator;
import su.nsk.iae.post.generator.isabelle.common.vars.GlobalVarHelper;
import su.nsk.iae.post.generator.isabelle.common.vars.VarHelper;
import su.nsk.iae.post.generator.isabelle.configuration.ConfigurationGenerator;
import su.nsk.iae.post.poST.ArrayVariable;
import su.nsk.iae.post.poST.AssignmentStatement;
import su.nsk.iae.post.poST.AttachVariableConfElement;
import su.nsk.iae.post.poST.Configuration;
import su.nsk.iae.post.poST.Constant;
import su.nsk.iae.post.poST.ForStatement;
import su.nsk.iae.post.poST.FunctionBlock;
import su.nsk.iae.post.poST.GlobalVarDeclaration;
import su.nsk.iae.post.poST.Model;
import su.nsk.iae.post.poST.PrimaryExpression;
import su.nsk.iae.post.poST.ProcessStatements;
import su.nsk.iae.post.poST.ProcessStatusExpression;
import su.nsk.iae.post.poST.Program;
import su.nsk.iae.post.poST.ProgramConfElement;
import su.nsk.iae.post.poST.ProgramConfElements;
import su.nsk.iae.post.poST.ProgramConfiguration;
import su.nsk.iae.post.poST.Resource;
import su.nsk.iae.post.poST.SymbolicVariable;
import su.nsk.iae.post.poST.TemplateProcessAttachVariableConfElement;
import su.nsk.iae.post.poST.TemplateProcessConfElement;
import su.nsk.iae.post.poST.TimeoutStatement;
import su.nsk.iae.post.poST.Variable;

@SuppressWarnings("all")
public class IsabelleGenerator implements IpoSTGenerator {
  private ConfigurationGenerator configuration = null;

  private VarHelper globVarList = new GlobalVarHelper();

  private List<ProgramGenerator> programs = new LinkedList<ProgramGenerator>();

  private List<FunctionGenerator> functions = new LinkedList<FunctionGenerator>();

  private List<FunctionBlockGenerator> fbs = new LinkedList<FunctionBlockGenerator>();

  private String fileName;

  /**
   * override execute(String root, String fileName, Resource resource) {
   * try {
   * this.fileName = fileName
   * val fsa = PoSTStandaloneSetup.getInjector().getInstance(JavaIoFileSystemAccess);
   * val generatePath = root + File.separator + "isabelle" + File.separator + fileName;
   * fsa.setOutputPath(generatePath);
   * 
   * model = resource.allContents.toIterable.filter(Model).get(0)
   * beforeGenerate(resource, fsa, null);
   * doGenerate(resource, fsa, null);
   * afterGenerate(resource, fsa, null);
   * return "Files generated in " + generatePath;
   * } catch (Throwable th) {
   * //Do nothing
   * }
   * return "Failure";
   * }
   */
  @Override
  public void setModel(final Model model) {
    this.globVarList.clear();
    this.programs.clear();
    final Consumer<GlobalVarDeclaration> _function = (GlobalVarDeclaration v) -> {
      this.globVarList.add(v, "Global");
    };
    model.getGlobVars().stream().forEach(_function);
    Configuration _conf = model.getConf();
    boolean _tripleNotEquals = (_conf != null);
    if (_tripleNotEquals) {
      Configuration _conf_1 = model.getConf();
      ConfigurationGenerator _configurationGenerator = new ConfigurationGenerator(_conf_1);
      this.configuration = _configurationGenerator;
      final Function<Resource, EList<ProgramConfiguration>> _function_1 = (Resource res) -> {
        return res.getResStatement().getProgramConfs();
      };
      final Function<EList<ProgramConfiguration>, Stream<ProgramConfiguration>> _function_2 = (EList<ProgramConfiguration> res) -> {
        return res.stream();
      };
      final Consumer<ProgramConfiguration> _function_3 = (ProgramConfiguration programConf) -> {
        final Program program = EcoreUtil.<Program>copy(programConf.getProgram());
        program.setName(this.capitalizeFirst(programConf.getName()));
        ProgramPOUGenerator _programPOUGenerator = new ProgramPOUGenerator(program, true);
        this.programs.add(_programPOUGenerator);
      };
      this.configuration.getResources().stream().<EList<ProgramConfiguration>>map(_function_1).<ProgramConfiguration>flatMap(_function_2).forEach(_function_3);
    } else {
      final Consumer<su.nsk.iae.post.poST.Function> _function_4 = (su.nsk.iae.post.poST.Function f) -> {
        FunctionPOUGenerator _functionPOUGenerator = new FunctionPOUGenerator(f);
        this.functions.add(_functionPOUGenerator);
      };
      model.getFuns().stream().forEach(_function_4);
      final Consumer<Program> _function_5 = (Program p) -> {
        ProgramPOUGenerator _programPOUGenerator = new ProgramPOUGenerator(p, false);
        this.programs.add(_programPOUGenerator);
      };
      model.getPrograms().stream().forEach(_function_5);
      final Consumer<FunctionBlock> _function_6 = (FunctionBlock fb) -> {
        FunctionBlockPOUGenerator _functionBlockPOUGenerator = new FunctionBlockPOUGenerator(fb, false);
        this.fbs.add(_functionBlockPOUGenerator);
      };
      model.getFbs().stream().forEach(_function_6);
    }
  }

  public void beforeGenerate(final org.eclipse.emf.ecore.resource.Resource input, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    this.preparePrograms();
  }

  public void doGenerate(final org.eclipse.emf.ecore.resource.Resource input, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    this.generateSingleFile(fsa, "");
  }

  public Object afterGenerate(final org.eclipse.emf.ecore.resource.Resource input, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    return null;
  }

  @Override
  public void generateSingleFile(final IFileSystemAccess2 fsa, final String path) {
    final String[] uri = path.split("/");
    if ((this.fileName == null)) {
      int _length = uri.length;
      int _minus = (_length - 1);
      final String sourceName = uri[_minus];
      this.fileName = sourceName.split("\\.")[0];
    }
    int _length_1 = uri.length;
    int _minus_1 = (_length_1 - 1);
    String new_path = String.join("/", Arrays.<CharSequence>copyOf(uri, _minus_1));
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("poST_");
    _builder.append(this.fileName);
    _builder.append(".thy");
    fsa.generateFile(_builder.toString(), this.generateSingleFileBody());
  }

  @Override
  public void generateMultipleFiles(final IFileSystemAccess2 fsa, final String path) {
    final String[] uri = path.split("/");
    if ((this.fileName == null)) {
      int _length = uri.length;
      int _minus = (_length - 1);
      this.fileName = (uri[_minus]).split("\\.")[0];
    }
    int _length_1 = uri.length;
    int _minus_1 = (_length_1 - 1);
    String new_path = String.join("/", Arrays.<CharSequence>copyOf(uri, _minus_1));
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(new_path);
    _builder.append("/poST_");
    _builder.append(this.fileName);
    _builder.append(".thy");
    fsa.generateFile(_builder.toString(), this.generateSingleFileBody());
  }

  public String generateSingleFileBody() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("theory poST_");
    _builder.append(this.fileName);
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("imports \"~~/poST/poSTVM/poSTVM_alt_inductive\"");
    _builder.newLine();
    _builder.append("begin");
    _builder.newLine();
    _builder.append("definition ");
    _builder.append(this.fileName);
    _builder.append(" :: \"model\" where");
    _builder.newLineIfNotEmpty();
    _builder.append("\"");
    _builder.append(this.fileName);
    _builder.append(" =");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("(");
    {
      if ((this.configuration != null)) {
        _builder.append("(Some ");
        String _generateConfiguration = this.configuration.generateConfiguration();
        _builder.append(_generateConfiguration, "\t");
        _builder.append(")");
      } else {
        _builder.append("None");
      }
    }
    _builder.append(",");
    _builder.newLineIfNotEmpty();
    _builder.append("\t ");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("[");
    String _generateVar = this.globVarList.generateVar();
    _builder.append(_generateVar, "\t ");
    _builder.append("],");
    _builder.newLineIfNotEmpty();
    _builder.append("\t ");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("[");
    {
      boolean _hasElements = false;
      for(final ProgramGenerator c : this.programs) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", \n\n", "\t ");
        }
        String _generateProgram = c.generateProgram();
        _builder.append(_generateProgram, "\t ");
      }
    }
    _builder.append("],");
    _builder.newLineIfNotEmpty();
    _builder.append("\t ");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("[");
    {
      boolean _hasElements_1 = false;
      for(final FunctionGenerator f : this.functions) {
        if (!_hasElements_1) {
          _hasElements_1 = true;
        } else {
          _builder.appendImmediate(", \n\n", "\t ");
        }
        String _generateFunction = f.generateFunction();
        _builder.append(_generateFunction, "\t ");
      }
    }
    _builder.append("],");
    _builder.newLineIfNotEmpty();
    _builder.append("\t ");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("[");
    {
      boolean _hasElements_2 = false;
      for(final FunctionBlockGenerator f_1 : this.fbs) {
        if (!_hasElements_2) {
          _hasElements_2 = true;
        } else {
          _builder.appendImmediate(", \n\n", "\t ");
        }
        String _generateFB = f_1.generateFB();
        _builder.append(_generateFB, "\t ");
      }
    }
    _builder.append("])\"");
    _builder.newLineIfNotEmpty();
    _builder.append("end");
    return _builder.toString();
  }

  private void preparePrograms() {
    if ((this.configuration == null)) {
      return;
    }
    final Function<Resource, EList<ProgramConfiguration>> _function = (Resource res) -> {
      return res.getResStatement().getProgramConfs();
    };
    final Function<EList<ProgramConfiguration>, Stream<ProgramConfiguration>> _function_1 = (EList<ProgramConfiguration> res) -> {
      return res.stream();
    };
    final Consumer<ProgramConfiguration> _function_2 = (ProgramConfiguration programConf) -> {
      ProgramConfElements _args = programConf.getArgs();
      boolean _tripleNotEquals = (_args != null);
      if (_tripleNotEquals) {
        final String programConfName = this.capitalizeFirst(programConf.getName());
        final Predicate<ProgramGenerator> _function_3 = (ProgramGenerator x) -> {
          String _name = x.getName();
          return Objects.equal(_name, programConfName);
        };
        final ProgramGenerator programGen = this.programs.stream().filter(_function_3).findFirst().get();
        final Consumer<ProgramConfElement> _function_4 = (ProgramConfElement confElement) -> {
          if ((confElement instanceof TemplateProcessConfElement)) {
            final su.nsk.iae.post.poST.Process process = EcoreUtil.<su.nsk.iae.post.poST.Process>copy(((TemplateProcessConfElement)confElement).getProcess());
            process.setName(this.capitalizeFirst(((TemplateProcessConfElement)confElement).getName()));
            final Consumer<TemplateProcessAttachVariableConfElement> _function_5 = (TemplateProcessAttachVariableConfElement e) -> {
              this.changeAllVars(e, process);
            };
            ((TemplateProcessConfElement)confElement).getArgs().getElements().stream().forEach(_function_5);
            programGen.addProcess(process, ((TemplateProcessConfElement)confElement).isActive());
          } else {
            if ((confElement instanceof AttachVariableConfElement)) {
              this.changeAllVars(((AttachVariableConfElement)confElement), programGen.getEObject());
            }
          }
        };
        programConf.getArgs().getElements().stream().forEach(_function_4);
      }
    };
    this.configuration.getResources().stream().<EList<ProgramConfiguration>>map(_function).<ProgramConfiguration>flatMap(_function_1).forEach(_function_2);
  }

  public void changeAllVars(final AttachVariableConfElement element, final EObject root) {
    this.changeAllVars(element.getProgramVar(), element.getAttVar(), element.getConst(), root);
  }

  public void changeAllVars(final TemplateProcessAttachVariableConfElement element, final EObject root) {
    this.changeAllVars(element.getProgramVar(), element.getAttVar(), element.getConst(), root);
  }

  public void changeAllVars(final Variable programVar, final Variable attVar, final Constant const_, final EObject root) {
    final Predicate<PrimaryExpression> _function = (PrimaryExpression v) -> {
      return ((v.getVariable() != null) && Objects.equal(v.getVariable().getName(), programVar.getName()));
    };
    final Consumer<PrimaryExpression> _function_1 = (PrimaryExpression v) -> {
      if ((attVar != null)) {
        v.setVariable(((SymbolicVariable) attVar));
      } else {
        v.setVariable(null);
        v.setConst(EcoreUtil.<Constant>copy(const_));
      }
    };
    EcoreUtil2.<PrimaryExpression>getAllContentsOfType(root, PrimaryExpression.class).stream().filter(_function).forEach(_function_1);
    final Predicate<AssignmentStatement> _function_2 = (AssignmentStatement v) -> {
      return ((v.getVariable() != null) && Objects.equal(v.getVariable().getName(), programVar.getName()));
    };
    final Consumer<AssignmentStatement> _function_3 = (AssignmentStatement v) -> {
      v.setVariable(((SymbolicVariable) attVar));
    };
    EcoreUtil2.<AssignmentStatement>getAllContentsOfType(root, AssignmentStatement.class).stream().filter(_function_2).forEach(_function_3);
    final Predicate<ForStatement> _function_4 = (ForStatement v) -> {
      String _name = v.getVariable().getName();
      String _name_1 = programVar.getName();
      return Objects.equal(_name, _name_1);
    };
    final Consumer<ForStatement> _function_5 = (ForStatement v) -> {
      v.setVariable(((SymbolicVariable) attVar));
    };
    EcoreUtil2.<ForStatement>getAllContentsOfType(root, ForStatement.class).stream().filter(_function_4).forEach(_function_5);
    final Predicate<ArrayVariable> _function_6 = (ArrayVariable v) -> {
      String _name = v.getVariable().getName();
      String _name_1 = programVar.getName();
      return Objects.equal(_name, _name_1);
    };
    final Consumer<ArrayVariable> _function_7 = (ArrayVariable v) -> {
      v.setVariable(((SymbolicVariable) attVar));
    };
    EcoreUtil2.<ArrayVariable>getAllContentsOfType(root, ArrayVariable.class).stream().filter(_function_6).forEach(_function_7);
    final Predicate<TimeoutStatement> _function_8 = (TimeoutStatement v) -> {
      return ((v.getVariable() != null) && Objects.equal(v.getVariable().getName(), programVar.getName()));
    };
    final Consumer<TimeoutStatement> _function_9 = (TimeoutStatement v) -> {
      v.setVariable(((SymbolicVariable) attVar));
    };
    EcoreUtil2.<TimeoutStatement>getAllContentsOfType(root, TimeoutStatement.class).stream().filter(_function_8).forEach(_function_9);
    final Predicate<ProcessStatements> _function_10 = (ProcessStatements v) -> {
      return ((v.getProcess() != null) && Objects.equal(v.getProcess().getName(), programVar.getName()));
    };
    final Consumer<ProcessStatements> _function_11 = (ProcessStatements v) -> {
      Variable _process = v.getProcess();
      _process.setName(this.capitalizeFirst(attVar.getName()));
    };
    EcoreUtil2.<ProcessStatements>getAllContentsOfType(root, ProcessStatements.class).stream().filter(_function_10).forEach(_function_11);
    final Predicate<ProcessStatusExpression> _function_12 = (ProcessStatusExpression v) -> {
      return ((v.getProcess() != null) && Objects.equal(v.getProcess().getName(), programVar.getName()));
    };
    final Consumer<ProcessStatusExpression> _function_13 = (ProcessStatusExpression v) -> {
      Variable _process = v.getProcess();
      _process.setName(this.capitalizeFirst(attVar.getName()));
    };
    EcoreUtil2.<ProcessStatusExpression>getAllContentsOfType(root, ProcessStatusExpression.class).stream().filter(_function_12).forEach(_function_13);
  }

  private String capitalizeFirst(final String str) {
    String _upperCase = str.substring(0, 1).toUpperCase();
    String _substring = str.substring(1);
    return (_upperCase + _substring);
  }

  public void setFileName(final String fileName) {
    this.fileName = fileName;
  }
}
