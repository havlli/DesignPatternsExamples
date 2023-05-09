package behavioral.observer.stockmarket;

import java.util.ArrayList;
import java.util.List;

// Concrete subject/observable
public class StockMarketImpl implements StockMarket {
    private List<Investor> investorList = new ArrayList<>();
    private double stockPrice;

    public StockMarketImpl(double initialStockPrice) {
        this.investorList = new ArrayList<>();
        this.stockPrice = initialStockPrice;
    }

    @Override
    public void register(Investor investor) {
        investorList.add(investor);
    }

    @Override
    public void unregister(Investor investor) {
        investorList.remove(investor);
    }

    @Override
    public void notifyInvestors() {
        investorList.forEach(investor -> investor.update(stockPrice));
    }

    public void setStockPrice(double newStockPrice) {
        this.stockPrice = newStockPrice;
        notifyInvestors();
    }
}
