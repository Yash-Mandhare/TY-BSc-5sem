// Write a package for Operation, which has two classes, Addition and Maximum. Addition has
// two methods add () and subtract (), which are used to add two integers and subtract two,
// float values respectively. Maximum has a method max () to display the maximum of two
// integers


package Operation;

import Operation.Addition;
import Operation.Maximum;

public class OperationTest {
    public static void main(String[] args) {
        Addition addition = new Addition();
        Maximum maximum = new Maximum();

        // Test the Addition class
        int sum = addition.add(5, 3);
        float difference = addition.subtract(8.0f, 4.5f);

        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);

        // Test the Maximum class
        maximum.max(10, 7);
    }
}
