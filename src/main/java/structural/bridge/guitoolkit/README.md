## GUI Toolkit
In this example, the `Window` interface represents the implementation hierarchy, and the `Component` class represents the abstraction hierarchy. The `Button` class is a refined abstraction that uses the Window interface to draw a button. The `WindowsWindow` class is a concrete implementation of the `Window` interface that draws buttons and text boxes on the `Windows` platform. The `Application` class is the client that creates a `WindowsWindow` object and a `Button` object, and calls the `draw()` method on the `Button` object.

```java
// Abstraction
public abstract class Component {
    protected Window window;

    public Component(Window window) {
        this.window = window;
    }

    public abstract void draw();
}

// Refined Abstraction
public class Button extends Component {
    public Button(Window window) {
        super(window);
    }

    public void draw() {
        window.drawButton();
    }
}

// Implementation
public interface Window {
    void drawButton();
    void drawTextBox();
}

// Concrete Implementation
public class WindowsWindow implements Window {
    public void drawButton() {
        // draw button for Windows
    }

    public void drawTextBox() {
        // draw text box for Windows
    }
}

// Client
public class Application {
    public static void main(String[] args) {
        Window window = new WindowsWindow();
        Component button = new Button(window);
        button.draw();
    }
}
```