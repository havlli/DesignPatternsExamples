package creational.abstractfactory.uifactory;

public class Client {

    public static void main(String[] args) {
        Application app = new Application(new WindowsUIFactory());
        app.createUI();

        app = new Application(new MacUIFactory());
        app.createUI();

        app = new Application(new LinuxUIFactory());
        app.createUI();
    }
}
