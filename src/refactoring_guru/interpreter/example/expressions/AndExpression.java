package refactoring_guru.interpreter.example.expressions;

public class AndExpression extends AbstractExpressions {
    private final AbstractExpressions first;
    private final AbstractExpressions second;

    public AndExpression(AbstractExpressions first, AbstractExpressions second) {
        this.first = first;
        this.second = second;
    }

    public boolean interpret(Context context) throws Exception {
        return this.first.interpret(context) && this.second.interpret(context);
    }
}
