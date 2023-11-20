// Create an abstract class “order” having members id, description. Create two subclasses
// “Purchase Order” and “Sales Order” having members customer name and Vendor name
// respectively. Define methods accept and display in all cases. Create 3 objects each of Purchase
// Order and Sales Order and accept and display details.
import java.util.Scanner;

abstract class Order {
    protected int id;
    protected String description;

    public Order(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public abstract void accept();
    public abstract void display();
}

class PurchaseOrder extends Order {
    private String customerName;

    public PurchaseOrder(int id, String description, String customerName) {
        super(id, description);
        this.customerName = customerName;
    }

    @Override
    public void accept() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Customer Name: ");
        customerName = input.nextLine();
    }

    @Override
    public void display() {
        System.out.println("Purchase Order - ID: " + id);
        System.out.println("Description: " + description);
        System.out.println("Customer Name: " + customerName);
    }
}

class SalesOrder extends Order {
    private String vendorName;

    public SalesOrder(int id, String description, String vendorName) {
        super(id, description);
        this.vendorName = vendorName;
    }

    @Override
    public void accept() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Vendor Name: ");
        vendorName = input.nextLine();
    }

    @Override
    public void display() {
        System.out.println("Sales Order - ID: " + id);
        System.out.println("Description: " + description);
        System.out.println("Vendor Name: " + vendorName);
    }
}

public class Purchase_order {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of Purchase Orders you want to create: ");
        int numPurchaseOrders = input.nextInt();
        PurchaseOrder[] purchaseOrders = new PurchaseOrder[numPurchaseOrders];

        for (int i = 0; i < numPurchaseOrders; i++) {
            input.nextLine(); // Consume the newline character
            System.out.println("\nEnter details for Purchase Order " + (i + 1));
            System.out.print("Enter ID: ");
            int id = input.nextInt();
            input.nextLine(); // Consume the newline character
            System.out.print("Enter Description: ");
            String description = input.nextLine();
            purchaseOrders[i] = new PurchaseOrder(id, description, "");
            purchaseOrders[i].accept();
        }

        System.out.print("\nEnter the number of Sales Orders you want to create: ");
        int numSalesOrders = input.nextInt();
        SalesOrder[] salesOrders = new SalesOrder[numSalesOrders];

        for (int i = 0; i < numSalesOrders; i++) {
            input.nextLine(); // Consume the newline character
            System.out.println("\nEnter details for Sales Order " + (i + 1));
            System.out.print("Enter ID: ");
            int id = input.nextInt();
            input.nextLine(); // Consume the newline character
            System.out.print("Enter Description: ");
            String description = input.nextLine();
            salesOrders[i] = new SalesOrder(id, description, "");
            salesOrders[i].accept();
        }

        System.out.println("\nOrder Details:\n");

        System.out.println("Purchase Orders:");
        for (PurchaseOrder order : purchaseOrders) {
            order.display();
            System.out.println();
        }

        System.out.println("Sales Orders:");
        for (SalesOrder order : salesOrders) {
            order.display();
            System.out.println();
        }

        input.close();
    }
}


/*
Enter the number of Purchase Orders you want to create: 2

Enter details for Purchase Order 1:
Enter ID: 101
Enter Description: Office Supplies
Enter Customer Name: ABC Company

Enter details for Purchase Order 2:
Enter ID: 102
Enter Description: Electronics
Enter Customer Name: XYZ Corporation

Enter the number of Sales Orders you want to create: 2

Enter details for Sales Order 1:
Enter ID: 201
Enter Description: Electronics
Enter Vendor Name: XYZ Electronics

Enter details for Sales Order 2:
Enter ID: 202
Enter Description: Clothing
Enter Vendor Name: Fashion World

Order Details:

Purchase Orders:
Purchase Order - ID: 101
Description: Office Supplies
Customer Name: ABC Company

Purchase Order - ID: 102
Description: Electronics
Customer Name: XYZ Corporation

Sales Orders:
Sales Order - ID: 201
Description: Electronics
Vendor Name: XYZ Electronics

Sales Order - ID: 202
Description: Clothing
Vendor Name: Fashion World
*/