import SY.SYMarks;
import TY.TYMarks;

public class Main {
    public static void main(String[] args) {
        // Create SYMarks and TYMarks objects for a student
        SYMarks syMarks = new SYMarks(75, 80, 85);
        TYMarks tyMarks = new TYMarks(90, 95);

        // Create a Student object
        Student student = new Student(101, "John Doe", syMarks, tyMarks);

        // Calculate and display the grade for the student
        student.calculateGrade();
    }
}

