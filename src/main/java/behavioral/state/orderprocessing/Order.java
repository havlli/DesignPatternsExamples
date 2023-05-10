package behavioral.state.orderprocessing;

public class Order {
    private OrderState orderState;

    public Order() {
        orderState = new NewOrderState();
    }

    public void setState(OrderState orderState) {
        this.orderState = orderState;
    }

    public void processOrder() {
        orderState.processOrder(this);
    }

    // other methods related to order processing
}
