package no_pattern.visitor.example.shapes;

import no_pattern.visitor.example.visitor.Visitor;

public interface Shape {
    void move(int x, int y);
    void draw();
    String accept(Visitor visitor);
}
