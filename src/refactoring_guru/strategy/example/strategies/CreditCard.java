package refactoring_guru.strategy.example.strategies;

/**
 * EN: Dummy credit card class.
 * <p>
 * RU: Очень наивная реализация кредитной карты.
 */
public class CreditCard {
  private int amount;

  public CreditCard() {
    this.amount = 100_000;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public int getAmount() {
    return amount;
  }
}

