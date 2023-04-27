package structural.bridge.paymentgateways;

// Refined abstraction
public class AccountPaymentGateway extends PaymentGateway {
    public AccountPaymentGateway(PaymentProcessor paymentProcessor) {
        super(paymentProcessor);
    }

    @Override
    public void processPayment(double amount) {
        paymentProcessor.processAccountPayment(amount);
    }
}
