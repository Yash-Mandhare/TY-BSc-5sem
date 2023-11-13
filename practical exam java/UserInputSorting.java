// Write a java program to accept 5 numbers using command line arguments sort and display them.

import java.util.Arrays;
import java.util.Scanner;

public class UserInputSorting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 5 numbers:");

        int[] numbers = new int[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            try {
                numbers[i] = scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter valid integer values.");
                return;
            }
        }

        // Sort the array in ascending order
        Arrays.sort(numbers);

        // Display the sorted numbers
        System.out.println("Sorted numbers:");
        for (int number : numbers) {
            System.out.println(number);
        }

        scanner.close();
    }
}
