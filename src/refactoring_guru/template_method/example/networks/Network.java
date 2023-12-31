package refactoring_guru.template_method.example.networks;

/**
 * EN: Base class of social network.
 *
 * RU: Базовый класс социальной сети.
 */
public abstract class Network {
    String userName;
    String password;

    Network() {}

    /**
     * EN: Publish the data to whatever network.
     *
     * RU: Публикация данных в любой сети.
     */
    public boolean post(String message) {
        // EN: Authenticate before posting. Every network uses a different
        // authentication method.
        //
        // RU: Проверка данных пользователя перед постом в соцсеть. Каждая сеть
        // для проверки использует разные методы.
        if (logIn(this.userName, this.password)) {
            // EN: Send the post data.
            //
            // RU: Отправка данных.
            boolean result =  sendData(message.getBytes());
            logOut();
            return result;
        }
        return false;
    }

    abstract boolean logIn(String userName, String password);
    abstract boolean sendData(byte[] data);
    abstract void logOut();
}