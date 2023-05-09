package behavioral.observer.guiapplication;

public class ButtonClickLogger implements ClickListener {
    @Override
    public void onClick() {
        System.out.println("Button clicked! Logging to file...");
    }
}
