package behavioral.command.transactionalsystems;

// Command interface
public interface Command {
    void execute();
    void undo();
}
