import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Frame extends JFrame {
    private JPanel panel;
    private JTextArea dataTextArea1, dataTextArea2, resultTextArea;
    private JButton readFromFirstFileButton, readFromSecondFileButton;
    private JButton sortByAgeInDescendingOrderButton;
    private JButton sortByEfficiencyOverAgeButton;
    private JButton getNamesStartingWithCInDescendingOrderButton;

    private List<Tree> trees = new ArrayList<>();
    Frame(String string) {
        super(string);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(500, 500);

        panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        dataTextArea1 = new JTextArea(10, 15);
        dataTextArea1.setLineWrap(true);
        dataTextArea1.setWrapStyleWord(true);

        dataTextArea2 = new JTextArea(10, 15);
        dataTextArea2.setLineWrap(true);
        dataTextArea2.setWrapStyleWord(true);

        resultTextArea = new JTextArea(10, 30);
        resultTextArea.setLineWrap(true);
        resultTextArea.setWrapStyleWord(true);

        // Initializing buttons
        readFromFirstFileButton = new JButton("Read From First File");
        readFromSecondFileButton = new JButton("Read From Second File");
        sortByAgeInDescendingOrderButton = new JButton("Sort By Age In Descending Order");
        sortByEfficiencyOverAgeButton = new JButton("Sort By Efficiency Over Age");
        getNamesStartingWithCInDescendingOrderButton = new JButton("Get Names Starting With C");

        gbc.gridwidth = 2;
        // Placing everything
        panel.add(readFromFirstFileButton, gbc);
        gbc.gridy = 1;
        panel.add(readFromSecondFileButton, gbc);

        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(new JScrollPane(dataTextArea1), gbc);
        gbc.gridx = 1;
        panel.add(new JScrollPane(dataTextArea2), gbc);

        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JScrollPane(resultTextArea), gbc);

        gbc.gridy = 4;
        panel.add(sortByEfficiencyOverAgeButton, gbc);

        gbc.gridy = 5;
        panel.add(getNamesStartingWithCInDescendingOrderButton, gbc);

        gbc.gridy = 6;
        panel.add(sortByAgeInDescendingOrderButton, gbc);
        readFromFirstFileButton.addActionListener(actionEvent -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Choose File");
            fileChooser.setCurrentDirectory(new File("./"));

            FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("Text File", "txt");
            fileChooser.setFileFilter(extensionFilter);

            if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                try {
                    List<Tree> list = TreeUtil.readType1TreesFromFile(fileChooser.getSelectedFile().getAbsolutePath());
                    if (trees.isEmpty()) {
                        trees = list;
                    } else {
                        trees.addAll(TreeUtil.readType1TreesFromFile(fileChooser.getSelectedFile().getAbsolutePath()));
                    }
                    dataTextArea1.setText(list.toString());
                } catch (FileNotFoundException exception) {
                    System.err.println();
                }
            }
        });

        readFromSecondFileButton.addActionListener(actionEvent -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Choose File");
            fileChooser.setCurrentDirectory(new File("./"));

            FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("Text File", "txt");
            fileChooser.setFileFilter(extensionFilter);

            if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                try {
                    List<Tree> list = TreeUtil.readType2TreesFromFile(fileChooser.getSelectedFile().getAbsolutePath());
                    if (trees.isEmpty()) {
                        trees = list;
                    } else {
                        trees.addAll(TreeUtil.readType2TreesFromFile(fileChooser.getSelectedFile().getAbsolutePath()));
                    }
                    dataTextArea2.setText(list.toString());
                } catch (FileNotFoundException exception) {
                    System.err.println();
                }
            }
        });

        setContentPane(panel);

        setVisible(true);
    }
}
