package refactoring_guru.creational.abstract_factory.app;

import refactoring_guru.creational.abstract_factory.buttons.Button;
import refactoring_guru.creational.abstract_factory.checkboxes.Checkbox;
import refactoring_guru.creational.abstract_factory.factories.GUIFactory;

/**
 * EN: Factory users don't care which concrete factory they use since they work
 * with factories and products through abstract interfaces.
 *
 * RU: Код, использующий фабрику, не волнует с какой конкретно фабрикой он
 * работает. Все получатели продуктов работают с продуктами через абстрактный
 * интерфейс.
 */
public class Application {
    private final Button button;
    private final Checkbox checkbox;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void paint() {
        button.paint();
        checkbox.paint();
    }
}
