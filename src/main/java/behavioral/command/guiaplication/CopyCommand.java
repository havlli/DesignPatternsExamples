package behavioral.command.guiaplication;

public class CopyCommand implements Command {
    private Clipboard clipboard;
    private TextEditor textEditor;

    public CopyCommand(Clipboard clipboard, TextEditor textEditor) {
        this.clipboard = clipboard;
        this.textEditor = textEditor;
    }

    @Override
    public void execute() {
        clipboard.copy(textEditor.getSelectedText());
    }
}
