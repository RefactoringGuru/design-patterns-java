package refactoring_guru.template_method.example;

import refactoring_guru.template_method.example.networks.Facebook;
import refactoring_guru.template_method.example.networks.Network;
import refactoring_guru.template_method.example.networks.Twitter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * EN: Demo class. Everything comes together here.
 * <p>
 * RU: Демо-класс. Здесь всё сводится воедино.
 */
public class Demo {
  public static void main(String[] args) {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      System.out.print("Input username: ");
      String userName = reader.readLine();
      System.out.print("Input password: ");
      String password = reader.readLine();
      System.out.print("Input message: ");
      String message = reader.readLine();

      Network network = getNetwork(reader, userName, password);
      if (network != null) {
        network.logIn(userName, password);
        network.sendData(message.getBytes());
        network.logOut();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static Network getNetwork(BufferedReader reader, String userName, String password) throws IOException {
    System.out.println("""
            Choose social network for posting a message.
            1 - Facebook
            2 - Twitter
            """);
    int choice = Integer.parseInt(reader.readLine());
    return switch (choice) {
      case 1 -> new Facebook(userName, password);
      case 2 -> new Twitter(userName, password);
      default -> {
        System.out.println("Invalid choice. Please run the program again.");
        yield null;
      }
    };
  }
}
