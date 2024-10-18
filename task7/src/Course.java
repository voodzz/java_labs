import java.util.Iterator;
import java.util.Set;

public class Course implements Iterable<Student>{
    private String name;
    private Set<Student> students;

    public Course(String name, Set<Student> students) {
        this.name = name;
        this.students = students;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", students=" + students +
                '}';
    }

    @Override
    public Iterator<Student> iterator() {
        return students.iterator();
    }
}
