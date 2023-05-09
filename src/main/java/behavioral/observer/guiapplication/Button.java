package behavioral.observer.guiapplication;

import java.util.ArrayList;
import java.util.List;

public class Button {
    private List<ClickListener> clickListeners = new ArrayList<>();

    public void addClickListener(ClickListener clickListener) {
        clickListeners.add(clickListener);
    }

    public void removeClickListener(ClickListener clickListener) {
        clickListeners.remove(clickListener);
    }

    public void click() {
        System.out.println("Button clicked");
        notifyClickListeners();
    }

    public void notifyClickListeners() {
        clickListeners.forEach(ClickListener::onClick);
    }


}
