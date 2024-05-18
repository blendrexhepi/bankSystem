package bank;

public abstract class Transaction {
    protected double amount;
    protected String originatingAccountId;
    protected String resultingAccountId;
    protected String reason;

    public Transaction(double amount, String originatingAccountId, String resultingAccountId, String reason) {
        this.amount = amount;
        this.originatingAccountId = originatingAccountId;
        this.resultingAccountId = resultingAccountId;
        this.reason = reason;
    }

    public abstract void process(Bank bank) throws AccountNotFoundException, InsufficientFundsException;

    @Override
    public String toString() {
        return "Transaction [amount=$" + String.format("%.2f", amount) +
                ", originatingAccountId=" + originatingAccountId +
                ", resultingAccountId=" + resultingAccountId +
                ", reason=" + reason + "]";
    }
}
