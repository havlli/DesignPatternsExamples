package behavioral.command.simpleexample;

public class Client {

    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        Invoker invoker = new Invoker();

        Command copyCommand = new CopyCommand(textEditor);
        Command pasteCommand = new PasteCommand(textEditor);
        Command cutCommand = new CutCommand(textEditor);

        invoker.setCommand(copyCommand);
        invoker.executeCommand();

        invoker.setCommand(pasteCommand);
        invoker.executeCommand();

        invoker.setCommand(cutCommand);
        invoker.executeCommand();
    }
}
