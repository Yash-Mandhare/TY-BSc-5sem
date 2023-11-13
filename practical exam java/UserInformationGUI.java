// Create the following GUI screen using appropriate layout managers. Accept the name, class , hobbies of the user and apply the changes and display the selected options in a text box.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInformationGUI extends JFrame implements ActionListener {
    private JTextField nameField;
    private JComboBox<String> classComboBox;
    private JCheckBox[] hobbyCheckboxes;
    private JTextArea displayArea;

    public UserInformationGUI() {
        setTitle("User Information");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        // Name panel
        JPanel namePanel = new JPanel();
        namePanel.add(new JLabel("Name: "));
        nameField = new JTextField(20);
        namePanel.add(nameField);

        // Class panel
        JPanel classPanel = new JPanel();
        classPanel.add(new JLabel("Class: "));
        String[] classes = {"Class 1", "Class 2", "Class 3"};
        classComboBox = new JComboBox<>(classes);
        classPanel.add(classComboBox);

        // Hobbies panel
        JPanel hobbiesPanel = new JPanel();
        hobbiesPanel.add(new JLabel("Hobbies: "));
        String[] hobbies = {"Reading", "Gaming", "Sports", "Music"};
        hobbyCheckboxes = new JCheckBox[hobbies.length];
        for (int i = 0; i < hobbies.length; i++) {
            hobbyCheckboxes[i] = new JCheckBox(hobbies[i]);
            hobbiesPanel.add(hobbyCheckboxes[i]);
        }

        // Display panel
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new BorderLayout());
        displayArea = new JTextArea(5, 20);
        displayArea.setEditable(false);
        displayPanel.add(new JLabel("Selected Options:"), BorderLayout.NORTH);
        displayPanel.add(new JScrollPane(displayArea), BorderLayout.CENTER);

        // Apply button
        JButton applyButton = new JButton("Apply Changes");
        applyButton.addActionListener(this);

        // Add components to the main panel
        panel.add(namePanel);
        panel.add(classPanel);
        panel.add(hobbiesPanel);
        panel.add(applyButton);
        panel.add(displayPanel);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Apply Changes")) {
            displaySelectedOptions();
        }
    }

    private void displaySelectedOptions() {
        StringBuilder selectedOptions = new StringBuilder();
        selectedOptions.append("Name: ").append(nameField.getText()).append("\n");
        selectedOptions.append("Class: ").append(classComboBox.getSelectedItem()).append("\n");
        selectedOptions.append("Hobbies: ");
        for (JCheckBox checkbox : hobbyCheckboxes) {
            if (checkbox.isSelected()) {
                selectedOptions.append(checkbox.getText()).append(", ");
            }
        }
        // Remove the last comma and space if any hobbies are selected
        if (selectedOptions.toString().endsWith(", ")) {
            selectedOptions.setLength(selectedOptions.length() - 2);
        }
        displayArea.setText(selectedOptions.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UserInformationGUI());
    }
}
