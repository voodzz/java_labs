package Strategy;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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

    InputWindow() {

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
                app.getSession().readDataFromFile(inputFileTextField.getText());
                app.setFileName(inputFileTextField.getText());
                setVisible(false);
                app.setVisible(true);
            } catch (FileNotFoundException | NumberFormatException exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Input exception", JOptionPane.ERROR_MESSAGE);
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
            dataTextArea.setText(String.valueOf(readFromFile()));
        });
    }

    public JButton getOpenNewFileButton() {
        return openNewFileButton;
    }

    private StringBuilder readFromFile() {
        StringBuilder buffer = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new File(inputFileTextField.getText()));
            scanner.useDelimiter("\n");
            while (scanner.hasNext()) {
                buffer.append(scanner.next()).append('\n');
            }
            scanner.close();
            buffer.deleteCharAt(buffer.length() - 1);
        } catch (FileNotFoundException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Input exception", JOptionPane.ERROR_MESSAGE);
        }
        return buffer;
    }
}
