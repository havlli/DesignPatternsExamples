package creational.abstractfactory.uifactory;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Menu;

public interface UIFactory {
    Button createButton();
    Menu createMenu();
    Dialog createDialog();
}
