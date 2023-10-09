package refactoring_guru.template_method.example.networks;

/**
 * EN: Base class of social network.
 * <p>
 * RU: Базовый класс социальной сети.
 */
public abstract class Network {
  public final String userName;
  public final String password;

  protected Network(String userName, String password) {
    this.userName = userName;
    this.password = password;
  }

  public String getUserName() {
    return userName;
  }

  public String getPassword() {
    return password;
  }

  public abstract void logIn(String userName, String password);

  public abstract void sendData(byte[] data);

  public abstract void logOut();

  protected abstract void simulateNetworkLatency();
}