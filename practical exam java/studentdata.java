// Define Student class(roll_no, name, percentage) to create n objects of the Student class. Accept details from the user for each object. Define a static method “sortStudent” which sorts the array on the basis of percentage.


import java.util.Scanner;
import java.util.Arrays;

class StudentInfo {
    private int rollNo;
    private String name;
    private double percentage;

    public StudentInfo(int rollNo, String name, double percentage) {
        this.rollNo = rollNo;
        this.name = name;
        this.percentage = percentage;
    }

    public static void sortStudents(StudentInfo[] students) {
        Arrays.sort(students, (s1, s2) -> Double.compare(s2.percentage, s1.percentage));
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public double getPercentage() {
        return percentage;
    }

    @Override
    public String toString() {
        return String.format("| %-8d | %-20s | %8.2f |", rollNo, name, percentage);
    }
}

public class studentdata {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();

        StudentInfo[] students = new StudentInfo[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for student " + (i + 1) + ":");
            System.out.print("Roll No: ");
            int rollNo = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Percentage: ");
            double percentage = scanner.nextDouble();

            students[i] = new StudentInfo(rollNo, name, percentage);
        }

        StudentInfo.sortStudents(students);

        System.out.println("+----------+----------------------+----------+");
        System.out.println("| Roll No  | Name                 | Percentage|");
        System.out.println("+----------+----------------------+----------+");

        for (StudentInfo student : students) {
            System.out.println(student);
        }

        System.out.println("+----------+----------------------+----------+");

        scanner.close();
    }
}


/*
 Enter the number of students: 2
Enter details for student 1:
Roll No: 101
Name: yash
Percentage: 70.0
Enter details for student 2:
Roll No: 102
Name: siddhi
Percentage: 85.9
+----------+----------------------+----------+
| Roll No  | Name                 | Percentage|
+----------+----------------------+----------+
| 102      | siddhi               |    85.90 |
| 101      | yash                 |    70.00 |
+----------+----------------------+----------+
 */