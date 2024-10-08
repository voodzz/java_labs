import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SeriesApplication extends JFrame {
    private JPanel Panel;
    private JRadioButton exponentialRadioButton;
    private JRadioButton linearRadioButton;
    private JTextArea firstElementTextArea;
    private JTextArea deltaTextArea;
    private JSpinner numberOfElementsSpinner;
    private JTextArea fileNameTextArea;
    private JButton writeToFileButton;
    private JTextArea outputTextArea;
    private JButton calculateButton;
    private JButton clearButton;

    SeriesApplication() {
        setContentPane(Panel);
        setTitle("Series");
        setSize(600, 350);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        numberOfElementsSpinner.setModel(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));

        // Group radioButtons so they cannot be enabled at the same time
        ButtonGroup radioButtons = new ButtonGroup();
        radioButtons.add(exponentialRadioButton);
        radioButtons.add(linearRadioButton);

        setVisible(true);
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                double firstElement = Double.parseDouble(firstElementTextArea.getText());
                double delta = Double.parseDouble(deltaTextArea.getText());
                int numberOfElements = (int)numberOfElementsSpinner.getValue();

                if(exponentialRadioButton.isSelected()) {
                    Exponential series = new Exponential(firstElement, delta, numberOfElements);
                    outputTextArea.setText("Elements: " + series.toString() + "\nSum: " + series.findSum());
                } else if (linearRadioButton.isSelected()) {
                    Linear series = new Linear(firstElement, delta, numberOfElements);
                    outputTextArea.setText("Elements: " + series.toString() + "\nSum: " + series.findSum());
                }
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                outputTextArea.setText("");
                firstElementTextArea.setText("");
                deltaTextArea.setText("");
                numberOfElementsSpinner.setValue(1);
                fileNameTextArea.setText("");
            }
        });
        writeToFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String filePath = fileNameTextArea.getText();
                double firstElement = Double.parseDouble(firstElementTextArea.getText());
                double delta = Double.parseDouble(deltaTextArea.getText());
                int numberOfElements = (int)numberOfElementsSpinner.getValue();

                if(exponentialRadioButton.isSelected()) {
                    Exponential series = new Exponential(firstElement, delta, numberOfElements);
                    try {
                        series.printToFile(filePath);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else if (linearRadioButton.isSelected()) {
                    Linear series = new Linear(firstElement, delta, numberOfElements);
                    try {
                        series.printToFile(filePath);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        new SeriesApplication();
    }
}
