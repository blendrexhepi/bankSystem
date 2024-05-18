package bank;

import java.util.*;

public class Bank {
    private double transactionFlatFee;
    private double transactionPercentFee;
    private List<Account> accounts;
    private List<Transaction> transactions;
    private double totalTransactionFeeAmount;
    private double totalTransferAmount;

    public Bank(String bankName, double transactionFlatFee, double transactionPercentFee) {
        this.transactionFlatFee = transactionFlatFee;
        this.transactionPercentFee = transactionPercentFee;
        this.accounts = new ArrayList<>();
        this.transactions = new ArrayList<>();
        this.totalTransactionFeeAmount = 0.0;
        this.totalTransferAmount = 0.0;
    }

    public void createAccount(String accountId, String name, double initialBalance) {
        Account account = new Account(accountId, name, initialBalance);
        accounts.add(account);
        System.out.println("Account created: " + account);
    }

    public void addTransaction(Transaction transaction) throws AccountNotFoundException, InsufficientFundsException {
        transactions.add(transaction);
        transaction.process(this);
    }

    public Account findAccountById(String accountId) throws AccountNotFoundException {
        for (Account account : accounts) {
            if (account.getAccountId().equals(accountId)) {
                return account;
            }
        }
        throw new AccountNotFoundException("Account with ID " + accountId + " not found.");
    }

    public double getTransactionFlatFee() {
        return transactionFlatFee;
    }

    public double getTransactionPercentFee() {
        return transactionPercentFee;
    }

    public void addTransactionFeeAmount(double amount) {
        totalTransactionFeeAmount += amount;
    }

    public void addTransferAmount(double amount) {
        totalTransferAmount += amount;
    }

    public void listTransactions(String accountId) {
        try {
            Account account = findAccountById(accountId);
            System.out.println("Transactions for account ID " + accountId + ":");
            for (Transaction transaction : transactions) {
                if (transaction.toString().contains(accountId)) {
                    System.out.println(transaction);
                }
            }
        } catch (AccountNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void checkAccountBalance(String accountId) {
        try {
            Account account = findAccountById(accountId);
            System.out.println("Account balance for " + account.getName() + ": $" + String.format("%.2f", account.getBalance()));
        } catch (AccountNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void listAccounts() {
        System.out.println("Accounts in the bank:");
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    public void checkTotalTransactionFeeAmount() {
        System.out.println("Total transaction fee amount: $" + String.format("%.2f", totalTransactionFeeAmount));
    }

    public void checkTotalTransferAmount() {
        System.out.println("Total transfer amount: $" + String.format("%.2f", totalTransferAmount));
    }
}
