package refactoring_guru.strategy.example.strategies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * EN: Concrete strategy. Implements credit card payment method.
 *
 * RU: Конкретная стратегия. Реализует оплату корзины интернет магазина
 * кредитной картой клиента.
 */
public class PayByCreditCard implements PayStrategy {
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private CreditCard card;

    /**
     * EN: Collect credit card data.
     *
     * RU: Собираем данные карты клиента.
     */
    @Override
    public void collectPaymentDetails() {
        try {
            System.out.print("Enter the card number: ");
            String number = READER.readLine();
            System.out.print("Enter the card expiration date 'mm/yy': ");
            String date = READER.readLine();
            System.out.print("Enter the CVV code: ");
            String cvv = READER.readLine();
            card = new CreditCard(number, date, cvv);

            // EN: Validate credit card number...
            //
            // RU: Валидируем номер карты...

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * EN: After card validation we can charge customer's credit card.
     *
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

