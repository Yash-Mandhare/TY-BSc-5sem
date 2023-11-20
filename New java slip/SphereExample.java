// Create a class Sphere, to calculate the volume and surface area of sphere. (Hint : Surface area=4*3.14(r*r), Volume=(4/3)3.14(r*r*r))

import java.util.Scanner;

class Sphere {
    private double radius;

    // Constructor to initialize the radius
    public Sphere(double radius) {
        this.radius = radius;
    }

    // Method to calculate the surface area of the sphere
    public double calculateSurfaceArea() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    // Method to calculate the volume of the sphere
    public double calculateVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }
}

public class SphereExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the radius of the sphere
        System.out.print("Enter the radius of the sphere: ");
        double radius = scanner.nextDouble();

        // Create a Sphere object with the given radius
        Sphere mySphere = new Sphere(radius);

        // Calculate and display the surface area and volume of the sphere
        double surfaceArea = mySphere.calculateSurfaceArea();
        double volume = mySphere.calculateVolume();

        System.out.println("\nSphere Details:");
        System.out.println("Radius: " + radius);
        System.out.println("Surface Area: " + surfaceArea);
        System.out.println("Volume: " + volume);

        scanner.close();
    }
}
