// Create an employee class(id,name,deptname,salary). Define a default and parameterized
// constructor. Use ‘this’ keyword to initialize instance variables. Keep a count of objects
// created. Create objects using parameterized constructor and display the object count after
// each object is created. (Use static member and method). Also display the contents of each
// object.

import java.util.Scanner;

class Employee {
    private int empid;
    private String empname;
    private String empdesignation;
    private double empsal;

    // Parameterized constructor
    public Employee(int empid, String empname, String empdesignation, double empsal) {
        this.empid = empid;
        this.empname = empname;
        this.empdesignation = empdesignation;
        this.empsal = empsal;
    }

    // Override toString() method
    @Override
    public String toString() {
        return "Employee Information:\n" +
                "Empid: " + empid + "\n" +
                "Empname: " + empname + "\n" +
                "Empdesignation: " + empdesignation + "\n" +
                "Empsal: " + empsal;
    }
}

public class EmployeeInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input employee information from the user
        System.out.print("Enter Empid: ");
        int empid = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        System.out.print("Enter Empname: ");
        String empname = scanner.nextLine();

        System.out.print("Enter Empdesignation: ");
        String empdesignation = scanner.nextLine();

        System.out.print("Enter Empsal: ");
        double empsal = scanner.nextDouble();

        // Create an Employee object
        Employee employee = new Employee(empid, empname, empdesignation, empsal);

        // Display employee information using toString()
        System.out.println("\nEmployee Information:\n" + employee.toString());

        scanner.close();
    }
}
