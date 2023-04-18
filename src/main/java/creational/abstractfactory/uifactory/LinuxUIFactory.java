package creational.abstractfactory.uifactory;

public class LinuxUIFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new LinuxButton();
    }

    @Override
    public Menu createMenu() {
        return new LinuxMenu();
    }

    @Override
    public Dialog createDialog() {
        return new LinuxDialog();
    }
}
