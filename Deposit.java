package bank;

public class Deposit extends Transaction {
    public Deposit(double amount, String accountId, String reason) {
        super(amount, accountId, null, reason);
    }

    @Override
    public void process(Bank bank) throws AccountNotFoundException {
        Account account = bank.findAccountById(originatingAccountId);
        account.deposit(amount);
        System.out.println("Deposit successful. New balance: $" + String.format("%.2f", account.getBalance()));
    }
}
