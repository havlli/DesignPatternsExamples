package behavioral.state.atmmachine;

public class IdleState implements ATMState {
    private ATM atm;

    public IdleState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard() {
        System.out.println("Card inserted!");
        atm.setState(new CardInsertedState(atm));
    }

    @Override
    public void ejectCard() {
        System.out.println("No card to eject!");
    }

    @Override
    public void enterPIN(int pin) {
        System.out.println("Insert card first!");
    }

    @Override
    public void requestCash(int amount) {
        System.out.println("Insert card first!");
    }
}
