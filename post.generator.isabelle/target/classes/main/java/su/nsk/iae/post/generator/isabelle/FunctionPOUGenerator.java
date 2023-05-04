package su.nsk.iae.post.generator.isabelle;

import java.util.function.Consumer;
import su.nsk.iae.post.generator.isabelle.common.FunctionGenerator;
import su.nsk.iae.post.poST.Function;
import su.nsk.iae.post.poST.InputOutputVarDeclaration;
import su.nsk.iae.post.poST.InputVarDeclaration;
import su.nsk.iae.post.poST.OutputVarDeclaration;
import su.nsk.iae.post.poST.VarDeclaration;

@SuppressWarnings("all")
public class FunctionPOUGenerator extends FunctionGenerator {
  public FunctionPOUGenerator(final Function f) {
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
}
