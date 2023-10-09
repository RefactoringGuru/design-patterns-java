package refactoring_guru.mediator.example.components;

import refactoring_guru.mediator.example.mediator.Mediator;

/**
 * EN: Common component interface.
 * <p>
 * RU: Общий интерфейс компонентов.
 */
public interface Component {
  void setMediator(Mediator mediator);

  String getName();
}
