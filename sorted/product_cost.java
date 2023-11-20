// Write a program to using marker interface create a class product(product_id, product_name, product_cost, product_quantity) define a default and parameterized constructor. Create objects of class product and display the contents of each object and Also display the object count.

import java.util.Scanner;

// Marker interface for counting objects
interface Countable {
}

class Product implements Countable {
    private int productId;
    private String productName;
    private double productCost;
    private int productQuantity;
    private static int objectCount = 0;

    // Default constructor
    public Product() {
        objectCount++; // Increment the object count when an object is created.
    }

    // Parameterized constructor
    public Product(int productId, String productName, double productCost, int productQuantity) {
        this.productId = productId;
        this.productName = productName;
        this.productCost = productCost;
        this.productQuantity = productQuantity;
        objectCount++; // Increment the object count when an object is created.
    }

    public void displayProductDetails() {
        System.out.format("%-10d%-20s%-15.2f%-15d%n", productId, productName, productCost, productQuantity);
    }

    public static void displayObjectCount() {
        System.out.println("Total number of Product objects created: " + objectCount);
    }
}

public class product_cost {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of products (n): ");
        int n = scanner.nextInt();

        // Create an array to store the Product objects
        Product[] products = new Product[n];

        // Collect user input for each product and create objects
        for (int i = 0; i < n; i++) {
            System.out.print("Enter Product " + (i + 1) + " details:\nProduct ID: ");
            int productId = scanner.nextInt();
            System.out.print("Product Name: ");
            String productName = scanner.next();
            System.out.print("Product Cost: ");
            double productCost = scanner.nextDouble();
            System.out.print("Product Quantity: ");
            int productQuantity = scanner.nextInt();

            products[i] = new Product(productId, productName, productCost, productQuantity);
        }

        // Display the details of each product in a table format
        System.out.format("%-10s%-20s%-15s%-15s%n", "Product ID", "Product Name", "Product Cost", "Product Quantity");
        for (Product product : products) {
            product.displayProductDetails();
        }

        // Display the total object count
        Product.displayObjectCount();
    }
}


/*
 Enter the number of products (n): 2
Enter Product 1 details:
Product ID: 101
Product Name: laptop
Product Cost: 1000
Product Quantity: 10
Enter Product 2 details:
Product ID: 102
Product Name: phone
Product Cost: 500
Product Quantity: 5
Product IDProduct Name        Product Cost   Product Quantity
101       laptop              1000.00        10
102       phone               500.00         5
Total number of Product objects created: 2
*/