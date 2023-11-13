// Write a Java program to design a screen using Awt that will take a user name and password. If the user name and password are not same, raise an Exception with appropriate message. User can have 3 login chances only. Use clear button to clear the TextFields.


import java.awt.*;
import java.awt.event.*;

class LoginScreen extends Frame {
    TextField usernameTextField, passwordTextField;
    Label usernameLabel, passwordLabel;
    Button loginButton, clearButton;
    int loginAttempts = 3;

    public LoginScreen() {
        setTitle("Login Screen");
        setSize(300, 150);
        setLayout(new GridLayout(3, 2));
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        usernameLabel = new Label("Username: ");
        add(usernameLabel);

        usernameTextField = new TextField(20);
        add(usernameTextField);

        passwordLabel = new Label("Password: ");
        add(passwordLabel);

        passwordTextField = new TextField(20);
        passwordTextField.setEchoChar('*');
        add(passwordTextField);

        loginButton = new Button("Login");
        add(loginButton);

        clearButton = new Button("Clear");
        add(clearButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String username = usernameTextField.getText();
                String password = passwordTextField.getText();

                if (username.equals(password)) {
                    System.out.println("Login Successful!");
                    System.exit(0);
                } else {
                    loginAttempts--;
                    if (loginAttempts == 0) {
                        System.out.println("Login failed. No more login attempts.");
                        System.exit(0);
                    } else {
                        System.out.println("Login failed. " + loginAttempts + " attempts remaining.");
                        usernameTextField.setText("");
                        passwordTextField.setText("");
                    }
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                usernameTextField.setText("");
                passwordTextField.setText("");
            }
        });
    }

    public static void main(String[] args) {
        LoginScreen loginScreen = new LoginScreen();
        loginScreen.setVisible(true);
    }
}



// Enter a username and password that are the same to simulate a successful login. For example:
// Username: myuser
// Password: myuser
// If you enter a matching username and password, the program will display "Login Successful!" and terminate.

// Enter a username and password that are different to simulate a failed login. You have three chances before the program terminates. For example:
// Username: myuser
// Password: wrongpassword
// After three failed attempts, the program will display "Login failed. No more login attempts." and terminate.