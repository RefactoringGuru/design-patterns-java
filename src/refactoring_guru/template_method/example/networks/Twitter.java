package refactoring_guru.template_method.example.networks;

/**
 * EN: Class of social network
 * <p>
 * RU: Класс социальной сети.
 */
public class Twitter extends Network {

  public Twitter(String userName, String password) {
    super(userName, password);
  }

  @Override
  public void logIn(String userName, String password) {
    simulateNetworkLatency();
    System.out.println("\n\nLogIn success on Twitter");
  }

  @Override
  public void sendData(byte[] data) {
    System.out.println("Message: '" + new String(data) + "' it was posted on Twitter");
  }

  @Override
  public void logOut() {
    System.out.println("User: '" + getUserName() + "' was logged out from Twitter");
  }

  @Override
  protected void simulateNetworkLatency() {
    try {
      System.out.println("Simulating network latency...");
      Thread.sleep(5000);
    } catch (InterruptedException ex) {
      Thread.currentThread().interrupt();
      throw new RuntimeException(ex);
    }
  }
}
