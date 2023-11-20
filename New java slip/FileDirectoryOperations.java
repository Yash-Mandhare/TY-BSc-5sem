// Write a program to accept a string as command line argument and check whether it is a file or
// directory. Also perform operations as follows:
// i)If it is a directory,delete all text files in that directory. Confirm delete operation from
// user before deleting text files. Also, display a count showing the number of files deleted,
// if any, from the directory.
// ii)If it is a file display various details of that file.

import java.io.File;
import java.util.Scanner;

public class FileDirectoryOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the file or directory path: ");
        String path = scanner.nextLine();

        File fileOrDir = new File(path);

        if (!fileOrDir.exists()) {
            System.out.println("File or directory does not exist.");
            return;
        }

        if (fileOrDir.isDirectory()) {
            // If it's a directory, delete all text files
            deleteTextFiles(fileOrDir, scanner);
        } else {
            // If it's a file, display details
            displayFileDetails(fileOrDir);
        }

        scanner.close();
    }

    private static void deleteTextFiles(File directory, Scanner scanner) {
        File[] files = directory.listFiles();
        int deletedCount = 0;

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().toLowerCase().endsWith(".txt")) {
                    // Confirm delete operation from the user
                    System.out.print("Do you want to delete " + file.getName() + "? (yes/no): ");
                    String userResponse = scanner.nextLine().toLowerCase();

                    if (userResponse.equals("yes")) {
                        if (file.delete()) {
                            System.out.println(file.getName() + " deleted successfully.");
                            deletedCount++;
                        } else {
                            System.out.println("Failed to delete " + file.getName());
                        }
                    } else {
                        System.out.println(file.getName() + " not deleted.");
                    }
                }
            }
        }

        System.out.println("Total " + deletedCount + " text files deleted from the directory.");
    }

    private static void displayFileDetails(File file) {
        System.out.println("File Details:");
        System.out.println("Name: " + file.getName());
        System.out.println("Path: " + file.getAbsolutePath());
        System.out.println("Size: " + file.length() + " bytes");
        System.out.println("Is Directory: " + file.isDirectory());
        System.out.println("Last Modified: " + file.lastModified());
    }
}
