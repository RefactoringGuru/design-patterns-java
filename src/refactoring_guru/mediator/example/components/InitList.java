package refactoring_guru.mediator.example.components;

import refactoring_guru.mediator.example.mediator.Mediator;
import refactoring_guru.mediator.example.mediator.Note;

import javax.swing.*;

/**
 * EN: Concrete components don't talk with each other. They have only one
 * communication channel–sending requests to the mediator.
 * <p>
 * RU: Конкретные компоненты никак не связаны между собой. У них есть только
 * один канал общения – через отправку уведомлений посреднику.
 */
@SuppressWarnings("unchecked")
public class InitList extends JList implements Component {
  private transient Mediator mediator;
  private final DefaultListModel<Note> listModel;
  private static final boolean running = true;

  public InitList(DefaultListModel<Note> listModel) {
    super(listModel);
    this.listModel = listModel;
    setModel(listModel);
    this.setLayoutOrientation(JList.VERTICAL);
    Thread thread = new Thread(new Hide(this));
    thread.start();
  }

  @Override
  public void setMediator(Mediator mediator) {
    this.mediator = mediator;
  }

  public void addElement(Note note) {
    listModel.addElement(note);
    int index = listModel.size() - 1;
    setSelectedIndex(index);
    ensureIndexIsVisible(index);
    mediator.sendToFilter(listModel);
  }

  public void deleteElement() {
    int index = this.getSelectedIndex();
    if (index >= 0 && index < listModel.size()) {
      listModel.remove(index);
      mediator.sendToFilter(listModel);
    }
  }

  public Note getCurrentElement() {
    return (Note) getSelectedValue();
  }

  @Override
  public String getName() {
    return "List";
  }

  private class Hide implements Runnable {
    private final InitList list;

    Hide(InitList list) {
      this.list = list;
    }

    @Override
    public void run() {
      while (running) {
        SwingUtilities.invokeLater(() -> mediator.hideElements(list.isSelectionEmpty()));
      }
    }
  }
}
