// Write a program to create a super class Vehicle having members Company and price.
// Derive two different classes LightMotorVehicle(mileage) and HeavyMotorVehicle
// (capacity_in_tons). Accept the information for "n" vehicles and display the information in
// appropriate form. While taking data, ask user about the type of vehicle first.

import java.util.Scanner;

class Vehicle {
    protected String company;
    protected double price;

    // Constructor for Vehicle class
    public Vehicle(String company, double price) {
        this.company = company;
        this.price = price;
    }

    // Display method for Vehicle class
    public void display() {
        System.out.println("Company: " + company);
        System.out.println("Price: $" + price);
    }
}

class LightMotorVehicle extends Vehicle {
    private double mileage;

    // Constructor for LightMotorVehicle class
    public LightMotorVehicle(String company, double price, double mileage) {
        super(company, price);
        this.mileage = mileage;
    }

    // Display method for LightMotorVehicle class
    @Override
    public void display() {
        super.display();
        System.out.println("Mileage: " + mileage + " km/l");
    }
}

class HeavyMotorVehicle extends Vehicle {
    private double capacity_in_tons;

    // Constructor for HeavyMotorVehicle class
    public HeavyMotorVehicle(String company, double price, double capacity_in_tons) {
        super(company, price);
        this.capacity_in_tons = capacity_in_tons;
    }

    // Display method for HeavyMotorVehicle class
    @Override
    public void display() {
        super.display();
        System.out.println("Capacity in Tons: " + capacity_in_tons + " tons");
    }
}

public class VehicleDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vehicles (n): ");
        int n = scanner.nextInt();

        Vehicle[] vehicles = new Vehicle[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter type of vehicle (L for Light, H for Heavy): ");
            char vehicleType = scanner.next().charAt(0);

            System.out.print("Enter company: ");
            String company = scanner.next();

            System.out.print("Enter price: $");
            double price = scanner.nextDouble();

            if (vehicleType == 'L') {
                System.out.print("Enter mileage: ");
                double mileage = scanner.nextDouble();
                vehicles[i] = new LightMotorVehicle(company, price, mileage);
            } else if (vehicleType == 'H') {
                System.out.print("Enter capacity in tons: ");
                double capacity_in_tons = scanner.nextDouble();
                vehicles[i] = new HeavyMotorVehicle(company, price, capacity_in_tons);
            } else {
                System.out.println("Invalid vehicle type. Please enter L for Light or H for Heavy.");
                i--; // Decrement i to repeat the current iteration
            }
        }

        // Display information for all vehicles
        System.out.println("\nVehicle Information:");
        for (Vehicle vehicle : vehicles) {
            vehicle.display();
            System.out.println(); // Add a newline for better readability
        }

        scanner.close();
    }
}
