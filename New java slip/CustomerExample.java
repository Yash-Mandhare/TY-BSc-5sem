// Design a Super class Customer (name, phone-number). Derive a class Depositor(accno , balance)
// from Customer. Again, derive a class Borrower (loan-no, loan-amt) from Depositor. Write
// necessary member functions to read and display the details of ‘n’customers.
import java.util.Scanner;

class Customer {
    protected String name;
    protected String phoneNumber;

    // Parameterized constructor for Customer class
    public Customer(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // Method to read customer details
    public void readCustomerDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Customer Name: ");
        name = scanner.nextLine();
        System.out.print("Enter Phone Number: ");
        phoneNumber = scanner.nextLine();
    }

    // Method to display customer details
    public void displayCustomerDetails() {
        System.out.printf("| %-15s | %-15s |%n", "Name", "Phone Number");
        System.out.println("|-----------------|-----------------|");
        System.out.printf("| %-15s | %-15s |%n", name, phoneNumber);
    }
}

class Depositor extends Customer {
    protected int accNo;
    protected double balance;

    // Parameterized constructor for Depositor class
    public Depositor(String name, String phoneNumber, int accNo, double balance) {
        super(name, phoneNumber);
        this.accNo = accNo;
        this.balance = balance;
    }

    // Method to read depositor details
    public void readDepositorDetails() {
        readCustomerDetails();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Account Number: ");
        accNo = scanner.nextInt();
        System.out.print("Enter Balance: $");
        balance = scanner.nextDouble();
    }

    // Method to display depositor details
    public void displayDepositorDetails() {
        displayCustomerDetails();
        System.out.printf("| %-15s | %-10s |%n", "Account Number", "Balance");
        System.out.println("|-----------------|------------|");
        System.out.printf("| %-15d | $%-9.2f |%n", accNo, balance);
    }
}

class Borrower extends Depositor {
    protected int loanNo;
    protected double loanAmt;

    // Parameterized constructor for Borrower class
    public Borrower(String name, String phoneNumber, int accNo, double balance, int loanNo, double loanAmt) {
        super(name, phoneNumber, accNo, balance);
        this.loanNo = loanNo;
        this.loanAmt = loanAmt;
    }

    // Method to read borrower details
    public void readBorrowerDetails() {
        readDepositorDetails();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Loan Number: ");
        loanNo = scanner.nextInt();
        System.out.print("Enter Loan Amount: $");
        loanAmt = scanner.nextDouble();
    }

    // Method to display borrower details in table format
    public void displayBorrowerDetails() {
        System.out.printf("| %-15s | %-15s | %-15s | %-10s | %-15s | %-15s |%n",
                "Name", "Phone Number", "Account Number", "Balance", "Loan Number", "Loan Amount");
        System.out.println("|-----------------|-----------------|-----------------|------------|-----------------|-----------------|");
        System.out.printf("| %-15s | %-15s | %-15d | $%-9.2f | %-15d | $%-9.2f |%n",
                name, phoneNumber, accNo, balance, loanNo, loanAmt);
    }
}

public class CustomerExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of customers (n): ");
        int n = scanner.nextInt();

        Borrower[] borrowers = new Borrower[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Customer " + (i + 1) + ":");
            borrowers[i] = new Borrower("", "", 0, 0.0, 0, 0.0);
            borrowers[i].readBorrowerDetails();
        }

        System.out.println("\nCustomer Details:");

        for (Borrower borrower : borrowers) {
            borrower.displayBorrowerDetails();
            System.out.println();
        }

        scanner.close();
    }
}


// Enter the number of customers (n): 2

// Enter details for Customer 1:
// Enter Customer Name: John Doe
// Enter Phone Number: 123-456-7890
// Enter Account Number: 1001
// Enter Balance: $5000.0
// Enter Loan Number: 101
// Enter Loan Amount: $2000.0

// Enter details for Customer 2:
// Enter Customer Name: Jane Smith
// Enter Phone Number: 987-654-3210
// Enter Account Number: 1002
// Enter Balance: $7000.0
// Enter Loan Number: 102
// Enter Loan Amount: $3000.0

// Customer Details:
// | Name            | Phone Number     | Account Number  | Balance    | Loan Number     | Loan Amount    |
// |-----------------|------------------|-----------------|------------|-----------------|-----------------|
// | John Doe        | 123-456-7890     | 1001            | $5000.00   | 101             | $2000.00       |
// | Jane Smith      | 987-654-3210     | 1002            | $7000.00   | 102             | $3000.00       |
