package behavioral.command.transactionalsystems;

// Concrete Command
public class DepositCommand implements Command {
    private Account account;
    private int amount;

    public DepositCommand(Account account, int amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute() {
        this.account.deposit(amount);
    }

    @Override
    public void undo() {
        this.account.revertDeposit(amount);
    }
}
