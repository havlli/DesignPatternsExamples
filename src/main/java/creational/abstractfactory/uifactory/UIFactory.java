package creational.abstractfactory.uifactory;

public interface UIFactory {
    Button createButton();
    Menu createMenu();
    Dialog createDialog();
}
