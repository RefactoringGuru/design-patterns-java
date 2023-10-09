package refactoring_guru.memento.example.history;

import refactoring_guru.memento.example.commands.Command;

import java.util.ArrayList;
import java.util.List;

public class History {
  private List<Pair> pairs = new ArrayList<>();
  private int virtualSize = 0;

  public void push(Command c, Memento m) {
    if (virtualSize != pairs.size() && virtualSize > 0) {
      pairs = pairs.subList(0, virtualSize - 1);
    }
    pairs.add(new Pair(c, m));
    virtualSize = pairs.size();
  }

  public boolean undo() {
    Pair pair = getUndo();
    if (pair == null) {
      return false;
    }
    System.out.println("Undoing: " + pair.getCommand().getName());
    pair.getMemento().restore();
    return true;
  }

  public boolean redo() {
    Pair pair = getRedo();
    if (pair == null) {
      return false;
    }
    System.out.println("Redoing: " + pair.getCommand().getName());
    pair.getMemento().restore();
    pair.getCommand().execute();
    return true;
  }

  private Pair getUndo() {
    if (virtualSize == 0) {
      return null;
    }
    virtualSize = Math.max(0, virtualSize - 1);
    return pairs.get(virtualSize);
  }

  private Pair getRedo() {
    if (virtualSize == pairs.size()) {
      return null;
    }
    virtualSize = Math.min(pairs.size(), virtualSize + 1);
    return pairs.get(virtualSize - 1);
  }

  private static class Pair {
    Command command;
    Memento memento;

    Pair(Command c, Memento m) {
      command = c;
      memento = m;
    }

    private Command getCommand() {
      return command;
    }

    private Memento getMemento() {
      return memento;
    }
  }
}
