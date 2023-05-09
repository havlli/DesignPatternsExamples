# GUI Application
In graphical user interfaces (GUIs), the Observer pattern is used extensively. Consider a scenario where a user interacts with a GUI by clicking on various buttons. Each button is an observer that listens for user clicks. Whenever a user clicks on a button, the button notifies all its subscribers (i.e., the listeners) that it has been clicked.
```java
import java.util.ArrayList;
import java.util.List;

class Button {
    private List<ClickListener> clickListeners = new ArrayList<>();

    public void addClickListener(ClickListener listener) {
        clickListeners.add(listener);
    }

    public void removeClickListener(ClickListener listener) {
        clickListeners.remove(listener);
    }

    public void click() {
        System.out.println("Button clicked!");
        notifyClickListeners();
    }

    private void notifyClickListeners() {
        for (ClickListener listener : clickListeners) {
            listener.onClick();
        }
    }
}

interface ClickListener {
    void onClick();
}

class ButtonClickLogger implements ClickListener {
    @Override
    public void onClick() {
        System.out.println("Button clicked! Logging to file...");
        // code to log button click to file
    }
}

class ButtonClickSound implements ClickListener {
    @Override
    public void onClick() {
        System.out.println("Button clicked! Playing sound...");
        // code to play sound when button is clicked
    }
}

public class Client {
    public static void main(String[] args) {
        Button button = new Button();
        ClickListener logger = new ButtonClickLogger();
        ClickListener sound = new ButtonClickSound();
        button.addClickListener(logger);
        button.addClickListener(sound);

        // simulate user clicking button
        button.click();
    }
}
```
In this example, the `Button` class acts as the subject and the `ClickListener` interface acts as the observer. The `Button` class has a list of `clickListeners` that it notifies whenever the button is clicked. The `ClickListener` interface has a single method `onClick()` that is implemented by the `ButtonClickLogger` and `ButtonClickSound` classes.

When the `Button` is clicked, it first prints a message to the console and then calls the `notifyClickListeners()` method, which loops through all the `clickListeners` and calls the `onClick()` method for each one. In the `main()` method, we create a `Button` object and add two listeners (`logger` and `sound`). We then simulate a user clicking the button by calling the `click()` method on the `Button` object.

When the `Button` is clicked, both listeners (`logger` and `sound`) are notified and perform their respective actions (i.e., log the click to a file and play a sound).