package student;

import student.StudentInfo;
import student.StudentPer;

public class StudentExample {
    public static void main(String[] args) {
        // Create a StudentPer object to input marks
        StudentPer studentPer = new StudentPer(101, "John Doe", "10th");

        // Display student information along with percentage
        studentPer.displayStudentInfoWithPercentage();

        // Create a StudentInfo object with predefined percentage
        StudentInfo studentInfo = new StudentInfo(101, "John Doe", "10th", 85.5);

        // Display student information
        studentInfo.displayStudentInfo();
    }
}

// Enter marks for 6 subjects:
// Subject 1: 90
// Subject 2: 85
// Subject 3: 78
// Subject 4: 92
// Subject 5: 88
// Subject 6: 95
// Student Information with Percentage:
// Roll Number: 101
// Name: John Doe
// Class: 10th
// Percentage: 88.0%

// Student Information:
// Roll Number: 101
// Name: John Doe
// Class: 10th
// Percentage: 85.5%

