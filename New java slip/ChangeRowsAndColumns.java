// Write a program to print an array after changing the rows and columns of a given
// two-dimensional array.

import java.util.Scanner;

public class ChangeRowsAndColumns {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for the number of rows and columns
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();

        System.out.print("Enter the number of columns: ");
        int columns = scanner.nextInt();

        // Create a two-dimensional array
        int[][] originalArray = new int[rows][columns];

        // Prompt user to enter elements for the array
        System.out.println("Enter elements for the array:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Enter element at position [" + i + "][" + j + "]: ");
                originalArray[i][j] = scanner.nextInt();
            }
        }

        // Print the original array
        System.out.println("\nOriginal Array:");
        printArray(originalArray);

        // Change rows and columns
        int[][] changedArray = changeRowsAndColumns(originalArray);

        // Print the array after changing rows and columns
        System.out.println("\nArray after changing rows and columns:");
        printArray(changedArray);

        scanner.close();
    }

    // Function to change rows and columns of a two-dimensional array
    private static int[][] changeRowsAndColumns(int[][] array) {
        int rows = array.length;
        int columns = array[0].length;

        int[][] resultArray = new int[columns][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                resultArray[j][i] = array[i][j];
            }
        }

        return resultArray;
    }

    // Function to print a two-dimensional array
    private static void printArray(int[][] array) {
        for (int[] row : array) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}


// Enter the number of rows: 2
// Enter the number of columns: 2
// Enter elements for the array:
// Enter element at position [0][0]: 0 1
// Enter element at position [0][1]: Enter element at position [1][0]: 23 90
// Enter element at position [1][1]: 
// Original Array:
// 0 1 
// 23 90

// Array after changing rows and columns:
// 0 23
// 1 90