package creational.abstractfactory.uifactory;

public class WindowsDialog implements Dialog {
    @Override
    public void open() {
        System.out.println("Windows dialog opened!");
    }
}
