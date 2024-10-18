import com.sun.source.tree.Tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Session {
    ArrayList<Student> session;

    @Override
    public String toString() {
        return "Session{" +
                "session=" + session +
                '}';
    }

    public Session() {
        session = new ArrayList<Student>();
    }

    void readDataFromFile(String fileName) throws FileNotFoundException, NumberFormatException {
        Scanner scanner = new Scanner(new File(fileName));
        while(scanner.hasNext()) {
            String[] line = scanner.nextLine().split("[-\\s]+");
            Map<String, Integer> subjectsAndMarksMap = new TreeMap<>();
            Integer id = Integer.parseInt(line[0]);
            String surname = line[1];
            for (int i = 2; i < line.length - 1; i += 2) {
                subjectsAndMarksMap.put(line[i], Integer.parseInt(line[i + 1]));
            }
            session.add(new Student(id, surname, subjectsAndMarksMap));
        }
        scanner.close();
    }
}
