package refactoring_guru.singleton.example.non_thread_safe;

public class DemoSingleThread {
  public static void main(String[] args) {
    var textBlock = """
            If you see the same value, then singleton was reused (yay!)
            If you see different values, then 2 singletons were created (booo!!)
            RESULT
            """;

    System.out.println(textBlock);
    Singleton singleton = Singleton.getInstance("FOO");
    Singleton anotherSingleton = Singleton.getInstance("BAR");
    System.out.println(singleton.value);
    System.out.println(anotherSingleton.value);
  }
}
