package creational.abstractfactory.uifactory;

public class WindowsUIFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Menu createMenu() {
        return new WindowsMenu();
    }

    @Override
    public Dialog createDialog() {
        return new WindowsDialog();
    }
}
