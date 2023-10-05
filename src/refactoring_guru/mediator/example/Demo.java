package refactoring_guru.mediator.example;

import refactoring_guru.mediator.example.components.*;
import refactoring_guru.mediator.example.mediator.Editor;
import refactoring_guru.mediator.example.mediator.Mediator;
import refactoring_guru.mediator.example.mediator.Note;

import javax.swing.*;

/**
 * EN: Demo class. Everything comes together here.
 * <p>
 * RU: Демо-класс. Здесь всё сводится воедино.
 */
public class Demo {
  public static void main(String[] args) {
    Mediator mediator = new Editor();
    ListModel<Note> noteList = new AbstractListModel<>() {
      @Override
      public int getSize() {
        return 0;
      }

      @Override
      public Note getElementAt(int i) {
        return null;
      }
    };

    mediator.registerComponent(new Title());
    mediator.registerComponent(new TextBox());
    mediator.registerComponent(new AddButton());
    mediator.registerComponent(new DeleteButton());
    mediator.registerComponent(new SaveButton());
    mediator.registerComponent(new InitList(new DefaultListModel<>()));
    mediator.registerComponent(new Filter(mediator, noteList));

    mediator.createGUI();
  }
}
