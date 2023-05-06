package behavioral.command.guiaplication;

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

        // Simulate user clicks on menu item
        saveMenuItem.click();
        copyMenuItem.click();
        pasteMenuItem.click();
    }
}
