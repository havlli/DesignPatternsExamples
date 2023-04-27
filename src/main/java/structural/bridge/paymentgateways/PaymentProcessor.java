package structural.bridge.paymentgateways;

// Implementation
public interface PaymentProcessor {
    void processCreditCardPayment(double amount);
    void processAccountPayment(double amount);
}
