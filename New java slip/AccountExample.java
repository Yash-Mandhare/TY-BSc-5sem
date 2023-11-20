// Write a program to define a class Account having members custname, accno. Define default
// and parameterized constructor. Create a subclass called SavingAccount with member savingbal,
// minbal. Create a derived class AccountDetail that extends the class SavingAccount with
// members, depositamt and withdrawalamt. Write a appropriate method to display customer
// details.

import java.util.Scanner;

class Account {
    protected String custName;
    protected int accNo;

    // Default constructor for Account class
    public Account() {
        custName = "Not available";
        accNo = 0;
    }

    // Parameterized constructor for Account class
    public Account(String custName, int accNo) {
        this.custName = custName;
        this.accNo = accNo;
    }

    // Method to display customer details in Account class
    public void displayAccountDetails() {
        System.out.println("Account Details:");
        System.out.println("Customer Name: " + custName);
        System.out.println("Account Number: " + accNo);
    }
}

class SavingAccount extends Account {
    protected double savingBal;
    protected double minBal;

    // Default constructor for SavingAccount class
    public SavingAccount() {
        savingBal = 0.0;
        minBal = 0.0;
    }

    // Parameterized constructor for SavingAccount class
    public SavingAccount(String custName, int accNo, double savingBal, double minBal) {
        super(custName, accNo);
        this.savingBal = savingBal;
        this.minBal = minBal;
    }

    // Method to display customer details in SavingAccount class
    public void displaySavingAccountDetails() {
        displayAccountDetails();
        System.out.println("Saving Balance: $" + savingBal);
        System.out.println("Minimum Balance: $" + minBal);
    }
}

class AccountDetail extends SavingAccount {
    protected double depositAmt;
    protected double withdrawalAmt;

    // Default constructor for AccountDetail class
    public AccountDetail() {
        depositAmt = 0.0;
        withdrawalAmt = 0.0;
    }

    // Parameterized constructor for AccountDetail class
    public AccountDetail(String custName, int accNo, double savingBal, double minBal, double depositAmt, double withdrawalAmt) {
        super(custName, accNo, savingBal, minBal);
        this.depositAmt = depositAmt;
        this.withdrawalAmt = withdrawalAmt;
    }

    // Method to display customer details in AccountDetail class
    public void displayAccountDetailDetails() {
        displaySavingAccountDetails();
        System.out.println("Deposit Amount: $" + depositAmt);
        System.out.println("Withdrawal Amount: $" + withdrawalAmt);
    }
}

public class AccountExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input customer details
        System.out.print("Enter Customer Name: ");
        String custName = scanner.nextLine();
        System.out.print("Enter Account Number: ");
        int accNo = scanner.nextInt();
        System.out.print("Enter Saving Balance: $");
        double savingBal = scanner.nextDouble();
        System.out.print("Enter Minimum Balance: $");
        double minBal = scanner.nextDouble();
        System.out.print("Enter Deposit Amount: $");
        double depositAmt = scanner.nextDouble();
        System.out.print("Enter Withdrawal Amount: $");
        double withdrawalAmt = scanner.nextDouble();

        // Create an AccountDetail object
        AccountDetail accountDetail = new AccountDetail(custName, accNo, savingBal, minBal, depositAmt, withdrawalAmt);

        // Display customer details
        accountDetail.displayAccountDetailDetails();

        scanner.close();
    }
}


// Enter Customer Name: John Doe
// Enter Account Number: 12345
// Enter Saving Balance: $5000
// Enter Minimum Balance: $1000
// Enter Deposit Amount: $2000
// Enter Withdrawal Amount: $500

// Account Details:
// Customer Name: John Doe
// Account Number: 12345
// Saving Balance: $5000.0
// Minimum Balance: $1000.0
// Deposit Amount: $2000.0
// Withdrawal Amount: $500.0
