package behavioral.command.transactionalsystems;

// Concrete Command
public class WithdrawCommand implements Command {
    private Account account;
    private int amount;

    public WithdrawCommand(Account account, int amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute() {
        this.account.withdraw(this.amount);
    }

    @Override
    public void undo() {
        this.account.revertWithdrawal(this.amount);
    }
}
