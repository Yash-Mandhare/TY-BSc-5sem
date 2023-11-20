//Write a program to create parent class College(cno, cname, caddr) and derived class Department(dno, dname) from College. Write a necessary methods to display College details.

import java.util.Scanner;

class College {
    protected int cno;
    protected String cname;
    protected String caddr;

    // Parameterized constructor for College class
    public College(int cno, String cname, String caddr) {
        this.cno = cno;
        this.cname = cname;
        this.caddr = caddr;
    }

    // Method to display College details
    public void displayCollegeDetails() {
        System.out.println("College Details:");
        System.out.println("College Number: " + cno);
        System.out.println("College Name: " + cname);
        System.out.println("College Address: " + caddr);
    }
}

class Department extends College {
    private int dno;
    private String dname;

    // Parameterized constructor for Department class
    public Department(int cno, String cname, String caddr, int dno, String dname) {
        super(cno, cname, caddr);
        this.dno = dno;
        this.dname = dname;
    }

    // Method to display Department details along with College details
    public void displayDepartmentDetails() {
        displayCollegeDetails();
        System.out.println("Department Details:");
        System.out.println("Department Number: " + dno);
        System.out.println("Department Name: " + dname);
    }
}

public class CollegeDepartmentExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input College details
        System.out.print("Enter College Number: ");
        int cno = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        System.out.print("Enter College Name: ");
        String cname = scanner.nextLine();
        System.out.print("Enter College Address: ");
        String caddr = scanner.nextLine();

        // Input Department details
        System.out.print("Enter Department Number: ");
        int dno = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        System.out.print("Enter Department Name: ");
        String dname = scanner.nextLine();

        // Create Department object
        Department department = new Department(cno, cname, caddr, dno, dname);

        // Display College and Department details
        department.displayDepartmentDetails();

        scanner.close();
    }
}
