import java.util.Scanner;

class Clock {
    private int hours;
    private int minutes;
    private int seconds;
    private String amPm;

    // Default constructor
    public Clock() {
        hours = 0;
        minutes = 0;
        seconds = 0;
        amPm = "AM";
    }

    // Parameterized constructor with validation
    public Clock(int hours, int minutes, int seconds) {
        if (isValidTime(hours, minutes, seconds)) {
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;
            setAmPm();
        } else {
            System.out.println("Invalid time values. Setting default values.");
            this.hours = 0;
            this.minutes = 0;
            this.seconds = 0;
            this.amPm = "AM";
        }
    }

    // Method to check the validity of time values
    private boolean isValidTime(int hours, int minutes, int seconds) {
        return (hours >= 0 && hours < 24) &&
               (minutes >= 0 && minutes < 60) &&
               (seconds >= 0 && seconds < 60);
    }

    // Method to set the time to AM/PM mode
    private void setAmPm() {
        amPm = (hours >= 12) ? "PM" : "AM";
        if (hours > 12) {
            hours -= 12;
        } else if (hours == 0) {
            hours = 12;
        }
    }

    // Method to display the time
    public void displayTime() {
        System.out.printf("%02d:%02d:%02d %s%n", hours, minutes, seconds, amPm);
    }
}

public class ClockExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input hours, minutes, and seconds
        System.out.print("Enter hours: ");
        int hours = scanner.nextInt();
        System.out.print("Enter minutes: ");
        int minutes = scanner.nextInt();
        System.out.print("Enter seconds: ");
        int seconds = scanner.nextInt();

        // Create a Clock object with the provided values
        Clock myClock = new Clock(hours, minutes, seconds);

        // Display the time
        System.out.println("\nTime in 12-hour format:");
        myClock.displayTime();

        scanner.close();
    }
}
