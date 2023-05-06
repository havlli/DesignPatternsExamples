package behavioral.command.guiaplication;

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
