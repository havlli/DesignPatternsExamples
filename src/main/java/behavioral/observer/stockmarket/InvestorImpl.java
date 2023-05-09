package behavioral.observer.stockmarket;

// Concrete observer
public class InvestorImpl implements Investor {
    private String name;

    public InvestorImpl(String name) {
        this.name = name;
    }

    @Override
    public void update(double stockPrice) {
        System.out.println(name + " received notification: Stock price is now " + stockPrice);
    }
}
