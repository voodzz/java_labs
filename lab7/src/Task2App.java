import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Random;

public class Task2App extends JFrame {
    private JLabel label;
    private JButton yesButton;
    private JButton noButton;

    Task2App() {
        setTitle("Task 2");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        label = new JLabel("Вас устраивает ваше расписание?");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBounds(0, this.getHeight() / 2 - 50, this.getWidth(), 30);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        add(label);

        yesButton = new JButton("Ужасное расписание");
        yesButton.setHorizontalAlignment(SwingConstants.CENTER);
        yesButton.setFont(new Font("Arial", Font.BOLD, 12));
        yesButton.setBounds(125, this.getHeight() / 2, 250, 50);
        add(yesButton);

        noButton = new JButton("Могло быть лучше");
        noButton.setHorizontalAlignment(SwingConstants.CENTER);
        noButton.setFont(new Font("Arial", Font.BOLD, 12));
        noButton.setBounds(125 + yesButton.getWidth() + 50, this.getHeight() / 2, 250, 50);
        add(noButton);
        setVisible(true);

        noButton.addActionListener(actionEvent -> {
            JOptionPane.showMessageDialog(this, "Я старалсь, как могла",
                    "Ответ", JOptionPane.INFORMATION_MESSAGE);
        });

        yesButton.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                Random rand = new Random();
                int x, y;
                do {
                    x = rand.nextInt(800 - yesButton.getWidth());
                    y = rand.nextInt(800 - yesButton.getHeight());
                    yesButton.setLocation(x, y);
                } while (yesButton.getBounds().intersects(label.getBounds()) ||
                        yesButton.getBounds().intersects(noButton.getBounds()));
            }
        });
    }
}
