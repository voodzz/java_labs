import javax.swing.*;

public class Frame extends JFrame {
    Frame(Course course) {
        setSize(600,600);
        setTitle("Session info");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        CoursePanel coursePanel = new CoursePanel(course);
        setContentPane(coursePanel);
        setVisible(true);
    }
}
