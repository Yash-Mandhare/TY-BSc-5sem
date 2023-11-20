// Design a class for Bank. Bank Class should support following operations;
// a. Deposit a certain amount into an account
// b. Withdraw a certain amount from an account
// c. Return a Balance value specifying the amount with details

import java.util.Scanner;

class Bank {
    private double balance;

    // Constructor to initialize the balance
    public Bank(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to deposit a certain amount into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive value.");
        }
    }

    // Method to withdraw a certain amount from the account
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }

    // Method to return the current balance
    public double getBalance() {
        return balance;
    }
}

public class BankExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a Bank object with an initial balance
        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();
        Bank myBank = new Bank(initialBalance);

        // Perform operations on the bank account
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            System.out.print("Enter your choice (1/2/3/4): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    myBank.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    myBank.withdraw(withdrawalAmount);
                    break;
                case 3:
                    System.out.println("Current balance: " + myBank.getBalance());
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, 3, or 4.");
            }
        }
    }
}


// Enter initial balance: 1000

// Menu:
// 1. Deposit
// 2. Withdraw
// 3. Check Balance
// 4. Exit
// Enter your choice (1/2/3/4): 1
// Enter deposit amount: 500
// Deposit successful. New balance: 1500.0

// Menu:
// 1. Deposit
// 2. Withdraw
// 3. Check Balance
// 4. Exit
// Enter your choice (1/2/3/4): 2
// Enter withdrawal amount: 200
// Withdrawal successful. New balance: 1300.0

// Menu:
// 1. Deposit
// 2. Withdraw
// 3. Check Balance
// 4. Exit
// Enter your choice (1/2/3/4): 3
// Current balance: 1300.0

// Menu:
// 1. Deposit
// 2. Withdraw
// 3. Check Balance
// 4. Exit
// Enter your choice (1/2/3/4): 4
// Exiting the program.
