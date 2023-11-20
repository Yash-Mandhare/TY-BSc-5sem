import java.util.Scanner;

public class MatrixOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Addition");
            System.out.println("2. Multiplication");
            System.out.println("3. Exit");

            System.out.print("Enter your choice (1/2/3): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    performAddition();
                    break;
                case 2:
                    performMultiplication();
                    break;
                case 3:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }
    }

    private static void performAddition() {
        Scanner scanner = new Scanner(System.in);

        // Input matrices from the user
        int[][] matrix1 = inputMatrix("Enter the first matrix:");
        int[][] matrix2 = inputMatrix("Enter the second matrix:");

        // Check if matrices are compatible for addition
        if (areMatricesCompatibleForAddition(matrix1, matrix2)) {
            // Perform addition and display result
            int[][] resultMatrix = addMatrices(matrix1, matrix2);
            System.out.println("\nResultant Matrix (Addition):");
            printMatrix(resultMatrix);
        } else {
            System.out.println("Matrices are not compatible for addition.");
        }
    }

    private static void performMultiplication() {
        Scanner scanner = new Scanner(System.in);

        // Input matrices from the user
        int[][] matrix1 = inputMatrix("Enter the first matrix:");
        int[][] matrix2 = inputMatrix("Enter the second matrix:");

        // Check if matrices are compatible for multiplication
        if (areMatricesCompatibleForMultiplication(matrix1, matrix2)) {
            // Perform multiplication and display result
            int[][] resultMatrix = multiplyMatrices(matrix1, matrix2);
            System.out.println("\nResultant Matrix (Multiplication):");
            printMatrix(resultMatrix);
        } else {
            System.out.println("Matrices are not compatible for multiplication.");
        }
    }

    private static int[][] inputMatrix(String prompt) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(prompt);
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int columns = scanner.nextInt();

        int[][] matrix = new int[rows][columns];

        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Enter element at position [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }

        return matrix;
    }

    private static boolean areMatricesCompatibleForAddition(int[][] matrix1, int[][] matrix2) {
        return matrix1.length == matrix2.length && matrix1[0].length == matrix2[0].length;
    }

    private static boolean areMatricesCompatibleForMultiplication(int[][] matrix1, int[][] matrix2) {
        return matrix1[0].length == matrix2.length;
    }

    private static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int columns = matrix1[0].length;

        int[][] resultMatrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                resultMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return resultMatrix;
    }

    private static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int columns1 = matrix1[0].length;
        int columns2 = matrix2[0].length;

        int[][] resultMatrix = new int[rows1][columns2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < columns2; j++) {
                for (int k = 0; k < columns1; k++) {
                    resultMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return resultMatrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
