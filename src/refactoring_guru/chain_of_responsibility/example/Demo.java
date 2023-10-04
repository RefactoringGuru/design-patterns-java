package refactoring_guru.chain_of_responsibility.example;

import refactoring_guru.chain_of_responsibility.example.middleware.Middleware;
import refactoring_guru.chain_of_responsibility.example.middleware.RoleCheckMiddleware;
import refactoring_guru.chain_of_responsibility.example.middleware.ThrottlingMiddleware;
import refactoring_guru.chain_of_responsibility.example.middleware.UserExistsMiddleware;
import refactoring_guru.chain_of_responsibility.example.server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

/**
 * EN: Demo class. Everything comes together here.
 * <p>
 * RU: Демо-класс. Здесь всё сводится воедино.
 */
public class Demo {
  private static Server server;

  public static void main(String[] args) {
    init();
    while(!attemptLogin()) {
      System.out.println("Error reading input. Try again.");
    }
  }

  private static void init() {
    server = new Server();
    server.register("admin@example.com", "admin_pass");
    server.register("user@example.com", "user_pass");

    Middleware middleware = Middleware.link(
            new ThrottlingMiddleware(2),
            new UserExistsMiddleware(server),
            new RoleCheckMiddleware()
    );

    server.setMiddleware(middleware);
  }

  private static boolean attemptLogin() {
    return Optional.ofNullable(getCredentials())
            .map(credentials -> server.logIn(credentials.email(), credentials.password()))
            .orElse(false);
  }

  private static Credentials getCredentials() {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      System.out.print("Enter email: ");
      String email = reader.readLine();
      System.out.print("Input password: ");
      String password = reader.readLine();
      return new Credentials(email, password);
    } catch (IOException e) {
      return null;
    }
  }
}
