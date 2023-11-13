/*
Define a class MyNumber having one private int data member. Write a default constructor to initialize it to 0 and another constructor to initialize it to a value (Use this). Write methods isNegative, isPositive, isZero, isOdd, isEven. Create an object in main. Use command line arguments to pass a value to the object
(Hint : convert string argument to integer) and perform the above tests. Provide javadoc comments for all constructors and methods and generate the html help file.*/

import java.util.Scanner;

/**
 * The MyNumber class represents a number and provides various methods to test its properties.
 */
public class MyNumber {
    private int number;

    /**
     * Default constructor that initializes the number to 0.
     */
    public MyNumber() {
        this.number = 0;
    }

    /**
     * Constructor that initializes the number to the given value.
     *
     * @param value The initial value of the number.
     */
    public MyNumber(int value) {
        this.number = value;
    }

    /**
     * Check if the number is negative.
     *
     * @return true if the number is negative, false otherwise.
     */
    public boolean isNegative() {
        return number < 0;
    }

    /**
     * Check if the number is positive.
     *
     * @return true if the number is positive, false otherwise.
     */
    public boolean isPositive() {
        return number > 0;
    }

    /**
     * Check if the number is zero.
     *
     * @return true if the number is zero, false otherwise.
     */
    public boolean isZero() {
        return number == 0;
    }

    /**
     * Check if the number is odd.
     *
     * @return true if the number is odd, false otherwise.
     */
    public boolean isOdd() {
        return number % 2 != 0;
    }

    /**
     * Check if the number is even.
     *
     * @return true if the number is even, false otherwise.
     */
    public boolean isEven() {
        return number % 2 == 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int value = scanner.nextInt();

        MyNumber myNumber = new MyNumber(value);

        System.out.println("Number: " + myNumber.number);
        System.out.println("Is Negative: " + myNumber.isNegative());
        System.out.println("Is Positive: " + myNumber.isPositive());
        System.out.println("Is Zero: " + myNumber.isZero());
        System.out.println("Is Odd: " + myNumber.isOdd());
        System.out.println("Is Even: " + myNumber.isEven());

        scanner.close();
    }
}
