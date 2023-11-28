//Write a Program to print all Prime numbers in an array of ‘n’ elements.(use command line arguments)


import java.util.Scanner;

public class PrimeNumbersInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        int[] array = new int[n];

        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        // Loop through each element in the array
        for (int i = 0; i < n; i++) {
            boolean isPrime = true;

            // Check if the current element is a prime number
            for (int j = 2; j * j <= array[i]; j++) {
                if (array[i] % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            // Display the prime numbers
            if (isPrime && array[i] > 1) {
                System.out.println(array[i] + " is a prime number");
            }
        }

        scanner.close(); // Close the scanner to prevent resource leak
    }
}
