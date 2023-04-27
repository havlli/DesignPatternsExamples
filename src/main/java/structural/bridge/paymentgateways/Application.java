package structural.bridge.paymentgateways;

// Client
public class Application {

    public static void main(String[] args) {
        PaymentProcessor paypalPaymentProcessor = new PaypalPaymentProcessor();
        PaymentGateway creditCardPaypalGateway = new CreditCardGateway(paypalPaymentProcessor);
        PaymentGateway accountPaypalGateway = new AccountPaymentGateway(paypalPaymentProcessor);

        creditCardPaypalGateway.processPayment(500);
        accountPaypalGateway.processPayment(500);

        PaymentProcessor skrillPaymentProcessor = new SkrillPaymentProcessor();
        PaymentGateway accountSkrillGateway = new AccountPaymentGateway(skrillPaymentProcessor);
        PaymentGateway creditCardSkrillGateway = new CreditCardGateway(skrillPaymentProcessor);

        accountSkrillGateway.processPayment(50);
        creditCardSkrillGateway.processPayment(50);

    }
}
