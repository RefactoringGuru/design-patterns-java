package refactoring_guru.flyweight.example.trees;

import java.util.HashMap;
import java.util.Map;

public final class TreeFactory {
  private static final Map<String, TreeType> treeTypes = new HashMap<>();

  private TreeFactory() throws InstantiationException {
      throw new InstantiationException("Cannot create an instance of this class");
  }

  public static TreeType getTreeType(String name) {
    return treeTypes.computeIfAbsent(name, k -> getTreeType(name));
  }
}
