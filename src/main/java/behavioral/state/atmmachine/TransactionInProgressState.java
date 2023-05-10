package behavioral.state.atmmachine;

public class TransactionInProgressState implements ATMState {
    private ATM atm;

    public TransactionInProgressState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard() {
        System.out.println("Transaction in progress!");
    }

    @Override
    public void ejectCard() {
        System.out.println("Transaction in progress!");
    }

    @Override
    public void enterPIN(int pin) {
        System.out.println("Transaction in progress!");
    }

    @Override
    public void requestCash(int amount) {
        System.out.println("Transaction in progress!");
    }
}
