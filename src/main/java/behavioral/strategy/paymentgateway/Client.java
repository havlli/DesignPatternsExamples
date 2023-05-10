package behavioral.strategy.paymentgateway;

public class Client {
    public static void main(String[] args) {
        Payment paypalPayment = new Payment(new PaypalPayment("text@text.com","12345"));
        paypalPayment.processPayment(100);

        Payment creditCardPayment = new Payment(new CreditCardPayment("123","123","123"));
        creditCardPayment.processPayment(250);
    }
}
