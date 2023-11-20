// Write a java program to display the system date and time in various formats shown below:
// Current date is : 31/08/2021 Current date is : 08-31-2021
// Current date is : Tuesday August 31 2021
// Current date and time is : Fri August 31 15:25:59 IST 2021 Current date and time is : 31/08/21 15:25:59 PM +0530 Current time is : 15:25:59
// Current week of year is : 35 Current week of month : 5 Current day of the year is : 243
// Note: Use java.util.Date and java.text.SimpleDateFormat class


import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTimeFormatter {
    public static void main(String[] args) {
        // Get the current date and time
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);

        // Define date format patterns
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("MM-dd-yyyy");
        SimpleDateFormat dateFormat3 = new SimpleDateFormat("EEEE MMMM dd yyyy");
        SimpleDateFormat dateFormat4 = new SimpleDateFormat("E MMMM dd HH:mm:ss z yyyy");
        SimpleDateFormat dateFormat5 = new SimpleDateFormat("dd/MM/yy HH:mm:ss a Z");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat weekOfYearFormat = new SimpleDateFormat("w");
        SimpleDateFormat weekOfMonthFormat = new SimpleDateFormat("W");
        SimpleDateFormat dayOfYearFormat = new SimpleDateFormat("D");

        // Format and display the date and time in various formats
        System.out.println("Current date is : " + dateFormat1.format(currentDate));
        System.out.println("Current date is : " + dateFormat2.format(currentDate));
        System.out.println("Current date is : " + dateFormat3.format(currentDate));
        System.out.println("Current date and time is : " + dateFormat4.format(currentDate));
        System.out.println("Current date and time is : " + dateFormat5.format(currentDate));
        System.out.println("Current time is : " + timeFormat.format(currentDate));
        System.out.println("Current week of year is : " + weekOfYearFormat.format(currentDate));
        System.out.println("Current week of month : " + weekOfMonthFormat.format(currentDate));
        System.out.println("Current day of the year is : " + dayOfYearFormat.format(currentDate));
    }
}
