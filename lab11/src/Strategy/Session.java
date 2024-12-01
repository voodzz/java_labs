package Strategy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Session {
    private ArrayList<Student> session;
    private ArrayList<String> subjects;

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (Student student : session) {
            result.append(student.toString()); // каждый студент уже имеет свой формат в методе toString()
        }

        return result.toString().trim();
    }

    public Session() {
        session = new ArrayList<>();
        subjects = new ArrayList<>();
    }

    void readDataFromFile(String fileName) throws FileNotFoundException, NumberFormatException {
        Scanner scanner = new Scanner(new File(fileName));
        session.clear();
        while(scanner.hasNext()) {
            String[] line = scanner.nextLine().split("[-\\s]+");
            Map<String, Integer> subjectsAndMarksMap = new TreeMap<>();
            Integer id = Integer.parseInt(line[0]);
            String surname = line[1];
            for (int i = 2; i < line.length - 1; i += 2) {
                subjectsAndMarksMap.put(line[i], Integer.parseInt(line[i + 1]));
            }
            session.add(new Student(id, surname, subjectsAndMarksMap));
            subjects.addAll(subjectsAndMarksMap.keySet());
        }
        scanner.close();
    }

    void writeDataToFile(String fileName) throws IOException {
        FileWriter writer = new FileWriter(fileName);
        writer.write(toString());
        writer.close();
    }

    public ArrayList<Student> getSession() {
        return session;
    }

    public ArrayList<String> getSubjects() {
        return subjects;
    }
}
