package behavioral.command.transactionalsystems;

public class Client {
    public static void main(String[] args) {
        Account account = new Account(500);
        TransactionManager transactionManager = new TransactionManager();

        // Deposit 100 and then withdraw 200
        transactionManager.execute(new DepositCommand(account, 100));
        transactionManager.execute(new WithdrawCommand(account, 200));

        // Rollback
        transactionManager.rollback();
    }
}
