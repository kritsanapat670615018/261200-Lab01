import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Turtle Drawing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.add(new JulyPanel());
        frame.setVisible(true);
    }
}

class JulyPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Sky background
        setBackground(Color.CYAN);

        // Draw Sun
        drawSun(g, 80, 80, 50);

        // Draw Fireworks
        drawFirework(g, 300, 300, 8, 60, Color.RED);
        drawFirework(g, 450, 200, 12, 40, Color.MAGENTA);
        drawFirework(g, 200, 400, 10, 50, Color.ORANGE);
    }

    private void drawSun(Graphics g, int x, int y, int r) {
        g.setColor(Color.YELLOW);
        g.fillOval(x - r, y - r, r * 2, r * 2);

        // Draw rays using loop
        for (int i = 0; i < 12; i++) {
            double angle = Math.toRadians(i * 30);
            int x1 = x + (int)(r * Math.cos(angle));
            int y1 = y + (int)(r * Math.sin(angle));
            int x2 = x + (int)((r + 20) * Math.cos(angle));
            int y2 = y + (int)((r + 20) * Math.sin(angle));
            g.drawLine(x1, y1, x2, y2);
        }
    }

    private void drawFirework(Graphics g, int x, int y, int lines, int length, Color color) {
        g.setColor(color);
        for (int i = 0; i < lines; i++) {
            double angle = Math.toRadians(i * (360.0 / lines));
            int x2 = x + (int)(length * Math.cos(angle));
            int y2 = y + (int)(length * Math.sin(angle));
            g.drawLine(x, y, x2, y2);
        }
    }
}
