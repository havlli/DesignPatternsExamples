package creational.abstractfactory.uifactory;

public class LinuxButton implements Button {
    @Override
    public void paint() {
        System.out.println("Linux button drawn!");
    }
}
