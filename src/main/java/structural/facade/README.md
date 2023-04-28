# Facade Pattern
The Facade design pattern is a structural design pattern that provides a simplified interface to a complex system of classes, making it easier to use and reducing the dependencies between the client code and the subsystems it uses.

In simpler terms, the Facade pattern hides the complexity of a system by providing a simplified interface that shields the client code from the underlying implementation details. It's a useful pattern when you have a complex system that's difficult to understand, and you want to provide a simplified interface for clients to use.

### Example of Facade
Let's say you are building an e-commerce website that sells products online. The website has various subsystems such as the user authentication system, the product catalog, the shopping cart system, and the payment gateway.

The client code needs to interact with each subsystem to perform specific tasks such as adding a product to the cart, processing the payment, etc.

Without the Facade pattern, the client code would have to interact with each subsystem separately, which could be complex and error-prone. However, with the Facade pattern, we can create a simplified interface that hides the complexity of the subsystems and provides a single point of contact for the client code.
```java
public class EcommerceFacade {
    private AuthenticationSystem authSystem;
    private ProductCatalog productCatalog;
    private ShoppingCartSystem shoppingCart;
    private PaymentGateway paymentGateway;

    public EcommerceFacade() {
        this.authSystem = new AuthenticationSystem();
        this.productCatalog = new ProductCatalog();
        this.shoppingCart = new ShoppingCartSystem();
        this.paymentGateway = new PaymentGateway();
    }

    public void addToCart(User user, Product product) {
        if (authSystem.isAuthenticated(user)) {
            productCatalog.addToCart(product, shoppingCart);
        }
    }

    public void checkout(User user) {
        if (authSystem.isAuthenticated(user)) {
            paymentGateway.processPayment(shoppingCart.getTotal());
            shoppingCart.clearCart();
        }
    }
}
```
In this example, we've created a Facade class called `EcommerceFacade` that provides a simplified interface for the e-commerce website. The `EcommerceFacade` class hides the complexity of the subsystems and provides two methods for the client code to use - `addToCart` and `checkout`.

The `addToCart` method adds a product to the shopping cart if the user is authenticated. The `checkout` method processes the payment and clears the cart if the user is authenticated.

Now the client code only needs to create an instance of the `EcommerceFacade` class and call the `addToCart` and `checkout` methods:
```java
public class Client {
    public static void main(String[] args) {
        EcommerceFacade ecommerce = new EcommerceFacade();
        User user = new User("john.doe@example.com", "password");
        Product product = new Product("iPhone 13", 999.99);
        ecommerce.addToCart(user, product);
        ecommerce.checkout(user);
    }
}
```
This code is much more convenient for the client because it only needs to interact with the `EcommerceFacade` class. Additionally, the client code is decoupled from the subsystems, which makes it easier to modify the subsystems without affecting the client code.