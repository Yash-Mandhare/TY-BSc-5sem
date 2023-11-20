@FunctionalInterface
interface CubeCalculator {
    int calculateCube(int num);
}

public class CubeExample {
    public static void main(String[] args) {
        // Using lambda expression to implement the functional interface
        CubeCalculator cubeCalculator = num -> num * num * num;

        // Example: Find the cube of 5
        int number = 5;
        int result = cubeCalculator.calculateCube(number);

        System.out.println("The cube of " + number + " is: " + result);
    }
}
