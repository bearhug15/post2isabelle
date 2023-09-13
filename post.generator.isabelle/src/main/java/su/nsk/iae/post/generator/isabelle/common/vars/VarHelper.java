package su.nsk.iae.post.generator.isabelle.common.vars;

import com.google.common.base.Objects;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import su.nsk.iae.post.generator.isabelle.common.util.GeneratorUtil;
import su.nsk.iae.post.generator.isabelle.common.vars.data.VarData;
import su.nsk.iae.post.poST.ArrayInitialization;
import su.nsk.iae.post.poST.ArrayInterval;
import su.nsk.iae.post.poST.Expression;
import su.nsk.iae.post.poST.FunctionBlock;
import su.nsk.iae.post.poST.ProcessVarInitDeclaration;
import su.nsk.iae.post.poST.ProcessVariable;
import su.nsk.iae.post.poST.SimpleSpecificationInit;
import su.nsk.iae.post.poST.SymbolicVariable;
import su.nsk.iae.post.poST.VarInitDeclaration;

@SuppressWarnings("all")
public abstract class VarHelper {
  protected String varType;

  protected List<VarData> listDecl = new LinkedList<VarData>();

  /**
   * def void add(EObject varDecl,String level) {
   * add(varDecl, "",level)
   * }
   */
  public abstract void add(final EObject varDecl, final String level);

  public void add(final String name, final String type, final String level) {
    this.add(name, type, null, level);
  }

  public void add(final String name, final String type, final String value, final String level) {
    this.add(name, type, value, false, level);
  }

  public void add(final String name, final String type, final String value, final boolean isConstant, final String level) {
    VarData _varData = new VarData(name, type, value, isConstant, level);
    this.listDecl.add(_varData);
  }

  public String getType() {
    return this.varType;
  }

  public List<VarData> getList() {
    return this.listDecl;
  }

  public void clear() {
    this.listDecl.clear();
  }

  public boolean contains(final String name) {
    final Predicate<VarData> _function = (VarData v) -> {
      String _name = v.getName();
      return Objects.equal(_name, name);
    };
    return this.listDecl.stream().anyMatch(_function);
  }

  public boolean hasConstant() {
    final Predicate<VarData> _function = (VarData v) -> {
      return v.isConstant();
    };
    return this.listDecl.stream().anyMatch(_function);
  }

  public boolean hasNonConstant() {
    final Predicate<VarData> _function = (VarData v) -> {
      boolean _isConstant = v.isConstant();
      return (!_isConstant);
    };
    return this.listDecl.stream().anyMatch(_function);
  }

  protected void parseSimpleVar(final EList<VarInitDeclaration> varList, final String level) {
    this.parseSimpleVar(varList, false, level);
  }

