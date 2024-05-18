package bank;

public class Transfer extends Transaction {
    private boolean useFlatFee;

    public Transfer(double amount, String originatingAccountId, String resultingAccountId, String reason, boolean useFlatFee) {
        super(amount, originatingAccountId, resultingAccountId, reason);
        this.useFlatFee = useFlatFee;
    }

    @Override
    public void process(Bank bank) throws AccountNotFoundException, InsufficientFundsException {
        Account fromAccount = bank.findAccountById(originatingAccountId);
        Account toAccount = bank.findAccountById(resultingAccountId);
        double fee = useFlatFee ? bank.getTransactionFlatFee() : (amount * bank.getTransactionPercentFee() / 100);
        if (fromAccount.withdraw(amount + fee)) {
            toAccount.deposit(amount);
            bank.addTransactionFeeAmount(fee);
            bank.addTransferAmount(amount);
            System.out.println("Transfer successful. Fee: $" + String.format("%.2f", fee));
        } else {
            throw new InsufficientFundsException("Insufficient funds for transfer.");
        }
    }
}
