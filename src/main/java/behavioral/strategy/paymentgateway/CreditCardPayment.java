package behavioral.strategy.paymentgateway;

public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String expiryDate;
    private String ccv;

    public CreditCardPayment(String cardNumber, String expiryDate, String ccv) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.ccv = ccv;
    }

    @Override
    public boolean pay(double amount) {
        // Process payment via credit card API
        System.out.println("Processing payment via credit card: " + amount);
        return true;
    }
}
