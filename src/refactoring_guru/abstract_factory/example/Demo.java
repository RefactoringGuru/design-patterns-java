package refactoring_guru.abstract_factory.example;

import refactoring_guru.abstract_factory.example.app.Application;
import refactoring_guru.abstract_factory.example.factories.GUIFactory;
import refactoring_guru.abstract_factory.example.factories.MacOSFactory;
import refactoring_guru.abstract_factory.example.factories.WindowsFactory;

/**
 * EN: Demo class. Everything comes together here.
 * <p>
 * RU: Демо-класс. Здесь всё сводится воедино.
 */
public class Demo {
    public static void main(String[] args) {
        Application app = configureApplication();
        app.paint();
    }

    /**
     * EN: Configures the application with the appropriate GUI factory based on the OS.
     * Dynamically selects the factory type depending on the current system configuration.
     * <p>
     * RU: Конфигурирует приложение с соответствующей фабрикой GUI на основе ОС.
     * Динамически выбирает тип фабрики в зависимости от текущей системной конфигурации.
     *
     * @return An instance of the Application configured with the appropriate GUI factory.
     */
    private static Application configureApplication() {
        GUIFactory factory = getOSGUIFactory();
        return new Application(factory);
    }

    /**
     * EN: Determines the appropriate GUI factory based on the operating system.
     * Checks the current system's OS property to decide which factory to instantiate.
     * <p>
     * RU: Определяет соответствующую фабрику GUI на основе операционной системы.
     * Проверяет свойство OS текущей системы, чтобы решить, какую фабрику создать.
     *
     * @return The GUIFactory instance corresponding to the detected operating system.
     */
    private static GUIFactory getOSGUIFactory() {
        String osName = System.getProperty("os.name").toLowerCase();
        return osName.contains("mac") ? new MacOSFactory() : new WindowsFactory();
    }
}
