import javax.swing.*;
import java.awt.*;

public class CoursePanel extends JPanel {
    private JTextArea textArea;

    CoursePanel(Course course) {
        setLayout(new GridLayout());
        textArea = new JTextArea(10, 40);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Arial", Font.PLAIN, 18));
        add(new JScrollPane(textArea));
        textArea.setText(course.toString());
    }
}
