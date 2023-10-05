package refactoring_guru.singleton.example.non_thread_safe;

public final class Singleton {
  private static Singleton instance;
  public String value;

  /**
   * EN: The following code emulates slow initialization.
   * <p>
   * RU: Этот код эмулирует медленную инициализацию.
   *
   * @param value example value
   */
  private Singleton(String value) {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException ex) {
      Thread.currentThread().interrupt();
    }
    this.value = value;
  }

  public static Singleton getInstance(String value) {
    if (instance == null) {
      instance = new Singleton(value);
    }
    return instance;
  }
}
