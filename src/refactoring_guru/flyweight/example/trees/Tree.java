package refactoring_guru.flyweight.example.trees;

import java.awt.*;

public class Tree {
  private final int xCoordinate;
  private final int yCoordinate;
  private final TreeType treeType;

  public Tree(int xCoordinate, int yCoordinate, TreeType treeType) {
    this.xCoordinate = xCoordinate;
    this.yCoordinate = yCoordinate;
    this.treeType = treeType;
  }

  public void draw(Graphics g) {
    treeType.draw(g, xCoordinate, yCoordinate);
  }
}
