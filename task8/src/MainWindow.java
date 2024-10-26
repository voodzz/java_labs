import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class MainWindow extends JFrame {
    private JPanel panel;
    private JLabel dataLabel;
    private JTextArea dataTextArea;
    private JButton saveToFileButton;
    private JButton sortByWeightButton;
    private JButton sortBySugarPercentButton;
    private JLabel newCandyLabel;
    private JLabel typeOfChocolateOrColorLabel;
    private JComboBox<String> typeOfChocolateOrColorComboBox;
    private JLabel typeOfCandyLabel;
    private JComboBox<String> typeOfCandyComboBox;
    private JLabel weightLabel;
    private JTextField weightTextField;
    private JLabel percentOfSugarLabel;
    private JTextField percentOfSugarTextField;
    private JButton addCandyButton;

    private final Font labelFont;
    private final Font boldLabelFont;

    private Present present;

    MainWindow() {
        setSize(500, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Candy Application");
        present = new Present(new ArrayList<>());

        panel = new JPanel(new GridBagLayout());

        // Initialize Labels
        dataLabel = new JLabel("Data");
        dataLabel.setHorizontalAlignment(SwingConstants.CENTER);
        newCandyLabel = new JLabel("New Candy");
        newCandyLabel.setHorizontalAlignment(SwingConstants.CENTER);
        typeOfCandyLabel = new JLabel("Type of Candy:");
        weightLabel = new JLabel("Weight (g):");
        typeOfChocolateOrColorLabel = new JLabel("Type of Chocolate or Color:");
        percentOfSugarLabel = new JLabel("Percent of Sugar:");

        // Initialize TextAreas, TextFields
        dataTextArea = new JTextArea(10, 30);
        dataTextArea.setFont(new Font("Arial", Font.PLAIN, 14));
        dataTextArea.setLineWrap(true);
        dataTextArea.setWrapStyleWord(true);
        weightTextField = new JTextField(10);
        percentOfSugarTextField = new JTextField(10);

        // Initialize ComboBoxes
        typeOfChocolateOrColorComboBox = new JComboBox<>(new String[]{"Bitter", "Milk", "White", "Blue", "Red", "Yellow", "Orange", "Green"});
        typeOfChocolateOrColorComboBox.setEditable(false);
        typeOfCandyComboBox = new JComboBox<>(new String[]{"Chocolate", "Lollipop"});
        typeOfCandyComboBox.setEditable(false);

        // Initialize Buttons
        saveToFileButton = new JButton("Save to File");
        sortByWeightButton = new JButton("Sort by Weight");
        sortBySugarPercentButton = new JButton("Sort by Percent of Sugar");
        addCandyButton = new JButton("Add Candy");

        // Set fonts
        labelFont = new Font("Arial", Font.PLAIN, 18);
        boldLabelFont = new Font("Arial", Font.BOLD, 18);
        dataLabel.setFont(boldLabelFont);
        newCandyLabel.setFont(boldLabelFont);
        typeOfCandyLabel.setFont(labelFont);
        weightLabel.setFont(labelFont);
        typeOfChocolateOrColorLabel.setFont(labelFont);
        percentOfSugarLabel.setFont(labelFont);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 0, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;

        // Add components to the panel
        panel.add(dataLabel, gbc);

        gbc.gridy = 1;
        panel.add(new JScrollPane(dataTextArea), gbc);

        gbc.gridy = 2;
        panel.add(saveToFileButton, gbc);

        gbc.gridy = 3;
        panel.add(sortByWeightButton, gbc);

        gbc.gridy = 4;
        panel.add(sortBySugarPercentButton, gbc);

        gbc.gridy = 5;
        panel.add(saveToFileButton, gbc);

        gbc.gridy = 6;
        panel.add(newCandyLabel, gbc);

        gbc.gridy = 7;
        gbc.gridwidth = 1;
        panel.add(typeOfCandyLabel, gbc);
        gbc.gridx = 1;
        panel.add(typeOfCandyComboBox, gbc);

        gbc.gridy = 8;
        gbc.gridx = 0;
        panel.add(typeOfChocolateOrColorLabel, gbc);
        gbc.gridx = 1;
        panel.add(typeOfChocolateOrColorComboBox, gbc);

        gbc.gridy = 9;
        gbc.gridx = 0;
        panel.add(weightLabel, gbc);
        gbc.gridx = 1;
        panel.add(weightTextField, gbc);

        gbc.gridy = 10;
        gbc.gridx = 0;
        panel.add(percentOfSugarLabel, gbc);
        gbc.gridx = 1;
        panel.add(percentOfSugarTextField, gbc);

        gbc.gridwidth = 2;
        gbc.gridy = 11;
        gbc.gridx = 0;
        panel.add(addCandyButton, gbc);

        setContentPane(panel);
        setVisible(false);

        saveToFileButton.addActionListener(actionEvent -> {
            JFileChooser fc = new JFileChooser();
            fc.setDialogTitle("Save File");
            Writer writer = new Writer();
            if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                try {
                    writer.writePresentToFile(present, fc.getSelectedFile());
                } catch (IOException exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage(),
                            "Exception", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        sortByWeightButton.addActionListener(actionEvent -> {
            ArrayList<Candy> sortedArray = present.sortByWeight();
            Present tmpPresent = new Present(sortedArray);
            dataTextArea.setText(tmpPresent.toString());
        });

        sortBySugarPercentButton.addActionListener(actionEvent -> {
            ArrayList<Candy> sortedArray = present.sortByPercentOfSugar();
            Present tmpPresent = new Present(sortedArray);
            dataTextArea.setText(tmpPresent.toString());
        });

        addCandyButton.addActionListener(actionEvent -> {
            Reader reader = new Reader();

            String typeOfCandy = Objects.requireNonNull(typeOfCandyComboBox.getSelectedItem()).toString();
            String typeOfChocolateOrColor = Objects.requireNonNull(typeOfChocolateOrColorComboBox.getSelectedItem()).toString();
            try {
                double weight = Double.parseDouble(weightTextField.getText());
                double percentOfSugar = Double.parseDouble(percentOfSugarTextField.getText());
                reader.checkTypeOrColorAndTypeMatching(typeOfChocolateOrColor, typeOfCandy, weight, percentOfSugar);
                if (typeOfCandy.equalsIgnoreCase("chocolate")) {
                    present.addCandy(new Chocolate(weight, percentOfSugar, ChocolateType.valueOf(typeOfChocolateOrColor.toUpperCase())));
                } else {
                    present.addCandy(new Lollipop(weight, percentOfSugar, LollipopColor.valueOf(typeOfChocolateOrColor.toUpperCase())));
                }
                dataTextArea.setText(present.toString());
            } catch (IllegalArgumentException exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(),
                        "Exception", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public Present getPresent() {
        return present;
    }

    public void setPresent(Present present) {
        this.present = present;
    }

    public JTextArea getDataTextArea() {
        return dataTextArea;
    }
}
