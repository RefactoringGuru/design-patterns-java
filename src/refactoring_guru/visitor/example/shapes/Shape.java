package refactoring_guru.visitor.example.shapes;

import refactoring_guru.visitor.example.visitor.Visitor;

public interface Shape {
    public void move(int x, int y);
    public void draw();
    public String accept(Visitor visitor);
}
