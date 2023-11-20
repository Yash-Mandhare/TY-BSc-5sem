// Define an Employee class with suitable attributes having getSalary() method, which returns
// salary withdrawn by a particular employee. Write a class Manager which extends a class
// Employee, override the getSalary() method, which will return salary of manager by adding
// traveling allowance, house rent allowance etc.


// Employee class with getSalary() method
class Employee {
    private String name;
    private double basicSalary;

    // Constructor
    public Employee(String name, double basicSalary) {
        this.name = name;
        this.basicSalary = basicSalary;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    // Method to calculate and return salary
    public double getSalary() {
        return basicSalary;
    }
}

// Manager class extending Employee
class Manager extends Employee {
    private double travelAllowance;
    private double houseRentAllowance;

    // Constructor
    public Manager(String name, double basicSalary, double travelAllowance, double houseRentAllowance) {
        super(name, basicSalary);
        this.travelAllowance = travelAllowance;
        this.houseRentAllowance = houseRentAllowance;
    }

    // Overriding getSalary() method to include additional allowances
    @Override
    public double getSalary() {
        // Adding travel allowance and house rent allowance to basic salary
        return getBasicSalary() + travelAllowance + houseRentAllowance;
    }
}

// Example usage
public class SalaryDemo {
    public static void main(String[] args) {
        // Creating an Employee
        Employee employee = new Employee("John Doe", 50000);

        // Creating a Manager
        Manager manager = new Manager("Jane Smith", 60000, 10000, 8000);

        // Displaying salaries
        System.out.println("Employee Salary: " + employee.getSalary());
        System.out.println("Manager Salary: " + manager.getSalary());
    }
}
