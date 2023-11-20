// Define a Item class (item_number, item_name, item_price). Define a default and parameterized
// constructor. Keep a count of objects created. Create objects using parameterized constructor
// and display the object count after each object is created.(Use static member and method). Also
// display the contents of each object.

public class Item {
    private int itemNumber;
    private String itemName;
    private double itemPrice;

    // Static member to keep track of the number of objects created
    private static int objectCount = 0;

    // Default constructor
    public Item() {
        // Increment the object count when a default constructor is called
        objectCount++;
    }

    // Parameterized constructor
    public Item(int itemNumber, String itemName, double itemPrice) {
        this.itemNumber = itemNumber;
        this.itemName = itemName;
        this.itemPrice = itemPrice;

        // Increment the object count when a parameterized constructor is called
        objectCount++;

        // Display the details of the created object
        displayObjectDetails();
    }

    // Static method to display the object count
    public static void displayObjectCount() {
        System.out.println("Total objects created: " + objectCount);
    }

    // Method to display the details of the object
    public void displayObjectDetails() {
        System.out.println("\nItem Details:");
        System.out.println("Item Number: " + itemNumber);
        System.out.println("Item Name: " + itemName);
        System.out.println("Item Price: $" + itemPrice);
        System.out.println("------------------------");
    }

    public static void main(String[] args) {
        // Create objects using parameterized constructor
        Item item1 = new Item(101, "Laptop", 999.99);
        Item item2 = new Item(102, "Smartphone", 499.99);

        // Display the object count after each object is created
        displayObjectCount();

        // Create an object using the default constructor
        Item item3 = new Item();

        // Display the object count after the default constructor is called
        displayObjectCount();
    }
}
