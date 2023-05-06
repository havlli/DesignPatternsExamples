package behavioral.command.undoredooperations;

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
