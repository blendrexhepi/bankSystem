# Bank System

# - Description
A Java program simulating a basic bank system with functionalities like account creation, deposit, withdrawal, transfer, and account balance inquiries.

#  - Features

+ Create bank accounts with ID, name, and initial balance.
+ Deposit funds into an account.
+ Withdraw funds from an account (with insufficient funds handling).
+ Transfer funds between accounts (with optional flat fee or percentage fee).
+ View a list of transactions for a specific account.
+ Check the current balance of an account.
+ View a list of all accounts in the bank.
+ Calculate and display the total transaction fee amount.
+ Calculate and display the total transfer amount.
+ Running the Program

# Prerequisites:
 Ensure you have Java installed on your system. You can verify this by opening a terminal or command prompt and typing java -version.
Compilation: Download or copy the source code files (Account.java, Bank.java, etc.) into a directory. Open a terminal or command prompt and navigate to that directory. Use the following command to compile the Java source files:
Bash
javac Account.java Bank.java Transaction.java Deposit.java Withdrawal.java Transfer.java BankSystem.java
Use code with caution.
content_copy
This will create a compiled class file named BankSystem.class.

Execution: Run the compiled program using the following command:
Bash
java BankSystem
Use code with caution.
content_copy
This will launch the bank system application.

# - User Interface

The program provides a text-based menu where you can choose from various options to interact with the bank system. It prompts for user input and displays relevant information based on the chosen operation.

# - Example Usage

Enter the bank name (e.g., My Bank).
Specify transaction flat fee and transaction percent fee (if applicable).
Use the menu to perform bank operations like:
Creating accounts by entering account ID, name, and initial balance.
Making deposits by entering the account ID and deposit amount.
Withdrawing funds by entering the account ID and withdrawal amount.
Transferring funds by entering the originating account ID, resulting account ID, transfer amount, and choosing a flat fee or percentage fee option.
Viewing a list of transactions for a specific account by entering the account ID.
Checking the current balance of an account by entering the account ID.
Viewing a list of all accounts in the bank.
Calculating and displaying the total transaction fee amount.
Calculating and displaying the total transfer amount.
Additional Notes

# - The code utilizes exception handling for AccountNotFoundException and InsufficientFundsException to provide informative messages to the user in case of account or balance issues.
The BankSystem class demonstrates a basic implementation and can be extended for further functionalities like transaction logs, account statements, or additional transaction types