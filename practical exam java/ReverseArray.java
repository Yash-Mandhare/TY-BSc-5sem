// Write a program to accept the array element and display in reverse order.

import java.util.Arrays;
import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        int[] array = new int[n];

        // Input array elements
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        // Sort the array in descending order
        Arrays.sort(array);
        for (int i = 0; i < n / 2; i++) {
            int temp = array[i];
            array[i] = array[n - 1 - i];
            array[n - 1 - i] = temp;
        }

         // Display array elements in reverse order
        //  System.out.println("Array elements in reverse order:");
        //  for (int i = n - 1; i >= 0; i--) {
        //      System.out.print(array[i] + " ");
        //  }

        // Display the sorted array in descending order
        System.out.println("Array elements in descending order:");
        for (int element : array) {
            System.out.print(element + " ");
        }
    }
}

