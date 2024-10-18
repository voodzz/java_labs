import java.util.Comparator;
import java.util.Objects;

public class ComparatorByName implements Comparator<Student> {

    @Override
    public int compare(Student student, Student t1) {
        return student.getName().compareTo(t1.getName());
    }
}
