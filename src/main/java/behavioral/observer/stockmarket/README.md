# Stock Market
In the stock market, various stock prices change frequently, and investors need to stay updated on these changes. An investor can act as an observer and subscribe to receive updates from the stock market. Whenever there is a change in the stock price, the investor will receive a notification. In this case, the stock market acts as the subject and the investors act as observers.
```java
// Subject interface
interface StockMarket {
    void register(Investor observer);
    void unregister(Investor observer);
    void notifyObservers();
}

// Concrete Subject class
class StockMarketImpl implements StockMarket {
    private List<Investor> observers;
    private double stockPrice;

    public StockMarketImpl(double initialStockPrice) {
        observers = new ArrayList<>();
        stockPrice = initialStockPrice;
    }

    public void register(Investor observer) {
        observers.add(observer);
    }

    public void unregister(Investor observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Investor observer : observers) {
            observer.update(stockPrice);
        }
    }

    public void setStockPrice(double newStockPrice) {
        stockPrice = newStockPrice;
        notifyObservers();
    }
}

// Observer interface
interface Investor {
    void update(double stockPrice);
}

// Concrete Observer class
class InvestorImpl implements Investor {
    private String name;

    public InvestorImpl(String name) {
        this.name = name;
    }

    public void update(double stockPrice) {
        System.out.println(name + " received notification: Stock price is now " + stockPrice);
    }
}

// Client code
public class StockMarketDemo {
    public static void main(String[] args) {
        StockMarketImpl stockMarket = new StockMarketImpl(100.0);

        Investor john = new InvestorImpl("John");
        Investor jane = new InvestorImpl("Jane");

        stockMarket.register(john);
        stockMarket.register(jane);

        stockMarket.setStockPrice(110.0);
        stockMarket.setStockPrice(120.0);

        stockMarket.unregister(jane);

        stockMarket.setStockPrice(130.0);
    }
}
```
In this example, `StockMarket` acts as the subject, which maintains a list of investors who are observing the stock market. When the stock price changes, the subject notifies all of its observers by calling their `update` method. The `Investor` interface acts as the observer, which is implemented by the `InvestorImpl` class. The `StockMarketDemo` class acts as the client, which creates the subject and the observers, and registers the observers with the subject. When the stock price changes, the client sets the new stock price using the `setStockPrice` method on the subject, which in turn notifies all of its observers. Finally, the client unregisters one of the observers from the subject, and sets the stock price again to see that the unregistered observer no longer receives notifications.