package behavioral.observer.guiapplication;

public class Client {
    public static void main(String[] args) {
        Button button = new Button();
        ClickListener logger = new ButtonClickLogger();
        ClickListener sound = new ButtonClickSound();
        button.addClickListener(logger);
        button.addClickListener(sound);

        button.click();
    }
}
