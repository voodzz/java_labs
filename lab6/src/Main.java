import javax.swing.*;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        Session session = new Session();
        try {
            session.readDataFromFile("session.txt");
            System.out.println(session.toString());
        } catch (NumberFormatException | FileNotFoundException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
        }
    }
}