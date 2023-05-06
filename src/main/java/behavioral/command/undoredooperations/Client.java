package behavioral.command.undoredooperations;

public class Client {
    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        textEditor.insert(0, "Hello ");
        textEditor.insert(6, "world");
        textEditor.print();

        textEditor.undo();
        textEditor.print();

        textEditor.redo();
        textEditor.print();

        textEditor.delete(0, 6);
        textEditor.print();

        textEditor.undo();
        textEditor.print();
    }
}
