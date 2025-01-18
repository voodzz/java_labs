import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    private JTextField arrayTextField;
    private JLabel minLabel1;
    private JLabel minLabel2;
    private JTextField addTextField;
    private JButton addButton;
    private JTextField toMinTextField;
    private JTextField traversalTextField;
    private JButton saveButton;

    public View() {
        setTitle("КР2 Войтукевич Руслан");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 800);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(8, 1));

        arrayTextField = new JTextField(30);
        add(arrayTextField);

        minLabel1 = new JLabel();
        add(minLabel1);

        minLabel2 = new JLabel();
        add(minLabel2);

        addTextField = new JTextField(30);
        add(addTextField);

        addButton = new JButton("Add Element");
        add(addButton);

        toMinTextField = new JTextField(30);
        add(toMinTextField);

        traversalTextField = new JTextField(30);
        add(traversalTextField);

        saveButton = new JButton("Save To File");
        add(saveButton);

        setVisible(true);
    }

    public JTextField getArrayTextField() {
        return arrayTextField;
    }

    public JLabel getMinLabel1() {
        return minLabel1;
    }

    public JLabel getMinLabel2() {
        return minLabel2;
    }

    public JTextField getAddTextField() {
        return addTextField;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JTextField getToMinTextField() {
        return toMinTextField;
    }

    public JTextField getTraversalTextField() {
        return traversalTextField;
    }

    public JButton getSaveButton() {
        return saveButton;
    }
}
