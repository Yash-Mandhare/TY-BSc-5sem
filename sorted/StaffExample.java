// Define an abstract class Staff with protected members id and name. Define a parameterized constructor. Define one subclass OfficeStaff with member department. Create n objects of OfficeStaff and display all details.

import java.util.Scanner;

abstract class Staff {
    protected int id;
    protected String name;

    // Parameterized constructor
    public Staff(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Abstract method to be implemented by subclasses
    public abstract void displayDetails();
}

class OfficeStaff extends Staff {
    private String department;

    // Parameterized constructor for OfficeStaff
    public OfficeStaff(int id, String name, String department) {
        super(id, name);
        this.department = department;
    }

    // Implementation of the abstract method to display details
    @Override
    public void displayDetails() {
        System.out.printf("| %-5d | %-15s | %-15s |%n", id, name, department);
    }
}

public class StaffExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for the number of staff members
        System.out.print("Enter the number of staff members: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        // Create an array of OfficeStaff objects
        OfficeStaff[] officeStaffArray = new OfficeStaff[n];

        // Populate the array with OfficeStaff objects using user input
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for OfficeStaff " + (i + 1) + ":");
            System.out.print("Enter ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume the newline
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Department: ");
            String department = scanner.nextLine();

            officeStaffArray[i] = new OfficeStaff(id, name, department);
        }

        // Display details of all OfficeStaff objects in table format
        System.out.println("\nStaff Details Table:");
        System.out.println("+-------+-----------------+-----------------+");
        System.out.println("|  ID   |      Name       |   Department    |");
        System.out.println("+-------+-----------------+-----------------+");

        for (OfficeStaff staff : officeStaffArray) {
            staff.displayDetails();
        }

        System.out.println("+-------+-----------------+-----------------+");

        scanner.close();
    }
}
/*
Enter the number of staff members: 2

Enter details for OfficeStaff 1:
Enter ID: 101
Enter Name: yash
Enter Department: bsc

Enter details for OfficeStaff 2:
Enter ID: 102
Enter Name: siddhi
Enter Department: bcs

Staff Details Table:
+-------+-----------------+-----------------+
|  ID   |      Name       |   Department    |
+-------+-----------------+-----------------+
| 101   | yash            | bsc             |
| 102   | siddhi          | bcs             |
+-------+-----------------+-----------------+
*/