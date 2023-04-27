package structural.bridge.guitoolkit;

// Concrete implementation
public class LinuxWindow implements Window {
    @Override
    public void drawButton() {
        System.out.println("Draw Button on Linux");
    }

    @Override
    public void drawTextBox() {
        System.out.println("Draw TextBox on Linux");
    }
}
