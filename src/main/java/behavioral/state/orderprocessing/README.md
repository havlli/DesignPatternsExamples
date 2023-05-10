# Order Processing
In this example, the `Order` class represents an order that can be in different states during its lifecycle. The `OrderState` interface defines the methods that are required to process the order in different states. The `NewOrderState`, `InProcessOrderState`, and `ShippedOrderState` classes implement the `OrderState` interface and define the behavior required to process an order in each state.
```java
public class Order {
    private OrderState state;

    public Order() {
        state = new NewOrderState();
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public void processOrder() {
        state.processOrder(this);
    }

    // other methods related to order processing...
}

public interface OrderState {
    void processOrder(Order order);
}

public class NewOrderState implements OrderState {
    public void processOrder(Order order) {
        // Perform actions related to processing a new order
        System.out.println("Order is being processed...");
        order.setState(new InProcessOrderState());
    }
}

public class InProcessOrderState implements OrderState {
    public void processOrder(Order order) {
        // Perform actions related to processing an order that is in progress
        System.out.println("Order is currently being processed...");
        order.setState(new ShippedOrderState());
    }
}

public class ShippedOrderState implements OrderState {
    public void processOrder(Order order) {
        // Perform actions related to processing a shipped order
        System.out.println("Order has been shipped.");
    }
}
```
The `Order` class maintains a reference to the current state of the order and delegates the processing of the order to the current state object. Whenever the order is processed, the `processOrder()` method is called, which in turn calls the `processOrder()` method of the current state object. Depending on the current state of the order, the state may be changed to a different state by calling the `setState()` method.

In this way, the State pattern allows us to model complex state transitions in an organized and structured way, making it easier to maintain and modify the code over time.