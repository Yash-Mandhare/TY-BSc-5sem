// Write a program which shows the combo box which includes list of T.Y.B.Sc.(Comp. Sci)
// subjects. Display the selected subject in a text field.

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubjectComboBoxExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Subject Selection");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a combo box with T.Y.B.Sc.(Comp. Sci) subjects
        String[] subjects = {"Advanced Java", "Data Structures", "Database Management Systems", "Operating Systems", "Software Engineering"};
        JComboBox<String> subjectComboBox = new JComboBox<>(subjects);
        subjectComboBox.setSelectedIndex(0); // Set default selection

        // Create a text field to display the selected subject
        JTextField selectedSubjectTextField = new JTextField(20);
        selectedSubjectTextField.setEditable(false);

        // Add an ActionListener to the combo box to update the text field
        subjectComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedSubject = (String) subjectComboBox.getSelectedItem();
                selectedSubjectTextField.setText("Selected Subject: " + selectedSubject);
            }
        });

        // Create a panel and add components to it
        JPanel panel = new JPanel();
        panel.add(new JLabel("Select Subject: "));
        panel.add(subjectComboBox);
        panel.add(selectedSubjectTextField);

        // Add the panel to the frame
        frame.add(panel);

        // Set frame visibility
        frame.setVisible(true);
    }
}

