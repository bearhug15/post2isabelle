package su.nsk.iae.post.generator.isabelle.common;

import com.google.common.base.Objects;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import su.nsk.iae.post.generator.isabelle.common.vars.ExternalVarHelper;
import su.nsk.iae.post.generator.isabelle.common.vars.InputOutputVarHelper;
import su.nsk.iae.post.generator.isabelle.common.vars.InputVarHelper;
import su.nsk.iae.post.generator.isabelle.common.vars.OutputVarHelper;
import su.nsk.iae.post.generator.isabelle.common.vars.SimpleVarHelper;
import su.nsk.iae.post.generator.isabelle.common.vars.VarHelper;
import su.nsk.iae.post.poST.ExternalVarDeclaration;
import su.nsk.iae.post.poST.FunctionBlock;
import su.nsk.iae.post.poST.InputOutputVarDeclaration;
import su.nsk.iae.post.poST.InputVarDeclaration;
import su.nsk.iae.post.poST.OutputVarDeclaration;
import su.nsk.iae.post.poST.VarDeclaration;

@SuppressWarnings("all")
public class FunctionBlockGenerator {
  protected FunctionBlock object;

  protected String FBName;

  protected String type;

  private boolean templateProcess;

  protected VarHelper inVarList = new InputVarHelper();

  protected VarHelper outVarList = new OutputVarHelper();

  protected VarHelper inOutVarList = new InputOutputVarHelper();

  protected VarHelper externalVarList = new ExternalVarHelper();

  protected VarHelper varList = new SimpleVarHelper();

  protected List<ProcessGenerator> processList = new LinkedList<ProcessGenerator>();

  public FunctionBlockGenerator(final boolean templateProcess) {
    this.templateProcess = templateProcess;
  }

  public FunctionBlockGenerator(final FunctionBlock fb, final boolean templateProcess) {
    this.templateProcess = templateProcess;
    this.object = fb;
    this.FBName = fb.getName();
    this.type = "FUNCTION_BLOCK";
    this.prepareFBVars();
    this.parseProcesses(fb.getProcesses());
  }

  /**
   * def void generate(IFileSystemAccess2 fsa, String path) {
   * fsa.generateFile('''«path»«programName.toLowerCase».st''', generateProgram)
   * }
   */
  public String generateFB() {
    return this.generateBody();
  }

  public String generateBody() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(\'\'");
    _builder.append(this.FBName);
    _builder.append("\'\',");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    String _generateFBVars = this.generateFBVars();
    _builder.append(_generateFBVars, " ");
    _builder.append(",");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    {
      boolean _hasElements = false;
      for(final ProcessGenerator process : this.processList) {
        if (!_hasElements) {
          _hasElements = true;
          _builder.append("[", " ");
        } else {
          _builder.appendImmediate(", \n", " ");
        }
        String _generateBody = process.generateBody();
        _builder.append(_generateBody, " ");
      }
      if (_hasElements) {
        _builder.append("]", " ");
      }
    }
    _builder.append(")");
    return _builder.toString();
  }

  public String generateFBVars() {
    String vars = this.varList.generateVar();
    String inVars = this.inVarList.generateVar();
    String outVars = this.outVarList.generateVar();
    String extVars = this.externalVarList.generateVar();
    String inOutVars = this.inOutVarList.generateVar();
    List<String> allVars = new LinkedList<String>();
    if ((vars != "")) {
      allVars.add(vars);
    }
    if ((inVars != "")) {
      allVars.add(inVars);
    }
    if ((outVars != "")) {
      allVars.add(outVars);
    }
    if ((inOutVars != "")) {
      allVars.add(inOutVars);
    }
    if ((extVars != "")) {
      allVars.add(extVars);
    }
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _isEmpty = allVars.isEmpty();
      if (_isEmpty) {
        _builder.append("[]");
      } else {
        {
          boolean _hasElements = false;
          for(final String s : allVars) {
            if (!_hasElements) {
              _hasElements = true;
              _builder.append("[");
            } else {
              _builder.appendImmediate(", \n", "");
            }
            _builder.append(s);
          }
          if (_hasElements) {
            _builder.append("]");
          }
        }
      }
    }
    return _builder.toString();
  }

  public String getName() {
    return this.FBName;
  }

  public EObject getEObject() {
    return this.object;
  }

  protected void parseProcesses(final EList<su.nsk.iae.post.poST.Process> processes) {
    final Consumer<su.nsk.iae.post.poST.Process> _function = (su.nsk.iae.post.poST.Process p) -> {
      final ProcessGenerator process = new ProcessGenerator(p);
      boolean _isTemplate = process.isTemplate();
      boolean _not = (!_isTemplate);
      if (_not) {
        this.processList.add(process);
      }
    };
    processes.stream().forEach(_function);
  }

  public void prepareFBVars() {
    final Consumer<InputVarDeclaration> _function = (InputVarDeclaration v) -> {
      this.inVarList.add(v, "FB");
    };
    this.object.getFbInVars().stream().forEach(_function);
    final Consumer<OutputVarDeclaration> _function_1 = (OutputVarDeclaration v) -> {
      this.outVarList.add(v, "FB");
    };
    this.object.getFbOutVars().stream().forEach(_function_1);
    final Consumer<InputOutputVarDeclaration> _function_2 = (InputOutputVarDeclaration v) -> {
      this.inOutVarList.add(v, "FB");
    };
    this.object.getFbInOutVars().stream().forEach(_function_2);
    final Consumer<ExternalVarDeclaration> _function_3 = (ExternalVarDeclaration v) -> {
      this.externalVarList.add(v, "FB");
    };
    this.object.getFbExternVars().stream().forEach(_function_3);
    final Consumer<VarDeclaration> _function_4 = (VarDeclaration v) -> {
      this.varList.add(v, "FB");
    };
    this.object.getFbVars().stream().forEach(_function_4);
  }

  public void addProcess(final su.nsk.iae.post.poST.Process process) {
    ProcessGenerator _processGenerator = new ProcessGenerator(process);
    this.processList.add(_processGenerator);
  }

  public void addProcess(final su.nsk.iae.post.poST.Process process, final boolean active) {
    ProcessGenerator _processGenerator = new ProcessGenerator(process, active);
    this.processList.add(_processGenerator);
  }

  public void addVar(final EObject varDecl) {
    this.varList.add(varDecl, "FB");
  }

  public void addVar(final EObject varDecl, final String pref) {
    this.varList.add(varDecl, pref);
  }

  public void addVar(final String name, final String type) {
    this.varList.add(name, type, "FB");
  }

  public void addVar(final String name, final String type, final String value) {
    this.varList.add(name, type, value);
  }

  public void addVar(final String name, final String type, final String value, final boolean isConstant) {
    this.varList.add(name, type, value, isConstant, "FB");
  }

  public boolean isFirstProcess(final ProcessGenerator process) {
    ProcessGenerator _get = this.processList.get(0);
    return Objects.equal(_get, process);
  }

  public void addInVar(final EObject varDecl) {
    this.inVarList.add(varDecl, "FB");
  }

  public void addInVar(final EObject varDecl, final String pref) {
    this.inVarList.add(varDecl, pref);
  }

  public void addOutVar(final EObject varDecl) {
    this.outVarList.add(varDecl, "FB");
  }

  public void addOutVar(final EObject varDecl, final String pref) {
    this.outVarList.add(varDecl, pref);
  }

  public void addInOutVar(final EObject varDecl) {
    this.inOutVarList.add(varDecl, "FB");
  }

  public void addInOutVar(final EObject varDecl, final String pref) {
    this.inOutVarList.add(varDecl, pref);
  }
}
