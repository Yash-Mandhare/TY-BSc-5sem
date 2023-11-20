// Write a java program that works as a simple calculator. Use a grid layout to arrange buttons for the digits and for the +, -, *, % operations. Add a text field to display the result.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame implements ActionListener {
    private JTextField display;
    private String currentInput;
    private double result;
    private char operator;

    public SimpleCalculator() {
        setTitle("Modern Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField(10);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        display.setEditable(false);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 5));

        String[] buttonLabels = {
            "7", "8", "9", "/", "C",
            "4", "5", "6", "*", "AC",
            "1", "2", "3", "-", "=",
            "0", ".", "+", "%"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(this);
            button.setFont(new Font("Arial", Font.PLAIN, 18));
            buttonPanel.add(button);
        }

        add(display, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.matches("[0-9]+") || command.equals(".")) {
            currentInput = (currentInput == null) ? command : currentInput + command;
            display.setText(currentInput);
        } else if (command.equals("C")) {
            currentInput = "";
            display.setText("");
        } else if (command.equals("AC")) {
            currentInput = "";
            display.setText("");
            result = 0;
        } else if (command.matches("[+\\-*/%]")) {
            if (currentInput != null) {
                result = Double.parseDouble(currentInput);
                currentInput = "";
            }
            operator = command.charAt(0);
        } else if (command.equals("=")) {
            if (currentInput != null) {
                double secondOperand = Double.parseDouble(currentInput);
                switch (operator) {
                    case '+':
                        result += secondOperand;
                        break;
                    case '-':
                        result -= secondOperand;
                        break;
                    case '*':
                        result *= secondOperand;
                        break;
                    case '/':
                        result /= secondOperand;
                        break;
                    case '%':
                        result %= secondOperand;
                        break;
                }
                display.setText(String.valueOf(result));
                currentInput = null;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SimpleCalculator calculator = new SimpleCalculator();
            calculator.setVisible(true);
        });
    }
}
