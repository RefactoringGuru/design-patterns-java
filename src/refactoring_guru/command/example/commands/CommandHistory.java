package refactoring_guru.command.example.commands;

import java.util.Stack;

public class CommandHistory {
    private Stack history = new Stack();

    public void push(Command c) {
        history.push(c);
    }

    public Command pop() {
        return (Command) history.pop();
    }

    public Boolean isEmpty() { return history.isEmpty(); }
}
