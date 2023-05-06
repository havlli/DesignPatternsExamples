package behavioral.command.transactionalsystems;

import java.util.Stack;

// Invoker
public class TransactionManager {
    private Stack<Command> commandStack;

    public TransactionManager() {
        this.commandStack = new Stack<>();
    }

    public void execute(Command command) {
        command.execute();
        this.commandStack.push(command);
    }

    public void rollback() {
        while(!this.commandStack.isEmpty()) {
            Command command = this.commandStack.pop();
            command.undo();
        }
    }
}
