// Create an employee class(id,name,deptname,salary). Define a default and parameterized constructor. Use ‘this’ keyword to initialize instance variables. Keep a count of objects created. Create objects using parameterized constructor and display the object count after each object is created.(Use static member and method). Also display the contents of each object.

import java.util.Scanner;
import java.util.ArrayList;

public class Employee {
    private int id;
    private String name;
    private String deptName;
    private double salary;
    private static int objectCount = 0;

    public Employee() {
        this.id = 0;
        this.name = "";
        this.deptName = "";
        this.salary = 0.0;
        objectCount++;
    }

    public Employee(int id, String name, String deptName, double salary) {
        this.id = id;
        this.name = name;
        this.deptName = deptName;
        this.salary = salary;
        objectCount++;
    }

    public static void displayObjectCount() {
        System.out.println("Total Employee objects created: " + objectCount);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of employees (N): ");
        int N = scanner.nextInt();

        ArrayList<Employee> employees = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            System.out.print("Enter Employee ID: ");
            int id = scanner.nextInt();

            scanner.nextLine(); // Consume newline
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Department: ");
            String deptName = scanner.nextLine();

            System.out.print("Enter Salary: ");
            double salary = scanner.nextDouble();

            Employee emp = new Employee(id, name, deptName, salary);
            employees.add(emp);
            displayObjectCount();
        }

        scanner.close();

        // Display all employees in table format
        System.out.println("\nEmployee Data:");
        System.out.println("--------------------------------------------------");
        System.out.printf("| %-10s | %-20s | %-15s | %-10s |\n", "ID", "Name", "Department", "Salary");
        System.out.println("--------------------------------------------------");
        for (Employee emp : employees) {
            System.out.printf("| %-10d | %-20s | %-15s | %-10.2f |\n", emp.id, emp.name, emp.deptName, emp.salary);
        }
        System.out.println("--------------------------------------------------");
    }
}
/* 

Enter the number of employees (N): 2
Enter Employee ID: 102
Enter Name: yash
Enter Department: bsc  
Enter Salary: 50000
Total Employee objects created: 1
Enter Employee ID: 101
Enter Name: siddhi
Enter Department: hr
Enter Salary: 60000
Total Employee objects created: 2

Employee Data:
--------------------------------------------------
| ID         | Name                 | Department      | Salary     |
--------------------------------------------------
| 102        | yash                 | bsc             | 50000.00   |
| 101        | siddhi               | hr              | 60000.00   |
--------------------------------------------------*/