import java.io.*;

public class CreateBookDataFile {
    public static void main(String[] args) {
        try (RandomAccessFile file = new RandomAccessFile("book.dat", "rw")) {
            // Write book data to the file
            Book book1 = new Book(1, "Introduction to Java", 25.0, 10);
            Book book2 = new Book(2, "Data Structures in C++", 30.0, 5);
            Book book3 = new Book(3, "Python Programming", 20.0, 15);
            Book book4 = new Book(4, "Algorithms and Data Structures", 40.0, 7);

            book1.writeData(file);
            book2.writeData(file);
            book3.writeData(file);
            book4.writeData(file);

            System.out.println("Data has been written to book.dat.");
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
