package refactoring_guru.composite.example.shapes;

import java.awt.*;

public class Dot extends BaseShape {

  public Dot(int x, int y, Color color) {
    super(x, y, color);
  }

  @Override
  public int getWidth() {
    return 3;
  }

  @Override
  public int getHeight() {
    return 3;
  }

  @Override
  public void paint(Graphics graphics) {
    super.paint(graphics);
    graphics.fillRect(x - 1, y - 1, getWidth(), getHeight());
  }
}
