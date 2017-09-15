package refactoring_guru.abstract_factory.example.factories;

import refactoring_guru.abstract_factory.example.buttons.MacOSButton;
import refactoring_guru.abstract_factory.example.checkboxes.MacOSCheckbox;

/**
 * EN: Each concrete factory extends basic factory and responsible for creating
 * products of a single variety.
 * 
 * RU: Каждая конкретная фабрика знает и создаёт только продукты своей вариации.
 */
public class MacOSFactory implements GUIFactory {

    @Override
    public MacOSButton createButton() {
        return new MacOSButton();
    }

    @Override
    public MacOSCheckbox createCheckbox() {
        return new MacOSCheckbox();
    }
}
