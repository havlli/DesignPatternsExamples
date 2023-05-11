package behavioral.visitor.guiframework;

public class Client {
    public static void main(String[] args) {
        GUIComponent[] components = {new Button(), new TextBox(), new Menu()};

        GUIComponentVisitor rendererVisitor = new GUIRendererVisitor();

        // Render all components
        for (GUIComponent guiComponent : components) {
            guiComponent.accept(rendererVisitor);
        }
    }
}
