// Write a menu driven program to perform the following operations i. Calculate the volume of cylinder. (hint : Volume: π × r² × h)
// ii. Find the factorial of given number.
// iii. Check the number is Armstrong or not.
// iv. Exit


import java.util.Scanner;

public class Factorial_Armstrong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Calculate the volume of a cylinder");
            System.out.println("2. Find the factorial of a number");
            System.out.println("3. Check if a number is Armstrong");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1/2/3/4): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    calculateCylinderVolume();
                    break;
                case 2:
                    findFactorial();
                    break;
                case 3:
                    checkArmstrongNumber();
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 4);
    }

    public static void calculateCylinderVolume() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the radius of the cylinder: ");
        double radius = scanner.nextDouble();
        System.out.print("Enter the height of the cylinder: ");
        double height = scanner.nextDouble();

        double volume = Math.PI * Math.pow(radius, 2) * height;
        System.out.println("The volume of the cylinder is: " + volume);
    }

    public static void findFactorial() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to find its factorial: ");
        int n = scanner.nextInt();

        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }

        System.out.println("The factorial of " + n + " is: " + factorial);
    }

    public static void checkArmstrongNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to check if it's an Armstrong number: ");
        int number = scanner.nextInt();
        int originalNumber = number;
        int sum = 0;

        int numberOfDigits = (int) Math.log10(number) + 1;

        while (number > 0) {
            int digit = number % 10;
            sum += Math.pow(digit, numberOfDigits);
            number /= 10;
        }

        if (sum == originalNumber) {
            System.out.println(originalNumber + " is an Armstrong number.");
        } else {
            System.out.println(originalNumber + " is not an Armstrong number.");
        }
    }
}
