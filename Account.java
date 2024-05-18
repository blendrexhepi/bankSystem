package bank;

public class Account {
    private String accountId;
    private String name;
    private double balance;

    public Account(String accountId, String name, double initialBalance) {
        this.accountId = accountId;
        this.name = name;
        this.balance = initialBalance;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal.");
        }
        balance -= amount;
        return true;
    }

    @Override
    public String toString() {
        return "Account ID: " + accountId + ", Name: " + name + ", Balance: $" + String.format("%.2f", balance);
    }
}
