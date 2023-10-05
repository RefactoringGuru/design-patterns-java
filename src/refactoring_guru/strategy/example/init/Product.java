package refactoring_guru.strategy.example.init;

public enum Product {
  MOTHER_BOARD(1, 2200),
  CPU(2, 1850),
  HDD(3, 1100),
  MEMORY(4, 890);

  private final int choice;
  private final int price;

  Product(int choice, int price) {
    this.choice = choice;
    this.price = price;
  }

  public int getPrice() {
    return price;
  }

  public static Product fromChoice(int choice) {
    for (Product product : values()) {
      if (product.choice == choice) {
        return product;
      }
    }
    throw new IllegalArgumentException("Invalid choice: " + choice);
  }
}
