package structural.bridge.paymentgateways;

// Abstraction
public abstract class PaymentGateway {
    protected PaymentProcessor paymentProcessor;

    public PaymentGateway(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public abstract void processPayment(double amount);
}
