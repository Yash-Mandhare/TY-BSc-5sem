// Write a java program that take input as a person name in the format of first, middle and last name and then print it in the form last, first and middle name, where in the middle name first character is capital letter.
import java.util.Scanner;

class InvalidDateException extends Exception {
    public InvalidDateException(String message) {
        super(message);
    }
}

class MyDate {
    private int day;
    private int month;
    private int year;

    public MyDate(int day, int month, int year) throws InvalidDateException {
        if (isValidDate(day, month, year)) {
            this.day = day;
            this.month = month;
            this.year = year;
        } else {
            throw new InvalidDateException("Invalid date");
        }
    }

    private boolean isValidDate(int day, int month, int year) {
        if (year < 1 || month < 1 || month > 12 || day < 1) {
            return false;
        }

        int maxDays = 31; // Assume maximum days initially

        if (month == 4 || month == 6 || month == 9 || month == 11) {
            maxDays = 30;
        } else if (month == 2) {
            maxDays = isLeapYear(year) ? 29 : 28;
        }

        return day <= maxDays;
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public void displayDate() {
        System.out.println("Date: " + day + " " + month + " " + year);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter day (1-31): ");
            int day = scanner.nextInt();

            System.out.print("Enter month (1-12): ");
            int month = scanner.nextInt();

            System.out.print("Enter year: ");
            int year = scanner.nextInt();

            MyDate date = new MyDate(day, month, year);
            date.displayDate();

        } catch (InvalidDateException e) {
            System.err.println("Exception: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Invalid input: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
