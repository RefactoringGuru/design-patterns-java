package refactoring_guru.strategy.example.strategies;

/**
 * EN: Concrete strategy. Implements credit card payment method.
 * <p>
 * RU: Конкретная стратегия. Реализует оплату корзины интернет магазина
 * кредитной картой клиента.
 */
public class PayByCreditCard implements PayStrategy {
  private CreditCard card;

  /**
   * EN: Collect credit card data.
   * <p>
   * RU: Собираем данные карты клиента.
   */
  @Override
  public void collectPaymentDetails() {
    System.out.print("Enter the card number: ");
    System.out.print("Enter the card expiration date 'mm/yy': ");
    System.out.print("Enter the CVV code: ");

    card = new CreditCard();
  }

  /**
   * EN: After card validation we can charge customer's credit card.
   * <p>
   * RU: После проверки карты мы можем совершить оплату. Если клиент
   * продолжает покупки, мы не запрашиваем карту заново.
   */
  @Override
  public boolean pay(int paymentAmount) {
    if (cardIsPresent()) {
      System.out.println("Paying " + paymentAmount + " using Credit Card.");
      card.setAmount(card.getAmount() - paymentAmount);
      return true;
    } else {
      return false;
    }
  }

  private boolean cardIsPresent() {
    return card != null;
  }
}

