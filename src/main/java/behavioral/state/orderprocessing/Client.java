package behavioral.state.orderprocessing;

public class Client {
    public static void main(String[] args) {
        Order order = new Order();

        order.processOrder();
        order.processOrder();
        order.processOrder();
    }
}
