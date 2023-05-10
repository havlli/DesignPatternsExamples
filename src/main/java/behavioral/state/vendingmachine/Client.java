package behavioral.state.vendingmachine;

public class Client {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.dispense();
        vendingMachine.selectProduct();

        vendingMachine.insertCoin();
        vendingMachine.dispense();
        vendingMachine.selectProduct();
        vendingMachine.dispense();
    }
}
