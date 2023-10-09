package refactoring_guru.prototype.example.shapes;

public class Circle extends Shape {
  public int radius;

  public Circle() {
  }

  public Circle(Circle target) {
    super(target);
    if (target != null) {
      this.radius = target.radius;
    }
  }

  @Override
  public Shape clone() {
    return new Circle(this);
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    Shape shape = (Shape) object;
    return radius == shape.x && radius == shape.y;
  }
}
