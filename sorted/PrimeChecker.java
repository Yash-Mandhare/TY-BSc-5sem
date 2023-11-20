// Write a program to accept a number from the user, if number is zero then throw user defined
// exception “Number is 0” otherwise check whether no is prime or not (Use static keyword).

import java.util.Scanner;

class PrimeNumberException extends Exception {
    public PrimeNumberException(String message) {
        super(message);
    }
}

public class PrimeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter a number: ");
            int number = scanner.nextInt();

            if (number == 0) {
                throw new PrimeNumberException("Number is 0");
            }

            if (isPrime(number)) {
                System.out.println(number + " is a prime number.");
            } else {
                System.out.println(number + " is not a prime number.");
            }
        } catch (PrimeNumberException e) {
            System.out.println("Exception: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid number.");
        } finally {
            scanner.close();
        }
    }

    // Static method to check whether a number is prime
    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
