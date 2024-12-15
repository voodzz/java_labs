package strategy.xmlStrategy;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import session.Student;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.ArrayList;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class DOMWriteStrategy implements XMLWriteStrategy {
    @Override
    public void writeToFile(String filePath, ArrayList<Student> data) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        Element root = document.createElement("students");
        document.appendChild(root);

        for (Student student : data) {
            Element studentElement = document.createElement("student");
            root.appendChild(studentElement);

            Element idElement = document.createElement("id");
            idElement.setTextContent(student.getId().toString());
            studentElement.appendChild(idElement);

            Element surnameElement = document.createElement("surname");
            surnameElement.setTextContent(student.getSurname());
            studentElement.appendChild(surnameElement);

            Element gradesElement = document.createElement("grades");
            for (String key : student.getSubjectAndMarkMap().keySet()) {
                Element subjectElement = document.createElement("subject");
                subjectElement.setAttribute("name", key);
                subjectElement.setTextContent(Integer.toString(student.getSubjectAndMarkMap().get(key)));
                gradesElement.appendChild(subjectElement);
            }
            studentElement.appendChild(gradesElement);
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(new DOMSource(document), new StreamResult(filePath));
    }
}
