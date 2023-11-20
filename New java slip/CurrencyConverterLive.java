// Write a simple currency converter, as shown in the figure. User can enter the amount of
// "Singapore Dollars", "US Dollars", or "Euros", in floating-point number. The converted
// values shall be displayed to 2 decimal places. Assume that 1 USD = 1.41 SGD,
// 1 USD = 0.92 Euro, 1 SGD = 0.65 Euro.

import java.awt.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class CurrencyConverterLive extends JFrame {
    private JTextField sgdTextField;
    private JTextField usdTextField;
    private JTextField euroTextField;

    private static final double SGD_TO_USD_RATE = 1.41;
    private static final double SGD_TO_EURO_RATE = 0.92;

    public CurrencyConverterLive() {
        setTitle("Currency Converter Live");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        panel.add(new JLabel("Singapore Dollar:"));
        sgdTextField = new JTextField();
        panel.add(sgdTextField);

        panel.add(new JLabel("US Dollar:"));
        usdTextField = new JTextField();
        usdTextField.setEditable(false); // Prevent editing, as it's automatically updated
        panel.add(usdTextField);

        panel.add(new JLabel("Euro:"));
        euroTextField = new JTextField();
        euroTextField.setEditable(false); // Prevent editing, as it's automatically updated
        panel.add(euroTextField);

        // Add DocumentListener to update other text fields dynamically
        sgdTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateConversion();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateConversion();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateConversion();
            }
        });

        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void updateConversion() {
        try {
            double sgdAmount = Double.parseDouble(sgdTextField.getText());

            // Update USD and Euro text fields
            double usdAmount = sgdAmount * SGD_TO_USD_RATE;
            double euroAmount = sgdAmount * SGD_TO_EURO_RATE;

            usdTextField.setText(String.format("%.2f", usdAmount));
            euroTextField.setText(String.format("%.2f", euroAmount));
        } catch (NumberFormatException ex) {
            // Handle invalid input
            usdTextField.setText("");
            euroTextField.setText("");
        }
    }

    public static void main(String[] args) {
        new CurrencyConverterLive();
    }
}
