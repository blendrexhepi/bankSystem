package bank;

public class Withdrawal extends Transaction {
    public Withdrawal(double amount, String accountId, String reason) {
        super(amount, accountId, null, reason);
    }

    @Override
    public void process(Bank bank) throws AccountNotFoundException, InsufficientFundsException {
        Account account = bank.findAccountById(originatingAccountId);
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful. New balance: $" + String.format("%.2f", account.getBalance()));
        } else {
            throw new InsufficientFundsException("Insufficient funds.");
        }
    }
}
