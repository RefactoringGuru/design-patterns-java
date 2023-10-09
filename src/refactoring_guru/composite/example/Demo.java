package refactoring_guru.composite.example;

import refactoring_guru.composite.example.editor.ImageEditor;
import refactoring_guru.composite.example.shapes.Circle;
import refactoring_guru.composite.example.shapes.CompoundShape;
import refactoring_guru.composite.example.shapes.Dot;
import refactoring_guru.composite.example.shapes.Rectangle;

import java.awt.*;

public class Demo {
  public static void main(String[] args) {
    ImageEditor editor = new ImageEditor();
    createAndLoadShapes(editor);
  }

  private static void createAndLoadShapes(ImageEditor editor) {
    Circle blueCircle = new Circle(10, 10, 10, Color.BLUE);

    Circle redCircle = new Circle(110, 110, 50, Color.RED);
    Dot redDot = new Dot(160, 160, Color.RED);
    CompoundShape redCompound = new CompoundShape(redCircle, redDot);

    Rectangle greenRectangle = new Rectangle(250, 250, 100, 100, Color.GREEN);
    Dot dot1 = new Dot(240, 240, Color.GREEN);
    Dot dot2 = new Dot(240, 360, Color.GREEN);
    Dot dot3 = new Dot(360, 360, Color.GREEN);
    Dot dot4 = new Dot(360, 240, Color.GREEN);
    CompoundShape greenCompound = new CompoundShape(greenRectangle, dot1, dot2, dot3, dot4);

    editor.loadShapes(blueCircle, redCompound, greenCompound);
  }
}