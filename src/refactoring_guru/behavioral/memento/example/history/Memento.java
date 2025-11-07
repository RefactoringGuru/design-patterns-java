package refactoring_guru.behavioral.memento.example.history;

import refactoring_guru.behavioral.memento.example.editor.Editor;

public class Memento {
    private final String backup;
    private final Editor editor;

    public Memento(Editor editor) {
        this.editor = editor;
        this.backup = editor.backup();
    }

    public void restore() {
        editor.restore(backup);
    }
}
