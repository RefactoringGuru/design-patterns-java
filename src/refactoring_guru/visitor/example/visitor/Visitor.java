package refactoring_guru.visitor.example.visitor;

import refactoring_guru.visitor.example.shapes.*;
import refactoring_guru.visitor.example.shapes.Circle;
import refactoring_guru.visitor.example.shapes.CompoundShape;
import refactoring_guru.visitor.example.shapes.Dot;
import refactoring_guru.visitor.example.shapes.Rectangle;

public interface Visitor {
    public String visitDot(Dot dot);

    public String visitCircle(Circle circle);

    public String visitRectangle(Rectangle rectangle);

    public String visitCompoundGraphic(CompoundShape cg);
}
