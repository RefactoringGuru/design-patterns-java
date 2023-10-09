package refactoring_guru.abstract_factory.example.checkboxes;

/**
 * EN: All products families have the same varieties (MacOS/Windows).
 *
 * This is another variant of a checkbox.
 *
 * RU: Все семейства продуктов имеют одинаковые вариации (MacOS/Windows).
 *
 * Вариация чекбокса под Windows.
 */
public class WindowsCheckbox implements Checkbox {

    @Override
    public void paint() {
        System.out.println("You have created WindowsCheckbox.");
    }
}
