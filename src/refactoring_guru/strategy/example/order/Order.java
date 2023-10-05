package refactoring_guru.strategy.example.order;

import refactoring_guru.strategy.example.strategies.PayStrategy;

/**
 * EN: Order class. Doesn't know the concrete payment method (strategy) user has
 * picked. It uses common strategy interface to delegate collecting payment data
 * to strategy object. It can be used to save order to database.
 * <p>
 * RU: Класс заказа. Ничего не знает о том каким способом (стратегией) будет
 * расчитыватся клиент, а просто вызывает метод оплаты. Все остальное стратегия
 * делает сама.
 */
public class Order {
  private int totalCost = 0;
  private boolean isClosed = false;

  /**
   * EN: Here we could collect and store payment data from the strategy.
   * <p>
   * RU: Здесь мы могли бы забрать и сохранить платежные данные из
   * стратегии.
   *
   * @param strategy given option
   */
  public void processOrder(PayStrategy strategy) {
    strategy.collectPaymentDetails();
  }

  public void setTotalCost(int cost) {
    this.totalCost += cost;
  }

  public int getTotalCost() {
    return totalCost;
  }

  public boolean isClosed() {
    return isClosed;
  }

  public void setClosed() {
    isClosed = true;
  }
}