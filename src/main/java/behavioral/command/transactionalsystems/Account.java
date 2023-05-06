package behavioral.command.transactionalsystems;

// Receiver
public class Account {
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public void deposit(int amount) {
        this.balance += amount;
        System.out.println("Deposited " + amount + ", Balance: " + this.balance);
    }

    public void withdraw(int amount) {
        if (this.balance < amount) {
            System.out.println("Insufficient balance, Balance: " + this.balance);
            return;
        }
        this.balance -= amount;
        System.out.println("Withdrawn " + amount + ", Balance: " + this.balance);
    }

    public void revertDeposit(int amount) {
        this.balance -= amount;
        System.out.println("Deposit Reverted " + amount + ", Balance: " + this.balance);
    }

    public void revertWithdrawal(int amount) {
        this.balance += amount;
        System.out.println("Withdrawal Reverted " + amount + ", Balance: " + this.balance);
    }
}
