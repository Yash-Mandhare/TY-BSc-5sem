// Write a program to accept a file name from command prompt, if the file exits then display number of words and lines in that file.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileStats {
    public static void main(String[] args) {
        // Create a Scanner to take user input
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the file name: ");
        String fileName = scanner.nextLine();

        try {
            // Create a FileReader object to read the file
            FileReader fileReader = new FileReader(fileName);

            // Create a BufferedReader to read the file efficiently
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            int wordCount = 0;
            int lineCount = 0;

            // Read each line from the file
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lineCount++;
                // Split each line into words using space as the delimiter
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }

            // Close the BufferedReader
            bufferedReader.close();

            // Display the results
            System.out.println("Number of words in the file: " + wordCount);
            System.out.println("Number of lines in the file: " + lineCount);

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        } finally {
            // Close the Scanner
            scanner.close();
        }
    }
}
