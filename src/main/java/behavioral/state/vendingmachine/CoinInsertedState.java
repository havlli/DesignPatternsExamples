package behavioral.state.vendingmachine;

public class CoinInsertedState implements VendingMachineState {
    private final VendingMachine vendingMachine;

    public CoinInsertedState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Coin already inserted!");
    }

    @Override
    public void selectProduct() {
        System.out.println("Product selected");
        vendingMachine.setCurrentState(new DispensingState(vendingMachine));
    }

    @Override
    public void dispense() {
        System.out.println("Please select a product first!");
    }
}
