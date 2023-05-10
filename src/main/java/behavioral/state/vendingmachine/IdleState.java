package behavioral.state.vendingmachine;

public class IdleState implements VendingMachineState {
    private final VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }


    @Override
    public void insertCoin() {
        System.out.println("Coin inserted");
        vendingMachine.setCurrentState(new CoinInsertedState(vendingMachine));
    }

    @Override
    public void selectProduct() {
        System.out.println("Please insert a coin first!");
    }

    @Override
    public void dispense() {
        System.out.println("Please select a product first!");
    }
}
