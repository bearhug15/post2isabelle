package su.nsk.iae.post.generator.isabelle.common;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.xtend2.lib.StringConcatenation;
import su.nsk.iae.post.generator.isabelle.common.vars.ExternalVarHelper;
import su.nsk.iae.post.generator.isabelle.common.vars.InputOutputVarHelper;
import su.nsk.iae.post.generator.isabelle.common.vars.InputVarHelper;
import su.nsk.iae.post.generator.isabelle.common.vars.OutputVarHelper;
import su.nsk.iae.post.generator.isabelle.common.vars.SimpleVarHelper;
import su.nsk.iae.post.generator.isabelle.common.vars.VarHelper;
import su.nsk.iae.post.poST.Function;
import su.nsk.iae.post.poST.InputOutputVarDeclaration;
import su.nsk.iae.post.poST.InputVarDeclaration;
import su.nsk.iae.post.poST.OutputVarDeclaration;
import su.nsk.iae.post.poST.VarDeclaration;

@SuppressWarnings("all")
public class FunctionGenerator {
  protected String functionName;

  protected String type;

  protected Function function;

  protected VarHelper inVarList = new InputVarHelper();

  protected VarHelper outVarList = new OutputVarHelper();

  protected VarHelper inOutVarList = new InputOutputVarHelper();

  protected VarHelper externalVarList = new ExternalVarHelper();

  protected VarHelper varList = new SimpleVarHelper();

  private StatementListGenerator statementList;

  public FunctionGenerator() {
    StatementListGenerator _statementListGenerator = new StatementListGenerator();
    this.statementList = _statementListGenerator;
  }

  public FunctionGenerator(final Function f) {
    this.function = f;
    this.functionName = f.getName();
    this.type = f.getType();
    final Consumer<InputVarDeclaration> _function = (InputVarDeclaration v) -> {
      this.inVarList.add(v, "Func");
    };
    f.getFunInVars().stream().forEach(_function);
    final Consumer<OutputVarDeclaration> _function_1 = (OutputVarDeclaration v) -> {
      this.outVarList.add(v, "Func");
    };
    f.getFunOutVars().stream().forEach(_function_1);
    final Consumer<InputOutputVarDeclaration> _function_2 = (InputOutputVarDeclaration v) -> {
      this.inOutVarList.add(v, "Func");
    };
    f.getFunInOutVars().stream().forEach(_function_2);
    final Consumer<VarDeclaration> _function_3 = (VarDeclaration v) -> {
      this.varList.add(v, "Func");
    };
    f.getFunVars().stream().forEach(_function_3);
  }

  public String generateFunction() {
    return this.generateBody();
  }

  public String generateBody() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(\'\'");
    String _name = this.function.getName();
    _builder.append(_name);
    _builder.append("\'\',");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    String _transformType = VarHelper.transformType(this.type);
    _builder.append(_transformType, " ");
    _builder.append(",");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    String _generateFuncVars = this.generateFuncVars();
    _builder.append(_generateFuncVars, " ");
    _builder.append(",");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    String _generateStatementList = this.statementList.generateStatementList(this.function.getStatement());
    _builder.append(_generateStatementList, " ");
    _builder.append(")");
    return _builder.toString();
  }

  public String generateFuncVars() {
    String vars = this.varList.generateVar();
    String inVars = this.inVarList.generateVar();
    String outVars = this.outVarList.generateVar();
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

  public void prepareFunctionVars() {
    this.prepareVars();
    this.prepareInVars();
    this.prepareOutVars();
    this.prepareInOutVars();
  }

  private void prepareVars() {
    final Consumer<VarDeclaration> _function = (VarDeclaration varDecl) -> {
      this.varList.add(varDecl, "Func");
    };
    this.function.getFunVars().stream().forEach(_function);
  }

  private void prepareInVars() {
    final Consumer<InputVarDeclaration> _function = (InputVarDeclaration varDecl) -> {
      this.inVarList.add(varDecl, "Func");
    };
    this.function.getFunInVars().stream().forEach(_function);
  }

  private void prepareOutVars() {
    final Consumer<OutputVarDeclaration> _function = (OutputVarDeclaration varDecl) -> {
      this.outVarList.add(varDecl, "Func");
    };
    this.function.getFunOutVars().stream().forEach(_function);
  }

  private void prepareInOutVars() {
    final Consumer<InputOutputVarDeclaration> _function = (InputOutputVarDeclaration varDecl) -> {
      this.inOutVarList.add(varDecl, "Func");
    };
    this.function.getFunInOutVars().stream().forEach(_function);
  }
}
