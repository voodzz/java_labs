import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SeriesWindowCode extends JFrame {
    private JPanel panel;
    private JRadioButton exponentialRadioButton;
    private JRadioButton linearRadioButton;
    private ButtonGroup radioButtonsGroup;
    private JTextField firstElementTextField;
    private JTextField deltaTextField;
    private JTextField fileNameTextField;
    private JTextArea outputTextArea;
    private JSpinner numberOfElementsSpinner;
    private JButton writeToFileButton;
    private JButton calculateButton;
    private JButton clearButton;
    private JLabel seriesTypeLabel;
    private JLabel firstElementLabel;
    private JLabel deltaLabel;
    private JLabel numberOfElementsLabel;
    private JLabel fileNameLabel;

    private Series series = null;

    SeriesWindowCode() {
        // Window configuration
        setTitle("Series");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(600, 800);
        setLocationRelativeTo(null);

        // Configurating fields
        panel = new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        setContentPane(panel);

        exponentialRadioButton = new JRadioButton("Exponential");
        linearRadioButton = new JRadioButton("Linear");
        radioButtonsGroup = new ButtonGroup();
        radioButtonsGroup.add(exponentialRadioButton);
        radioButtonsGroup.add(linearRadioButton);

        firstElementTextField = new JTextField();
        deltaTextField = new JTextField();
        fileNameTextField = new JTextField();

        outputTextArea = new JTextArea(10, 1);
        outputTextArea.setLineWrap(true);
        outputTextArea.setWrapStyleWord(true);

        numberOfElementsSpinner = new JSpinner();
        numberOfElementsSpinner.setModel(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));

        writeToFileButton = new JButton("Write to file");
        calculateButton = new JButton("Calculate");
        clearButton = new JButton("Clear");

        seriesTypeLabel = new JLabel("Choose series");
        firstElementLabel = new JLabel("First Element");
        deltaLabel = new JLabel("Delta");
        numberOfElementsLabel = new JLabel("Number Of Elements");
        fileNameLabel = new JLabel("File For The Output");

        // Placing fields on a window
        // First row
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        panel.add(seriesTypeLabel, gridBagConstraints);
        gridBagConstraints.gridx = 1;
        panel.add(exponentialRadioButton, gridBagConstraints);
        gridBagConstraints.gridx = 2;
        panel.add(linearRadioButton, gridBagConstraints);

        // Second row
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        panel.add(firstElementLabel, gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridwidth = 2;
        panel.add(firstElementTextField, gridBagConstraints);

        // Third row
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 1;
        panel.add(deltaLabel, gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridwidth = 2;
        panel.add(deltaTextField, gridBagConstraints);

        // Fourth row
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 1;
        panel.add(numberOfElementsLabel, gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridwidth = 2;
        panel.add(numberOfElementsSpinner, gridBagConstraints);

        // Fifth row
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridwidth = 1;
        panel.add(fileNameLabel, gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridwidth = 2;
        panel.add(fileNameTextField, gridBagConstraints);

        // Sixth row
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridwidth = 3;
        panel.add(new JScrollPane(outputTextArea), gridBagConstraints);

        // Seventh row
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        panel.add(calculateButton, gridBagConstraints);

        // Eighth row
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridx = 0;
        panel.add(clearButton, gridBagConstraints);

        // Ninth row
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridx = 0;
        panel.add(writeToFileButton, gridBagConstraints);

        // Adding listeners
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (series == null) {
                    initializeSeries();
                }
                outputTextArea.setText("Elements: " + series.toString() + "\nSum: " + series.findSum());
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                firstElementTextField.setText("");
                deltaTextField.setText("");
                numberOfElementsSpinner.setValue(1);
                outputTextArea.setText("");
                fileNameTextField.setText("");
            }
        });

        writeToFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String filePath = fileNameTextField.getText();
                initializeSeries();
                try {
                    series.printToFile("output.txt");
                } catch (IOException exception) {
                    JOptionPane errorWindow = new JOptionPane(exception.getMessage());
                }
            }
        });

        setVisible(true);
    }

    void initializeSeries() {
        double firstElement = Double.parseDouble(firstElementTextField.getText());
        double delta = Double.parseDouble(deltaTextField.getText());
        int numberOfElements = (int) numberOfElementsSpinner.getValue();
        if (series == null) {
            if (exponentialRadioButton.isSelected()) {
                series = new Exponential(firstElement, delta, numberOfElements);
            } else if (linearRadioButton.isSelected()) {
                series = new Linear(firstElement, delta, numberOfElements);
            }
        } else {
            series.setFirstElement(firstElement);
            series.setDelta(delta);
            series.setNumberOfElements(numberOfElements);
        }
    }
}
