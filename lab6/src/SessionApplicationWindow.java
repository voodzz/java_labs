import javax.swing.*;
import java.awt.*;

public class SessionApplicationWindow extends JFrame {
    private JPanel panel;
    private JLabel inputAreaLabel;
    private JLabel newStudentLabel;
    private JLabel studentNameLabel;
    private JLabel additionalResultsLabel;
    private JTextArea inputTextArea;
    private JTextArea additionalResultsTextArea;
    private JTextField studentNameTextField;
    private JButton addStudentButton;

    public SessionApplicationWindow() {
        setTitle("Session Observer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        setSize(800, 1100);
        setLocationRelativeTo(null);

        panel = new JPanel(new GridBagLayout());
        setContentPane(panel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Initializing labels
        inputAreaLabel = new JLabel("Input:");
        inputAreaLabel.setHorizontalAlignment(SwingConstants.CENTER);
        inputAreaLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        newStudentLabel = new JLabel("New student");
        newStudentLabel.setHorizontalAlignment(SwingConstants.CENTER);
        newStudentLabel.setFont(new Font("Arial", Font.BOLD, 18));
        studentNameLabel = new JLabel("Name:");
        studentNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        studentNameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        additionalResultsLabel = new JLabel("Session results (subj-mark):");
        additionalResultsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        additionalResultsLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        // Initializing textAreas
        inputTextArea = new JTextArea(10, 20);
        additionalResultsTextArea = new JTextArea(10, 40);

        // Initializing textFields
        studentNameTextField = new JTextField();

        // Initializing buttons
        addStudentButton = new JButton("Add");

        // Placing everything
        // First row
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(inputAreaLabel, gbc);

        // Second row
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(inputTextArea, gbc);

        // Third row
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(newStudentLabel, gbc);

        // Fourth row
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        panel.add(studentNameLabel, gbc);
        gbc.gridx = 1;
        panel.add(studentNameTextField, gbc);

        // Fifth row
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panel.add(additionalResultsLabel, gbc);

        // Sixth row
        gbc.gridy = 5;
        panel.add(additionalResultsTextArea, gbc);

        // Seventh row
        gbc.gridy = 6;
        panel.add(addStudentButton, gbc);

        setVisible(false);
    }
}
