// Define a class ‘Donor’ to store the below mentioned details of a blood donor. name, age,
// address, contactnumber, bloodgroup, date of last donation. Create ‘n’ objects of this class for
// all the regular donors at Pune. Write these objects to a file. Read these objects from the file and
// display only those donors’ details whose blood group is ‘A+ve’ and had not donated for the
// recent six months.

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Donor implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int age;
    private String address;
    private String contactNumber;
    private String bloodGroup;
    private Date lastDonationDate;

    public Donor(String name, int age, String address, String contactNumber, String bloodGroup, String lastDonationDate) throws ParseException {
        this.name = name;
        this.age = age;
        this.address = address;
        this.contactNumber = contactNumber;
        this.bloodGroup = bloodGroup;

        // Parse the date string to a Date object
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.lastDonationDate = dateFormat.parse(lastDonationDate);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public Date getLastDonationDate() {
        return lastDonationDate;
    }

    @Override
    public String toString() {
        return "Donor [name=" + name + ", age=" + age + ", address=" + address + ", contactNumber=" + contactNumber
                + ", bloodGroup=" + bloodGroup + ", lastDonationDate=" + lastDonationDate + "]";
    }
}

public class DonorManagement {
    public static void main(String[] args) {
        List<Donor> donorList = new ArrayList<>();

        try {
            // Creating Donor objects
            Donor donor1 = new Donor("John Doe", 30, "Pune", "1234567890", "A+", "01/01/2023");
            Donor donor2 = new Donor("Jane Doe", 25, "Pune", "9876543210", "B+", "15/05/2022");
            Donor donor3 = new Donor("Alice Smith", 35, "Pune", "5551112222", "A+", "20/08/2022");

            donorList.add(donor1);
            donorList.add(donor2);
            donorList.add(donor3);

            // Writing Donor objects to a file
            writeDonorsToFile(donorList, "donors.dat");

            // Reading Donor objects from the file
            List<Donor> readDonorList = readDonorsFromFile("donors.dat");

            // Displaying donors with blood group 'A+' and not donated in the last six months
            displayFilteredDonors(readDonorList);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void writeDonorsToFile(List<Donor> donorList, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(donorList);
            System.out.println("Donor objects written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Donor> readDonorsFromFile(String fileName) {
        List<Donor> readDonorList = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            readDonorList = (List<Donor>) ois.readObject();
            System.out.println("Donor objects read from file successfully.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return readDonorList;
    }

    private static void displayFilteredDonors(List<Donor> donorList) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date currentDate = new Date();

        System.out.println("\nDonors with blood group 'A+' and not donated in the last six months:");
        for (Donor donor : donorList) {
            if ("A+".equals(donor.getBloodGroup()) && monthsBetween(donor.getLastDonationDate(), currentDate) >= 6) {
                System.out.println("Name: " + donor.getName());
                System.out.println("Age: " + donor.getAge());
                System.out.println("Address: " + donor.getAddress());
                System.out.println("Contact Number: " + donor.getContactNumber());
                System.out.println("Blood Group: " + donor.getBloodGroup());
                System.out.println("Last Donation Date: " + dateFormat.format(donor.getLastDonationDate()));
                System.out.println("------------------------");
            }
        }
    }

    private static int monthsBetween(Date startDate, Date endDate) {
        return (int) ((endDate.getTime() - startDate.getTime()) / (1000L * 60 * 60 * 24 * 30));
    }
}
