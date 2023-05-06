# Transactional Operations
In a transactional system, a set of operations is grouped together as a single transaction, which must either complete entirely or roll back completely if any operation fails. The Command pattern is well-suited for implementing transactional systems, as it allows a set of related operations to be grouped together and executed as a single unit.

In this example, `Command` is an interface that defines the methods for executing and undoing a command. The `DepositCommand` and `WithdrawCommand` classes are concrete implementations of the `Command` interface, representing the deposit and withdraw operations on an `Account`. The `TransactionManager` class is the invoker that manages the commands and ensures that they are executed as a single transaction.

When a command is executed, it is added to the `commandStack` stack. If any command in the transaction fails, the `rollback()` method is called to undo all commands in the stack. The `rollback()` method pops commands off the stack and calls their `undo()` methods to undo their effects.

Using the Command pattern in this way ensures that a set of operations can be grouped together as a single transaction, and that the entire transaction can be rolled back if any operation fails.
```java
// Receiver
class Account {
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

// Command interface
interface Command {
    void execute();
    void undo();
}

// Concrete Command
class DepositCommand implements Command {
    private Account account;
    private int amount;
    
    public DepositCommand(Account account, int amount) {
        this.account = account;
        this.amount = amount;
    }
    
    public void execute() {
        this.account.deposit(this.amount);
    }
    
    public void undo() {
        this.account.revertDeposit(this.amount);
    }
}

// Concrete Command
class WithdrawCommand implements Command {
    private Account account;
    private int amount;
    
    public WithdrawCommand(Account account, int amount) {
        this.account = account;
        this.amount = amount;
    }
    
    public void execute() {
        this.account.withdraw(this.amount);
    }
    
    public void undo() {
        this.account.revertWithdrawal(this.amount);
    }
}

// Invoker
class TransactionManager {
    private Stack<Command> commandStack;
    
    public TransactionManager() {
        this.commandStack = new Stack<>();
    }
    
    public void execute(Command command) {
        command.execute();
        this.commandStack.push(command);
    }
    
    public void rollback() {
        while (!this.commandStack.isEmpty()) {
            Command command = this.commandStack.pop();
            command.undo();
        }
    }
}

// Client
public class Client {
    public static void main(String[] args) {
        Account account = new Account(500);
        TransactionManager manager = new TransactionManager();
        
        // Deposit 100 and then withdraw 200
        manager.execute(new DepositCommand(account, 100));
        manager.execute(new WithdrawCommand(account, 200));
        
        // Rollback
        manager.rollback();
    }
}
```
