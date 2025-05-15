package refactoring_guru.behavioral.visitor.example.shapes;

import refactoring_guru.behavioral.visitor.example.visitor.Visitor;

public interface Shape {
    void move(int x, int y);
    void draw();
    String accept(Visitor visitor);
}
