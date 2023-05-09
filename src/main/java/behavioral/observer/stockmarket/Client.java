package behavioral.observer.stockmarket;

public class Client {
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
