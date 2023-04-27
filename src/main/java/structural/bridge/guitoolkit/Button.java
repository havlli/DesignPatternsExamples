package structural.bridge.guitoolkit;

// Refined abstraction
public class Button extends Component {
    public Button(Window window) {
        super(window);
    }

    @Override
    public void draw() {
        window.drawButton();
    }
}
