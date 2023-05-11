package behavioral.visitor.guiframework;

public class Menu implements GUIComponent {
    @Override
    public void accept(GUIComponentVisitor visitor) {
        visitor.visit(this);
    }

    // Methods specific to Menu
    public void draw() {
        System.out.println("Drawing menu....");
    }
}
