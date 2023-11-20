//Write a program to create a class Customer(custno,custname,contactnumber,custaddr).
// Write a method to search the customer name with given contact number and display the
// details.

import java.util.ArrayList;

class Customer {
    private int custno;
    private String custname;
    private String contactnumber;
    private String custaddr;

    // Constructor
    public Customer(int custno, String custname, String contactnumber, String custaddr) {
        this.custno = custno;
        this.custname = custname;
        this.contactnumber = contactnumber;
        this.custaddr = custaddr;
    }

    // Getter methods
    public int getCustno() {
        return custno;
    }

    public String getCustname() {
        return custname;
    }

    public String getContactnumber() {
        return contactnumber;
    }

    public String getCustaddr() {
        return custaddr;
    }

    // Method to search for a customer by contact number
    public static Customer searchCustomerByContactNumber(ArrayList<Customer> customers, String contactNumber) {
        for (Customer customer : customers) {
            if (customer.getContactnumber().equals(contactNumber)) {
                return customer;
            }
        }
        return null; // Customer not found
    }
}

public class CustomerDemo {
    public static void main(String[] args) {
        // Create a list of customers
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1, "John Doe", "1234567890", "123 Main St"));
        customers.add(new Customer(2, "Jane Smith", "9876543210", "456 Oak St"));
        customers.add(new Customer(3, "Bob Johnson", "5551234567", "789 Pine St"));

        // Search for a customer by contact number
        String searchContactNumber = "9876543210";
        Customer foundCustomer = Customer.searchCustomerByContactNumber(customers, searchContactNumber);

        // Display the customer details if found
        if (foundCustomer != null) {
            System.out.println("Customer found:");
            System.out.println("Customer Number: " + foundCustomer.getCustno());
            System.out.println("Customer Name: " + foundCustomer.getCustname());
            System.out.println("Contact Number: " + foundCustomer.getContactnumber());
            System.out.println("Customer Address: " + foundCustomer.getCustaddr());
        } else {
            System.out.println("Customer not found with contact number: " + searchContactNumber);
        }
    }
}
