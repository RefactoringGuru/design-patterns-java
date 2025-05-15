package refactoring_guru.creational.abstract_factory.factories;

import refactoring_guru.creational.abstract_factory.buttons.Button;
import refactoring_guru.creational.abstract_factory.checkboxes.Checkbox;

/**
 * EN: Abstract factory knows about all (abstract) product types.
 *
 * RU: Абстрактная фабрика знает обо всех (абстрактных) типах продуктов.
 */
public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
