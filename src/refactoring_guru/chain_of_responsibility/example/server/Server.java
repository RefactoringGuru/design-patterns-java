package refactoring_guru.chain_of_responsibility.example.server;

import refactoring_guru.chain_of_responsibility.example.middleware.Middleware;

import java.util.HashMap;
import java.util.Map;

/**
 * EN: Server class.
 * <p>
 * RU: Класс сервера.
 */
public class Server {
  private final Map<String, String> users = new HashMap<>();
  private Middleware middleware;

  /**
   * EN: Client passes a chain of object to server. This improves flexibility
   * and makes testing the server class easier.
   * <p>
   * RU: Клиент подаёт готовую цепочку в сервер. Это увеличивает гибкость и
   * упрощает тестирование класса сервера.
   */
  public void setMiddleware(Middleware middleware) {
    this.middleware = middleware;
  }

  /**
   * EN: Server gets email and password from client and sends the
   * authorization request to the chain.
   * <p>
   * RU: Сервер получает email и пароль от клиента и запускает проверку
   * авторизации у цепочки.
   */
  public boolean logIn(String email, String password) {
    return middleware.check(email, password);
  }

  public void register(String email, String password) {
    users.put(email, password);
  }

  public boolean hasEmail(String email) {
    return users.containsKey(email);
  }

  public boolean isValidPassword(String email, String password) {
    return users.get(email).equals(password);
  }
}
