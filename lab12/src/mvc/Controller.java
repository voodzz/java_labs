package mvc;

import visitor.IteratorOutOfBoundsException;
import visitor.MySet;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Controller {
    Model<Integer> model;
    View view;

    public Controller() throws FileNotFoundException {
        model = new Model<>();
        view = new View();
        model.attach(view);

        view.getReadLeftListDataButton().addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            fc.setCurrentDirectory(new File("./"));
            fc.setDialogTitle("Choose File");
            if (fc.showOpenDialog(view) == JFileChooser.APPROVE_OPTION) {
                try {
                    model.setSet1(readDataFromFile(fc.getSelectedFile().toString()));
                    model.notifyObservers();
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        });

        view.getReadRightListDataButton().addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            fc.setCurrentDirectory(new File("./"));
            fc.setDialogTitle("Choose File");
            if (fc.showOpenDialog(view) == JFileChooser.APPROVE_OPTION) {
                try {
                    model.setSet2(readDataFromFile(fc.getSelectedFile().toString()));
                    model.notifyObservers();
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        });

        view.getClearLeftButton().addActionListener(e -> {
            model.getSet1().clear();
            model.notifyObservers();
        });

        view.getClearRightButton().addActionListener(e -> {
            model.getSet2().clear();
            model.notifyObservers();
        });

        view.getRemoveButton().addActionListener(e -> {
            if (!view.getLeftList().getSelectedValuesList().isEmpty() && !model.getSet1().isEmpty()) {
                for (Integer value : view.getLeftList().getSelectedValuesList()) {
                    model.getSet1().remove(value);
                    model.notifyObservers();
                }
            }
            if (!view.getRightList().getSelectedValuesList().isEmpty() && !model.getSet2().isEmpty()) {
                for (Integer value : view.getRightList().getSelectedValuesList()) {
                    model.getSet2().remove(value);
                    model.notifyObservers();
                }
            }
        });

        view.getUnionButton().addActionListener(e -> {
            view.getOutputTextField().setText(model.getSet1().uniteWith(model.getSet2()).toString());
        });

        view.getIntersectionButton().addActionListener(e -> {
            try {
                view.getOutputTextField().setText(model.getSet1().intersectWith(model.getSet2()).toString());
            } catch (IteratorOutOfBoundsException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        });

        view.getDifferenceButton().addActionListener(e -> {
            try {
                view.getOutputTextField().setText(model.getSet1().differenceWith(model.getSet2()).toString());
            } catch (IteratorOutOfBoundsException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        });
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
