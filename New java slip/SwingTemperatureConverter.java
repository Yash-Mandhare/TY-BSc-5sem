// Write a program called SwingTemperatureConverter to convert temperature values
// between Celsius and Fahrenheit. User can enter either the Celsius or the Fahrenheit value,
// in floating-point number. Hints: To display a floating-point number in a specific format
// (e.g., 1 decimal place), use the static method String.format(), which has the same form
// as printf(). For example, String.format("%.1f", 1.234) returns String "1.2".

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class SwingTemperatureConverter {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Temperature Converter");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel(new GridLayout(2, 2));

            JLabel celsiusLabel = new JLabel("Celsius:");
            JTextField celsiusField = new JTextField();

            JLabel fahrenheitLabel = new JLabel("Fahrenheit:");
            JTextField fahrenheitField = new JTextField();

            // Adding DocumentListener to the Celsius field for live conversion
            celsiusField.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    convertAndSetFahrenheit();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    convertAndSetFahrenheit();
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    convertAndSetFahrenheit();
                }

                private void convertAndSetFahrenheit() {
                    try {
                        // Get the input Celsius value from the user
                        double celsiusValue = Double.parseDouble(celsiusField.getText());

                        // Convert Celsius to Fahrenheit
                        double fahrenheitValue = (celsiusValue * 9 / 5) + 32;

                        // Display the result in the Fahrenheit field
                        fahrenheitField.setText(String.format("%.1f", fahrenheitValue));
                    } catch (NumberFormatException ex) {
                        // Handle invalid input
                        fahrenheitField.setText("Invalid Input");
                    }
                }
            });

            // Adding components to the panel
            panel.add(celsiusLabel);
            panel.add(celsiusField);
            panel.add(fahrenheitLabel);
            panel.add(fahrenheitField);

            // Adding the panel to the frame
            frame.getContentPane().add(panel);

            frame.setSize(300, 150);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
