package creational.abstractfactory.uifactory;

public class MacDialog implements Dialog {
    @Override
    public void open() {
        System.out.println("Mac dialog opened!");
    }
}
