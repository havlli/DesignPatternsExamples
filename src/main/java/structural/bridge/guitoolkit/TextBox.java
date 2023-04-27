package structural.bridge.guitoolkit;

// Refined abstraction
public class TextBox extends Component {
    public TextBox(Window window) {
        super(window);
    }

    @Override
    public void draw() {
        window.drawTextBox();
    }
}
