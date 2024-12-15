package session;

import org.xml.sax.SAXException;
import strategy.xmlStrategy.XMLReadStrategy;
import strategy.xmlStrategy.XMLWriteStrategy;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Session {
    private ArrayList<Student> students;
    private ArrayList<String> subjects;
    private XMLReadStrategy readStrategy;
    private XMLWriteStrategy writeStrategy;

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (Student student : students) {
            result.append(student.toString()); // каждый студент уже имеет свой формат в методе toString()
        }

        return result.toString().trim();
    }

    public Session() {
        students = new ArrayList<>();
        subjects = new ArrayList<>();
        readStrategy = null;
        writeStrategy = null;
    }

    public void readDataFromFile(String fileName) throws IOException, NumberFormatException, ParserConfigurationException, SAXException {
        students = readStrategy.parse(fileName);
        for (Student student : students) {
            for (String subject : student.getSubjectAndMarkMap().keySet()) {
                if (!subjects.contains(subject)) {
                    subjects.add(subject);
                }
            }
        }
    }

    public void writeDataToFile(String fileName) throws IOException, ParserConfigurationException, TransformerException {
        writeStrategy.writeToFile(fileName, students);
    }

    public void setReadStrategy(XMLReadStrategy readStrategy) {
        this.readStrategy = readStrategy;
    }

    public void setWriteStrategy(XMLWriteStrategy writeStrategy) {
        this.writeStrategy = writeStrategy;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<String> getSubjects() {
        return subjects;
    }
}
