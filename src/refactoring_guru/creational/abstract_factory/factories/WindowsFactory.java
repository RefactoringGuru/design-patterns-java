package refactoring_guru.creational.abstract_factory.factories;

import refactoring_guru.creational.abstract_factory.buttons.Button;
import refactoring_guru.creational.abstract_factory.buttons.WindowsButton;
import refactoring_guru.creational.abstract_factory.checkboxes.Checkbox;
import refactoring_guru.creational.abstract_factory.checkboxes.WindowsCheckbox;

/**
 * EN: Each concrete factory extends basic factory and responsible for creating
 * products of a single variety.
 *
 * RU: Каждая конкретная фабрика знает и создаёт только продукты своей вариации.
 */
public class WindowsFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
