import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class BinaryTree implements MyElement, MyIterable {
    private ArrayList<Integer> data;
    MyStrategy strategy;

    public BinaryTree() {
        data = new ArrayList<>();
        strategy = new MinStreamAPIStrategy();
    }

    public int size() {
        return data.size();
    }

    public ArrayList<Integer> getElements() {
        return data;
    }

    public void setMinStrategy(MyStrategy strategy) {
        this.strategy = strategy;
    }

    public void add(int number) {
        if (data.isEmpty()) {
            data.add(number);
            return;
        }

        int index = 0;
        while (true) {
            if (data.get(index) == 0) {
                data.set(index, number);
                return;
            } else if (number < data.get(index)) {
                index = 2 * index + 1;
            } else {
                index = 2 * index + 2;
            }

            // Расчет высоты дерева и добавление нулей до нужного размера
            int height = (int) (Math.log(index + 1) / Math.log(2));
            while (data.size() < Math.pow(2, height + 1) - 1) {
                data.add(0);
            }
        }
    }

    public String getPreOrderTraversal() {
        StringBuilder result = new StringBuilder();
        PreOrderTraversalTreeIterator it = (PreOrderTraversalTreeIterator) this.createIterator();
        for (it.first(); !it.isDone(); it.next()) {
            result.append(it.currentItem()).append(" ");
        }
        result.delete(result.length() - 1, result.length());
        return result.toString();
    }

    public int min() {
        return strategy.execute(this);
    }

    public String moveToMin() {
        int index = 0;
        StringBuilder path = new StringBuilder();
        while (index < data.size()) {
            path.append(data.get(index)).append(' ');
            if (data.get(2 * index + 1) == 0) {
                break;
            } else {
                index = 2 * index + 1;
            }
        }
        return path.toString();
    }

    public void accept(MyVisitor visitor) {
        for (int value : data) {
           visitor.visitElement(value);
        }
    }

    public void save() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (FileWriter writer = new FileWriter(file)) {
                for (int value : data) {
                    writer.write(value + "\n");
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }

    @Override
    public MyIterator createIterator() {
        return new PreOrderTraversalTreeIterator(this);
    }
}
