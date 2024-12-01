package Strategy;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class SessionApplicationWindow extends JFrame {
    private JPanel panel;
    private JLabel inputAreaLabel;
    private JLabel newStudentLabel;
    private JLabel idLabel;
    private JLabel studentSurnameLabel;
    private JLabel additionalResultsLabel;
    private JLabel subjectsLabel;
    private JTextArea inputTextArea;
    private JTextArea subjectsTextArea;
    private JTextField additionalResultsTextField;
    private JTextField idTextField;
    private JTextField studentNameTextField;
    private JButton addStudentButton;
    private JButton listSubjectsButton;
    private JButton openNewFileButton;

    private Font labelFont;
    private Font boldLabelFont;

    private Session session;
    private String fileName;

    public SessionApplicationWindow(InputWindow inputWindow) {
        setTitle("Session Observer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        setSize(800, 1100);
        setLocationRelativeTo(null);

        session = new Session();

        panel = new JPanel(new GridBagLayout());
        setContentPane(panel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        labelFont = new Font("Arial", Font.PLAIN, 18);
        boldLabelFont = new Font("Arial", Font.BOLD, 18);

        // Initializing labels
        inputAreaLabel = new JLabel("Data");
        inputAreaLabel.setHorizontalAlignment(SwingConstants.CENTER);
        inputAreaLabel.setFont(boldLabelFont);

        newStudentLabel = new JLabel("New student");
        newStudentLabel.setHorizontalAlignment(SwingConstants.CENTER);
        newStudentLabel.setFont(boldLabelFont);

        idLabel = new JLabel("ID:");
        idLabel.setHorizontalAlignment(SwingConstants.CENTER);
        idLabel.setFont(labelFont);

        studentSurnameLabel = new JLabel("Name:");
        studentSurnameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        studentSurnameLabel.setFont(labelFont);

        additionalResultsLabel = new JLabel("Session results (subj-mark):");
        additionalResultsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        additionalResultsLabel.setFont(labelFont);

        subjectsLabel = new JLabel("Session subjects (alphabetical order)");
        subjectsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        subjectsLabel.setFont(boldLabelFont);

        // Initializing textAreas
        inputTextArea = new JTextArea(10, 30);
        inputTextArea.setLineWrap(true);
        inputTextArea.setWrapStyleWord(true);

        subjectsTextArea = new JTextArea(2, 30);
        subjectsTextArea.setLineWrap(true);
        subjectsTextArea.setWrapStyleWord(true);

        // Initializing textFields
        additionalResultsTextField = new JTextField();
        studentNameTextField = new JTextField();
        idTextField = new JTextField();

        // Initializing buttons
        addStudentButton = new JButton("Add");
        listSubjectsButton = new JButton("List Subjects");

        // Placing everything
        // First row
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(inputAreaLabel, gbc);

        // Second row
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JScrollPane(inputTextArea), gbc);

        // Third row
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(newStudentLabel, gbc);

        // Fourth row
        gbc.gridwidth = 1;
        gbc.gridy = 3;
        panel.add(idLabel, gbc);
        gbc.gridx = 1;
        panel.add(idTextField, gbc);

        // Fifth row
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(studentSurnameLabel, gbc);
        gbc.gridx = 1;
        panel.add(studentNameTextField, gbc);

        // Sixth row
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        panel.add(additionalResultsLabel, gbc);

        // Seventh row
        gbc.gridy = 6;
        panel.add(additionalResultsTextField, gbc);

        // Eighth row
        gbc.gridy = 7;
        panel.add(addStudentButton, gbc);

        // Ninth row
        gbc.gridy = 8;
        panel.add(subjectsLabel, gbc);

        // Tenth row
        gbc.gridy = 9;
        panel.add(new JScrollPane(subjectsTextArea), gbc);

        // Eleventh row
        gbc.gridy = 10;
        panel.add(listSubjectsButton, gbc);

        // 12th row
        openNewFileButton = inputWindow.getOpenNewFileButton();
        gbc.gridy = 11;
        panel.add(openNewFileButton, gbc);

        panel.revalidate();
        panel.repaint();

        setVisible(false);

        listSubjectsButton.addActionListener(actionEvent -> listSubjects());

        addStudentButton.addActionListener(actionEvent -> {
            if (idTextField.getText().isEmpty() || studentNameTextField.getText().isEmpty() || additionalResultsTextField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Input is missing", "Wrong Input", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    Integer id = Integer.parseInt(idTextField.getText());
                    checkForDuplicates(id);
                    String surname = studentNameTextField.getText();
                    String[] subjectsAndMarksTokens = additionalResultsTextField.getText().split("[-\\s]+");
                    Map<String, Integer> subjectsAndMarksMap = new TreeMap<>();
                    for (int i = 0; i < subjectsAndMarksTokens.length; i += 2) {
                        subjectsAndMarksMap.put(subjectsAndMarksTokens[i], Integer.parseInt(subjectsAndMarksTokens[i + 1]));
                    }
                    session.getSubjects().addAll(subjectsAndMarksMap.keySet());
                    session.getSession().add(new Student(id, surname, subjectsAndMarksMap));
                    StringBuilder buffer = new StringBuilder(inputTextArea.getText());
                    for (Student student : session.getSession()) {
                        buffer.append(student);
                    }
                    buffer.deleteCharAt(buffer.length() - 1);
                    inputTextArea.setText(buffer.toString());
                    session.writeDataToFile(fileName);
                    listSubjects();
                } catch (NumberFormatException | IndexOutOfBoundsException | IOException exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage(),
                                                "Exception", JOptionPane.ERROR_MESSAGE);
                }  catch (IllegalArgumentException exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage(),
                            "Input error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    void checkForDuplicates(Integer id) throws IllegalArgumentException{
        if (session.getSession().stream().anyMatch(student -> student.getId().equals(id))) {
            throw new IllegalArgumentException("Student with this ID already exists.");
        };
    }

    void listSubjects() {
        // Первый вариант через stream api
        StreamStrategy streamStrategy = new StreamStrategy();
        subjectsTextArea.setText(streamStrategy.listSubjects(session));

        /* Второй вариант через Set
        SetStrategy setStrategy = new SetStrategy();
        subjectsTextArea.setText(setStrategy.listSubjects(session)); */
    }

    public JPanel getPanel() {
        return panel;
    }

    public JTextArea getInputTextArea() {
        return inputTextArea;
    }

    public Session getSession() {
        return session;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public JTextField getIdTextField() {
        return idTextField;
    }

    public JTextField getStudentNameTextField() {
        return studentNameTextField;
    }

    public JTextField getAdditionalResultsTextField() {
        return additionalResultsTextField;
    }

    public JTextArea getSubjectsTextArea() {
        return subjectsTextArea;
    }
}
