package su.nsk.iae.post.generator.isabelle;

import su.nsk.iae.post.generator.isabelle.common.FunctionBlockGenerator;
import su.nsk.iae.post.poST.FunctionBlock;

@SuppressWarnings("all")
public class FunctionBlockPOUGenerator extends FunctionBlockGenerator {
  public FunctionBlockPOUGenerator(final FunctionBlock fb, final boolean templateProcess) {
    super(templateProcess);
    this.object = fb;
    this.FBName = fb.getName();
    this.type = "FUNCTION_BLOCK";
    this.prepareFBVars();
    this.parseProcesses(fb.getProcesses());
  }
}
