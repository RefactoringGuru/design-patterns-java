package refactoring_guru.abstract_factory.example.checkboxes;

/**
 * EN: All products families have the same varieties (MacOS/Windows).
 * <p>
 * This is a variant of a checkbox.
 * <p>
 * RU: Все семейства продуктов имеют одинаковые вариации (MacOS/Windows).
 * <p>
 * Вариация чекбокса под MacOS.
 */
public class MacOSCheckbox implements Checkbox {

  @Override
  public void paint() {
    System.out.println("You have created MacOSCheckbox.");
  }
}
