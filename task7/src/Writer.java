import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    public void saveCourseToFile(Course course,String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(course.toString());
        } catch (IOException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Writing exception", JOptionPane.ERROR_MESSAGE);
        }
    }
}
