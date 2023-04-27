package structural.bridge.paymentgateways;

// Concrete Implementation
public class SkrillPaymentProcessor implements PaymentProcessor {
    @Override
    public void processCreditCardPayment(double amount) {
        System.out.println("Processing " + amount + " credit card payment using Skrill API");
    }

    @Override
    public void processAccountPayment(double amount) {
        System.out.println("Processing " + amount + " account payment using Skrill API");
    }
}
