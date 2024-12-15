package strategy.xmlStrategy;

import session.Student;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import java.util.ArrayList;

public interface XMLWriteStrategy {
    void writeToFile(String filePath, ArrayList<Student> data) throws ParserConfigurationException, TransformerException;
}
