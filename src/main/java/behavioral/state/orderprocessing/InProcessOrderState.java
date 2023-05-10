package behavioral.state.orderprocessing;

public class InProcessOrderState implements OrderState {
    @Override
    public void processOrder(Order order) {
        // Perform actions related to processing order that is in progress
        System.out.println("Order is currently being processed...");
        order.setState(new ShippedOrderState());
    }
}
