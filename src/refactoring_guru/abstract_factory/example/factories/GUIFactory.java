package refactoring_guru.abstract_factory.example.factories;

import refactoring_guru.abstract_factory.example.buttons.Button;
import refactoring_guru.abstract_factory.example.checkboxes.Checkbox;

/**
 * EN: Abstract factory knows about all (abstract) product types.
 *
 * RU: Абстрактная фабрика знает обо всех (абстрактных) типах продуктов.
 */
public interface GUIFactory {
    public abstract Button createButton();
    public abstract Checkbox createCheckbox();
}
