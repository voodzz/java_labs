package strategy.xmlStrategy;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import session.Student;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class DOMReadStrategy implements XMLReadStrategy {
    @Override
    public ArrayList<Student> parse(String fileName) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(fileName);

        NodeList studentsNodeList = doc.getElementsByTagName("student");
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < studentsNodeList.getLength(); ++i) {
            if (studentsNodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element studentElement = (Element) studentsNodeList.item(i);
                Student student = new Student();

                NodeList childNodes = studentElement.getChildNodes();
                for (int j = 0; j < childNodes.getLength(); ++j) {
                    if (childNodes.item(j).getNodeType() == Node.ELEMENT_NODE) {
                        Element childElement = (Element) childNodes.item(j);
                        switch (childElement.getNodeName()) {
                            case "id": {
                                student.setId(Integer.parseInt(childElement.getTextContent()));
                            } break;
                            case "surname": {
                                student.setSurname(childElement.getTextContent());
                            } break;
                            case "grades": {
                                Map<String, Integer> subjectsAndMarks = getSubjectsAndMarksMap(childElement);
                                student.setSubjectAndMarkMap(subjectsAndMarks);
                            } break;

                        }
                    }
                }

                students.add(student);
            }
        }
        return students;
    }

    private static Map<String, Integer> getSubjectsAndMarksMap(Element childElement) {
        NodeList gradesNodeList = childElement.getChildNodes();
        Map<String, Integer> subjectsAndMarks = new TreeMap<>();
        for (int k = 0; k < gradesNodeList.getLength(); ++k) {
            if (gradesNodeList.item(k).getNodeType() == Node.ELEMENT_NODE) {
                Element gradeElement = (Element) gradesNodeList.item(k);
                if (gradeElement.getNodeName().equals("subject")) {
                    subjectsAndMarks.put(gradeElement.getAttribute("name"), Integer.parseInt(gradeElement.getTextContent()));
                }
            }
        }
        return subjectsAndMarks;
    }
}
