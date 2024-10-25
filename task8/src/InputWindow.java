import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class InputWindow extends JFrame {
    private JTextArea inputTextArea;
    private JButton chooseFileButton;
    private JButton continueButton;
    private JPanel panel;

    InputWindow() {
        setLocationRelativeTo(null);
        setTitle("Input Dialog");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);

        panel = new JPanel(new GridBagLayout());
        inputTextArea = new JTextArea(10, 30);
        inputTextArea.setFont(new Font("Arial", Font.PLAIN, 14));
        inputTextArea.setLineWrap(true);
        inputTextArea.setWrapStyleWord(true);
        chooseFileButton = new JButton("Choose File");
        continueButton = new JButton("Continue");
        setContentPane(panel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        panel.add(new JScrollPane(inputTextArea), gbc);

        gbc.gridy = 1;
        panel.add(chooseFileButton, gbc);

        gbc.gridy = 2;
        panel.add(continueButton, gbc);

        chooseFileButton.addActionListener(actionEvent -> {
            try {
                JFileChooser fc = new JFileChooser();
                fc.setDialogTitle("Choose File");
                Reader reader = new Reader();
                if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                    String data = reader.readDataFromFile(fc.getSelectedFile());
                    inputTextArea.setText(data);
                }
            } catch (IOException exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(),
                        "Exception", JOptionPane.ERROR_MESSAGE);
            }
        });

        continueButton.addActionListener(actionEvent -> {
            inputTextArea.setText("");
        });

        setVisible(true);
    }
}
