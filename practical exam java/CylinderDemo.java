// Define an interface “Operation” which has methods area(),volume().Define a constant PI having a value 3.142.Create a class cylinder which implements this interface (members – radius, height) Create one object and calculate the area and volume

// Define the Operation interface
interface Operation {
    double PI = 3.142;  // Constant for PI

    double area();    // Method to calculate the area
    double volume();  // Method to calculate the volume
}

// Create a class Cylinder that implements the Operation interface
class Cylinder implements Operation {
    private double radius;
    private double height;

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double area() {
        // Surface area of a cylinder: 2 * PI * radius * (radius + height)
        return 2 * PI * radius * (radius + height);
    }

    @Override
    public double volume() {
        // Volume of a cylinder: PI * radius^2 * height
        return PI * radius * radius * height;
    }
}

public class CylinderDemo {
    public static void main(String[] args) {
        // Create a Cylinder object
        Cylinder cylinder = new Cylinder(5.0, 10.0);

        // Calculate and display the area and volume
        System.out.println("Cylinder Area: " + cylinder.area());
        System.out.println("Cylinder Volume: " + cylinder.volume());
    }
}
