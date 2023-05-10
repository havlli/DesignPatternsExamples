# ATM Machine
ATM machines can use the state pattern to model their behavior. The machine can have different states, such as "idle", "card inserted", "PIN entered", "transaction in progress", and "transaction complete". Depending on the current state, the machine will behave differently when a user inserts their card or enters their PIN. By using the state pattern, the ATM machine's behavior can be easily modified or extended.
```java
public interface ATMState {
    void insertCard();

    void ejectCard();

    void enterPIN(int pin);

    void requestCash(int amount);
}

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

public class CardInsertedState implements ATMState {
    private ATM atm;

    public CardInsertedState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard() {
        System.out.println("Card already inserted!");
    }

    @Override
    public void ejectCard() {
        System.out.println("Card ejected!");
        atm.setState(new IdleState(atm));
    }

    @Override
    public void enterPIN(int pin) {
        System.out.println("PIN entered");
        atm.setState(new PINEnteredState(atm));
    }

    @Override
    public void requestCash(int amount) {
        System.out.println("Enter PIN first!");
    }
}

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
```
In this example, the `ATM` class acts as the context that maintains the current state of the ATM machine. The different states that the machine can be in are represented by the `ATMState` interface and its implementations (`IdleState`, `CardInsertedState`, etc.).

When the user interacts with the ATM machine (e.g., inserting a card, entering a PIN), the `ATM` class delegates the handling of the interaction to the current state object. Each state object handles the interaction differently based on its current state and the action performed, and can transition the `ATM` object to a new state if necessary.

Overall, the state pattern provides a flexible and modular way to represent complex state transitions in a system like an ATM machine.