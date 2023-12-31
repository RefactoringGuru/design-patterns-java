package refactoring_guru.interpreter.example.expressions;

import java.util.HashMap;

public class Context {
    HashMap<String, Boolean> poolVariables = new HashMap<>();

    public boolean lookUp(String name) throws Exception {
        if (!poolVariables.containsKey(name)) {
            throw new Exception("No exist variable: name");
        }

        return this.poolVariables.get(name);
    }

    public void assign(VariableExpression variable, boolean value) {
        this.poolVariables.put(variable.getName(), value);
    }
}
