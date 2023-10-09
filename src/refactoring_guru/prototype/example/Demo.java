package refactoring_guru.prototype.example;

import refactoring_guru.prototype.example.shapes.Circle;
import refactoring_guru.prototype.example.shapes.Rectangle;
import refactoring_guru.prototype.example.shapes.Shape;

import java.util.ArrayList;
import java.util.List;

public class Demo {
  public static void main(String[] args) {
    List<Shape> shapes = new ArrayList<>();
    List<Shape> shapeArrayList = new ArrayList<>();

    Circle circle = new Circle();
    circle.x = 10;
    circle.y = 20;
    circle.radius = 15;
    circle.color = "red";
    shapes.add(circle);

    Circle anotherCircle = (Circle) circle.clone();
    shapes.add(anotherCircle);

    Rectangle rectangle = new Rectangle();
    rectangle.width = 10;
    rectangle.height = 20;
    rectangle.color = "blue";
    shapes.add(rectangle);

    cloneAndCompare(shapes, shapeArrayList);
  }

  private static void cloneAndCompare(List<Shape> shapes, List<Shape> shapeList) {
    for (Shape shape : shapes) {
      shapeList.add(shape.clone());
    }

    for (int i = 0; i < shapes.size(); i++) {
      if (shapes.get(i) != shapeList.get(i)) {
        System.out.println(i + "Shapes are different objects (yay!)");
        if (shapes.get(i).equals(shapeList.get(i))) {
          System.out.println(i + "And they are identical (yay!)");
        } else {
          System.out.println(i + "But they are not identical (booo!)");
        }
      } else {
        System.out.println(i + "Shape objects are the same (booo!)");
      }
    }
  }
}
