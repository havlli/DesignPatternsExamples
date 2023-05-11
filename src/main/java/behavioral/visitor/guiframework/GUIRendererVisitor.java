package behavioral.visitor.guiframework;

public class GUIRendererVisitor implements GUIComponentVisitor {
    @Override
    public void visit(Button button) {
        button.draw();
    }

    @Override
    public void visit(TextBox textBox) {
        textBox.draw();
    }

    @Override
    public void visit(Menu menu) {
        menu.draw();
    }
}
