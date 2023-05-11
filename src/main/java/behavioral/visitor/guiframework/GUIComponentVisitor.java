package behavioral.visitor.guiframework;


public interface GUIComponentVisitor {
    void visit(Button button);
    void visit(TextBox textBox);
    void visit(Menu menu);
}
