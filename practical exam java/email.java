import java.util.Scanner;

class InvalidUsernameException extends Exception {
    public InvalidUsernameException(String message) {
        super(message);
    }
}

class InvalidPasswordException extends Exception {
    public InvalidPasswordException(String message) {
        super(message);
    }
}

class EmailId {
    private String username;
    private String password;

    public EmailId() {
        username = "";
        password = "";
    }

    public EmailId(String username, String password) throws InvalidUsernameException, InvalidPasswordException {
        if (isValidUsername(username)) {
            this.username = username;
        } else {
            throw new InvalidUsernameException("Invalid username");
        }

        if (isValidPassword(password)) {
            this.password = password;
        } else {
            throw new InvalidPasswordException("Invalid password");
        }
    }

    private boolean isValidUsername(String username) {
        // Add your validation logic here
        // For example, you can check for a valid email format
        return username.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$");
    }

    private boolean isValidPassword(String password) {
        // Add your validation logic for the password here
        // You can define your own rules for a valid password
        return password.length() >= 8;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter your email address: ");
            String username = scanner.nextLine();

            System.out.print("Enter your password: ");
            String password = scanner.nextLine();

            EmailId email = new EmailId(username, password);
            System.out.println("Email and password are valid.");
        } catch (InvalidUsernameException | InvalidPasswordException e) {
            System.err.println("Exception: " + e.getMessage());
        }

        scanner.close();
    }
}



// Enter your email address: john.doe@example.com
// Enter your password: strongpass123

// Output:
// Email and password are valid.


// Enter your email address: invalid_email
// Enter your password: somepassword

// Output:
// Exception: Invalid username


// Enter your email address: valid_email@example.com
// Enter your password: pass

// Output:
// Exception: Invalid password
