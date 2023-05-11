package behavioral.visitor.guiframework;

public class Button implements GUIComponent {
    @Override
    public void accept(GUIComponentVisitor visitor) {
        visitor.visit(this);
    }

    // Methods specific to button
    public void draw() {
        System.out.println("Drawing button...");
    }
}
