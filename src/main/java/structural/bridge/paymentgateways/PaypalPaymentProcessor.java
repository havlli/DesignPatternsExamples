package structural.bridge.paymentgateways;

// Concrete implementation
public class PaypalPaymentProcessor implements PaymentProcessor {
    @Override
    public void processCreditCardPayment(double amount) {
        System.out.println("Processing " + amount + " credit card payment using PayPal API");
    }

    @Override
    public void processAccountPayment(double amount) {
        System.out.println("Processing " + amount + " account payment using PayPal API");
    }
}
