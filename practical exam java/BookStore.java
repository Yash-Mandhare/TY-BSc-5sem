import java.io.*;
import java.util.Scanner;

class Book {
    private int bookid;
    private String bookname;
    private double bookprice;
    private int bookqty;

    public Book(int bookid, String bookname, double bookprice, int bookqty) {
        this.bookid = bookid;
        this.bookname = bookname;
        this.bookprice = bookprice;
        this.bookqty = bookqty;
    }

    public int getBookId() {
        return bookid;
    }

    public String getBookName() {
        return bookname;
    }

    public double getBookPrice() {
        return bookprice;
    }

    public int getBookQty() {
        return bookqty;
    }

    public void writeData(RandomAccessFile file) throws IOException {
        file.writeInt(bookid);
        file.writeUTF(bookname);
        file.writeDouble(bookprice);
        file.writeInt(bookqty);
    }

    public static Book readData(RandomAccessFile file) throws IOException {
        int bookid = file.readInt();
        String bookname = file.readUTF();
        double bookprice = file.readDouble();
        int bookqty = file.readInt();
        return new Book(bookid, bookname, bookprice, bookqty);
    }
}

public class BookStore{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            RandomAccessFile file = new RandomAccessFile("book.dat", "rw");

            while (true) {
                System.out.println("Menu:");
                System.out.println("1. Search for a specific book by name");
                System.out.println("2. Display all books and total cost");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter the book name to search: ");
                        String searchName = scanner.nextLine();
                        boolean found = false;

                        file.seek(0);
                        while (file.getFilePointer() < file.length()) {
                            Book book = Book.readData(file);
                            if (book.getBookName().equalsIgnoreCase(searchName)) {
                                System.out.println("Book Found: " + book.getBookName());
                                System.out.println("Book ID: " + book.getBookId());
                                System.out.println("Book Price: " + book.getBookPrice());
                                System.out.println("Book Quantity: " + book.getBookQty());
                                found = true;
                            }
                        }

                        if (!found) {
                            System.out.println("Book not found.");
                        }
                        break;

                    case 2:
                        double totalCost = 0;

                        file.seek(0);
                        while (file.getFilePointer() < file.length()) {
                            Book book = Book.readData(file);
                            System.out.println("Book ID: " + book.getBookId());
                            System.out.println("Book Name: " + book.getBookName());
                            System.out.println("Book Price: " + book.getBookPrice());
                            System.out.println("Book Quantity: " + book.getBookQty());
                            totalCost += (book.getBookPrice() * book.getBookQty());
                            System.out.println();
                        }

                        System.out.println("Total Cost of all books: " + totalCost);
                        break;

                    case 3:
                        file.close();
                        scanner.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            }
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
