package student;

import java.util.Scanner;

public class StudentPer {
    private int rollNo;
    private String name;
    private String studentClass;
    private int[] marks = new int[6];

    // Parameterized constructor to initialize student details
    public StudentPer(int rollNo, String name, String studentClass) {
        this.rollNo = rollNo;
        this.name = name;
        this.studentClass = studentClass;
        inputMarks();
    }

    // Method to input marks for 6 subjects
    private void inputMarks() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter marks for 6 subjects:");
        for (int i = 0; i < 6; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
        }
    }

    // Method to calculate and return the percentage
    public double calculatePercentage() {
        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }
        return (double) totalMarks / 6;
    }

    // Method to display student information along with calculated percentage
    public void displayStudentInfoWithPercentage() {
        System.out.println("Student Information with Percentage:");
        System.out.println("Roll Number: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Class: " + studentClass);
        System.out.println("Percentage: " + calculatePercentage() + "%");
    }
}
