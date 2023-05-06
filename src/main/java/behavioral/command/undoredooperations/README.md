## Multi-level undo/redo operations

In this example, the `Command` interface defines two methods, `execute()` and `undo()`, that represent the actions and the corresponding reverse actions that can be taken on the text editor. The `InsertCommand` and `DeleteCommand` classes are concrete implementations of the `Command` interface that represent the insertion and deletion of text.

The `TextEditor` class maintains the text content and two stacks of commands, `undoStack` and `redoStack`. Whenever a command is executed, it is pushed onto the `undoStack`, and when an undo operation is requested, the most recent command is popped from the `undoStack`, its `undo()` method is called to reverse the effect of the command, and the command is pushed onto the `redoStack`.

Similarly, when a redo operation is requested, the most recent command is popped from the `redo`
```java
// Command interface
public interface Command {
    void execute();

    void undo();
}

// Concrete command for inserting text
public class InsertCommand implements Command {
    private TextEditor textEditor;
    private int position;
    private String text;

    public InsertCommand(TextEditor textEditor, int position, String text) {
        this.textEditor = textEditor;
        this.position = position;
        this.text = text;
    }

    @Override
    public void execute() {
        textEditor.insert(position, text);
    }

    @Override
    public void undo() {
        textEditor.delete(position, text.length());
    }
}

// Concrete command for deleting text
public class DeleteCommand implements Command {
    private TextEditor textEditor;
    private int position;
    private String text;

    public DeleteCommand(TextEditor textEditor, int position, String text) {
        this.textEditor = textEditor;
        this.position = position;
        this.text = text;
    }

    @Override
    public void execute() {
        textEditor.delete(position, text.length());
    }

    @Override
    public void undo() {
        textEditor.insert(position, text);
    }
}

// TextEditor class
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

// Client
public class Client {
    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        textEditor.insert(0, "Hello ");
        textEditor.insert(6, "world");
        textEditor.print();

        textEditor.undo();
        textEditor.print();

        textEditor.redo();
        textEditor.print();

        textEditor.delete(0, 6);
        textEditor.print();

        textEditor.undo();
        textEditor.print();
    }
}
```