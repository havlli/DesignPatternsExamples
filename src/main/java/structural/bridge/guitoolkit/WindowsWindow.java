package structural.bridge.guitoolkit;

// Concrete Implementation
public class WindowsWindow implements Window {
    @Override
    public void drawButton() {
        System.out.println("Draw Button on windows");
    }

    @Override
    public void drawTextBox() {
        System.out.println("Draw TextBox on windows");
    }
}
