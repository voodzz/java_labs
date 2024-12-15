package strategy.xmlStrategy;

import session.Student;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public interface XMLReadStrategy {
    ArrayList<Student> parse(String fileName) throws ParserConfigurationException, SAXException, IOException;
}