  protected void parseSimpleVar(final EList<VarInitDeclaration> varList, final boolean isConst, final String level) {
    for (final VarInitDeclaration v : varList) {
      SimpleSpecificationInit _spec = v.getSpec();
      boolean _tripleNotEquals = (_spec != null);
      if (_tripleNotEquals) {
        String type = VarHelper.transformType(v.getSpec().getType());
        String value = null;
        Expression _value = v.getSpec().getValue();
        boolean _tripleNotEquals_1 = (_value != null);
        if (_tripleNotEquals_1) {
          value = GeneratorUtil.generateExpression(v.getSpec().getValue());
        }
        EList<SymbolicVariable> _vars = v.getVarList().getVars();
        for (final SymbolicVariable e : _vars) {
          String _name = e.getName();
          VarData _varData = new VarData(_name, type, value, isConst, level);
          this.listDecl.add(_varData);
        }
      } else {
        FunctionBlock _fb = v.getFb();
        boolean _tripleNotEquals_2 = (_fb != null);
        if (_tripleNotEquals_2) {
          final String type_1 = v.getFb().getName();
          EList<SymbolicVariable> _vars_1 = v.getVarList().getVars();
          for (final SymbolicVariable e_1 : _vars_1) {
            String _name_1 = e_1.getName();
            VarData _varData_1 = new VarData(_name_1, type_1, isConst, level);
            this.listDecl.add(_varData_1);
          }
        } else {
          final String type_2 = VarHelper.transformType(v.getArrSpec().getInit().getType());
          ArrayInterval _interval = v.getArrSpec().getInit().getInterval();
          boolean _tripleNotEquals_3 = (_interval != null);
          if (_tripleNotEquals_3) {
            List<String> values = null;
            ArrayInitialization _values = v.getArrSpec().getValues();
            boolean _tripleNotEquals_4 = (_values != null);
            if (_tripleNotEquals_4) {
              LinkedList<String> _linkedList = new LinkedList<String>();
              values = _linkedList;
              EList<Expression> _elements = v.getArrSpec().getValues().getElements();
              for (final Expression e_2 : _elements) {
                values.add(GeneratorUtil.generateExpression(e_2));
              }
            }
            final String start = GeneratorUtil.generateExpression(v.getArrSpec().getInit().getInterval().getStart());
            final String end = GeneratorUtil.generateExpression(v.getArrSpec().getInit().getInterval().getEnd());
            EList<SymbolicVariable> _vars_2 = v.getVarList().getVars();
            for (final SymbolicVariable e_3 : _vars_2) {
              String _name_2 = e_3.getName();
              VarData _varData_2 = new VarData(_name_2, type_2, isConst, values, start, end, level);
              this.listDecl.add(_varData_2);
            }
          } else {
            List<String> values_1 = null;
            ArrayInitialization _values_1 = v.getArrSpec().getValues();
            boolean _tripleNotEquals_5 = (_values_1 != null);
            if (_tripleNotEquals_5) {
              LinkedList<String> _linkedList_1 = new LinkedList<String>();
              values_1 = _linkedList_1;
              EList<Expression> _elements_1 = v.getArrSpec().getValues().getElements();
              for (final Expression e_4 : _elements_1) {
                values_1.add(GeneratorUtil.generateExpression(e_4));
              }
            }
            EList<SymbolicVariable> _vars_3 = v.getVarList().getVars();
            for (final SymbolicVariable e_5 : _vars_3) {
              String _name_3 = e_5.getName();
              VarData _varData_3 = new VarData(_name_3, type_2, isConst, values_1, level);
              this.listDecl.add(_varData_3);
            }
          }
        }
      }
    }
  }

  protected void parseProcessVar(final EList<ProcessVarInitDeclaration> varList, final String level) {
    for (final ProcessVarInitDeclaration v : varList) {
      {
        final String type = v.getProcess().getName();
        EList<ProcessVariable> _vars = v.getVarList().getVars();
        for (final ProcessVariable e : _vars) {
          String _name = e.getName();
          VarData _varData = new VarData(_name, type, false, level);
          this.listDecl.add(_varData);
        }
      }
    }
  }

