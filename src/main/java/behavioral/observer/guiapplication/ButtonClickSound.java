package behavioral.observer.guiapplication;

public class ButtonClickSound implements ClickListener {
    @Override
    public void onClick() {
        System.out.println("Button clicked! Playing sound...");
    }
}
