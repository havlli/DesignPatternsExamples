package creational.abstractfactory.uifactory;

public class LinuxDialog implements Dialog {
    @Override
    public void open() {
        System.out.println("Linux dialog opened!");
    }
}
