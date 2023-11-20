import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ConcentricCircles extends JFrame {

    public ConcentricCircles() {
        setTitle("Concentric Circles");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addMouseListener(new CircleMouseListener());

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class CircleMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            drawConcentricCircles(e.getX(), e.getY());
        }
    }

    private void drawConcentricCircles(int x, int y) {
        Graphics g = getGraphics();
        g.setColor(Color.BLUE);

        // Draw three concentric circles centered at the mouse click position
        int radius1 = 30;
        int radius2 = 60;
        int radius3 = 90;

        g.drawOval(x - radius1, y - radius1, 2 * radius1, 2 * radius1);
        g.drawOval(x - radius2, y - radius2, 2 * radius2, 2 * radius2);
        g.drawOval(x - radius3, y - radius3, 2 * radius3, 2 * radius3);
    }

    public static void main(String[] args) {
        new ConcentricCircles();
    }
}
