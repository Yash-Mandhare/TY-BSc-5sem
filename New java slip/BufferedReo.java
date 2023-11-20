import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReo {
    public static void main(String[] args) {
        try {
            // Create BufferedReader object to read input from the console
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            // Read student information from the console
            System.out.print("Enter Roll No: ");
            int rollNo = Integer.parseInt(br.readLine());

            System.out.print("Enter Name: ");
            String name = br.readLine();

            System.out.print("Enter Class: ");
            String className = br.readLine();

            System.out.print("Enter Percentage: ");
            double percentage = Double.parseDouble(br.readLine());

            // Create a Student object with the entered information
            Student student = new Student(rollNo, name, className, percentage);

            // Display the student information
            student.displayStudentInfo();

            // Close the BufferedReader
            br.close();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
