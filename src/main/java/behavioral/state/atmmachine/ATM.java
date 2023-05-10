package behavioral.state.atmmachine;

public class ATM {
    private ATMState currentState;

    public ATM() {
        currentState = new IdleState(this);
    }

    public void setState(ATMState state) {
        currentState = state;
    }

    public void insertCard() {
        currentState.insertCard();
    }

    public void ejectCard() {
        currentState.ejectCard();
    }

    public void enterPin(int pin) {
        currentState.enterPIN(pin);
    }

    public void requestCash(int amount) {
        currentState.requestCash(amount);
    }
}
