package structural.bridge.guitoolkit;

// Client
public class Application {

    public static void main(String[] args) {
        Window window = new WindowsWindow();
        Component windowsButton = new Button(window);
        windowsButton.draw();

        Component windowsTextBox = new TextBox(window);
        windowsTextBox.draw();

        window = new LinuxWindow();
        Component linuxButton = new Button(window);
        linuxButton.draw();

        Component linuxTextBox = new TextBox(window);
        linuxTextBox.draw();
    }
}
