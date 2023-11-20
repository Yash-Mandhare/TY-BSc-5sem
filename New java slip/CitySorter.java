//Write a program to accept ‘n’ name of cities from the user and sort them in ascending order.


import java.util.Arrays;
import java.util.Scanner;

public class CitySorter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for the number of cities
        System.out.print("Enter the number of cities: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        // Create an array to store the names of cities
        String[] cities = new String[n];

        // Prompt user to enter the names of cities
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name of city " + (i + 1) + ": ");
            cities[i] = scanner.nextLine();
        }

        // Sort the array of cities in ascending order
        Arrays.sort(cities);

        // Display the sorted list of cities
        System.out.println("\nSorted list of cities in ascending order:");
        for (String city : cities) {
            System.out.println(city);
        }

        scanner.close();
    }
}
