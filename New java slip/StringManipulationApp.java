import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StringManipulationApp extends JFrame {
    private JTextField textField1, textField2, textField3;
    private JButton concatButton, reverseButton;

    public StringManipulationApp() {
        // Set up the JFrame
        setTitle("String Manipulation App");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Create text boxes
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        textField1.setBounds(20, 20, 150, 30);
        textField2.setBounds(180, 20, 150, 30);
        textField3.setBounds(20, 70, 310, 30);
        textField3.setEditable(false); // Make the third text box read-only
        add(textField1);
        add(textField2);
        add(textField3);

        // Create buttons
        concatButton = new JButton("Concatenate");
        reverseButton = new JButton("Reverse");
        concatButton.setBounds(20, 120, 150, 30);
        reverseButton.setBounds(180, 120, 150, 30);
        add(concatButton);
        add(reverseButton);

        // Add action listeners to buttons
        concatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                concatenateStrings();
            }
        });

        reverseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reverseString();
            }
        });
    }

    private void concatenateStrings() {
        String text1 = textField1.getText();
        String text2 = textField2.getText();
        String result = text1 + " " + text2;
        textField3.setText(result);
    }

    private void reverseString() {
        String text = textField3.getText();
        String reversedText = new StringBuilder(text).reverse().toString();
        textField3.setText(reversedText);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                StringManipulationApp app = new StringManipulationApp();
                app.setVisible(true);
            }
        });
    }
}
