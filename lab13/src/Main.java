import gui.Frame;
import gui.InputWindow;
import org.xml.sax.SAXException;
import session.Student;
import strategy.xmlStrategy.DOMReadStrategy;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        DOMReadStrategy domStrategy = new DOMReadStrategy();
        try {
            ArrayList<Student> students = domStrategy.parse("XMLSession1.xml");
            for (Student student : students) {
                System.out.print(student);
            }
            new InputWindow();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}