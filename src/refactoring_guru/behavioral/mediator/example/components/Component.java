package refactoring_guru.behavioral.mediator.example.components;

import refactoring_guru.behavioral.mediator.example.mediator.Mediator;

/**
 * EN: Common component interface.
 *
 * RU: Общий интерфейс компонентов.
 */
public interface Component {
    void setMediator(Mediator mediator);
    String getName();
}
