package refactoring_guru.strategy.example;

import refactoring_guru.strategy.example.init.PaymentMethod;
import refactoring_guru.strategy.example.init.Product;
import refactoring_guru.strategy.example.order.Order;
import refactoring_guru.strategy.example.strategies.PayStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * EN: World first console e-commerce application.
 * <p>
 * RU: Первый в мире консольный интернет магазин.
 */
public class Demo {
  private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
  private static final Order order = new Order();
  private static PayStrategy strategy;

  private static final String PRODUCT_SELECTION_TEXT = """
          Please select a product:
          1 - Mother board
          2 - CPU
          3 - HDD
          4 - Memory
          """;

  private static final String PAYMENT_METHOD_TEXT = """
          Please select a payment method:
          1 - PalPay
          2 - Credit Card
          """;

  public static void main(String[] args) throws IOException {
    while (!order.isClosed()) {
      processUserInput();
      processPayment();
    }
  }

  private static void processUserInput() throws IOException {
    String continueChoice = "";
    do {
      System.out.print(PRODUCT_SELECTION_TEXT);
      try {
        int choice = Integer.parseInt(bufferedReader.readLine());
        Product product = Product.fromChoice(choice);
        System.out.print("Count: ");
        int count = Integer.parseInt(bufferedReader.readLine());
        order.setTotalCost(product.getPrice() * count);
      } catch (IllegalArgumentException e) {
        System.out.println("Invalid input. Please try again.");
        continue;
      }
      System.out.print("Do you wish to continue selecting products? Y/N: ");
      continueChoice = bufferedReader.readLine();
    } while (continueChoice.equalsIgnoreCase("Y"));
  }

  private static void processPayment() throws IOException {
    if (strategy == null) {
      System.out.println(PAYMENT_METHOD_TEXT);
      var paymentMethod = bufferedReader.readLine();
      strategy = PaymentMethod.fromChoice(Integer.parseInt(paymentMethod)).createStrategy();
    }

    order.processOrder(strategy);

    System.out.print("Pay " + order.getTotalCost() + " units or Continue shopping? P/C: ");
    var proceed = bufferedReader.readLine();
    if (proceed.equalsIgnoreCase("P")) {
      if (strategy.pay(order.getTotalCost())) {
        System.out.println("Payment has been successful.");
      } else {
        System.out.println("FAIL! Please, check your data.");
      }
      order.setClosed();
    }
  }
}
