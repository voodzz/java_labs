import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class TaskOnePanel extends JPanel {
    private JList<F1Driver> leftList;
    private JList<F1Driver> rightList;
    private DefaultListModel<F1Driver> leftListModel;
    private DefaultListModel<F1Driver> rightListModel;
    private JButton leftArrowButton;
    private JButton rightArrowButton;
    private BorderLayout mainLayout;
    private BorderLayout secondLayout;

    private class F1Driver {
        String name;
        String surname;
        int number;

        public F1Driver(String name, String surname, int number) {
            this.name = name;
            this.surname = surname;
            this.number = number;
        }

        @Override
        public String toString() {
            return number + " - " + name + " " + surname;
        }
    }

    Vector<F1Driver> readDataFromFile(String fileName) throws FileNotFoundException, IllegalArgumentException {
        Vector<F1Driver> data = new Vector<>();
        Scanner scanner = new Scanner(new File(fileName));
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] tokens = line.split("\\s+");
            if (tokens.length != 3) {
                throw new IllegalArgumentException("Incorrect data format.");
            }
            data.add(new F1Driver(tokens[0], tokens[1], Integer.parseInt(tokens[2])));
        }
        scanner.close();
        return data;
    }

    TaskOnePanel() {
        super();
        try {
            mainLayout = new BorderLayout();
            setLayout(mainLayout);
            secondLayout = new BorderLayout();
            leftListModel = new DefaultListModel<>();
            rightListModel = new DefaultListModel<>();
            rightArrowButton = new JButton("-->");
            leftArrowButton = new JButton("<--");

            Vector<F1Driver> leftData = readDataFromFile("F1_drivers_2016.txt");
            Vector<F1Driver> rightData = readDataFromFile("F1_drivers_2024.txt");
            leftList = new JList<>(leftListModel);
            rightList = new JList<>(rightListModel);
            leftData.forEach(driver -> leftListModel.addElement(driver));
            rightData.forEach(driver -> rightListModel.addElement(driver));

            JScrollPane leftPane = new JScrollPane(leftList);
            leftPane.setPreferredSize(new Dimension(250, 700));
            JScrollPane rightPane = new JScrollPane(rightList);
            rightPane.setPreferredSize(new Dimension(250, 700));

            add(leftPane, BorderLayout.WEST);
            add(rightPane, BorderLayout.EAST);

            JPanel middlePanel = new JPanel();
            middlePanel.setLayout(secondLayout);
            add(middlePanel, BorderLayout.CENTER);
            middlePanel.add(leftArrowButton, BorderLayout.SOUTH);
            middlePanel.add(rightArrowButton, BorderLayout.NORTH);

            leftArrowButton.addActionListener(actionEvent -> {
                if (!rightList.isSelectionEmpty()) {
                    for (F1Driver driver : rightList.getSelectedValuesList()) {
                        leftListModel.addElement(driver);
                        rightListModel.removeElement(driver);
                    }
                }
            });

            rightArrowButton.addActionListener(actionEvent -> {
                if (!leftList.isSelectionEmpty()) {
                    for (F1Driver driver : leftList.getSelectedValuesList()) {
                        rightListModel.addElement(driver);
                        leftListModel.removeElement(driver);
                    }
                }
            });
        } catch (FileNotFoundException | IllegalArgumentException exception) {
            JOptionPane.showMessageDialog(null, exception);
        }
    }

}
