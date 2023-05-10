package behavioral.state.orderprocessing;

public class ShippedOrderState implements OrderState {
    @Override
    public void processOrder(Order order) {
        // Perform action related to processing a shipped order
        System.out.println("Order has been shipped");
    }
}
