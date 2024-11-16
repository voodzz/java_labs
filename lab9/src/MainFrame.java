import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame(String title) throws HeadlessException {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(600,800);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Task 1", new TaskOnePanel());
        add(tabbedPane);

        setVisible(true);
    }
}
