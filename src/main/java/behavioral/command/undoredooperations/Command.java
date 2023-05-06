package behavioral.command.undoredooperations;

public interface Command {
    void execute();
    void undo();
}
