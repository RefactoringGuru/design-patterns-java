package refactoring_guru.strategy.example.init;

import refactoring_guru.strategy.example.strategies.PayByCreditCard;
import refactoring_guru.strategy.example.strategies.PayByPayPal;
import refactoring_guru.strategy.example.strategies.PayStrategy;

public enum PaymentMethod {
  PAYPAL(1) {
    @Override
    public PayStrategy createStrategy() {
      return new PayByPayPal();
    }
  },
  CREDIT_CARD(2) {
    @Override
    public PayStrategy createStrategy() {
      return new PayByCreditCard();
    }
  };

  private final int choice;

  PaymentMethod(int choice) {
    this.choice = choice;
  }

  public abstract PayStrategy createStrategy();

  public static PaymentMethod fromChoice(int choice) {
    for (PaymentMethod method : values()) {
      if (method.choice == choice) {
        return method;
      }
    }
    throw new IllegalArgumentException("Invalid choice: " + choice);
  }
}
