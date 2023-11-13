// Define a class patient (patient_name, patient_age, patient_oxy_level,patient_HRCT_report). Create an object of patient. Handle appropriate exception while patient oxygen level less than 95% and HRCT scan report greater than 10, then throw user defined Exception “Patient is Covid Positive(+) and Need to Hospitalized” otherwise display its information.


import java.util.Scanner;

class CovidPositiveException extends Exception {
    public CovidPositiveException(String message) {
        super(message);
    }
}

class Patient {
    private String patientName;
    private int patientAge;
    private double patientOxyLevel;
    private int patientHRCTReport;

    public Patient(String patientName, int patientAge, double patientOxyLevel, int patientHRCTReport) {
        this.patientName = patientName;
        this.patientAge = patientAge;
        this.patientOxyLevel = patientOxyLevel;
        this.patientHRCTReport = patientHRCTReport;
    }

    public void checkPatientCondition() throws CovidPositiveException {
        if (patientOxyLevel < 95.0 && patientHRCTReport > 10) {
            throw new CovidPositiveException("Patient is Covid Positive(+) and Needs to be Hospitalized");
        }
    }

    public void displayPatientInfo() {
        System.out.println("Patient Information:");
        System.out.println("Name: " + patientName);
        System.out.println("Age: " + patientAge + " years");
        System.out.println("Oxygen Level: " + patientOxyLevel + "%");
        System.out.println("HRCT Scan Report: " + patientHRCTReport);
    }
}

public class PatientDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter patient details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        System.out.print("Oxygen Level (%): ");
        double oxygenLevel = scanner.nextDouble();
        System.out.print("HRCT Scan Report: ");
        int hrctReport = scanner.nextInt();

        Patient patient = new Patient(name, age, oxygenLevel, hrctReport);

        try {
            patient.checkPatientCondition();
            System.out.println("Patient is not Covid Positive. Details:");
            patient.displayPatientInfo();
        } catch (CovidPositiveException e) {
            System.out.println(e.getMessage());
        }
    }
}


// Enter patient details:
// Name: yash
// Age: 20
// Oxygen Level (%): 95.0
// HRCT Scan Report: 12
// Patient is not Covid Positive. Details:
// Patient Information:
// Name: yash
// Age: 20 years
// Oxygen Level: 95.0%
// HRCT Scan Report: 12

// Enter patient details:
// Name: yash
// Age: 20
// Oxygen Level (%): 94.0
// HRCT Scan Report: 12
// Patient is Covid Positive(+) and Needs to be Hospitalized