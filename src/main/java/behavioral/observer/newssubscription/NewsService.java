package behavioral.observer.newssubscription;

import java.util.ArrayList;
import java.util.List;

public class NewsService implements Subject {
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
        observers.forEach(observer -> observer.update(news));
    }

    public void setNews(String news) {
        this.news = news;
        notifyObservers();
    }
}
