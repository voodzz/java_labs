package mvc;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class View extends JFrame implements Observer<Integer> {
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

    public View() throws FileNotFoundException {
        super();
        setTitle("My Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 1000);
        setLocationRelativeTo(null);

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
        setVisible(true);
    }

    @Override
    public void update(Model<Integer> model) {
        leftListModel = model.getSet1().getListModel();
        leftList.setModel(leftListModel);
        rightListModel = model.getSet2().getListModel();
        rightList.setModel(rightListModel);
    }

    public JButton getReadLeftListDataButton() {
        return readLeftListDataButton;
    }

    public JButton getReadRightListDataButton() {
        return readRightListDataButton;
    }

    public JButton getClearLeftButton() {
        return clearLeftButton;
    }

    public JButton getClearRightButton() {
        return clearRightButton;
    }

    public JButton getRemoveButton() {
        return removeButton;
    }

    public JButton getUnionButton() {
        return unionButton;
    }

    public JButton getIntersectionButton() {
        return intersectionButton;
    }

    public JButton getDifferenceButton() {
        return differenceButton;
    }

    public JTextField getOutputTextField() {
        return outputTextField;
    }

    public JList<Integer> getLeftList() {
        return leftList;
    }

    public JList<Integer> getRightList() {
        return rightList;
    }
}