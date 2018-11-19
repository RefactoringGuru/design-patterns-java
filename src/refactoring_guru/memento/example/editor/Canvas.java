package refactoring_guru.memento.example.editor;

import refactoring_guru.memento.example.commands.ColorCommand;
import refactoring_guru.memento.example.commands.MoveCommand;
import refactoring_guru.memento.example.shapes.Shape;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

class Canvas extends java.awt.Canvas {
    private Editor editor;
    private JFrame frame;
    private static final int PADDING = 10;

    Canvas(Editor editor) {
        this.editor = editor;
        createFrame();
        attachKeyboardListeners();
        attachMouseListeners();
        refresh();
    }

    private void createFrame() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel contentPanel = new JPanel();
        Border padding = BorderFactory.createEmptyBorder(PADDING, PADDING, PADDING, PADDING);
        contentPanel.setBorder(padding);
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        frame.setContentPane(contentPanel);

        contentPanel.add(new JLabel("Select and drag to move."), BorderLayout.PAGE_END);
        contentPanel.add(new JLabel("Right click to change color."), BorderLayout.PAGE_END);
        contentPanel.add(new JLabel("Undo: Ctrl+Z, Redo: Ctrl+R"), BorderLayout.PAGE_END);
        contentPanel.add(this);
        frame.setVisible(true);
        contentPanel.setBackground(Color.LIGHT_GRAY);
    }

    private void attachKeyboardListeners() {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0) {
                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_Z:
                            editor.undo();
                            break;
                        case KeyEvent.VK_R:
                            editor.redo();
                            break;
                    }
                }
            }
        });
    }

    private void attachMouseListeners() {
        MouseAdapter colorizer = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() != MouseEvent.BUTTON3) {
                    return;
                }
                Shape target = editor.getShapes().getChildAt(e.getX(), e.getY());
                if (target != null) {
                    editor.execute(new ColorCommand(editor, new Color((int) (Math.random() * 0x1000000))));
                    repaint();
                }
            }
        };
        addMouseListener(colorizer);

        MouseAdapter selector = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() != MouseEvent.BUTTON1) {
                    return;
                }

                Shape target = editor.getShapes().getChildAt(e.getX(), e.getY());
                boolean ctrl = (e.getModifiers() & ActionEvent.CTRL_MASK) == ActionEvent.CTRL_MASK;

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


        MouseAdapter dragger = new MouseAdapter() {
            MoveCommand moveCommand;

            @Override
            public void mouseDragged(MouseEvent e) {
                if ((e.getModifiersEx() & MouseEvent.BUTTON1_DOWN_MASK) != MouseEvent.BUTTON1_DOWN_MASK) {
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
                    return;
                }
                moveCommand.stop(e.getX(), e.getY());
                editor.execute(moveCommand);
                this.moveCommand = null;
                repaint();
            }
        };
        addMouseListener(dragger);
        addMouseMotionListener(dragger);
    }

    public int getWidth() {
        return editor.getShapes().getX() + editor.getShapes().getWidth() + PADDING;
    }

    public int getHeight() {
        return editor.getShapes().getY() + editor.getShapes().getHeight() + PADDING;
    }

    void refresh() {
        this.setSize(getWidth(), getHeight());
        frame.pack();
    }

    public void update(Graphics g) {
        paint(g);
    }

    public void paint(Graphics graphics) {
        BufferedImage buffer = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D ig2 = buffer.createGraphics();
        ig2.setBackground(Color.WHITE);
        ig2.clearRect(0, 0, this.getWidth(), this.getHeight());

        editor.getShapes().paint(buffer.getGraphics());

        graphics.drawImage(buffer, 0, 0, null);
    }
}
