package refactoring_guru.memento.example.editor;

import refactoring_guru.memento.example.commands.Command;
import refactoring_guru.memento.example.history.History;
import refactoring_guru.memento.example.history.Memento;
import refactoring_guru.memento.example.shapes.CompoundShape;
import refactoring_guru.memento.example.shapes.Shape;

import javax.swing.*;
import java.io.*;
import java.util.Base64;

public class Editor extends JComponent {
  private final Frame canvas;
  private CompoundShape allShapes = new CompoundShape();
  private final transient History history;

  public Editor() {
    canvas = new Frame(this);
    history = new History();
  }

  public void loadShapes(Shape... shapes) {
    allShapes.clear();
    allShapes.add(shapes);
    canvas.refresh();
  }

  public CompoundShape getShapes() {
    return allShapes;
  }

  public void execute(Command c) throws IOException {
    history.push(c, new Memento(this));
    c.execute();
  }

  public void undo() {
    if (history.undo())
      canvas.repaint();
  }

  public void redo() {
    if (history.redo())
      canvas.repaint();
  }

  public String backup() throws IOException {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
    objectOutputStream.writeObject(this.allShapes);
    objectOutputStream.close();
    return Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
  }

  public void restore(String state) {
    try {
      byte[] data = Base64.getDecoder().decode(state);
      ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
      this.allShapes = (CompoundShape) ois.readObject();
      ois.close();
    } catch (ClassNotFoundException e) {
      System.out.print("ClassNotFoundException occurred.");
    } catch (IOException e) {
      System.out.print("IOException occurred.");
    }
  }
}
