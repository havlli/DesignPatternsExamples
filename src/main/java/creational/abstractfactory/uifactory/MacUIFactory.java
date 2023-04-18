package creational.abstractfactory.uifactory;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Menu;

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
