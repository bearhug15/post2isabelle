package su.nsk.iae.post.generator.isabelle.configuration;

import org.eclipse.xtend2.lib.StringConcatenation;
import su.nsk.iae.post.generator.isabelle.common.util.GeneratorUtil;
import su.nsk.iae.post.poST.Constant;
import su.nsk.iae.post.poST.Task;
import su.nsk.iae.post.poST.TaskInitialization;

@SuppressWarnings("all")
public class TaskGenerator {
  private Task task;

  public TaskGenerator(final Task task) {
    this.task = task;
  }

  public String generateTask() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(\'\'");
    String _name = this.task.getName();
    _builder.append(_name);
    _builder.append("\'\', ");
    String _generateFirstArg = this.generateFirstArg();
    _builder.append(_generateFirstArg);
    _builder.append(", ");
    String _priority = this.task.getInit().getPriority();
    _builder.append(_priority);
    _builder.append(")");
    return _builder.toString();
  }

  private String generateFirstArg() {
    final TaskInitialization init = this.task.getInit();
    Constant _interval = init.getInterval();
    boolean _tripleNotEquals = (_interval != null);
    if (_tripleNotEquals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("(task_init.Interval ");
      String _generateConstant = GeneratorUtil.generateConstant(init.getInterval());
      _builder.append(_generateConstant);
      _builder.append(")");
      return _builder.toString();
    }
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("(task_init.Single ");
    String _generateConstant_1 = GeneratorUtil.generateConstant(init.getSingle());
    _builder_1.append(_generateConstant_1);
    _builder_1.append(")");
    return _builder_1.toString();
  }
}
