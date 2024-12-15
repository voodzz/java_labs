package strategy.xmlStrategy;

import session.Student;
import org.xml.sax.*;
import xml.MyStudentHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;

public class SAXReadStrategy implements XMLReadStrategy {
    @Override
    public ArrayList<Student> parse(String fileName) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        XMLReader xmlReader = saxParser.getXMLReader();
        MyStudentHandler handler = new MyStudentHandler();
        xmlReader.setContentHandler(handler);
        xmlReader.parse(fileName);
        return handler.getStudents();
    }
}
