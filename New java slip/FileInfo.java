// Write a program that reads on file name from the user, then displays information about
// whether the file exists, whether the file is readable, whether the file is writable, the type of
// file and the length of the file in bytes.

import java.io.File;
import java.util.Scanner;

public class FileInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for a file name
        System.out.print("Enter the file name: ");
        String fileName = scanner.nextLine();

        // Create a File object with the provided file name
        File file = new File(fileName);

        // Check if the file exists
        if (file.exists()) {
            System.out.println("File exists.");

            // Check if the file is readable
            System.out.println("Readable: " + file.canRead());

            // Check if the file is writable
            System.out.println("Writable: " + file.canWrite());

            // Get the type of file (directory or regular file)
            System.out.println("File Type: " + (file.isDirectory() ? "Directory" : "Regular File"));

            // Get the length of the file in bytes
            System.out.println("File Length: " + file.length() + " bytes");
        } else {
            System.out.println("File does not exist.");
        }

        scanner.close();
    }
}
