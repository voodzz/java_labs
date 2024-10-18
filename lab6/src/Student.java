import java.util.Map;

public class Student {
    private Integer id;
    private String surname;
    Map<String, Integer> subjectAndMarkMap;

    public Student() {
        id = 0;
        surname = "";
        subjectAndMarkMap = null;
    }

    public Student(Integer id, String surname, Map<String, Integer> subjectAndMarkMap) {
        this.id = id;
        this.surname = surname;
        this.subjectAndMarkMap = subjectAndMarkMap;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", subjectAndMarkMap=" + subjectAndMarkMap +
                "}\n";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Map<String, Integer> getSubjectAndMarkMap() {
        return subjectAndMarkMap;
    }

    public void setSubjectAndMarkMap(Map<String, Integer> subjectAndMarkMap) {
        this.subjectAndMarkMap = subjectAndMarkMap;
    }
}
