import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputWindow extends JFrame {
    private JPanel panel;
    private JLabel inputFileLabel;
    private JTextField inputFileTextField;
    private JButton readFromFileButton;

    private SessionApplicationWindow app;

    InputWindow() {
        app = new SessionApplicationWindow();

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

        add(panel);

        setVisible(true);

        readFromFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                app.setVisible(true);
                setVisible(false);
            }
        });
    }
}
