import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MouseEventDemo extends JFrame {

    private JLabel label;

    public MouseEventDemo() {
        setTitle("Mouse Event Demo");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel("No event yet");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setForeground(Color.BLACK);

        JPanel panel = new JPanel();
        panel.add(label);

        // Add mouse adapter to handle mouse events
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                displayEvent("Mouse Clicked");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                displayEvent("Mouse Pressed");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                displayEvent("Mouse Released");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                displayEvent("Mouse Entered");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                displayEvent("Mouse Exited");
            }
        });

        // Add the panel to the frame
        add(panel);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void displayEvent(String eventName) {
        label.setText(eventName);
        label.setForeground(Color.RED);
    }

    public static void main(String[] args) {
        new MouseEventDemo();
    }
}
