package su.nsk.iae.post.generator.isabelle.common.util;

import com.google.common.base.Objects;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import su.nsk.iae.post.poST.AddExpression;
import su.nsk.iae.post.poST.AddOperator;
import su.nsk.iae.post.poST.AndExpression;
import su.nsk.iae.post.poST.ArrayVariable;
import su.nsk.iae.post.poST.AssignmentType;
import su.nsk.iae.post.poST.CompExpression;
import su.nsk.iae.post.poST.CompOperator;
import su.nsk.iae.post.poST.Constant;
import su.nsk.iae.post.poST.EquExpression;
import su.nsk.iae.post.poST.EquOperator;
import su.nsk.iae.post.poST.Expression;
import su.nsk.iae.post.poST.FunctionCall;
import su.nsk.iae.post.poST.IntegerLiteral;
import su.nsk.iae.post.poST.MulExpression;
import su.nsk.iae.post.poST.MulOperator;
import su.nsk.iae.post.poST.NumericLiteral;
import su.nsk.iae.post.poST.ParamAssignment;
import su.nsk.iae.post.poST.ParamAssignmentElements;
import su.nsk.iae.post.poST.PowerExpression;
import su.nsk.iae.post.poST.PrimaryExpression;
import su.nsk.iae.post.poST.ProcessStatusExpression;
import su.nsk.iae.post.poST.RealLiteral;
import su.nsk.iae.post.poST.SignedInteger;
import su.nsk.iae.post.poST.SymbolicVariable;
import su.nsk.iae.post.poST.TimeLiteral;
import su.nsk.iae.post.poST.UnaryExpression;
import su.nsk.iae.post.poST.UnaryOperator;
import su.nsk.iae.post.poST.XorExpression;

