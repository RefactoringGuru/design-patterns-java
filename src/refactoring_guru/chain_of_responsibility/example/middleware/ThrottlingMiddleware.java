package refactoring_guru.chain_of_responsibility.example.middleware;

/**
 * EN: ConcreteHandler. Checks whether there are too many failed login requests.
 *
 * RU: Конкретный элемент цепи обрабатывает запрос по-своему.
 */
public class ThrottlingMiddleware extends Middleware {
    private int requestPerMinute;
    private int request;
    private long currentTime;

    public ThrottlingMiddleware(int requestPerMinute) {
        this.requestPerMinute = requestPerMinute;
        this.currentTime = System.currentTimeMillis();
    }

    /**
     * EN: Please, not that checkNext() call can be inserted both in the
     * beginning of this method and in the end.
     *
     * This gives much more flexibility than a simple loop over all middleware
     * objects. For instance, an element of a chain can change the order of
     * checks by running its check after all other checks.
     *
     * RU: Обратите внимание, вызов checkNext() можно вставить как в начале
     * этого метода, так и в середине или в конце.
     *
     * Это даёт еще один уровень гибкости по сравнению с проверками в цикле.
     * Например, элемент цепи может пропустить все остальные проверки вперёд и
     * запустить свою проверку в конце.
     */
    public boolean check(String email, String password) {
        if (System.currentTimeMillis() > currentTime + 60_000) {
            request = 0;
            currentTime = System.currentTimeMillis();
        }

        request++;
        
        if (request > requestPerMinute) {
            System.out.println("Request limit exceeded!");
            Thread.currentThread().stop();
        }
        return checkNext(email, password);
    }
}
