import SY.SYMarks;
import TY.TYMarks;

public class Student {
    private int rollNumber;
    private String name;
    private SYMarks syMarks;
    private TYMarks tyMarks;

    public Student(int rollNumber, String name, SYMarks syMarks, TYMarks tyMarks) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.syMarks = syMarks;
        this.tyMarks = tyMarks;
    }

    /**
     * 
     */
    public void calculateGrade() {
        double computerTotal = syMarks.getComputerTotal();
        double mathsTotal = syMarks.getMathsTotal();
        double electronicsTotal = syMarks.getElectronicsTotal();
        double theoryMarks = tyMarks.getTheory();
        double practicalMarks = tyMarks.getPracticals();
    
        double totalSYMarks = computerTotal + mathsTotal + electronicsTotal;
        double totalTYMarks = theoryMarks + practicalMarks;
        double totalMarks = totalSYMarks + totalTYMarks;
    
        double totalSubjects = 5; // Number of subjects in SY and TY
        double maxMarks = totalSubjects * 100; // Assuming maximum marks for each subject is 100
    
        double percentage = (totalMarks / maxMarks) * 100;
    
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
    
        System.out.println("Computer Marks: " + computerTotal);
        System.out.println("Maths Marks: " + mathsTotal);
        System.out.println("Electronics Marks: " + electronicsTotal);
        System.out.println("Theory Marks: " + theoryMarks);
        System.out.println("Practical Marks: " + practicalMarks);
    
        System.out.println("Total Marks (SY + TY): " + totalMarks);
        System.out.println("Percentage: " + percentage + "%");
    
        String grade;
        if (percentage >= 70) {
            grade = "A";
        } else if (percentage >= 60) {
            grade = "B";
        } else if (percentage >= 50) {
            grade = "C";
        } else if (percentage >= 40) {
            grade = "D";
        } else {
            grade = "FAIL";
        }
    
        System.out.println("Grade: " + grade);
    }
     
}
