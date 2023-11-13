// Define an abstract class Staff with protected members id and name. Define a parameterized constructor. Define one subclass OfficeStaff with member department. Create n objects of OfficeStaff and display all details.

import java.util.Scanner;

abstract class Staff {
    protected int id;
    protected String name;

    public Staff(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract void displayDetails();
}

class OfficeStaff extends Staff {
    private String department;

    public OfficeStaff(int id, String name, String department) {
        super(id, name);
        this.department = department;
    }

    @Override
    public void displayDetails() {
        System.out.printf("| %-4d | %-20s | %-20s |\n", id, name, department);
    }
}

public class StaffDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of OfficeStaff members: ");
        int n = scanner.nextInt();

        OfficeStaff[] officeStaffMembers = new OfficeStaff[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for OfficeStaff member #" + (i + 1));
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Department: ");
            String department = scanner.nextLine();

            officeStaffMembers[i] = new OfficeStaff(id, name, department);
        }

        System.out.println("\nDetails of OfficeStaff members:");
        System.out.println("+------+----------------------+----------------------+");
        System.out.println("|  ID  |        Name          |     Department       |");
        System.out.println("+------+----------------------+----------------------+");

        for (int i = 0; i < n; i++) {
            officeStaffMembers[i].displayDetails();
        }

        System.out.println("+------+----------------------+----------------------+");
    }
}

// Enter the number of OfficeStaff members: 2
// Enter details for OfficeStaff member #1
// ID: 101
// Name: yash
// Department: bsc
// Enter details for OfficeStaff member #2
// ID: 102
// Name: siddhi
// Department: bcs

// Details of OfficeStaff members:
// +------+----------------------+----------------------+
// |  ID  |        Name          |     Department       |
// +------+----------------------+----------------------+
// | 101  | yash                 | bsc                  |
// | 102  | siddhi               | bcs                  |
// +------+----------------------+----------------------+