package structural.bridge.guitoolkit;

// Abstraction
public abstract class Component {
    protected Window window;

    public Component(Window window) {
        this.window = window;
    }

    public abstract void draw();
}
