package refactoring_guru.memento.example.shapes;

import java.awt.*;

public class Dot extends BaseShape {
  private final int DOT_WIDTH = 3;
  private final int DOT_HEIGHT = 3;

  public Dot(int x, int y, Color color) {
    super(x, y, color);
  }

  @Override
  public int getWidth() {
    return DOT_WIDTH;
  }

  @Override
  public int getHeight() {
    return DOT_HEIGHT;
  }

  @Override
  public void paint(Graphics graphics) {
    super.paint(graphics);
    graphics.fillRect(x - 1, y - 1, getWidth(), getHeight());
  }
}
