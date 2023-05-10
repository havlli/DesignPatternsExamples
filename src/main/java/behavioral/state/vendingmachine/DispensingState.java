package behavioral.state.vendingmachine;

public class DispensingState implements VendingMachineState {
    private final VendingMachine vendingMachine;

    public DispensingState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Coin already inserted!");
    }

    @Override
    public void selectProduct() {
        System.out.println("Product already selected!");
    }

    @Override
    public void dispense() {
        System.out.println("Product dispensed!");
        vendingMachine.setCurrentState(new IdleState(vendingMachine));
    }
}
