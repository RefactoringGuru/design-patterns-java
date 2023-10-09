package refactoring_guru.memento.example;

import refactoring_guru.memento.example.editor.Editor;
import refactoring_guru.memento.example.shapes.Circle;
import refactoring_guru.memento.example.shapes.CompoundShape;
import refactoring_guru.memento.example.shapes.Dot;
import refactoring_guru.memento.example.shapes.Rectangle;

import java.awt.*;

public class Demo {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.loadShapes(
                new Circle(10, 10, 10, Color.BLUE),

                new CompoundShape(
                        new Circle(110, 110, 50, Color.RED),
                        new Dot(160, 160, Color.RED)
                ),

                new CompoundShape(
                        new Rectangle(250, 250, 100, 100, Color.GREEN),
                        new Dot(240, 240, Color.GREEN),
                        new Dot(240, 360, Color.GREEN),
                        new Dot(360, 360, Color.GREEN),
                        new Dot(360, 240, Color.GREEN)
                )
        );
    }
}
