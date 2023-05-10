package behavioral.state.atmmachine;

public class PINEnteredState implements ATMState {
    private ATM atm;

    public PINEnteredState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard() {
        System.out.println("Card already inserted!");
    }

    @Override
    public void ejectCard() {
        System.out.println("Card ejected");
        atm.setState(new IdleState(atm));
    }

    @Override
    public void enterPIN(int pin) {
        System.out.println("PIN already entered!");
    }

    @Override
    public void requestCash(int amount) {
        System.out.println("Cash requested: " + amount);
        atm.setState(new TransactionInProgressState(atm));
    }
}
