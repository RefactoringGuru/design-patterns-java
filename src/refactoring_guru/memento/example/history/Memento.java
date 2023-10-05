package refactoring_guru.memento.example.history;

import refactoring_guru.memento.example.editor.Editor;

import java.io.IOException;

public class Memento {
  private final String backup;
  private final Editor editor;

  public Memento(Editor editor) throws IOException {
    this.editor = editor;
    this.backup = editor.backup();
  }

  public void restore() {
    editor.restore(backup);
  }
}
