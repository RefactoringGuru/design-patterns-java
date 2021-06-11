package refactoring_guru.interpreter.example.expressions;

public class VariableExpression extends AbstractExpressions {
    private final String name;

    public VariableExpression(String name) {
        this.name = name;
    }

    public boolean interpret(Context context) throws Exception {
        return context.lookUp(this.name);
    }

    public String getName() {
        return this.name;
    }
}
