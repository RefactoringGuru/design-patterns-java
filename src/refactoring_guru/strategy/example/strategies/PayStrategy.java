package refactoring_guru.strategy.example.strategies;

/**
 * EN: Common interface for all strategies.
 * <p>
 * RU: Общий интерфейс всех стратегий.
 */
public interface PayStrategy {
  boolean pay(int paymentAmount);

  void collectPaymentDetails();
}

