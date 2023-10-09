package refactoring_guru.factory_method.example.buttons;

import javax.swing.*;
import java.awt.*;

/**
 * EN: Windows button implementation.
 * <p>
 * RU: Реализация нативных кнопок операционной системы.
 */
public class WindowsButton implements Button {
  JPanel panel = new JPanel();
  JFrame frame = new JFrame();
  JButton button;

  public void render() {
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    JLabel label = new JLabel("Hello World!");
    label.setOpaque(true);
    label.setBackground(new Color(235, 233, 126));
    label.setFont(new Font("Dialog", Font.BOLD, 44));
    label.setHorizontalAlignment(SwingConstants.CENTER);
    panel.setLayout(new FlowLayout(FlowLayout.CENTER));
    frame.getContentPane().add(panel);
    panel.add(label);
    onClick();
    panel.add(button);

    frame.setSize(320, 200);
    frame.setVisible(true);
    onClick();
  }

  public void onClick() {
    button = new JButton("Exit");
    button.addActionListener(e -> {
      frame.setVisible(false);
      System.exit(0);
    });
  }
}