  public String generateVar() {
    boolean _isEmpty = this.listDecl.isEmpty();
    if (_isEmpty) {
      return "";
    }
    String _switchResult = null;
    String _level = this.listDecl.get(0).getLevel();
    if (_level != null) {
      switch (_level) {
        case "Global":
          _switchResult = "";
          break;
        case "Program":
          _switchResult = "prog_var";
          break;
        case "Process":
          _switchResult = "proc_var";
          break;
        case "Func":
          _switchResult = "func_var";
          break;
        case "FB":
          _switchResult = "func_block_var";
          break;
      }
    }
    final String varLevel = _switchResult;
    Map<Boolean, List<VarData>> constGroups = this.listDecl.stream().collect(Collectors.<VarData>partitioningBy(new Predicate<VarData>() {
      @Override
      public boolean test(final VarData t) {
        return t.isConstant();
      }
    }));
    List<VarData> conGroup = constGroups.get(Boolean.valueOf(true));
    List<VarData> unconGroup = constGroups.get(Boolean.valueOf(false));
    String con = "";
    String uncon = "";
    if ((((this.getType() != "Var") && (this.getType() != "GlobalVar")) && (this.getType() != "ExtVar"))) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("(");
      _builder.append(varLevel);
      _builder.append(".");
      _builder.append(this.varType);
      _builder.append(" ");
      _builder.newLineIfNotEmpty();
      {
        boolean _hasElements = false;
        for(final VarData decl : this.listDecl) {
          if (!_hasElements) {
            _hasElements = true;
            _builder.append("\t[");
          } else {
            _builder.appendImmediate(",\n\t", "");
          }
          _builder.append("(\'\'");
          String _name = decl.getName();
          _builder.append(_name);
          _builder.append("\'\', ");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          {
            boolean _isFB = decl.isFB();
            if (_isFB) {
              String _generateFunctionBlock = this.generateFunctionBlock(decl);
              _builder.append(_generateFunctionBlock, "\t");
            } else {
              boolean _isArray = decl.isArray();
              boolean _not = (!_isArray);
              if (_not) {
                String _generateSymbolicVar = this.generateSymbolicVar(decl);
                _builder.append(_generateSymbolicVar, "\t");
              } else {
                String _generateArrayVar = this.generateArrayVar(decl);
                _builder.append(_generateArrayVar, "\t");
              }
            }
          }
          _builder.append(")");
        }
        if (_hasElements) {
          _builder.append("]", "\t");
        }
      }
      _builder.append(")");
      return _builder.toString();
    } else {
      String _type = this.getType();
      boolean _tripleEquals = (_type == "ProcessVar");
      if (_tripleEquals) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("(");
        _builder_1.append(varLevel);
        _builder_1.append(".");
        _builder_1.append(this.varType);
        _builder_1.append(" (True, ");
        _builder_1.newLineIfNotEmpty();
        {
          boolean _hasElements_1 = false;
          for(final VarData decl_1 : conGroup) {
            if (!_hasElements_1) {
              _hasElements_1 = true;
              _builder_1.append("\t[");
            } else {
              _builder_1.appendImmediate(", \n\t", "");
            }
            _builder_1.append("(\'\'");
            String _name_1 = decl_1.getName();
            _builder_1.append(_name_1);
            _builder_1.append("\'\', \'\'");
            String _type_1 = decl_1.getType();
            _builder_1.append(_type_1);
            _builder_1.append("\'\')");
          }
          if (_hasElements_1) {
            _builder_1.append("]", "\t");
          }
        }
        _builder_1.append("))");
        return _builder_1.toString();
      } else {
        String _type_2 = this.getType();
        boolean _equals = Objects.equal(_type_2, "Var");
        if (_equals) {
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("(");
          _builder_2.append(varLevel);
          _builder_2.append(".");
          _builder_2.append(this.varType);
          _builder_2.append(" (True, ");
          _builder_2.newLineIfNotEmpty();
          {
            boolean _hasElements_2 = false;
            for(final VarData decl_2 : conGroup) {
              if (!_hasElements_2) {
                _hasElements_2 = true;
                _builder_2.append("\t[");
              } else {
                _builder_2.appendImmediate(", \n\t", "");
              }
              _builder_2.append("(\'\'");
              String _name_2 = decl_2.getName();
              _builder_2.append(_name_2);
              _builder_2.append("\'\', ");
              _builder_2.newLineIfNotEmpty();
              _builder_2.append("\t ");
              {
                boolean _isFB_1 = decl_2.isFB();
                if (_isFB_1) {
                  String _generateFunctionBlock_1 = this.generateFunctionBlock(decl_2);
                  _builder_2.append(_generateFunctionBlock_1, "\t ");
                } else {
                  boolean _isArray_1 = decl_2.isArray();
                  boolean _not_1 = (!_isArray_1);
                  if (_not_1) {
                    String _generateSymbolicVar_1 = this.generateSymbolicVar(decl_2);
                    _builder_2.append(_generateSymbolicVar_1, "\t ");
                  } else {
                    String _generateArrayVar_1 = this.generateArrayVar(decl_2);
                    _builder_2.append(_generateArrayVar_1, "\t ");
                  }
                }
              }
              _builder_2.append(")");
            }
            if (_hasElements_2) {
              _builder_2.append("]", "\t");
            }
          }
          _builder_2.append("))");
          con = _builder_2.toString();
          StringConcatenation _builder_3 = new StringConcatenation();
          _builder_3.append("(");
          _builder_3.append(varLevel);
          _builder_3.append(".");
          _builder_3.append(this.varType);
          _builder_3.append(" (False, ");
          _builder_3.newLineIfNotEmpty();
          {
            boolean _hasElements_3 = false;
            for(final VarData decl_3 : unconGroup) {
              if (!_hasElements_3) {
                _hasElements_3 = true;
                _builder_3.append("\t[");
              } else {
                _builder_3.appendImmediate(", \n\t", "");
              }
              _builder_3.append("(\'\'");
              String _name_3 = decl_3.getName();
              _builder_3.append(_name_3);
              _builder_3.append("\'\', ");
              _builder_3.newLineIfNotEmpty();
              _builder_3.append("\t ");
              {
                boolean _isFB_2 = decl_3.isFB();
                if (_isFB_2) {
                  String _generateFunctionBlock_2 = this.generateFunctionBlock(decl_3);
                  _builder_3.append(_generateFunctionBlock_2, "\t ");
                } else {
                  boolean _isArray_2 = decl_3.isArray();
                  boolean _not_2 = (!_isArray_2);
                  if (_not_2) {
                    String _generateSymbolicVar_2 = this.generateSymbolicVar(decl_3);
                    _builder_3.append(_generateSymbolicVar_2, "\t ");
                  } else {
                    String _generateArrayVar_2 = this.generateArrayVar(decl_3);
                    _builder_3.append(_generateArrayVar_2, "\t ");
                  }
                }
              }
              _builder_3.append(")");
            }
            if (_hasElements_3) {
              _builder_3.append("]", "\t");
            }
          }
          _builder_3.append("))");
          uncon = _builder_3.toString();
        } else {
          String _type_3 = this.getType();
          boolean _equals_1 = Objects.equal(_type_3, "ExtVar");
          if (_equals_1) {
            StringConcatenation _builder_4 = new StringConcatenation();
            _builder_4.append("(");
            _builder_4.append(varLevel);
            _builder_4.append(".");
            _builder_4.append(this.varType);
            _builder_4.append(" (True, ");
            _builder_4.newLineIfNotEmpty();
            {
              boolean _hasElements_4 = false;
              for(final VarData decl_4 : conGroup) {
                if (!_hasElements_4) {
                  _hasElements_4 = true;
                  _builder_4.append("\t[");
                } else {
                  _builder_4.appendImmediate(", \n\t", "");
                }
                _builder_4.append("(\'\'");
                String _name_4 = decl_4.getName();
                _builder_4.append(_name_4);
                _builder_4.append("\'\', ");
                String _type_4 = decl_4.getType();
                _builder_4.append(_type_4);
                _builder_4.append(")");
              }
              if (_hasElements_4) {
                _builder_4.append("]", "\t");
              }
            }
            _builder_4.append("))");
            con = _builder_4.toString();
            StringConcatenation _builder_5 = new StringConcatenation();
            _builder_5.append("(");
            _builder_5.append(varLevel);
            _builder_5.append(".");
            _builder_5.append(this.varType);
            _builder_5.append(" (False, ");
            _builder_5.newLineIfNotEmpty();
            {
              boolean _hasElements_5 = false;
              for(final VarData decl_5 : unconGroup) {
                if (!_hasElements_5) {
                  _hasElements_5 = true;
                  _builder_5.append("\t[");
                } else {
                  _builder_5.appendImmediate(", \n\t", "");
                }
                _builder_5.append("(\'\'");
                String _name_5 = decl_5.getName();
                _builder_5.append(_name_5);
                _builder_5.append("\'\', ");
                String _type_5 = decl_5.getType();
                _builder_5.append(_type_5);
                _builder_5.append(")");
              }
              if (_hasElements_5) {
                _builder_5.append("]", "\t");
              }
            }
            _builder_5.append("))");
            uncon = _builder_5.toString();
          } else {
            StringConcatenation _builder_6 = new StringConcatenation();
            _builder_6.append("(True, ");
            _builder_6.newLine();
            {
              boolean _hasElements_6 = false;
              for(final VarData decl_6 : conGroup) {
                if (!_hasElements_6) {
                  _hasElements_6 = true;
                  _builder_6.append("\t[");
                } else {
                  _builder_6.appendImmediate(",\n\t", "");
                }
                _builder_6.append("(\'\'");
                String _name_6 = decl_6.getName();
                _builder_6.append(_name_6);
                _builder_6.append("\'\', ");
                String _generateAllVar = this.generateAllVar(decl_6);
                _builder_6.append(_generateAllVar);
                _builder_6.append(")");
              }
              if (_hasElements_6) {
                _builder_6.append("]");
              }
            }
            con = _builder_6.toString();
            StringConcatenation _builder_7 = new StringConcatenation();
            _builder_7.append("(False, ");
            _builder_7.newLine();
            {
              boolean _hasElements_7 = false;
              for(final VarData decl_7 : unconGroup) {
                if (!_hasElements_7) {
                  _hasElements_7 = true;
                  _builder_7.append("\t[");
                } else {
                  _builder_7.appendImmediate(",\n\t", "");
                }
                _builder_7.append("(\'\'");
                String _name_7 = decl_7.getName();
                _builder_7.append(_name_7);
                _builder_7.append("\'\', ");
                String _generateAllVar_1 = this.generateAllVar(decl_7);
                _builder_7.append(_generateAllVar_1);
                _builder_7.append(")");
              }
              if (_hasElements_7) {
                _builder_7.append("]");
              }
            }
            _builder_7.append(")");
            uncon = _builder_7.toString();
          }
        }
        if (((!conGroup.isEmpty()) && (!unconGroup.isEmpty()))) {
          StringConcatenation _builder_8 = new StringConcatenation();
          _builder_8.append(con);
          _builder_8.append(",");
          _builder_8.newLineIfNotEmpty();
          _builder_8.append(uncon);
          return _builder_8.toString();
        } else {
          if (((!conGroup.isEmpty()) && unconGroup.isEmpty())) {
            return con;
          } else {
            if ((conGroup.isEmpty() && (!unconGroup.isEmpty()))) {
              return uncon;
            } else {
              return "";
            }
          }
        }
      }
    }
  }

  public static String transformType(final String t) {
    String _switchResult = null;
    if (t != null) {
      switch (t) {
        case "INT":
          _switchResult = "(ptype.Int 0)";
          break;
        case "SINT":
          _switchResult = "(ptype.Int 0)";
          break;
        case "DINT":
          _switchResult = "(ptype.Int 0)";
          break;
        case "LINT":
          _switchResult = "(ptype.Int 0)";
          break;
        case "UINT":
          _switchResult = "(ptype.Nat 0)";
          break;
        case "USINT":
          _switchResult = "(ptype.Nat 0)";
          break;
        case "UDINT":
          _switchResult = "(ptype.Nat 0)";
          break;
        case "ULINT":
          _switchResult = "(ptype.Nat 0)";
          break;
        case "REAL":
          _switchResult = "(ptype.Real 0.0)";
          break;
        case "LREAL":
          _switchResult = "(ptype.Real 0.0)";
          break;
        case "TIME":
          _switchResult = "(ptype.Time (time.Time 0 0 0 0 0))";
          break;
        case "BOOL":
          _switchResult = "(ptype.Bool False)";
          break;
        default:
          _switchResult = t;
          break;
      }
    } else {
      _switchResult = t;
    }
    return _switchResult;
  }

  public String transformLocation(final String l) {
    final String dirt = l.substring(1, 2);
    final String dirs = l.substring(2, 3);
    final String ints_conc = l.substring(3, l.length());
    String[] ints = ints_conc.split("\\.");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(direct_type_perfix.");
    _builder.append(dirt);
    _builder.append(", direct_size_prefix.");
    _builder.append(dirs);
    _builder.append(", ");
    {
      boolean _hasElements = false;
      for(final String one_int : ints) {
        if (!_hasElements) {
          _hasElements = true;
          _builder.append("[");
        } else {
          _builder.appendImmediate(", ", "");
        }
        _builder.append("(");
        _builder.append(one_int);
        _builder.append(")");
      }
      if (_hasElements) {
        _builder.append("]");
      }
    }
    _builder.append(")");
    return _builder.toString();
  }

  public String generateSymbolicVar(final VarData decl) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(var_init_decl.Symbolic ");
    String _type = decl.getType();
    _builder.append(_type);
    _builder.append(" ");
    {
      String _value = decl.getValue();
      boolean _tripleNotEquals = (_value != null);
      if (_tripleNotEquals) {
        _builder.append("(Some ");
        String _value_1 = decl.getValue();
        _builder.append(_value_1);
        _builder.append(")");
      } else {
        _builder.append("None");
      }
    }
    _builder.append(")");
    return _builder.toString();
  }

  public String generateArrayVar(final VarData decl) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(var_init_decl.Array ");
    _builder.newLine();
    _builder.append("\t");
    {
      String _start = decl.getStart();
      boolean _equals = Objects.equal(_start, null);
      if (_equals) {
        _builder.append("(array_interval.Int 0 ");
        String _string = Integer.valueOf((((Object[])Conversions.unwrapArray(decl.getArraValues(), Object.class)).length)).toString();
        _builder.append(_string, "\t");
        _builder.append(")");
      } else {
        _builder.append("(array_interval.Expr ");
        String _start_1 = decl.getStart();
        _builder.append(_start_1, "\t");
        _builder.append(" ");
        String _end = decl.getEnd();
        _builder.append(_end, "\t");
        _builder.append(")");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("[]");
    _builder.newLine();
    _builder.append("\t");
    {
      List<String> _arraValues = decl.getArraValues();
      boolean _tripleNotEquals = (_arraValues != null);
      if (_tripleNotEquals) {
        _builder.append("(Some ");
        {
          List<String> _arraValues_1 = decl.getArraValues();
          boolean _hasElements = false;
          for(final String v : _arraValues_1) {
            if (!_hasElements) {
              _hasElements = true;
              _builder.append("[", "\t");
            } else {
              _builder.appendImmediate(", ", "\t");
            }
            _builder.append(v, "\t");
          }
          if (_hasElements) {
            _builder.append("]", "\t");
          }
        }
        _builder.append(")");
      } else {
        _builder.append("None");
      }
    }
    _builder.append(")");
    return _builder.toString();
  }

  public String generateFunctionBlock(final VarData decl) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(var_init_decl.FunctionBlock \'\'");
    String _type = decl.getType();
    _builder.append(_type);
    _builder.append("\'\')");
    return _builder.toString();
  }

  public String generateAllVar(final VarData decl) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    {
      boolean _isDirect = decl.isDirect();
      boolean _not = (!_isDirect);
      if (_not) {
        _builder.append("all_var_init_decl.Var ");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        {
          boolean _isFB = decl.isFB();
          if (_isFB) {
            String _generateFunctionBlock = this.generateFunctionBlock(decl);
            _builder.append(_generateFunctionBlock, "\t\t");
          } else {
            boolean _isArray = decl.isArray();
            boolean _not_1 = (!_isArray);
            if (_not_1) {
              String _generateSymbolicVar = this.generateSymbolicVar(decl);
              _builder.append(_generateSymbolicVar, "\t\t");
            } else {
              String _generateArrayVar = this.generateArrayVar(decl);
              _builder.append(_generateArrayVar, "\t\t");
            }
          }
        }
      } else {
        _builder.append("all_var_init_decl.GlobalVar (");
        String _transformLocation = this.transformLocation(decl.getLocation());
        _builder.append(_transformLocation);
        _builder.append(", ");
        String _transformType = VarHelper.transformType(decl.getType());
        _builder.append(_transformType);
        _builder.append(")");
      }
    }
    _builder.append(")");
    return _builder.toString();
  }
}
