package creational.abstractfactory.uifactory;

public class MacButton implements Button {
    @Override
    public void paint() {
        System.out.println("Mac button drawn!");
    }
}
