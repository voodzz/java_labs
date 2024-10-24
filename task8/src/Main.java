import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Reader reader = new Reader();
        try {
            Present present = reader.readPresentFromFile("test.txt");
            System.out.println(present.toString());
        } catch (IOException | IllegalArgumentException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Input exception", JOptionPane.ERROR_MESSAGE);
        }
    }
}