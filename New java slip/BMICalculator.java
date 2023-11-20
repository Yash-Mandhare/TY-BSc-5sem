/*Write a program to read the First Name and Last Name of a person, his weight and height using
command line arguments. Calculate the BMI Index which is defined as the individual's body mass
divided by the square of their height.
(Hint : BMI = Wts. In kgs / (ht)2)*/

import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for input
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter Weight in kgs: ");
        double weight = scanner.nextDouble();

        System.out.print("Enter Height in meters: ");
        double height = scanner.nextDouble();

        // Calculate BMI
        double bmi = calculateBMI(weight, height);

        // Display the result in table format
        System.out.println("\nBMI Calculation Table:");
        System.out.println("+--------------+--------------+---------+--------+");
        System.out.println("| First Name   | Last Name    | Weight  | Height |");
        System.out.println("+--------------+--------------+---------+--------+");
        System.out.printf("| %-12s | %-12s | %-7.2f | %-6.2f |%n", firstName, lastName, weight, height);
        System.out.println("+--------------+--------------+---------+--------+");
        System.out.printf("| BMI Index:   |                          | %-9.2f |%n", bmi);
        System.out.println("+--------------+--------------+---------+--------+");

        scanner.close();
    }

    // Function to calculate BMI
    private static double calculateBMI(double weight, double height) {
        return weight / (height * height);
    }
}
