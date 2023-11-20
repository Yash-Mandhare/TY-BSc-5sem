// Write a program that creates a user interface to perform integer divisions. The user enters two
// numbers in the text fields, Number1 and Number2. The division of Number1 and Number2 is
// displayed in the Result field when the Divide button is clicked. If Number1 or Number2 were
// not an integer, the program would throw a NumberFormatException. If Number2 were Zero,
// the program would throw an Arithmetic Exception Display the exception in a message
// dialog box.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DivisionCalculator extends JFrame {
    private JTextField number1Field, number2Field, resultField;

    public DivisionCalculator() {
        // Set up the frame
        setTitle("Integer Division Calculator");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        JLabel labelNumber1 = new JLabel("Number1:");
        JLabel labelNumber2 = new JLabel("Number2:");
        JLabel labelResult = new JLabel("Result:");

        number1Field = new JTextField(10);
        number2Field = new JTextField(10);
        resultField = new JTextField(10);
        resultField.setEditable(false);

        JButton divideButton = new JButton("Divide");
        divideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performDivision();
            }
        });

        // Set up the layout
        setLayout(new GridLayout(4, 2, 10, 10));
        add(labelNumber1);
        add(number1Field);
        add(labelNumber2);
        add(number2Field);
        add(labelResult);
        add(resultField);
        add(new JLabel()); // Placeholder for better alignment
        add(divideButton);

        // Display the frame
        setVisible(true);
    }

    private void performDivision() {
        try {
            // Get the numbers from the text fields
            int number1 = Integer.parseInt(number1Field.getText());
            int number2 = Integer.parseInt(number2Field.getText());

            // Perform division and display the result
            int result = number1 / number2;
            resultField.setText(Integer.toString(result));
        } catch (NumberFormatException ex) {
            // Handle non-integer input
            JOptionPane.showMessageDialog(this, "Please enter valid integers for Number1 and Number2.",
                    "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (ArithmeticException ex) {
            // Handle division by zero
            JOptionPane.showMessageDialog(this, "Cannot divide by zero. Please enter a non-zero value for Number2.",
                    "Arithmetic Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // Run the GUI on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DivisionCalculator();
            }
        });
    }
}
