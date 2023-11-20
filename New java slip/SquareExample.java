// Write a program to find the Square of given number using function interface.

// Functional interface for squaring a number
interface SquareCalculator {
    int calculateSquare(int num);
}

public class SquareExample {
    public static void main(String[] args) {
        // Using lambda expression to implement the functional interface
        SquareCalculator squareCalculator = num -> num * num;

        // Example: Find the square of 8
        int number = 8;
        int result = squareCalculator.calculateSquare(number);

        System.out.println("The square of " + number + " is: " + result);
    }
}

