## Payment Gateways
In the context of payment gateways, the Bridge pattern can be used to separate the payment processing logic from the actual payment gateway implementation. This allows for greater flexibility in integrating different payment gateways into an application.

In this example, the `PaymentProcessor` interface represents the implementation hierarchy, and the `PaymentGateway` class represents the abstraction hierarchy. The `CreditCardGateway` class is a refined abstraction that uses the `PaymentProcessor` interface to process credit card payments. The `PaypalPaymentProcessor` class is a concrete implementation of the `PaymentProcessor` interface that uses the PayPal API to process credit card and PayPal payments. The Application class is the client that creates a `PaypalPaymentProcessor` object and a `CreditCardGateway` object, and calls the `processPayment()` method on the `CreditCardGateway` object.
```java
// Abstraction
public abstract class PaymentGateway {
    protected PaymentProcessor paymentProcessor;

    public PaymentGateway(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public abstract void processPayment(double amount);
}

// Refined Abstraction
public class CreditCardGateway extends PaymentGateway {
    public CreditCardGateway(PaymentProcessor paymentProcessor) {
        super(paymentProcessor);
    }

    public void processPayment(double amount) {
        paymentProcessor.processCreditCardPayment(amount);
    }
}

// Implementation
public interface PaymentProcessor {
    void processCreditCardPayment(double amount);
    void processPaypalPayment(double amount);
}

// Concrete Implementation
public class PaypalPaymentProcessor implements PaymentProcessor {
    public void processCreditCardPayment(double amount) {
        // process credit card payment using PayPal API
    }

    public void processPaypalPayment(double amount) {
        // process PayPal payment using PayPal API
    }
}

// Client
public class Application {
    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new PaypalPaymentProcessor();
        PaymentGateway creditCardGateway = new CreditCardGateway(paymentProcessor);
        creditCardGateway.processPayment(100.0);
    }
}
```