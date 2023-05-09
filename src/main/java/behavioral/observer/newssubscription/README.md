# News Subscription
Consider a newspaper publisher that provides a subscription service to its readers. When a new edition of the newspaper is published, it notifies its subscribers about it. In this case, the publisher acts as the subject and the subscribers act as observers. Whenever a new edition is published, the publisher notifies all its subscribers.
```java
import java.util.ArrayList;
import java.util.List;

interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

class NewsService implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String news;

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(news);
        }
    }

    public void setNews(String news) {
        this.news = news;
        notifyObservers();
    }
}

interface Observer {
    void update(String news);
}

class Subscriber implements Observer {
    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String news) {
        System.out.println(name + " received news: " + news);
    }
}

public class Client {
    public static void main(String[] args) {
        NewsService newsService = new NewsService();

        // Create subscribers
        Subscriber subscriber1 = new Subscriber("John");
        Subscriber subscriber2 = new Subscriber("Jane");

        // Register subscribers
        newsService.registerObserver(subscriber1);
        newsService.registerObserver(subscriber2);

        // Set news
        newsService.setNews("Breaking news: The sky is blue!");

        // Unregister a subscriber
        newsService.removeObserver(subscriber1);

        // Set news again
        newsService.setNews("Breaking news: The grass is green!");

        // Output:
        // John received news: Breaking news: The sky is blue!
        // Jane received news: Breaking news: The sky is blue!
        // Jane received news: Breaking news: The grass is green!
    }
}
```
In this example, `NewsService` is the `Subject` which maintains a list of `Observer` objects (`Subscriber` instances) and sends them updates whenever there's new news. The `Subscriber` receives updates from the `NewsService` and prints them to the console.

The `Client` class demonstrates how to use the Observer pattern by creating a `NewsService` object, registering subscribers, and setting news. When news is set, subscribers are notified and receive the update. In this example, John and Jane are subscribers and they receive updates about the news. Later, John unsubscribes and only Jane receives updates.