package refactoring_guru.mediator.example.components;

import refactoring_guru.mediator.example.mediator.Mediator;
import refactoring_guru.mediator.example.mediator.Note;

import javax.swing.*;
import java.awt.event.KeyEvent;
import javax.swing.DefaultListModel;

/**
 * EN: Concrete components don't talk with each other. They have only one
 * communication channel–sending requests to the mediator.
 * <p>
 * RU: Конкретные компоненты никак не связаны между собой. У них есть только
 * один канал общения – через отправку уведомлений посреднику.
 */
public class Filter extends JTextField implements Component {
  private transient Mediator mediator;
  private transient ListModel<Note> listModel;

  public Filter(Mediator mediator, ListModel<Note> listModel) {
    this.mediator = mediator;
    this.listModel = listModel;
  }

  @Override
  public void setMediator(Mediator mediator) {
    this.mediator = mediator;
  }

  @Override
  protected void processComponentKeyEvent(KeyEvent keyEvent) {
    String start = getText();
    searchElements(start);
  }

  public void setList(ListModel<Note> listModel) {
    this.listModel = listModel;
  }

  private void searchElements(String s) {
    if (listModel == null || s.equals("")) {
      mediator.setElementsList(listModel);
      return;
    }

    DefaultListModel<Note> filteredListModel = new DefaultListModel<>();
    for (int i = 0; i < listModel.getSize(); i++) {
      Note note = listModel.getElementAt(i);
      if (note.getName().contains(s)) {
        filteredListModel.addElement(note);
      }
    }
    mediator.setElementsList(filteredListModel);
  }

  @Override
  public String getName() {
    return "Filter";
  }
}
