package behavioral.command.simpleexample;

public class CutCommand implements Command {
    private TextEditor textEditor;

    public CutCommand(TextEditor textEditor) {
        this.textEditor = textEditor;
    }

    @Override
    public void execute() {
        textEditor.cut();
    }
}
