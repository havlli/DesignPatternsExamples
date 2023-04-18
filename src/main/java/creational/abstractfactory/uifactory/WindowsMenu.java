package creational.abstractfactory.uifactory;

public class WindowsMenu implements Menu {
    @Override
    public void show() {
        System.out.println("Windows menu shown!");
    }
}
