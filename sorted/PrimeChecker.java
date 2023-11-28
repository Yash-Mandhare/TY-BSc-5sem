// Write a program to accept a number from the user, if number is zero then throw user defined
// exception “Number is 0” otherwise check whether no is prime or not (Use static keyword).

import java.util.Scanner;

public class PrimeExample {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number to check if it's prime: ");
        int n = scanner.nextInt();

        int i, m = 0, flag = 0;
        m = n / 2;

        if (n == 0 || n == 1) {
            System.out.println(n + " is not a prime number");
        } else {
            for (i = 2; i <= m; i++) {
                if (n % i == 0) {
                    System.out.println(n + " is not a prime number");
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                System.out.println(n + " is a prime number");
            }
        }

        scanner.close(); // Close the scanner to prevent resource leak
    }
}

