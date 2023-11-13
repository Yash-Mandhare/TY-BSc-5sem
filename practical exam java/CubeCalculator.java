// Write a program to find the cube of given number using function interface.

// Functional interface for cube operation
@FunctionalInterface
interface CubeFunction {
    double cube(double x);
}

public class CubeCalculator {
    public static void main(String[] args) {
        // Create a lambda expression to implement the cube function
        CubeFunction cube = (x) -> x * x * x;

        // Specify the number for which you want to calculate the cube
        double number = 5.0;

        // Calculate the cube using the lambda expression
        double result = cube.cube(number);

        // Display the result
        System.out.println("The cube of " + number + " is: " + result);
    }
}