@SuppressWarnings("all")
public class GeneratorUtil {
  public static String generateConstant(final Constant constant) {
    NumericLiteral _num = constant.getNum();
    boolean _tripleNotEquals = (_num != null);
    if (_tripleNotEquals) {
      final NumericLiteral num = constant.getNum();
      GeneratorUtil.convertNumericLiteralType(num);
      if ((num instanceof IntegerLiteral)) {
        boolean _equals = ((IntegerLiteral)num).getType().equals("UINT");
        if (_equals) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("(const.Nat ");
          String _value = ((IntegerLiteral)num).getValue().getValue();
          _builder.append(_value);
          _builder.append(")");
          return _builder.toString();
        } else {
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("(const.Int ");
          String _generateSignedInteger = GeneratorUtil.generateSignedInteger(((IntegerLiteral)num).getValue());
          _builder_1.append(_generateSignedInteger);
          _builder_1.append(")");
          return _builder_1.toString();
        }
      }
      final RealLiteral dNum = ((RealLiteral) num);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("(const.Real (");
      {
        boolean _isRSig = dNum.isRSig();
        if (_isRSig) {
          _builder_2.append("-");
        }
      }
      String _value_1 = dNum.getValue();
      _builder_2.append(_value_1);
      _builder_2.append("))");
      return _builder_2.toString();
    }
    TimeLiteral _time = constant.getTime();
    boolean _tripleNotEquals_1 = (_time != null);
    if (_tripleNotEquals_1) {
      String timelit = constant.getTime().getInterval();
      String[] times = timelit.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
      HashMap<String, String> time_map = new HashMap<String, String>();
      time_map.put("d", "0");
      time_map.put("h", "0");
      time_map.put("m", "0");
      time_map.put("s", "0");
      time_map.put("ms", "0");
      for (int i = 0; (i < (((List<String>)Conversions.doWrapArray(times)).size() / 2)); i++) {
        String _get = times[((i * 2) + 1)];
        if (_get != null) {
          switch (_get) {
            case "d":
              time_map.put("d", (times[(i * 2)]).toString());
              break;
            case "h":
              time_map.put("h", (times[(i * 2)]).toString());
              break;
            case "m":
              time_map.put("m", (times[(i * 2)]).toString());
              break;
            case "s":
              time_map.put("s", (times[(i * 2)]).toString());
              break;
            case "ms":
              time_map.put("ms", (times[(i * 2)]).toString());
              break;
          }
        }
      }
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("(const.Time (time.Time ");
      String _get = time_map.get("d");
      _builder_3.append(_get);
      _builder_3.append(" ");
      String _get_1 = time_map.get("h");
      _builder_3.append(_get_1);
      _builder_3.append(" ");
      String _get_2 = time_map.get("m");
      _builder_3.append(_get_2);
      _builder_3.append(" ");
      String _get_3 = time_map.get("s");
      _builder_3.append(_get_3);
      _builder_3.append(" ");
      String _get_4 = time_map.get("ms");
      _builder_3.append(_get_4);
      _builder_3.append("))");
      return _builder_3.toString();
    }
    boolean _equals_1 = constant.getOth().equals("TRUE");
    if (_equals_1) {
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("(const.Bool True)");
      return _builder_4.toString();
    } else {
      boolean _equals_2 = constant.getOth().equals("FALSE");
      if (_equals_2) {
        StringConcatenation _builder_5 = new StringConcatenation();
        _builder_5.append("(const.Bool False)");
        return _builder_5.toString();
      }
    }
    return constant.getOth();
  }

  public static String generateSignedInteger(final SignedInteger sint) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    {
      boolean _isISig = sint.isISig();
      if (_isISig) {
        _builder.append("-");
      }
    }
    String _value = sint.getValue();
    _builder.append(_value);
    _builder.append(")");
    return _builder.toString();
  }

  public static String generateExpression(final Expression exp) {
    boolean _matched = false;
    if (exp instanceof PrimaryExpression) {
      _matched=true;
      Constant _const = ((PrimaryExpression)exp).getConst();
      boolean _tripleNotEquals = (_const != null);
      if (_tripleNotEquals) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("(expr.Const ");
        String _generateConstant = GeneratorUtil.generateConstant(((PrimaryExpression)exp).getConst());
        _builder.append(_generateConstant);
        _builder.append(")");
        return _builder.toString();
      } else {
        SymbolicVariable _variable = ((PrimaryExpression)exp).getVariable();
        boolean _tripleNotEquals_1 = (_variable != null);
        if (_tripleNotEquals_1) {
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("(expr.SymbolicVar \'\'");
          String _name = ((PrimaryExpression)exp).getVariable().getName();
          _builder_1.append(_name);
          _builder_1.append("\'\')");
          return _builder_1.toString();
        } else {
          ArrayVariable _array = ((PrimaryExpression)exp).getArray();
          boolean _tripleNotEquals_2 = (_array != null);
          if (_tripleNotEquals_2) {
            StringConcatenation _builder_2 = new StringConcatenation();
            _builder_2.append("(expr.ArrayVar ");
            _builder_2.newLine();
            _builder_2.append("\t");
            _builder_2.append("\'\'");
            String _name_1 = ((PrimaryExpression)exp).getArray().getVariable().getName();
            _builder_2.append(_name_1, "\t");
            _builder_2.append("\'\' ");
            _builder_2.newLineIfNotEmpty();
            _builder_2.append("\t");
            String _generateExpression = GeneratorUtil.generateExpression(((PrimaryExpression)exp).getArray().getIndex());
            _builder_2.append(_generateExpression, "\t");
            _builder_2.append(")");
            return _builder_2.toString();
          } else {
            ProcessStatusExpression _procStatus = ((PrimaryExpression)exp).getProcStatus();
            boolean _tripleNotEquals_3 = (_procStatus != null);
            if (_tripleNotEquals_3) {
              return GeneratorUtil.generateProcessStatus(((PrimaryExpression)exp).getProcStatus());
            } else {
              FunctionCall _funCall = ((PrimaryExpression)exp).getFunCall();
              boolean _tripleNotEquals_4 = (_funCall != null);
              if (_tripleNotEquals_4) {
                StringConcatenation _builder_3 = new StringConcatenation();
                _builder_3.append("(expr.FunctionCall ");
                _builder_3.newLine();
                _builder_3.append("\t");
                _builder_3.append("\'\'");
                String _name_2 = ((PrimaryExpression)exp).getFunCall().getFunction().getName();
                _builder_3.append(_name_2, "\t");
                _builder_3.append("\'\' ");
                _builder_3.newLineIfNotEmpty();
                _builder_3.append("\t");
                final Function<Expression, String> _function = (Expression x) -> {
                  return GeneratorUtil.generateExpression(x);
                };
                String _generateParamAssignmentElements = GeneratorUtil.generateParamAssignmentElements(((PrimaryExpression)exp).getFunCall().getArgs(), _function);
                _builder_3.append(_generateParamAssignmentElements, "\t");
                _builder_3.append(")");
                return _builder_3.toString();
              } else {
                StringConcatenation _builder_4 = new StringConcatenation();
                _builder_4.append("(");
                String _generateExpression_1 = GeneratorUtil.generateExpression(((PrimaryExpression)exp).getNestExpr());
                _builder_4.append(_generateExpression_1);
                _builder_4.append(")");
                return _builder_4.toString();
              }
            }
          }
        }
      }
    }
    if (!_matched) {
      if (exp instanceof UnaryExpression) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("(expr.Unary ");
        _builder.newLine();
        _builder.append("\t");
        {
          UnaryOperator _unOp = ((UnaryExpression)exp).getUnOp();
          boolean _equals = Objects.equal(_unOp, UnaryOperator.NOT);
          if (_equals) {
            _builder.append("unary_op.Not");
          } else {
            UnaryOperator _unOp_1 = ((UnaryExpression)exp).getUnOp();
            boolean _equals_1 = Objects.equal(_unOp_1, UnaryOperator.UNMINUS);
            if (_equals_1) {
              _builder.append("unary_op.Minus");
            }
          }
        }
        _builder.append(" ");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        String _generateExpression = GeneratorUtil.generateExpression(((UnaryExpression)exp).getRight());
        _builder.append(_generateExpression, "\t");
        _builder.append(")");
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (exp instanceof PowerExpression) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("(expr.Binary ");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("binary_op.Pow ");
        _builder.newLine();
        _builder.append("\t");
        String _generateExpression = GeneratorUtil.generateExpression(((PowerExpression)exp).getLeft());
        _builder.append(_generateExpression, "\t");
        _builder.append(" ");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        String _generateExpression_1 = GeneratorUtil.generateExpression(((PowerExpression)exp).getRight());
        _builder.append(_generateExpression_1, "\t");
        _builder.append(")");
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (exp instanceof MulExpression) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("(expr.Binary ");
        _builder.newLine();
        _builder.append("\t");
        String _generateMulOperators = GeneratorUtil.generateMulOperators(((MulExpression)exp).getMulOp());
        _builder.append(_generateMulOperators, "\t");
        _builder.append(" ");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        String _generateExpression = GeneratorUtil.generateExpression(((MulExpression)exp).getLeft());
        _builder.append(_generateExpression, "\t");
        _builder.append(" ");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        String _generateExpression_1 = GeneratorUtil.generateExpression(((MulExpression)exp).getRight());
        _builder.append(_generateExpression_1, "\t");
        _builder.append(")");
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (exp instanceof AddExpression) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("(expr.Binary ");
        _builder.newLine();
        _builder.append("\t");
        {
          AddOperator _addOp = ((AddExpression)exp).getAddOp();
          boolean _equals = Objects.equal(_addOp, AddOperator.PLUS);
          if (_equals) {
            _builder.append("binary_op.Add");
          } else {
            _builder.append("binary_op.Sub");
          }
        }
        _builder.append(" ");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        String _generateExpression = GeneratorUtil.generateExpression(((AddExpression)exp).getLeft());
        _builder.append(_generateExpression, "\t");
        _builder.append(" ");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        String _generateExpression_1 = GeneratorUtil.generateExpression(((AddExpression)exp).getRight());
        _builder.append(_generateExpression_1, "\t");
        _builder.append(")");
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (exp instanceof EquExpression) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("(expr.Binary ");
        _builder.newLine();
        _builder.append("\t");
        String _generateEquOperators = GeneratorUtil.generateEquOperators(((EquExpression)exp).getEquOp());
        _builder.append(_generateEquOperators, "\t");
        _builder.append(" ");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        String _generateExpression = GeneratorUtil.generateExpression(((EquExpression)exp).getLeft());
        _builder.append(_generateExpression, "\t");
        _builder.append(" ");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        String _generateExpression_1 = GeneratorUtil.generateExpression(((EquExpression)exp).getRight());
        _builder.append(_generateExpression_1, "\t");
        _builder.append(")");
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (exp instanceof CompExpression) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("(expr.Binary ");
        _builder.newLine();
        _builder.append("\t");
        {
          CompOperator _compOp = ((CompExpression)exp).getCompOp();
          boolean _equals = Objects.equal(_compOp, CompOperator.EQUAL);
          if (_equals) {
            _builder.append("binary_op.Eq");
          } else {
            _builder.append("binary_op.NotEq");
          }
        }
        _builder.append(" ");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        String _generateExpression = GeneratorUtil.generateExpression(((CompExpression)exp).getLeft());
        _builder.append(_generateExpression, "\t");
        _builder.append(" ");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        String _generateExpression_1 = GeneratorUtil.generateExpression(((CompExpression)exp).getRight());
        _builder.append(_generateExpression_1, "\t");
        _builder.append(")");
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (exp instanceof AndExpression) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("(expr.Binary binary_op.And ");
        _builder.newLine();
        _builder.append("\t");
        String _generateExpression = GeneratorUtil.generateExpression(((AndExpression)exp).getLeft());
        _builder.append(_generateExpression, "\t");
        _builder.append(" ");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        String _generateExpression_1 = GeneratorUtil.generateExpression(((AndExpression)exp).getRight());
        _builder.append(_generateExpression_1, "\t");
        _builder.append(")");
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (exp instanceof XorExpression) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("(expr.Binary binary_op.Xor ");
        _builder.newLine();
        _builder.append("\t");
        String _generateExpression = GeneratorUtil.generateExpression(((XorExpression)exp).getLeft());
        _builder.append(_generateExpression, "\t");
        _builder.append(" ");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        String _generateExpression_1 = GeneratorUtil.generateExpression(((XorExpression)exp).getRight());
        _builder.append(_generateExpression_1, "\t");
        _builder.append(")");
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (exp instanceof Expression) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("(expr.Binary binary_op.Or ");
        _builder.newLine();
        _builder.append("\t");
        String _generateExpression = GeneratorUtil.generateExpression(exp.getLeft());
        _builder.append(_generateExpression, "\t");
        _builder.append(" ");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        String _generateExpression_1 = GeneratorUtil.generateExpression(exp.getRight());
        _builder.append(_generateExpression_1, "\t");
        _builder.append(")");
        return _builder.toString();
      }
    }
    return null;
  }

  public static String generateProcessStatus(final ProcessStatusExpression exp) {
    boolean _isActive = exp.isActive();
    if (_isActive) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("(expr.ProcStatExpr \'\'");
      String _name = exp.getProcess().getName();
      _builder.append(_name);
      _builder.append("\'\' proc_status.Active)");
      return _builder.toString();
    } else {
      boolean _isInactive = exp.isInactive();
      if (_isInactive) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("(expr.ProcStatExpr \'\'");
        String _name_1 = exp.getProcess().getName();
        _builder_1.append(_name_1);
        _builder_1.append("\'\' proc_status.Inactive)");
        return _builder_1.toString();
      } else {
        boolean _isStop = exp.isStop();
        if (_isStop) {
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("(expr.ProcStatExpr \'\'");
          String _name_2 = exp.getProcess().getName();
          _builder_2.append(_name_2);
          _builder_2.append("\'\' proc_status.Stop)");
          return _builder_2.toString();
        }
      }
    }
    StringConcatenation _builder_3 = new StringConcatenation();
    _builder_3.append("(expr.ProcStatExpr \'\'");
    String _name_3 = exp.getProcess().getName();
    _builder_3.append(_name_3);
    _builder_3.append("\'\' proc_status.Error)");
    return _builder_3.toString();
  }

  public static String generateParamAssignmentElements(final ParamAssignmentElements elements) {
    final Function<Expression, String> _function = (Expression x) -> {
      return GeneratorUtil.generateExpression(x);
    };
    return GeneratorUtil.generateParamAssignmentElements(elements, _function);
  }

  public static String generateParamAssignmentElements(final ParamAssignmentElements elements, final Function<Expression, String> gExp) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<ParamAssignment> _elements = elements.getElements();
      boolean _hasElements = false;
      for(final ParamAssignment elem : _elements) {
        if (!_hasElements) {
          _hasElements = true;
          _builder.append("[");
        } else {
          _builder.appendImmediate(",\n", "");
        }
        String _generateParamAssignment = GeneratorUtil.generateParamAssignment(elem, gExp);
        _builder.append(_generateParamAssignment);
      }
      if (_hasElements) {
        _builder.append("]");
      }
    }
    return _builder.toString();
  }

  private static String generateParamAssignment(final ParamAssignment ele, final Function<Expression, String> gExp) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(param_assign.SymbolicVar ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\'\'");
    String _name = ele.getVariable().getName();
    _builder.append(_name, "\t");
    _builder.append("\'\' ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    {
      AssignmentType _assig = ele.getAssig();
      boolean _equals = Objects.equal(_assig, AssignmentType.IN);
      if (_equals) {
        _builder.append("assign_type.ColonEq");
      } else {
        _builder.append("assign_type.Conseq");
      }
    }
    _builder.append(" ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    String _apply = gExp.apply(ele.getValue());
    _builder.append(_apply, "\t");
    _builder.append(")");
    return _builder.toString();
  }

  private static String generateEquOperators(final EquOperator op) {
    if (op != null) {
      switch (op) {
        case LESS:
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("binary_op.Less");
          return _builder.toString();
        case LESS_EQU:
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("binary_op.LessEq");
          return _builder_1.toString();
        case GREATER:
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("binary_op.More");
          return _builder_2.toString();
        case GREATER_EQU:
          StringConcatenation _builder_3 = new StringConcatenation();
          _builder_3.append("binary_op.MoreEq");
          return _builder_3.toString();
        default:
          break;
      }
    }
    return null;
  }

  private static String generateMulOperators(final MulOperator op) {
    if (op != null) {
      switch (op) {
        case MUL:
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("binary_op.Mul");
          return _builder.toString();
        case DIV:
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("binary_op.Div");
          return _builder_1.toString();
        case MOD:
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("binary_op.Mod");
          return _builder_2.toString();
        default:
          break;
      }
    }
    return null;
  }

  private static void convertNumericLiteralType(final NumericLiteral c) {
    String _type = c.getType();
    if (_type != null) {
      switch (_type) {
        case "SINT":
          c.setType("INT");
          break;
        case "DINT":
          c.setType("INT");
          break;
        case "LINT":
          c.setType("INT");
          break;
        case "USINT":
          c.setType("UINT");
          break;
        case "UDINT":
          c.setType("UINT");
          break;
        case "ULINT":
          c.setType("UINT");
          break;
        case "LREAL":
          c.setType("REAL");
          break;
      }
    }
  }
}
