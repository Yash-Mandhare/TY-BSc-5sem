// Define a class patient (patient_name, patient_age, patient_oxy_level,patient_HRCT_report). Create an object of patient. Handle appropriate exception while patient oxygen level less than 95% and HRCT scan report greater than 10, then throw user defined Exception “Patient is Covid Positive(+) and Need to Hospitalized” otherwise display its information.

import java.util.Scanner;


class patient{
	private String name;
	private int age;
	private double oxy_level;
	private int HRCT;

	public patient(String name, int age, double oxy_level, int HRCT){
		this.name = name;
		this.age =age;
		this.oxy_level =oxy_level;
		this.HRCT =HRCT;

	
	}
	
	public void Displaypatient(){
		System.out.println("the patient details:");
		System.out.println("Patient Name: "+name);
		System.out.println("Patient Age: "+age);
		System.out.println("Patient oxy_level: "+oxy_level+"%");
		System.out.println("Patient HRCT report: "+HRCT+"\n\n");

		if(oxy_level< 95 && HRCT>10){
			System.out.println("Patient is Covid Positive(+) and Need to Hospitalized");
		}
		else{
			System.out.println("Patient is not Covid Positive(+) ");
		}
	}
}

public class PatientDemo{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter patient details:");
		System.out.print("Patient Name: ");
		String name = input.nextLine();
		System.out.print("Patient Age: ");
		int age = input.nextInt();
		System.out.print("Patient oxy_level: ");
		Double oxy_level = input.nextDouble();
		System.out.print("Patient HRCT report: ");
		int HRCT = input.nextInt();

		patient patientdetails = new patient(name,age , oxy_level, HRCT );
		
		patientdetails.Displaypatient();
		
	}
}

	