package behavioral.strategy.paymentgateway;

public class PaypalPayment implements PaymentStrategy {
    private String email;
    private String password;

    public PaypalPayment(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public boolean pay(double amount) {
        // Process payment via PayPal API
        System.out.println("Processing payment via PayPal: " + amount);
        return true;
    }
}
