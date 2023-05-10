package behavioral.state.orderprocessing;

public class NewOrderState implements OrderState {
    @Override
    public void processOrder(Order order) {
        // Perform actions related to processing a new order
        System.out.println("Order is being processed...");
        order.setState(new InProcessOrderState());
    }
}
