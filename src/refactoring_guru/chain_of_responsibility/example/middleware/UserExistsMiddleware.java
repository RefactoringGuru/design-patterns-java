package refactoring_guru.chain_of_responsibility.example.middleware;

import refactoring_guru.chain_of_responsibility.example.server.Server;

/**
 * RU: Конкретный элемент цепи обрабатывает запрос по-своему.
 */
public class UserExistsMiddleware extends Middleware {
    public boolean check(String email, String password) {
        if (!Server.hasEmail(email)) {
            return false;
        }
        return checkNext(email, password);
    }
}
