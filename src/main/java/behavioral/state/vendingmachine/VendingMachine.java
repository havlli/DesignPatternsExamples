package behavioral.state.vendingmachine;

public class VendingMachine {
    private VendingMachineState currentState;

    public VendingMachine() {
        this.currentState = new IdleState(this);
    }

    public void insertCoin() {
        currentState.insertCoin();
    }

    public void selectProduct() {
        currentState.selectProduct();
    }

    public void dispense() {
        currentState.dispense();
    }

    public void setCurrentState(VendingMachineState state) {
        this.currentState = state;
    }
}
