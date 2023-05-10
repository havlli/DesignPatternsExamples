package behavioral.strategy.paymentgateway;

public interface PaymentStrategy {
    boolean pay(double amount);
}
