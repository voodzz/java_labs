package gui;

import org.xml.sax.SAXException;
import session.Student;
import strategy.xmlStrategy.DOMReadStrategy;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.io.IOException;

public class InputWindow extends JFrame {
    private JPanel panel;
    private JLabel inputFileLabel;
    private JLabel dataLabel;
    private JTextField inputFileTextField;
    private JTextArea dataTextArea;
    private JButton readFromFileButton;
    private JButton openNewFileButton;
    private JButton workWithDataButton;

    private SessionApplicationWindow app;

    public InputWindow() {

        setTitle("Session Observer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(400, 400);
        setLocationRelativeTo(null);

        panel = new JPanel(new GridBagLayout());  // Используем GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);  // Отступы между элементами
        gbc.fill = GridBagConstraints.HORIZONTAL;

        inputFileLabel = new JLabel("Input file:");
        dataLabel = new JLabel("Data:");
        dataLabel.setHorizontalAlignment(SwingConstants.CENTER);

        inputFileTextField = new JTextField(10);
        dataTextArea = new JTextArea(10, 30);
        dataTextArea.setLineWrap(true);
        dataTextArea.setWrapStyleWord(true);

        readFromFileButton = new JButton("Read");
        openNewFileButton = new JButton("Open New File");
        workWithDataButton = new JButton("Work With Data");

        gbc.gridy = 0;
        gbc.gridx = 0;
        panel.add(inputFileLabel, gbc);

        gbc.gridx = 1;
        panel.add(inputFileTextField, gbc);

        gbc.gridx = 2;
        panel.add(readFromFileButton, gbc);

        gbc.gridwidth = 3;
        gbc.gridy = 1;
        gbc.gridx = 0;
        panel.add(dataLabel, gbc);

        gbc.gridy = 2;
        panel.add(new JScrollPane(dataTextArea), gbc);

        gbc.gridy = 3;
        panel.add(workWithDataButton, gbc);

        app = new SessionApplicationWindow(this);

        add(panel);

        setVisible(true);

        workWithDataButton.addActionListener(actionEvent -> {
            try {
                app.getInputTextArea().setText(String.valueOf(readFromFile()));
//                app.getSession().setStrategy(new SAXReadStrategy());
//                app.getSession().readDataFromFile(inputFileTextField.getText());
                app.setFileName(inputFileTextField.getText());
                setVisible(false);
                app.setVisible(true);
            } catch (NumberFormatException | IOException | SAXException | ParserConfigurationException exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage());
            }
        });

        openNewFileButton.addActionListener(actionEvent -> {
            dataTextArea.setText("");
            inputFileTextField.setText("");
            setVisible(true);
            app.setVisible(false);
            app.getIdTextField().setText("");
            app.getStudentNameTextField().setText("");
            app.getAdditionalResultsTextField().setText("");
            app.getSubjectsTextArea().setText("");
        });

        readFromFileButton.addActionListener(actionEvent -> {
            app.getSession().setReadStrategy(new DOMReadStrategy());
            try {
                app.getSession().readDataFromFile(inputFileTextField.getText());
                dataTextArea.setText(String.valueOf(readFromFile()));
            } catch (IOException | ParserConfigurationException | SAXException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        });
    }

    public JButton getOpenNewFileButton() {
        return openNewFileButton;
    }

    private StringBuilder readFromFile() throws IOException, ParserConfigurationException, SAXException {
        app.getSession().setReadStrategy(new DOMReadStrategy());
        app.getSession().readDataFromFile(inputFileTextField.getText());
        StringBuilder stringBuilder = new StringBuilder();
        for (Student student : app.getSession().getStudents()) {
            stringBuilder.append(student.toString());
        }
        return stringBuilder;
    }
}
