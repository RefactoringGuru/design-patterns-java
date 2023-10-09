package refactoring_guru.decorator.example;

import refactoring_guru.decorator.example.decorators.*;

public class Demo {
  public static void main(String[] args) {
    init();
  }

  private static void init() {
    DataSourceDecorator encoded = new CompressionDecorator(
            new EncryptionDecorator(
                    new FileDataSource("out/OutputDemo.txt")));
    encoded.writeData("Name, salary\nJohn Smith, 100000\nSteven Jobs\n");
    DataSource plain = new FileDataSource("out/OutputDemo.txt");

    System.out.println("- Input ----------------");
    System.out.println("Name, salary\nJohn Smith, 100000\nSteven Jobs\n");
    System.out.println("- Encoded --------------");
    System.out.println(plain.readData());
    System.out.println("- Decoded --------------");
    System.out.println(encoded.readData());
  }
}
