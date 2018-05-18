package refactoring_guru.mediator.example.components;

import refactoring_guru.mediator.example.mediator.Mediator;

import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * EN: Concrete components don't talk with each other. They have only one
 * communication channel–sending requests to the mediator.
 *
 * RU: Конкретные компоненты никак не связаны между собой. У них есть только
 * один канал общения – через отправку уведомлений посреднику.
 */
public class TextBox extends JTextArea implements Component {
    private Mediator mediator;

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    protected void processComponentKeyEvent(KeyEvent keyEvent) {
        mediator.markNote();
    }

    @Override
    public String getName() {
        return "TextBox";
    }
}
