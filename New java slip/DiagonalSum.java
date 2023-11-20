// Write a program to accept the two dimensional array from user and display sum of its diagonal elements.

import java.util.Scanner;

public class DiagonalSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of rows and columns for the 2D array
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();

        System.out.print("Enter the number of columns: ");
        int columns = scanner.nextInt();

        // Declare a 2D array
        int[][] matrix = new int[rows][columns];

        // Input the elements of the 2D array from the user
        System.out.println("Enter the elements of the 2D array:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Enter element at position (" + i + ", " + j + "): ");
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Calculate the sum of diagonal elements
        int diagonalSum = 0;
        for (int i = 0; i < Math.min(rows, columns); i++) {
            diagonalSum += matrix[i][i];
        }

        // Display the original matrix
        System.out.println("\nThe 2D array is:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        // Display the sum of diagonal elements
        System.out.println("\nThe sum of diagonal elements is: " + diagonalSum);

        scanner.close();
    }
}

// Enter the number of rows: 3
// Enter the number of columns: 3
// Enter the elements of the 2D array:
// Enter element at position (0, 0): 1
// Enter element at position (0, 1): 2
// Enter element at position (0, 2): 3
// Enter element at position (1, 0): 4
// Enter element at position (1, 1): 5
// Enter element at position (1, 2): 6
// Enter element at position (2, 0): 7
// Enter element at position (2, 1): 8
// Enter element at position (2, 2): 9

// The 2D array is:
// 1	2	3	
// 4	5	6	
// 7	8	9	

// The sum of diagonal elements is: 15
