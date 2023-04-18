package creational.abstractfactory.uifactory;

public class MacUIFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Menu createMenu() {
        return new MacMenu();
    }

    @Override
    public Dialog createDialog() {
        return new MacDialog();
    }
}
