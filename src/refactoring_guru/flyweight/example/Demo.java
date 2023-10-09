package refactoring_guru.flyweight.example;

import refactoring_guru.flyweight.example.forest.Forest;

import java.util.Random;

public class Demo {
  static final int CANVAS_SIZE = 500;
  static final int TREES_TO_DRAW = 1000000;
  static final int TREE_TYPES = 2;

  public static void main(String[] args) {
    Forest forest = new Forest();
    int treesPerType = TREES_TO_DRAW / TREE_TYPES;
    Random random = new Random();

    for (int i = 0; i < treesPerType; i++) {
      forest.plantTree(random.nextInt(CANVAS_SIZE), random.nextInt(CANVAS_SIZE), "Summer Oak");
      forest.plantTree(random.nextInt(CANVAS_SIZE), random.nextInt(CANVAS_SIZE), "Autumn Oak");
    }

    forest.setSize(CANVAS_SIZE, CANVAS_SIZE);
    forest.setVisible(true);
    logStatistics();
  }

  private static void logStatistics() {
    System.out.println(TREES_TO_DRAW + " trees drawn");
    System.out.println("---------------------");
    System.out.println("Memory usage:");
    System.out.println("Tree size (8 bytes) * " + TREES_TO_DRAW);
    System.out.println("+ TreeTypes size (~30 bytes) * " + TREE_TYPES);
    System.out.println("---------------------");
    System.out.println("Total: " + ((TREES_TO_DRAW * 8 + TREE_TYPES * 30) / 1024 / 1024) +
            "MB (instead of " + ((TREES_TO_DRAW * 38) / 1024 / 1024) + "MB)");
  }
}
