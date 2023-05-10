package behavioral.state.vendingmachine;

public interface VendingMachineState {
    void insertCoin();
    void selectProduct();
    void dispense();
}
