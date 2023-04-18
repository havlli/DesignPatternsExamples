package creational.abstractfactory.uifactory;

public class LinuxMenu implements Menu {
    @Override
    public void show() {
        System.out.println("Linux menu shown!");
    }
}
