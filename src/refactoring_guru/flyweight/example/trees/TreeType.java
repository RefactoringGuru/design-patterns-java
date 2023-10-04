package refactoring_guru.flyweight.example.trees;

import java.awt.*;

public class TreeType {
  private final Color color;

  public TreeType(Color color) {
    this.color = color;
  }

  public void draw(Graphics g, int x, int y) {
    g.setColor(Color.BLACK);
    g.fillRect(x - 1, y, 3, 5);
    g.setColor(color);
    g.fillOval(x - 5, y - 10, 10, 10);
  }
}
