package behavioral.state.atmmachine;

public class Client {
    public static void main(String[] args) {
        ATM atm = new ATM();

        atm.ejectCard();
        atm.insertCard();
        atm.requestCash(100);
        atm.enterPin(1234);
        atm.requestCash(100);
        atm.ejectCard();
    }
}
