import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputWindow extends JFrame {
    private JPanel panel;
    private JLabel inputFileLabel;
    private JTextField inputFileTextField;
    private JButton readFromFileButton;
    private JButton openNewFileButton;

    private SessionApplicationWindow app;

    InputWindow() {

        setTitle("Session Observer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(400, 100);
        setLocationRelativeTo(null);

        panel = new JPanel(new GridBagLayout());  // Используем GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);  // Отступы между элементами

        // Настройки для метки
        inputFileLabel = new JLabel("Input file:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(inputFileLabel, gbc);

        // Настройки для текстового поля
        inputFileTextField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(inputFileTextField, gbc);

        // Настройки для кнопки
        readFromFileButton = new JButton("Read");
        gbc.gridx = 2;
        gbc.gridy = 0;
        panel.add(readFromFileButton, gbc);

        openNewFileButton = new JButton("Open New File");

        app = new SessionApplicationWindow(this);

        add(panel);

        setVisible(true);

        readFromFileButton.addActionListener(actionEvent -> {
            try {
                Scanner scanner = new Scanner(new File(inputFileTextField.getText()));
                scanner.useDelimiter("\n");
                StringBuilder buffer = new StringBuilder();
                while (scanner.hasNext()) {
                    buffer.append(scanner.next()).append('\n');
                }
                scanner.close();
                buffer.deleteCharAt(buffer.length() - 1);
                app.getInputTextArea().setText(buffer.toString());
                app.getSession().readDataFromFile(inputFileTextField.getText());
                app.setFileName(inputFileTextField.getText());
                setVisible(false);
                app.setVisible(true);
            } catch (FileNotFoundException | NumberFormatException exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Input exception", JOptionPane.ERROR_MESSAGE);
            }
        });

        openNewFileButton.addActionListener(actionEvent -> {
            setVisible(true);
            app.setVisible(false);
            app.getIdTextField().setText("");
            app.getStudentNameTextField().setText("");
            app.getAdditionalResultsTextField().setText("");
            app.getSubjectsTextArea().setText("");
        });
    }

    public JButton getOpenNewFileButton() {
        return openNewFileButton;
    }
}
