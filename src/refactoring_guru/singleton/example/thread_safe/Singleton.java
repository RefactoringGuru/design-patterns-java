package refactoring_guru.singleton.example.thread_safe;

public final class Singleton {
    // EN: The field must be declared volatile so that double check lock would
    // work.
    //
    // See: https://refactoring.guru/java-dcl-issue
    //
    // RU: Поле обязательно должно быть объявлено volatile, чтобы двойная
    // проверка блокировки сработала как надо.
    //
    // См: https://refactoring.guru/java-dcl-issue
    private static volatile Singleton instance;

    public String value;

    private Singleton(String value) {
        this.value = value;
    }

    public static Singleton getInstance(String value) {
        // EN: This code may appear a bit convoluted. In particular, the need
        // for the local variable result may be unclear. This is a micro-
        // optimization.
        //
        // The field would be read first time in the first if statement and
        // second time in the return statement. The field is declared volatile,
        // which means it has to be refetched from memory every time it is
        // accessed (more processing is required to access volatile variables)
        // and can not be stored into a register by the compiler. When copied to
        // the local variable and then used in both statements (if and return),
        // the register optimization can be done by the JVM.
        //
        // RU: Вам может быть неясно зачем мы используем дублирующую локальную
        // переменную здесь. Это — микрооптимизация.
        //
        // Поле одиночки объявлено как volatile, что заставляет программу
        // обновлять её значение из памяти каждый раз при доступе к переменной,
        // тогда как значение обычной переменной может быть записано в регистр
        // процессора для более быстрого чтения. Используя дополнительную
        // локальную перменную, мы можем ускорить работу с переменной, обновляя
        // значение поля только тогда, когда действительно нужно.
        Singleton result = instance;
        if (result == null) {
            synchronized (Singleton.class) {
                result = instance;
                if (result == null) {
                    instance = result = new Singleton(value);
                }
            }
        }
        return instance;
    }
}
