package refactoring_guru.chain_of_responsibility.example.middleware;

import java.util.Optional;

/**
 * EN: ConcreteHandler. Checks whether there are too many failed login requests.
 * <p>
 * RU: Конкретный элемент цепи обрабатывает запрос по-своему.
 */
public class ThrottlingMiddleware extends Middleware {
  private final int requestPerMinute;
  private int request;
  private long currentTime;

  public ThrottlingMiddleware(int requestPerMinute) {
    this.requestPerMinute = requestPerMinute;
    this.currentTime = System.currentTimeMillis();
  }

  /**
   * EN: Please, not that checkNext() call can be inserted both in the
   * beginning of this method and in the end.
   * <p>
   * This gives much more flexibility than a simple loop over all middleware
   * objects. For instance, an element of a chain can change the order of
   * checks by running its check after all other checks.
   * <p>
   * RU: Обратите внимание, вызов checkNext() можно вставить как в начале
   * этого метода, так и в середине или в конце.
   * <p>
   * Это даёт еще один уровень гибкости по сравнению с проверками в цикле.
   * Например, элемент цепи может пропустить все остальные проверки вперёд и
   * запустить свою проверку в конце.
   */
  public boolean check(String email, String password) {
    return resetIfTimeElapsed()
            .filter(this::withinRateLimit)
            .map(ignored -> checkNext(email, password))
            .orElseThrow(() -> {
              System.out.println("Request limit exceeded!");
              return new RuntimeException("Request limit exceeded!");
            });
  }

  private Optional<Boolean> resetIfTimeElapsed() {
    long now = System.currentTimeMillis();
    if (now > currentTime + 60_000) {
      request = 0;
      currentTime = now;
    }
    request++;
    return Optional.of(true);
  }

  @Override
  protected boolean checkNext(String email, String password) {
    return true;
  }

  private boolean withinRateLimit(Boolean ignored) {
    return request <= requestPerMinute;
  }
}
