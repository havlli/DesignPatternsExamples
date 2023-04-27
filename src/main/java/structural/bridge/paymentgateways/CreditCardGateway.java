package structural.bridge.paymentgateways;

// Refined Abstraction
public class CreditCardGateway extends PaymentGateway {
    public CreditCardGateway(PaymentProcessor paymentProcessor) {
        super(paymentProcessor);
    }

    @Override
    public void processPayment(double amount) {
        paymentProcessor.processCreditCardPayment(amount);
    }
}
