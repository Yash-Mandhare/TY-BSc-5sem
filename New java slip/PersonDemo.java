// Write program to define class Person with data member as Personname,Aadharno, Panno.
// Accept information for 5 objects and display appropriate information (use this keyword).

import java.util.Scanner;

class Person {
    private String personName;
    private String aadharNo;
    private String panNo;

    // Constructor for Person class
    public Person(String personName, String aadharNo, String panNo) {
        this.personName = personName;
        this.aadharNo = aadharNo;
        this.panNo = panNo;
    }

    // Display method for Person class
    public void display() {
        System.out.println("Person Name: " + this.personName);
        System.out.println("Aadhar Number: " + this.aadharNo);
        System.out.println("PAN Number: " + this.panNo);
    }
}

public class PersonDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Person[] persons = new Person[5];

        // Accept information for 5 objects
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter information for Person " + (i + 1) + ":");
            System.out.print("Person Name: ");
            String personName = scanner.next();

            System.out.print("Aadhar Number: ");
            String aadharNo = scanner.next();

            System.out.print("PAN Number: ");
            String panNo = scanner.next();

            persons[i] = new Person(personName, aadharNo, panNo);
        }

        // Display information for all persons
        System.out.println("\nPerson Information:");
        for (Person person : persons) {
            person.display();
            System.out.println(); // Add a newline for better readability
        }

        scanner.close();
    }
}
