import javax.swing.*;
import java.awt.*;

public class TaskThreePanel extends JPanel {
    private ButtonGroup group;
    private final ImageIcon[] images = new ImageIcon[]{
            new ImageIcon("notSelected.png"),
            new ImageIcon("selected.png"),
            new ImageIcon("pressed.png"),
            new ImageIcon("rollover.png")
    };

    TaskThreePanel() {
        super();
        setLayout(new GridLayout(2,2));
        group = new ButtonGroup();

        for (int i = 0; i < images.length; ++i) {
            Image image = images[i].getImage();
            Image scaledInstance = image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH); // scale
            images[i] = new ImageIcon(scaledInstance);
        }

        for (int i = 0; i < 4; ++i) {
            JRadioButton radioButton = new JRadioButton(images[0]);
            radioButton.setText((i + 1) + "");
            radioButton.setSelectedIcon(images[1]);
            radioButton.setPressedIcon(images[2]);
            radioButton.setRolloverIcon(images[3]);
            radioButton.setFont(new Font("Arial", Font.PLAIN, 24));
            group.add(radioButton);
            add(radioButton);
        }
    }
}
