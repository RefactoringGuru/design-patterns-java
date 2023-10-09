package refactoring_guru.chain_of_responsibility.example.middleware;

/**
 * EN: ConcreteHandler. Checks a user's role.
 * <p>
 * RU: Конкретный элемент цепи обрабатывает запрос по-своему.
 */
public class RoleCheckMiddleware extends Middleware {
  public boolean check(String email, String password) {
    return email.equals("admin@example.com") || checkNext(email, password);
  }
}
