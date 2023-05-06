package behavioral.command.undoredooperations;

import java.util.Stack;

public class TextEditor {
    private StringBuilder text = new StringBuilder();
    private Stack<Command> undoStack = new Stack<>();
    private Stack<Command> redoStack = new Stack<>();

    public void insert(int position, String text) {
        undoStack.push(new InsertCommand(this, position, text));
        this.text.insert(position, text);
        redoStack.clear();
    }

    public void delete(int position, int length) {
        String deletedText = text.substring(position, position + length);
        undoStack.push(new DeleteCommand(this, position, deletedText));
        text.delete(position, position + length);
        redoStack.clear();
    }

    public void undo() {
        if (!undoStack.empty()) {
            Command command = undoStack.pop();
            command.undo();
            redoStack.push(command);
        }
    }

    public void redo() {
        if (!redoStack.empty()) {
            Command command = redoStack.pop();
            command.execute();
            undoStack.push(command);
        }
    }

    public void print() {
        System.out.println(text.toString());
    }
}
