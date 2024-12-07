package mvc;

import javax.swing.*;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        try {
            new Controller();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
