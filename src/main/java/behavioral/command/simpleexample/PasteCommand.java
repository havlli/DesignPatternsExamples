package behavioral.command.simpleexample;

public class PasteCommand implements Command {
    private TextEditor textEditor;

    public PasteCommand(TextEditor textEditor) {
        this.textEditor = textEditor;
    }

    @Override
    public void execute() {
        textEditor.paste();
    }
}
