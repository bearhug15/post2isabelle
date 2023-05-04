package su.nsk.iae.post.generator.isabelle.configuration;

import com.google.common.base.Objects;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import su.nsk.iae.post.generator.isabelle.common.util.GeneratorUtil;
import su.nsk.iae.post.poST.AssignmentType;
import su.nsk.iae.post.poST.AttachVariableConfElement;
import su.nsk.iae.post.poST.ProgramConfElement;
import su.nsk.iae.post.poST.ProgramConfElements;
import su.nsk.iae.post.poST.ProgramConfiguration;
import su.nsk.iae.post.poST.SymbolicVariable;
import su.nsk.iae.post.poST.Task;

@SuppressWarnings("all")
public class ProgramConfigurationGenerator {
  private ProgramConfiguration programConf;

  public ProgramConfigurationGenerator(final ProgramConfiguration programConfiguration) {
    this.programConf = programConfiguration;
  }

  public String generateProgramConfiguration() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(\'\'");
    String _name = this.programConf.getName();
    _builder.append(_name);
    _builder.append("\'\',");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    String _generateTask = this.generateTask();
    _builder.append(_generateTask, " ");
    _builder.append(",");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("\'\'");
    String _name_1 = this.programConf.getProgram().getName();
    _builder.append(_name_1, " ");
    _builder.append("\'\',");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    String _generateArgs = this.generateArgs();
    _builder.append(_generateArgs, " ");
    _builder.append(")");
    return _builder.toString();
  }

  private String generateTask() {
    Task _task = this.programConf.getTask();
    boolean _tripleNotEquals = (_task != null);
    if (_tripleNotEquals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("(Some \'\'");
      String _name = this.programConf.getTask().getName();
      _builder.append(_name);
      _builder.append("\'\')");
      return _builder.toString();
    }
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("None");
    return _builder_1.toString();
  }

  private String capitalizeFirst(final String str) {
    String _upperCase = str.substring(0, 1).toUpperCase();
    String _substring = str.substring(1);
    return (_upperCase + _substring);
  }

  private String generateArgs() {
    ProgramConfElements _args = this.programConf.getArgs();
    boolean _tripleEquals = (_args == null);
    if (_tripleEquals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("None");
      return _builder.toString();
    }
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("(Some ");
    _builder_1.newLine();
    _builder_1.append("\t");
    {
      EList<ProgramConfElement> _elements = this.programConf.getArgs().getElements();
      boolean _hasElements = false;
      for(final ProgramConfElement arg : _elements) {
        if (!_hasElements) {
          _hasElements = true;
          _builder_1.append("[", "\t");
        } else {
          _builder_1.appendImmediate(", \n", "\t");
        }
        _builder_1.append("(");
        {
          if ((arg instanceof AttachVariableConfElement)) {
            _builder_1.append("\'\'");
            String _name = ((AttachVariableConfElement)arg).getProgramVar().getName();
            _builder_1.append(_name, "\t");
            _builder_1.append("\'\', ");
            String _generateAssignmentSign = this.generateAssignmentSign(((AttachVariableConfElement)arg).getAssig());
            _builder_1.append(_generateAssignmentSign, "\t");
            _builder_1.append(", ");
            {
              SymbolicVariable _attVar = ((AttachVariableConfElement)arg).getAttVar();
              boolean _tripleNotEquals = (_attVar != null);
              if (_tripleNotEquals) {
                _builder_1.append("(attach_var.SymbolicVar \'\'");
                String _name_1 = ((AttachVariableConfElement)arg).getAttVar().getName();
                _builder_1.append(_name_1, "\t");
                _builder_1.append("\'\')");
              } else {
                _builder_1.append("(attach_var.Const ");
                String _generateConstant = GeneratorUtil.generateConstant(((AttachVariableConfElement)arg).getConst());
                _builder_1.append(_generateConstant, "\t");
                _builder_1.append(")");
              }
            }
          }
        }
        _builder_1.append(")");
      }
      if (_hasElements) {
        _builder_1.append("]", "\t");
      }
    }
    _builder_1.append(")");
    return _builder_1.toString();
  }

  private String generateAssignmentSign(final AssignmentType assig) {
    boolean _equals = Objects.equal(assig, AssignmentType.IN);
    if (_equals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("assign_type.ColonEq");
      return _builder.toString();
    }
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("assign_type.Conseq");
    return _builder_1.toString();
  }
}
