import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Frame extends JFrame {
    private JPanel panel;
    private JList<Integer> leftList;
    private JList<Integer> rightList;
    private DefaultListModel<Integer> leftListModel;
    private DefaultListModel<Integer> rightListModel;
    private JButton readLeftListDataButton;
    private JButton readRightListDataButton;
    private JButton clearLeftButton;
    private JButton clearRightButton;
    private JLabel operationsLabel;
    private JButton removeButton;
    private JButton unionButton;
    private JButton intersectionButton;
    private JButton differenceButton;
    private JTextField outputTextField;

    private MySet<Integer> leftSet;
    private MySet<Integer> rightSet;

    public Frame() throws FileNotFoundException {
        super();
        setTitle("My Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 1000);
        setLocationRelativeTo(null);

        leftSet = new MySet<>();
        rightSet = new MySet<>();

        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;

        removeButton = new JButton("Remove Element");
        clearLeftButton = new JButton("Clear");
        clearRightButton = new JButton("Clear");
        readLeftListDataButton = new JButton("Read Data");
        readRightListDataButton = new JButton("Read Data");
        unionButton = new JButton("Unite Sets");
        intersectionButton = new JButton("Intersect Sets");
        differenceButton = new JButton("Find Difference of Sets (left \\ right)");

        operationsLabel = new JLabel("Operations");
        operationsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        operationsLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        leftListModel = new DefaultListModel<>();
        rightListModel = new DefaultListModel<>();
        leftList = new JList<>(leftListModel);
        rightList = new JList<>(rightListModel);

        outputTextField = new JTextField(10);

        JScrollPane leftListScrollPane = new JScrollPane(leftList);
        leftListScrollPane.setPreferredSize(new Dimension(300, 600));
        JScrollPane rightListScrollPane = new JScrollPane(rightList);
        rightListScrollPane.setPreferredSize(new Dimension(300, 600));

        panel.add(leftListScrollPane, constraints);
        constraints.gridx = 1;
        panel.add(rightListScrollPane, constraints);

        constraints.gridy = 1;
        constraints.gridx = 0;
        panel.add(readLeftListDataButton, constraints);
        constraints.gridx = 1;
        panel.add(readRightListDataButton, constraints);

        constraints.gridy = 2;
        constraints.gridx = 0;
        panel.add(clearLeftButton, constraints);
        constraints.gridx = 1;
        panel.add(clearRightButton, constraints);

        constraints.gridy = 3;
        constraints.gridx = 0;
        constraints.gridwidth = 2;
        panel.add(removeButton, constraints);

        constraints.gridy = 4;
        panel.add(operationsLabel, constraints);

        constraints.gridy = 5;
        panel.add(outputTextField, constraints);

        constraints.gridy = 6;
        panel.add(unionButton, constraints);
        constraints.gridy = 7;
        panel.add(intersectionButton, constraints);
        constraints.gridy = 8;
        panel.add(differenceButton, constraints);

        setContentPane(panel);

        clearLeftButton.addActionListener(e -> {
            leftListModel.clear();
            leftSet.clear();
        });
        clearRightButton.addActionListener(e -> {
            rightListModel.clear();
            rightSet.clear();
        });

        readLeftListDataButton.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            fc.setCurrentDirectory(new File("./"));
            fc.setDialogTitle("Choose File");
            if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                try {
                    leftSet = readDataFromFile(fc.getSelectedFile().toString());
                    leftListModel = leftSet.getListModel();
                    leftList.setModel(leftListModel);
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        });

        readRightListDataButton.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            fc.setDialogTitle("Choose File");
            fc.setCurrentDirectory(new File("./"));
            if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                try {
                    rightSet = readDataFromFile(fc.getSelectedFile().toString());
                    rightListModel = rightSet.getListModel();
                    rightList.setModel(rightListModel);
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        });

        removeButton.addActionListener(e -> {
            if (!leftList.getSelectedValuesList().isEmpty() && !leftSet.isEmpty()) {
                for (Integer value : leftList.getSelectedValuesList()) {
                    leftListModel.removeElement(value);
                    leftSet.remove(value);
                }
            }
            if (!rightList.getSelectedValuesList().isEmpty() && !rightSet.isEmpty()) {
                for (Integer value : rightList.getSelectedValuesList()) {
                    rightListModel.removeElement(value);
                    rightSet.remove(value);
                }
            }
        });

        unionButton.addActionListener(e -> outputTextField.setText(leftSet.uniteWith(rightSet).toString()));
        intersectionButton.addActionListener(e -> {
            try {
                outputTextField.setText(leftSet.intersectWith(rightSet).toString());
            } catch (IteratorOutOfBoundsException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        });
        differenceButton.addActionListener(e -> {
            try {
                outputTextField.setText(leftSet.differenceWith(rightSet).toString());
            } catch (IteratorOutOfBoundsException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        });
        setVisible(true);
    }

    private MySet<Integer> readDataFromFile(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        MySet<Integer> set = new MySet<>();
        while (scanner.hasNextLine()) {
            String[] data = scanner.nextLine().split("[,\\s]");
            for (int i = 1; i < data.length - 1; ++i) {
                set.add(Integer.parseInt(data[i]));
            }
        }
        scanner.close();
        return set;
    }
}
