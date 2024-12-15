package xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import session.Student;

import java.util.ArrayList;
import java.util.TreeMap;

public class MyStudentHandler extends DefaultHandler {
    private static final String STUDENTS_TAG = "students";
    private static final String STUDENT_TAG = "student";
    private static final String ID_TAG = "id";
    private static final String SURNAME_TAG = "surname";
    private static final String GRADES_TAG = "grades";
    private static final String SUBJECT_TAG = "subject";

    private static final String SUBJECT_NAME_ATTRIBUTE = "name";

    private ArrayList<Student> students;
    private Student currentStudent;
    private String currentElement;
    private String currentSubject;

    public ArrayList<Student> getStudents() {
        return students;
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;

        switch (currentElement) {
            case STUDENTS_TAG: {
                students = new ArrayList<>();
            } break;
            case STUDENT_TAG: {
                currentStudent = new Student();
            } break;
            case GRADES_TAG: {
                currentStudent.setSubjectAndMarkMap(new TreeMap<>());
            } break;
            case SUBJECT_TAG: {
                currentSubject = attributes.getValue(SUBJECT_NAME_ATTRIBUTE);
                currentStudent.getSubjectAndMarkMap().put(currentSubject, 0);
            } break;
            default: {
            } break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String text = new String(ch, start, length);

        if (currentElement == null || currentElement.contains("<")) {
            return;
        }

        switch (currentElement) {
            case ID_TAG: {
                currentStudent.setId(Integer.parseInt(text));
            } break;
            case SURNAME_TAG: {
                currentStudent.setSurname(text);
            } break;
            case SUBJECT_TAG: {
                currentStudent.getSubjectAndMarkMap().put(currentSubject, Integer.parseInt(text));
            }
            default: {
            } break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals(STUDENT_TAG)) {
            students.add(currentStudent);
            currentStudent = null;
        }
        currentElement = null;
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }
}
