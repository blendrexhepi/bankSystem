package bank;

import java.util.Scanner;

public class BankSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter bank name:");
        String bankName = scanner.nextLine();
        System.out.println("Enter transaction flat fee:");
        double transactionFlatFee = scanner.nextDouble();
        System.out.println("Enter transaction percent fee:");
        double transactionPercentFee = scanner.nextDouble();

        Bank bank = new Bank(bankName, transactionFlatFee, transactionPercentFee);

        boolean running = true;
        while (running) {
            System.out.println("\nBank System Menu:");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. List Transactions");
            System.out.println("6. Check Account Balance");
            System.out.println("7. List Accounts");
            System.out.println("8. Check Total Transaction Fee Amount");
            System.out.println("9. Check Total Transfer Amount");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            try {
                switch (choice) {
                    case 1:
                        System.out.println("Enter account ID:");
                        String accountId = scanner.nextLine();
                        System.out.println("Enter account holder name:");
                        String name = scanner.nextLine();
                        System.out.println("Enter initial balance:");
                        double initialBalance = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline
                        bank.createAccount(accountId, name, initialBalance);
                        System.out.println("Account created successfully.");
                        break;
                    case 2:
                        System.out.println("Enter account ID:");
                        String depositAccountId = scanner.nextLine();
                        System.out.println("Enter deposit amount:");
                        double depositAmount = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline
                        bank.addTransaction(new Deposit(depositAmount, depositAccountId, "Deposit"));
                        System.out.println("Deposit successful.");
                        break;
                    case 3:
                        System.out.println("Enter account ID:");
                        String withdrawAccountId = scanner.nextLine();
                        System.out.println("Enter withdrawal amount:");
                        double withdrawAmount = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline
                        bank.addTransaction(new Withdrawal(withdrawAmount, withdrawAccountId, "Withdrawal"));
                        System.out.println("Withdrawal successful.");
                        break;
                    case 4:
                        System.out.println("Enter originating account ID:");
                        String fromAccountId = scanner.nextLine();
                        System.out.println("Enter resulting account ID:");
                        String toAccountId = scanner.nextLine();
                        System.out.println("Enter transfer amount:");
                        double transferAmount = scanner.nextDouble();
                        System.out.println("Use flat fee? (true/false):");
                        boolean useFlatFee = scanner.nextBoolean();
                        scanner.nextLine(); // Consume newline
                        bank.addTransaction(new Transfer(transferAmount, fromAccountId, toAccountId, "Transfer", useFlatFee));
                        System.out.println("Transfer successful.");
                        break;
                    case 5:
                        System.out.println("Enter account ID:");
                        String transactionAccountId = scanner.nextLine();
                        bank.listTransactions(transactionAccountId);
                        break;
                    case 6:
                        System.out.println("Enter account ID:");
                        String balanceAccountId = scanner.nextLine();
                        bank.checkAccountBalance(balanceAccountId);
                        break;
                    case 7:
                        bank.listAccounts();
                        break;
                    case 8:
                        bank.checkTotalTransactionFeeAmount();
                        break;
                    case 9:
                        bank.checkTotalTransferAmount();
                        break;
                    case 10:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (AccountNotFoundException | InsufficientFundsException e) {
                System.out.println(e.getMessage());
            }

            System.out.print("Would you like to return to the menu? (yes/no): ");
            String continueChoice = scanner.nextLine();
            if (continueChoice.equalsIgnoreCase("no")) {
                System.out.println("Exiting...");
                scanner.close();
                running = false;
            }
        }
    }
}
