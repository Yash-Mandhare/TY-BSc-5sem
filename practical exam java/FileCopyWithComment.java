import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopyWithComment {
    public static void main(String[] args) {
        // Replace these with the actual file paths
        String inputFile = "first.txt";
        String outputFile = "second.txt";

        try {
            // Open the first file for reading
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));

            // Open the second file for writing
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            // Copy the contents from the first file to the second file
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine(); // Add a new line after each line from the first file
            }

            // Add the comment at the end of the second file
            writer.write("end of file");

            // Close the files
            reader.close();
            writer.close();

            System.out.println("File copied successfully with the comment.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
