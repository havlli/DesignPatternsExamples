# Command Pattern Example
Let's say we have a simple text editor application that can perform various operations such as copy, paste, cut, and undo. We can implement the Command pattern as follows:

1.  First, we define a common interface for all commands. This interface will have a single method, `execute()`, which will be implemented by all the concrete command classes.
```java
public interface Command {
    void execute();
}
```
2.  Next, we create concrete command classes that implement the `Command` interface for each of the operations we want to perform. Here, we will create three classes for `CopyCommand`, `PasteCommand`, and `CutCommand`.
```java
public class CopyCommand implements Command {
    private TextEditor textEditor;
    
    public CopyCommand(TextEditor textEditor) {
        this.textEditor = textEditor;
    }
    
    public void execute() {
        textEditor.copy();
    }
}

public class PasteCommand implements Command {
    private TextEditor textEditor;
    
    public PasteCommand(TextEditor textEditor) {
        this.textEditor = textEditor;
    }
    
    public void execute() {
        textEditor.paste();
    }
}

public class CutCommand implements Command {
    private TextEditor textEditor;
    
    public CutCommand(TextEditor textEditor) {
        this.textEditor = textEditor;
    }
    
    public void execute() {
        textEditor.cut();
    }
}
```
In the above code, each command class has a reference to the `TextEditor` object, which is the receiver that will perform the actual operation.

3.  We can now use the `Command` interface and its concrete implementations to build the text editor application. Here, we will create an `Invoker` class, which is responsible for executing the commands. The `Invoker` class will have a method `setCommand(Command cmd)` to set the command to be executed and a method `executeCommand()` to execute the command.
```java
public class Invoker {
    private Command command;
    
    public void setCommand(Command command) {
        this.command = command;
    }
    
    public void executeCommand() {
        command.execute();
    }
}
```
4.  Finally, we create a `TextEditor` class, which is the receiver object that will perform the actual operations. This class will have methods for each operation, such as `copy()`, `paste()`, `cut()`, and `undo()`.
```java
public class TextEditor {
    private String clipboard;
    private String text;
    
    public void copy() {
        clipboard = text;
    }
    
    public void paste() {
        text += clipboard;
    }
    
    public void cut() {
        clipboard = text;
        text = "";
    }
    
    public void undo() {
        text = clipboard;
    }
}
```
5.  To use the Command pattern in the text editor application, we create an instance of the `TextEditor` class and an instance of the `Invoker` class. We then create instances of the concrete command classes and set them on the `Invoker` object using the `setCommand()` method. Finally, we execute the commands using the `executeCommand()` method on the `Invoker` object.
```java
public  class  Client {
	public static void main(String[] args) {
	    TextEditor textEditor = new TextEditor();
	    Invoker invoker = new Invoker();

	    // Create concrete command instances
	    Command copyCommand = new CopyCommand(textEditor);
	    Command pasteCommand = new PasteCommand(textEditor);
	    Command cutCommand = new CutCommand(textEditor);

	    // Set commands on invoker object
	    invoker.setCommand(copyCommand);
	    invoker.executeCommand();

	    invoker.setCommand(cutCommand);
	    invoker.executeCommand();

	    invoker.setCommand(pasteCommand);
	    invoker.executeCommand();
	}
}
```

In the above code, we create an instance of `TextEditor` and `Invoker` classes. We then create instances of the concrete command classes and set them on the `Invoker` object using the `setCommand()` method. Finally, we execute the commands using the `executeCommand()` method on the `Invoker` object.

When we run the `main()` method, it will output the following:
Command: Copy
Command: Cut
Command: Paste

As you can see, the `Invoker` object executes each command without knowing how the actual operations are performed by the receiver object. The receiver object, in this case, the `TextEditor` class, is encapsulated within the concrete command classes, which allows for flexibility and extensibility in the system.

This is just a simple example, but the Command pattern can be useful in a variety of scenarios where we need to decouple the requester from the receiver and provide a flexible and extensible way to perform actions in a system.