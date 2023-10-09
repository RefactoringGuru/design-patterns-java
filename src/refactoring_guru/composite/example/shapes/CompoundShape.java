package refactoring_guru.composite.example.shapes;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompoundShape extends BaseShape {
  protected List<Shape> children = new ArrayList<>();

  public CompoundShape(Shape... components) {
    super(0, 0, Color.BLACK);
    add(components);
  }

  public void add(Shape component) {
    children.add(component);
  }

  public void add(Shape... components) {
    children.addAll(Arrays.asList(components));
  }

  public void remove(Shape child) {
    children.remove(child);
  }

  public void remove(Shape... components) {
    children.removeAll(Arrays.asList(components));
  }

  public void clear() {
    children.clear();
  }

  @Override
  public int getX() {
    checkNoEmpty(children);
    int x = children.get(0).getX();
    for (Shape child : children) {
      if (child.getX() < x) {
        x = child.getX();
      }
    }
    return x;
  }

  @Override
  public int getY() {
    checkNoEmpty(children);
    int y = children.get(0).getY();
    for (Shape child : children) {
      if (child.getY() < y) {
        y = child.getY();
      }
    }
    return y;
  }

  @Override
  public int getWidth() {
    int maxWidth = 0;
    int x = getX();

    for (Shape child : children) {
      int childRelativeX = child.getX() - x;
      int childWidth = childRelativeX + child.getWidth();
      maxWidth = Math.max(maxWidth, childWidth);
    }
    return maxWidth;
  }

  @Override
  public int getHeight() {
    int maxHeight = 0;
    int y = getY();

    for (Shape child : children) {
      int childRelativeY = child.getY() - y;
      int childHeight = childRelativeY + child.getHeight();
      maxHeight = Math.max(maxHeight, childHeight);
    }
    return maxHeight;
  }

  @Override
  public void move(int x, int y) {
    for (Shape child : children) {
      child.move(x, y);
    }
  }

  @Override
  public boolean isInsideBounds(int x, int y) {
    for (Shape child : children) {
      if (child.isInsideBounds(x, y)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public void unSelect() {
    super.unSelect();
    for (Shape child : children) {
      child.unSelect();
    }
  }

  public void selectChildAt(int x, int y) {
    for (Shape child : children) {
      if (child.isInsideBounds(x, y)) {
        child.select();
      }
    }
  }

  @Override
  public void paint(Graphics graphics) {
    if (isSelected()) {
      enableSelectionStyle(graphics);
      graphics.drawRect(getX() - 1, getY() - 1, getWidth() + 1, getHeight() + 1);
      disableSelectionStyle(graphics);
    }

    for (Shape child : children) {
      child.paint(graphics);
    }
  }

  private static void checkNoEmpty(List<Shape> children) {
      if (children.isEmpty()) {
          throw new IllegalArgumentException("The List is empty ");
      }
  }
}
