/*
 * Write a java program that take input as a person name in the format of first, middle and last name and then print it in the form last, first and middle name, where in the middle name first character is capital letter.
*/

import java.util.Scanner;

public class NameFormatter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for input
        System.out.print("Enter your full name (First Middle Last): ");
        String fullName = scanner.nextLine();

        // Split the input into first, middle, and last names
        String[] nameParts = fullName.split(" ");
        
        if (nameParts.length == 3) {
            String firstName = nameParts[0];
            String middleName = nameParts[1];
            String lastName = nameParts[2];

            // Capitalize the first letter of the middle name
            middleName = middleName.substring(0, 1).toUpperCase() + middleName.substring(1);

            // Format and print the name in the desired format
            String formattedName = lastName + ", " + firstName + " " + middleName;
            System.out.println("Formatted name: " + formattedName);
        } else {
            System.out.println("Invalid input. Please provide first, middle, and last names.");
        }

        scanner.close();
    }
}
