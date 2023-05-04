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
import su.nsk.iae.post.generator.isabelle.common.vars.TempVarHelper;
import su.nsk.iae.post.generator.isabelle.common.vars.VarHelper;
import su.nsk.iae.post.poST.ExternalVarDeclaration;
import su.nsk.iae.post.poST.InputOutputVarDeclaration;
import su.nsk.iae.post.poST.InputVarDeclaration;
import su.nsk.iae.post.poST.OutputVarDeclaration;
import su.nsk.iae.post.poST.Program;
import su.nsk.iae.post.poST.TempVarDeclaration;
import su.nsk.iae.post.poST.VarDeclaration;

@SuppressWarnings("all")
public class ProgramGenerator {
  protected Program object;

  protected String programName;

  protected String type;

  private boolean templateProcess;

  protected VarHelper inVarList = new InputVarHelper();

  protected VarHelper outVarList = new OutputVarHelper();

  protected VarHelper inOutVarList = new InputOutputVarHelper();

  protected VarHelper externalVarList = new ExternalVarHelper();

  protected VarHelper varList = new SimpleVarHelper();

  protected VarHelper tempVarList = new TempVarHelper();

  protected List<ProcessGenerator> processList = new LinkedList<ProcessGenerator>();

  public ProgramGenerator(final boolean templateProcess) {
    this.templateProcess = templateProcess;
  }

  public ProgramGenerator(final Program program) {
    this.templateProcess = this.templateProcess;
    this.object = program;
    this.programName = program.getName();
    this.type = "PROGRAM";
    this.prepareProgramVars();
    this.parseProcesses(program.getProcesses());
  }

  public String generateProgram() {
    return this.generateBody();
  }

  public String generateBody() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(\'\'");
    _builder.append(this.programName);
    _builder.append("\'\',");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    String _generateProgVars = this.generateProgVars();
    _builder.append(_generateProgVars, " ");
    _builder.append(",");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    {
      boolean _isEmpty = this.processList.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        {
          boolean _hasElements = false;
          for(final ProcessGenerator process : this.processList) {
            if (!_hasElements) {
              _hasElements = true;
              _builder.append("[", "\t");
            } else {
              _builder.appendImmediate(", \n ", "\t");
            }
            String _generateBody = process.generateBody();
            _builder.append(_generateBody, "\t");
          }
          if (_hasElements) {
            _builder.append("]", "\t");
          }
        }
      } else {
        _builder.append("[]");
      }
    }
    _builder.append(")");
    return _builder.toString();
  }

  public String generateProgVars() {
    String vars = this.varList.generateVar();
    String inVars = this.inVarList.generateVar();
    String outVars = this.outVarList.generateVar();
    String extVars = this.externalVarList.generateVar();
    String inOutVars = this.inOutVarList.generateVar();
    String tempVars = this.tempVarList.generateVar();
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
    if ((tempVars != "")) {
      allVars.add(tempVars);
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
    return this.programName;
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

  public void prepareProgramVars() {
    final Consumer<InputVarDeclaration> _function = (InputVarDeclaration v) -> {
      this.inVarList.add(v, "Program");
    };
    this.object.getProgInVars().stream().forEach(_function);
    final Consumer<OutputVarDeclaration> _function_1 = (OutputVarDeclaration v) -> {
      this.outVarList.add(v, "Program");
    };
    this.object.getProgOutVars().stream().forEach(_function_1);
    final Consumer<InputOutputVarDeclaration> _function_2 = (InputOutputVarDeclaration v) -> {
      this.inOutVarList.add(v, "Program");
    };
    this.object.getProgInOutVars().stream().forEach(_function_2);
    final Consumer<ExternalVarDeclaration> _function_3 = (ExternalVarDeclaration v) -> {
      this.externalVarList.add(v, "Program");
    };
    this.object.getProgExternVars().stream().forEach(_function_3);
    final Consumer<VarDeclaration> _function_4 = (VarDeclaration v) -> {
      this.varList.add(v, "Program");
    };
    this.object.getProgVars().stream().forEach(_function_4);
    final Consumer<TempVarDeclaration> _function_5 = (TempVarDeclaration v) -> {
      this.tempVarList.add(v, "Program");
    };
    this.object.getProgTempVars().stream().forEach(_function_5);
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
    this.varList.add(varDecl, "Program");
  }

  public void addVar(final EObject varDecl, final String pref) {
    this.varList.add(varDecl, pref);
  }

  public void addVar(final String name, final String type) {
    this.varList.add(name, type, "Program");
  }

  public void addVar(final String name, final String type, final String value) {
    this.varList.add(name, type, value);
  }

  public void addVar(final String name, final String type, final String value, final boolean isConstant) {
    this.varList.add(name, type, value, isConstant, "Program");
  }

  public void addTempVar(final EObject varDecl) {
    this.tempVarList.add(varDecl, "Program");
  }

  public void addTempVar(final EObject varDecl, final String pref) {
    this.tempVarList.add(varDecl, pref);
  }

  public void addTempVar(final String name, final String type, final String value) {
    this.tempVarList.add(name, type, value);
  }

  public boolean isFirstProcess(final ProcessGenerator process) {
    ProcessGenerator _get = this.processList.get(0);
    return Objects.equal(_get, process);
  }

  public void addInVar(final EObject varDecl) {
    this.inVarList.add(varDecl, "Program");
  }

  public void addInVar(final EObject varDecl, final String pref) {
    this.inVarList.add(varDecl, pref);
  }

  public void addOutVar(final EObject varDecl) {
    this.outVarList.add(varDecl, "Program");
  }

  public void addOutVar(final EObject varDecl, final String pref) {
    this.outVarList.add(varDecl, pref);
  }

  public void addInOutVar(final EObject varDecl) {
    this.inOutVarList.add(varDecl, "Program");
  }

  public void addInOutVar(final EObject varDecl, final String pref) {
    this.inOutVarList.add(varDecl, pref);
  }
}
