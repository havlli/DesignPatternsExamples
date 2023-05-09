package behavioral.observer.stockmarket;

// Subject/Observable Interface
public interface StockMarket {
    void register(Investor investor);
    void unregister(Investor investor);
    void notifyInvestors();
}
