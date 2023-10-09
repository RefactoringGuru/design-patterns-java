package refactoring_guru.visitor.example.shapes;

import refactoring_guru.visitor.example.visitor.Visitor;

public record Rectangle(int id, int x, int y, int width, int height) implements Shape {

  @Override
  public String accept(Visitor visitor) {
    return visitor.visitRectangle(this);
  }

  @Override
  public void move(int x, int y) {
    // move shape
  }

  @Override
  public void draw() {
    // draw shape
  }
}
