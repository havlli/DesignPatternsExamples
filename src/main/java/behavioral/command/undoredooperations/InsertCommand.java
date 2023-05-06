package behavioral.command.undoredooperations;

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
