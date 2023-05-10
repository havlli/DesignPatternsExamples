# Payment Gateway
In this system, there are multiple payment gateways that the system can use to process payments, and each gateway may use a different algorithm for processing payments.

To implement the Strategy Pattern, we create an interface called `PaymentStrategy` that defines the method `pay()`. We then create concrete implementations of this interface for each payment gateway that the system supports, such as `PayPalPayment` and `CreditCardPayment`.

Next, we create a `Payment` class that takes in a `PaymentStrategy` object and uses it to process a payment. This `Payment` class is responsible for setting the appropriate `PaymentStrategy` object based on the user's selection.

By using the Strategy Pattern, we can easily swap out different payment strategies at runtime without having to modify the `Payment` class. This makes the system more flexible and easier to maintain.
```java
public interface PaymentStrategy {
    boolean pay(double amount);
}

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

public class Payment {
    private PaymentStrategy paymentStrategy;

    public Payment(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public boolean processPayment(double amount) {
        return paymentStrategy.pay(amount);
    }
}
```