package behavioral.visitor.guiframework;

public interface GUIComponent {
    void accept(GUIComponentVisitor visitor);
}
