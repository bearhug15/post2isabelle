package su.nsk.iae.post.generator.isabelle.common.vars.data;

import java.util.List;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Data
@SuppressWarnings("all")
public class VarData {
  public VarData(final String name, final String type, final String value, final boolean isConstant, final String level, final String location) {
    this.name = name;
    this.type = type;
    this.value = value;
    this.isConstant = isConstant;
    this.isArray = false;
    this.arraValues = null;
    this.level = level;
    this.start = null;
    this.end = null;
    this.isFB = false;
    this.isDirect = true;
    this.location = location;
  }

  public VarData(final String name, final String type, final String value, final boolean isConstant, final String level) {
    this.name = name;
    this.type = type;
    this.value = value;
    this.isConstant = isConstant;
    this.isArray = false;
    this.arraValues = null;
    this.level = level;
    this.start = null;
    this.end = null;
    this.isFB = false;
    this.isDirect = false;
    this.location = null;
  }

  public VarData(final String name, final String type, final boolean isConstant, final List<String> arraValues, final String level) {
    this.name = name;
    this.type = type;
    this.value = null;
    this.isConstant = isConstant;
    this.isArray = true;
    this.arraValues = arraValues;
    this.level = level;
    this.start = null;
    this.end = null;
    this.isFB = false;
    this.isDirect = false;
    this.location = null;
  }

  public VarData(final String name, final String type, final boolean isConstant, final List<String> arraValues, final String start, final String end, final String level) {
    this.name = name;
    this.type = type;
    this.value = null;
    this.isConstant = isConstant;
    this.isArray = true;
    this.arraValues = arraValues;
    this.level = level;
    this.start = start;
    this.end = end;
    this.isFB = false;
    this.isDirect = false;
    this.location = null;
  }

  public VarData(final String name, final String type, final boolean isConstant, final String level) {
    this.name = name;
    this.type = type;
    this.value = null;
    this.isConstant = isConstant;
    this.isArray = false;
    this.arraValues = null;
    this.level = level;
    this.start = null;
    this.end = null;
    this.isFB = true;
    this.isDirect = false;
    this.location = null;
  }

  public VarData(final String name, final String type, final String level) {
    this.name = name;
    this.type = type;
    this.value = null;
    this.isConstant = false;
    this.isArray = false;
    this.arraValues = null;
    this.level = level;
    this.start = null;
    this.end = null;
    this.isFB = false;
    this.isDirect = false;
    this.location = null;
  }

  private final String name;

  private final String type;

  private final String value;

  private final String level;

  private final boolean isConstant;

  private final boolean isFB;

  private final boolean isDirect;

  private final String location;

  private final boolean isArray;

  private final String start;

  private final String end;

  private final List<String> arraValues;

  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.name== null) ? 0 : this.name.hashCode());
    result = prime * result + ((this.type== null) ? 0 : this.type.hashCode());
    result = prime * result + ((this.value== null) ? 0 : this.value.hashCode());
    result = prime * result + ((this.level== null) ? 0 : this.level.hashCode());
    result = prime * result + (this.isConstant ? 1231 : 1237);
    result = prime * result + (this.isFB ? 1231 : 1237);
    result = prime * result + (this.isDirect ? 1231 : 1237);
    result = prime * result + ((this.location== null) ? 0 : this.location.hashCode());
    result = prime * result + (this.isArray ? 1231 : 1237);
    result = prime * result + ((this.start== null) ? 0 : this.start.hashCode());
    result = prime * result + ((this.end== null) ? 0 : this.end.hashCode());
    return prime * result + ((this.arraValues== null) ? 0 : this.arraValues.hashCode());
  }

  @Override
  @Pure
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    VarData other = (VarData) obj;
    if (this.name == null) {
      if (other.name != null)
        return false;
    } else if (!this.name.equals(other.name))
      return false;
    if (this.type == null) {
      if (other.type != null)
        return false;
    } else if (!this.type.equals(other.type))
      return false;
    if (this.value == null) {
      if (other.value != null)
        return false;
    } else if (!this.value.equals(other.value))
      return false;
    if (this.level == null) {
      if (other.level != null)
        return false;
    } else if (!this.level.equals(other.level))
      return false;
    if (other.isConstant != this.isConstant)
      return false;
    if (other.isFB != this.isFB)
      return false;
    if (other.isDirect != this.isDirect)
      return false;
    if (this.location == null) {
      if (other.location != null)
        return false;
    } else if (!this.location.equals(other.location))
      return false;
    if (other.isArray != this.isArray)
      return false;
    if (this.start == null) {
      if (other.start != null)
        return false;
    } else if (!this.start.equals(other.start))
      return false;
    if (this.end == null) {
      if (other.end != null)
        return false;
    } else if (!this.end.equals(other.end))
      return false;
    if (this.arraValues == null) {
      if (other.arraValues != null)
        return false;
    } else if (!this.arraValues.equals(other.arraValues))
      return false;
    return true;
  }

  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("name", this.name);
    b.add("type", this.type);
    b.add("value", this.value);
    b.add("level", this.level);
    b.add("isConstant", this.isConstant);
    b.add("isFB", this.isFB);
    b.add("isDirect", this.isDirect);
    b.add("location", this.location);
    b.add("isArray", this.isArray);
    b.add("start", this.start);
    b.add("end", this.end);
    b.add("arraValues", this.arraValues);
    return b.toString();
  }

  @Pure
  public String getName() {
    return this.name;
  }

  @Pure
  public String getType() {
    return this.type;
  }

  @Pure
  public String getValue() {
    return this.value;
  }

  @Pure
  public String getLevel() {
    return this.level;
  }

  @Pure
  public boolean isConstant() {
    return this.isConstant;
  }

  @Pure
  public boolean isFB() {
    return this.isFB;
  }

  @Pure
  public boolean isDirect() {
    return this.isDirect;
  }

  @Pure
  public String getLocation() {
    return this.location;
  }

  @Pure
  public boolean isArray() {
    return this.isArray;
  }

  @Pure
  public String getStart() {
    return this.start;
  }

  @Pure
  public String getEnd() {
    return this.end;
  }

  @Pure
  public List<String> getArraValues() {
    return this.arraValues;
  }
}
