import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Task1App extends JFrame {
    private JButton button;
    private JLabel statusLabel;

    public Task1App() {
        setTitle("Task 1");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        statusLabel = new JLabel("Cursor Coordinates: ");
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        statusLabel.setBounds(0, this.getHeight() - 50, this.getWidth(), 50);
        add(statusLabel);

        button = new JButton("Button");
        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.setBounds(this.getWidth() / 2 - 100,  this.getHeight() / 2 - 15, 200, 30);
        add(button);

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Point point = SwingUtilities.convertPoint(e.getComponent(), e.getPoint(), Task1App.this);
                button.setLocation(point.x - button.getWidth() / 2, point.y - button.getHeight() / 2);
            }
        });

        button.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
               if (e.isControlDown()) {
                   Point point = SwingUtilities.convertPoint(e.getComponent(), e.getPoint(), Task1App.this);
                   button.setLocation(point.x - button.getWidth() / 2, point.y - button.getHeight() / 2);
                   statusLabel.setText("Cursor Coordinates: " + point.x + ", " + point.y);
               }
            }

            public void mouseMoved(MouseEvent e) {
                Point point = SwingUtilities.convertPoint(e.getComponent(), e.getPoint(), Task1App.this);
                statusLabel.setText("Cursor Coordinates: " + point.x + ", " + point.y);
            }
        });

        button.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE && !button.getText().isEmpty()) {
                    button.setText(button.getText().substring(0, button.getText().length() - 1));
                } else if (Character.isLetterOrDigit(e.getKeyChar()) || e.getKeyCode() == KeyEvent.VK_SPACE
                || e.getKeyCode() == KeyEvent.VK_COMMA || e.getKeyCode() == KeyEvent.VK_PERIOD
                || e.getKeyCode() == KeyEvent.VK_SLASH || e.getKeyCode() == KeyEvent.VK_QUOTE) {
                    button.setText(button.getText() + e.getKeyChar());
                }
            }
        });
        button.setFocusable(true);

        setVisible(true);
    }
}