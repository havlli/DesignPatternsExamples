package behavioral.command.guiaplication;

public class PasteCommand implements Command {
    private Clipboard clipboard;
    private TextEditor textEditor;

    public PasteCommand(Clipboard clipboard, TextEditor textEditor) {
        this.clipboard = clipboard;
        this.textEditor = textEditor;
    }

    @Override
    public void execute() {
        textEditor.insert(clipboard.getContents());
    }
}
