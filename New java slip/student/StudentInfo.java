package student;

public class StudentInfo {
    private int rollNo;
    private String name;
    private String studentClass;
    private double percentage;

    // Parameterized constructor to initialize student details
    public StudentInfo(int rollNo, String name, String studentClass, double percentage) {
        this.rollNo = rollNo;
        this.name = name;
        this.studentClass = studentClass;
        this.percentage = percentage;
    }

    // Method to display student information
    public void displayStudentInfo() {
        System.out.println("Student Information:");
        System.out.println("Roll Number: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Class: " + studentClass);
        System.out.println("Percentage: " + percentage + "%");
    }
}
