## GUI application
In a GUI application, different buttons or menus might be associated with different commands. Here's an example of how the Command pattern might be used to handle button presses:
```java
public interface Command {
    void execute();
}

public class SaveCommand implements Command {
    private Document document;

    public SaveCommand(Document document) {
        this.document = document;
    }

    public void execute() {
        document.save();
    }
}

public class CopyCommand implements Command {
    private Clipboard clipboard;
    private TextEditor textEditor;

    public CopyCommand(Clipboard clipboard, TextEditor textEditor) {
        this.clipboard = clipboard;
        this.textEditor = textEditor;
    }

    public void execute() {
        clipboard.copy(textEditor.getSelectedText());
    }
}

public class PasteCommand implements Command {
    private Clipboard clipboard;
    private TextEditor textEditor;

    public PasteCommand(Clipboard clipboard, TextEditor textEditor) {
        this.clipboard = clipboard;
        this.textEditor = textEditor;
    }

    public void execute() {
        textEditor.insert(clipboard.getContents());
    }
}

public class MenuItem {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void click() {
        command.execute();
    }
}

public class TextEditor {
    private String text;
    private int startSelection;
    private int endSelection;

    public String getSelectedText() {
        return text.substring(startSelection, endSelection);
    }

    public void insert(String contents) {
        // Insert contents at current cursor position
    }

    // Other methods for manipulating text and cursor position
}

public class Clipboard {
    private String contents;

    public void copy(String text) {
        contents = text;
    }

    public String getContents() {
        return contents;
    }
}

public class Document {
    public void save() {
        // Save document
    }
}

public class Client {
    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        Clipboard clipboard = new Clipboard();
        Document document = new Document();

        // Create concrete command instances
        Command saveCommand = new SaveCommand(document);
        Command copyCommand = new CopyCommand(clipboard, textEditor);
        Command pasteCommand = new PasteCommand(clipboard, textEditor);

        // Create menu items and associate commands with them
        MenuItem saveMenuItem = new MenuItem();
        saveMenuItem.setCommand(saveCommand);

        MenuItem copyMenuItem = new MenuItem();
        copyMenuItem.setCommand(copyCommand);

        MenuItem pasteMenuItem = new MenuItem();
        pasteMenuItem.setCommand(pasteCommand);

        // Simulate user clicks on menu items
        saveMenuItem.click();
        copyMenuItem.click();
        pasteMenuItem.click();
    }
}
```
In this example, the `TextEditor` class represents a simple text editor with methods for inserting and manipulating text. The `Clipboard` class represents the clipboard, which can be used to store and retrieve text. The `Command` interface defines the `execute()` method that encapsulates an action, and the `SaveCommand`, `CopyCommand`, and `PasteCommand` classes are concrete implementations of the `Command` interface that encapsulate specific actions. The `MenuItem` class represents a menu item that can be associated with a command, and the `click()` method on the `MenuItem` class calls the `execute()` method on the associated command.

-   `Command` interface: This is the abstract interface that defines the `execute()` method that all concrete command classes will implement.

-   `SaveCommand`, `CopyCommand`, and `PasteCommand` classes: These are concrete implementations of the `Command` interface that encapsulate specific actions. They are the commands that will be associated with the menu items.

-   `MenuItem` class: This is the invoker class that associates a command with a menu item and calls the `execute()` method on the associated command when the menu item is clicked.

-   `TextEditor` and `Clipboard` classes: These are the receivers of the commands. The `TextEditor` class has methods for inserting and manipulating text, and the `Clipboard` class has methods for storing and retrieving text. The commands use these classes to perform their actions.