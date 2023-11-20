import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutExample {

    public static void main(String[] args) {
        JFrame frame = new JFrame("BorderLayout Example");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create buttons for each region
        JButton buttonNorth = new JButton("North");
        JButton buttonSouth = new JButton("South");
        JButton buttonEast = new JButton("East");
        JButton buttonWest = new JButton("West");
        JButton buttonCenter = new JButton("Center");

        // Set layout manager to BorderLayout
        frame.setLayout(new BorderLayout());

        // Add buttons to the frame with specified regions
        frame.add(buttonNorth, BorderLayout.NORTH);
        frame.add(buttonSouth, BorderLayout.SOUTH);
        frame.add(buttonEast, BorderLayout.EAST);
        frame.add(buttonWest, BorderLayout.WEST);
        frame.add(buttonCenter, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
