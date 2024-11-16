import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TaskTwoPanel extends JPanel {
    private GridLayout gridLayout;
    private final int N = 5;
    private Color defaultColor;
    private String defaultText;

    TaskTwoPanel() {
        super();
        gridLayout = new GridLayout(N, N);
        setLayout(gridLayout);

        MouseListener mouseListener = new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                JButton source = (JButton) e.getSource();
                defaultColor = source.getBackground();
                source.setBackground(Color.cyan);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                JButton source = (JButton) e.getSource();
                source.setBackground(defaultColor);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    JButton source = (JButton) e.getSource();
                    defaultText = source.getText();
                    source.setText("Clicked!");
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    JButton source = (JButton) e.getSource();
                    source.setText(defaultText);
                }
            }
        };

        for (int i = 0; i < N * N; ++i) {
            JButton button = new JButton("" + (i + 1));
            button.setBackground(Color.LIGHT_GRAY);
            button.addMouseListener(mouseListener);
            add(button);
        }
    }
}
