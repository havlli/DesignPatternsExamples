package creational.abstractfactory.uifactory;

public class Application {
    private UIFactory uiFactory;

    public Application(UIFactory uiFactory) {
        this.uiFactory = uiFactory;
    }

    public void createUI() {
        Button button = uiFactory.createButton();
        Menu menu = uiFactory.createMenu();
        Dialog dialog = uiFactory.createDialog();

        button.paint();
        menu.show();
        dialog.open();
    }
}
