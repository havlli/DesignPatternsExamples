package behavioral.command.simpleexample;

public class TextEditor {
    private String clipboard;
    private String text;

    public void copy() {
        clipboard = text;
        System.out.println("Running copy command");
    }

    public void paste() {
        text += clipboard;
        System.out.println("Running paste command");
    }

    public void cut() {
        clipboard = text;
        text = "";
        System.out.println("Running cut command");
    }

    public void undo() {
        text = clipboard;
    }
}
