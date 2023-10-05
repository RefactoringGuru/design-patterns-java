package refactoring_guru.prototype.example.shapes;

import java.util.Objects;

public abstract class Shape {
  public int x;
  public int y;
  public String color;

  protected Shape() {
  }

  protected Shape(Shape target) {
    if (target != null) {
      this.x = target.x;
      this.y = target.y;
      this.color = target.color;
    }
  }

  public abstract Shape clone();

  @Override
  public boolean equals(Object object2) {
    if (!(object2 instanceof Shape shape2)) return false;
    return shape2.x == x && shape2.y == y && Objects.equals(shape2.color, color);
  }

  @Override
  public int hashCode() {
    return Integer.hashCode(x)
            ^ Integer.hashCode(y);
  }
}
