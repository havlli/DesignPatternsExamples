package behavioral.state.atmmachine;

public interface ATMState {
    void insertCard();
    void ejectCard();
    void enterPIN(int pin);
    void requestCash(int amount);
}
