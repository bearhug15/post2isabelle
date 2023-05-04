package su.nsk.iae.post.generator.isabelle;

import su.nsk.iae.post.generator.isabelle.common.ProgramGenerator;
import su.nsk.iae.post.poST.Program;

@SuppressWarnings("all")
public class ProgramPOUGenerator extends ProgramGenerator {
  public ProgramPOUGenerator(final Program program, final boolean templateProcess) {
    super(templateProcess);
    this.object = program;
    this.programName = program.getName();
    this.type = "PROGRAM";
    this.prepareProgramVars();
    this.parseProcesses(program.getProcesses());
  }
}
