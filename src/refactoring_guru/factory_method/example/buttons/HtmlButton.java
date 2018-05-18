package refactoring_guru.factory_method.example.buttons;

/**
 * EN: HTML button implementation.
 *
 * RU: Реализация HTML кнопок.
 */
public class HtmlButton implements Button {

    public void render() {
        System.out.println("<button>Test Button</button>");
        onClick();
    }

    public void onClick() {
        System.out.println("Click! Button says - 'Hello World!'");
    }
}
