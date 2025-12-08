package no_pattern.visitor.example.visitor;

import no_pattern.visitor.example.shapes.Circle;
import no_pattern.visitor.example.shapes.CompoundShape;
import no_pattern.visitor.example.shapes.Dot;
import no_pattern.visitor.example.shapes.Rectangle;

public interface Visitor {
    String visitDot(Dot dot);

    String visitCircle(Circle circle);

    String visitRectangle(Rectangle rectangle);

    String visitCompoundGraphic(CompoundShape cg);
}
