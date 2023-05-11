package behavioral.visitor.guiframework;

public class TextBox implements GUIComponent {
    @Override
    public void accept(GUIComponentVisitor visitor) {
        visitor.visit(this);
    }

    // Methods specific to textBox
    public void draw() {
        System.out.println("Drawing textBox...");
    }
}
