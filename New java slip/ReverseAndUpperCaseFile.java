import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseAndUpperCaseFile {
    public static void main(String[] args) throws IOException {
        String fileName = "sample.txt"; // Change this to your file path

        // Read the file and store its lines in a list
        List<String> lines = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;

        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }

        reader.close();

        // Reverse the list and convert to uppercase
        Collections.reverse(lines);
        for (int i = 0; i <  lines.size(); i++) {
            lines.set(i, lines.get(i).toUpperCase());
        }

        // Write the modified content back to the file
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

        for (String modifiedLine : lines) {
            writer.write(modifiedLine);
            writer.newLine();
        }

        writer.close();

        System.out.println("File contents reversed and converted to uppercase. Changes saved to " + fileName);
    }
}
