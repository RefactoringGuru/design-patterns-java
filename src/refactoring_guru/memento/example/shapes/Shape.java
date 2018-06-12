package refactoring_guru.memento.example.shapes;

import java.awt.*;
import java.io.Serializable;

public interface Shape extends Serializable {
    public int getX();
    public int getY();
    public int getWidth();
    public int getHeight();
    public void drag();
    public void drop();
    public void moveTo(int x, int y);
    public void moveBy(int x, int y);
    public boolean isInsideBounds(int x, int y);
    public Color getColor();
    public void setColor(Color color);
    public void select();
    public void unSelect();
    public boolean isSelected();
    public void paint(Graphics graphics);
}

