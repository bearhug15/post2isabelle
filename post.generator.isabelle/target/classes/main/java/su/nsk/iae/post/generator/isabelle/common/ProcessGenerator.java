package su.nsk.iae.post.generator.isabelle.common;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import org.eclipse.xtend2.lib.StringConcatenation;
import su.nsk.iae.post.generator.isabelle.common.vars.InputOutputVarHelper;
import su.nsk.iae.post.generator.isabelle.common.vars.InputVarHelper;
import su.nsk.iae.post.generator.isabelle.common.vars.OutputVarHelper;
import su.nsk.iae.post.generator.isabelle.common.vars.ProcessVarHelper;
import su.nsk.iae.post.generator.isabelle.common.vars.SimpleVarHelper;
import su.nsk.iae.post.generator.isabelle.common.vars.VarHelper;
import su.nsk.iae.post.poST.InputOutputVarDeclaration;
import su.nsk.iae.post.poST.InputVarDeclaration;
import su.nsk.iae.post.poST.OutputVarDeclaration;
import su.nsk.iae.post.poST.State;
import su.nsk.iae.post.poST.TempVarDeclaration;
import su.nsk.iae.post.poST.VarDeclaration;

@SuppressWarnings("all")
public class ProcessGenerator {
  private su.nsk.iae.post.poST.Process process;

  private boolean active;

  private VarHelper inVarList = new InputVarHelper();

  private VarHelper outVarList = new OutputVarHelper();

  private VarHelper inOutVarList = new InputOutputVarHelper();

  private VarHelper varList = new SimpleVarHelper();

  private VarHelper processVarList = new ProcessVarHelper();

  private List<StateGenerator> stateList = new LinkedList<StateGenerator>();

  public ProcessGenerator(final su.nsk.iae.post.poST.Process process) {
    this(process, false);
  }

  /**
   * new(ProgramGenerator program, Process process, boolean active) {
   * this.program = program
   * this.process = process
   * this.active = active
   * process.states.stream.forEach([s | stateList.add(new StateGenerator(program, this, s))])
   * }
   */
  public ProcessGenerator(final su.nsk.iae.post.poST.Process process, final boolean active) {
    this.process = process;
    this.active = active;
    final Consumer<State> _function = (State s) -> {
      StateGenerator _stateGenerator = new StateGenerator(s);
      this.stateList.add(_stateGenerator);
    };
    process.getStates().stream().forEach(_function);
    this.prepareProcessVars();
  }

  public String generateBody() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(\'\'");
    String _name = this.process.getName();
    _builder.append(_name);
    _builder.append("\'\',");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    String _generateProcVars = this.generateProcVars();
    _builder.append(_generateProcVars, " ");
    _builder.append(",");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    {
      boolean _hasElements = false;
      for(final StateGenerator state : this.stateList) {
        if (!_hasElements) {
          _hasElements = true;
          _builder.append("[", "\t");
        } else {
          _builder.appendImmediate(", \n ", "\t");
        }
        String _generateBody = state.generateBody();
        _builder.append(_generateBody, "\t");
      }
      if (_hasElements) {
        _builder.append("]", "\t");
      }
    }
    _builder.append(")");
    return _builder.toString();
  }

  public String generateProcVars() {
    String vars = this.varList.generateVar();
    String inVars = this.inVarList.generateVar();
    String outVars = this.outVarList.generateVar();
    String inOutVars = this.inOutVarList.generateVar();
    String processVars = this.processVarList.generateVar();
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
    if ((processVars != "")) {
      allVars.add(processVars);
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
    return this.process.getName();
  }

  public boolean containsVar(final String name) {
    return ((((this.varList.contains(name) || this.processVarList.contains(name)) || 
      this.inVarList.contains(name)) || this.outVarList.contains(name)) || this.inOutVarList.contains(name));
  }

  /**
   * def boolean isTemplate() {
   * return (process.procInVars.empty) && (process.procOutVars.empty) && (process.procInOutVars.empty)
   * }
   */
  public boolean isTemplate() {
    return false;
  }

  public void prepareProcessVars() {
    this.prepareVars();
    this.prepareProcVars();
    this.prepareInVars();
    this.prepareOutVars();
    this.prepareInOutVars();
  }

  private void prepareVars() {
    final Consumer<VarDeclaration> _function = (VarDeclaration varDecl) -> {
      this.varList.add(varDecl, "Process");
    };
    this.process.getProcVars().stream().forEach(_function);
  }

  private void prepareProcVars() {
    final Consumer<TempVarDeclaration> _function = (TempVarDeclaration varDecl) -> {
      this.processVarList.add(varDecl, "Process");
    };
    this.process.getProcTempVars().stream().forEach(_function);
  }

  private void prepareInVars() {
    final Consumer<InputVarDeclaration> _function = (InputVarDeclaration varDecl) -> {
      this.inVarList.add(varDecl, "Process");
    };
    this.process.getProcInVars().stream().forEach(_function);
  }

  private void prepareOutVars() {
    final Consumer<OutputVarDeclaration> _function = (OutputVarDeclaration varDecl) -> {
      this.outVarList.add(varDecl, "Process");
    };
    this.process.getProcOutVars().stream().forEach(_function);
  }

  private void prepareInOutVars() {
    final Consumer<InputOutputVarDeclaration> _function = (InputOutputVarDeclaration varDecl) -> {
      this.inOutVarList.add(varDecl, "Process");
    };
    this.process.getProcInOutVars().stream().forEach(_function);
  }

  private boolean hasTimeouts() {
    final Predicate<StateGenerator> _function = (StateGenerator x) -> {
      return x.hasTimeout();
    };
    return this.stateList.stream().anyMatch(_function);
  }
}
