package refactoring_guru.singleton.example.thread_safe;

/**
 * EN: The field must be declared volatile so that double check lock would
 * work correctly.
 * <p>
 * RU: Поле обязательно должно быть объявлено volatile, чтобы двойная
 * проверка блокировки сработала как надо.
 */
public final class Singleton {
  private static Singleton instance;

  public String value;

  private Singleton(String value) {
    this.value = value;
  }

  /**
   * It exists to prevent race condition between multiple threads that may
   * EN: The approach taken here is called double-checked locking (DCL).
   * attempt to get singleton instance at the same time, creating
   * separate instances as a result.
   * <p>
   * It may seem that having the `result` variable here is completely
   * pointless. There is, however, a very important caveat when
   * implementing double-checked locking in Java, which is solved by
   * introducing this local variable.
   * <p>
   * You can read more info DCL issues in Java here:
   * {@link <a href="https://refactoring.guru/java-dcl-issue">...</a>}
   * <p>
   * RU: Техника, которую мы здесь применяем называется «блокировка с
   * двойной проверкой» (Double-Checked Locking). Она применяется, чтобы
   * предотвратить создание нескольких объектов-одиночек, если метод будет
   * вызван из нескольких потоков одновременно.
   * <p>
   * Хотя переменная `result` вполне оправданно кажется здесь лишней, она
   * помогает избежать подводных камней реализации DCL в Java.
   * <p>
   * Больше об этой проблеме можно почитать здесь:
   * {@link <a href="https://refactoring.guru/ru/java-dcl-issue">...</a>}
   *
   * @param value value which can be provided
   * @return the instance of the Singleton class
   */
  public static Singleton getInstance(String value) {
    Singleton result = instance;
    if (result != null) {
      return result;
    }
    synchronized (Singleton.class) {
      if (instance == null) {
        instance = new Singleton(value);
      }
      return instance;
    }
  }
}
