package refactoring_guru.memento.example.editor;

import refactoring_guru.memento.example.commands.ColorCommand;
import refactoring_guru.memento.example.commands.MoveCommand;
import refactoring_guru.memento.example.shapes.Shape;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

class Frame extends Canvas implements FrameMemento {
  private final Editor editor;
  private JFrame jFrame;
  private static final int PADDING = 10;
  private final Random random = new Random();

  Frame(Editor editor) {
    this.editor = editor;
    initFrame();
    attachListeners();
    mouseListeners();
    refresh();
  }

  private void initFrame() {
    jFrame = new JFrame();
    jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    jFrame.setLocationRelativeTo(null);

    JPanel contentPanel = new JPanel();
    Border padding = BorderFactory.createEmptyBorder(PADDING, PADDING, PADDING, PADDING);
    contentPanel.setBorder(padding);
    contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
    jFrame.setContentPane(contentPanel);

    contentPanel.add(new JLabel("Select and drag to move."), BorderLayout.PAGE_END);
    contentPanel.add(new JLabel("Right click to change color."), BorderLayout.PAGE_END);
    contentPanel.add(new JLabel("Undo: Ctrl+Z, Redo: Ctrl+R"), BorderLayout.PAGE_END);
    contentPanel.add(this);
    jFrame.setVisible(true);
    contentPanel.setBackground(Color.LIGHT_GRAY);
  }

  private void attachListeners() {
    addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        if ((e.getModifiersEx() & InputEvent.CTRL_DOWN_MASK) != 0) {
          switch (e.getKeyCode()) {
            case KeyEvent.VK_Z -> editor.undo();
            case KeyEvent.VK_R -> editor.redo();
            default -> Logger.getLogger(Frame.class.getName())
                    .log(Level.WARNING, () -> "Unknown component: ");

          }
        }
      }
    });
  }

  private void mouseListeners() {
    MouseAdapter mouseAdapter = new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        if (e.getButton() != MouseEvent.BUTTON3) {
          return;
        }
        Shape target = editor.getShapes().getChildAt(e.getX(), e.getY());
        if (target != null) {
          try {
            editor.execute(new ColorCommand(editor, new Color((random.nextInt() * 0x1000000))));
          } catch (IOException ex) {
            throw new RuntimeException(ex);
          }
          repaint();
        }
      }
    };
    addMouseListener(mouseAdapter);

    MouseAdapter selector = new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        if (e.getButton() != MouseEvent.BUTTON1) {
          throw new IllegalArgumentException("if the button is not working ");
        }

        Shape target = editor.getShapes().getChildAt(e.getX(), e.getY());
        boolean ctrl = (e.getModifiersEx() & ActionEvent.CTRL_MASK) == ActionEvent.CTRL_MASK;

        if (target == null) {
          if (!ctrl) {
            editor.getShapes().unSelect();
          }
        } else {
          if (ctrl) {
            if (target.isSelected()) {
              target.unSelect();
            } else {
              target.select();
            }
          } else {
            if (!target.isSelected()) {
              editor.getShapes().unSelect();
            }
            target.select();
          }
        }
        repaint();
      }
    };
    addMouseListener(selector);


    MouseAdapter mouseAdapter1 = new MouseAdapter() {
      MoveCommand moveCommand;

      @Override
      public void mouseDragged(MouseEvent e) {
        if ((e.getModifiersEx() & InputEvent.BUTTON1_DOWN_MASK) != InputEvent.BUTTON1_DOWN_MASK) {
          return;
        }
        if (moveCommand == null) {
          moveCommand = new MoveCommand(editor);
          moveCommand.start(e.getX(), e.getY());
        }
        moveCommand.move(e.getX(), e.getY());
        repaint();
      }

      @Override
      public void mouseReleased(MouseEvent e) {
        if (e.getButton() != MouseEvent.BUTTON1 || moveCommand == null) {
          throw new IllegalArgumentException("Cannot execute");
        }
        moveCommand.stop(e.getX(), e.getY());
        try {
          editor.execute(moveCommand);
        } catch (IOException ex) {
          throw new RuntimeException(ex);
        }
        this.moveCommand = null;
        repaint();
      }
    };
    addMouseListener(mouseAdapter1);
    addMouseMotionListener(mouseAdapter1);
  }

  @Override
  public int getWidth() {
    return editor.getShapes().getX() + editor.getShapes().getWidth() + PADDING;
  }

  @Override
  public int getHeight() {
    return editor.getShapes().getY() + editor.getShapes().getHeight() + PADDING;
  }

  @Override
  public void refresh() {
    this.setSize(getWidth(), getHeight());
    jFrame.pack();
  }

  @Override
  public void update(Graphics g) {
    paint(g);
  }

  @Override
  public void paint(Graphics graphics) {
    BufferedImage buffer = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
    Graphics2D ig2 = buffer.createGraphics();
    ig2.setBackground(Color.WHITE);
    ig2.clearRect(0, 0, this.getWidth(), this.getHeight());

    editor.getShapes().paint(buffer.getGraphics());

    graphics.drawImage(buffer, 0, 0, null);
  }
}
