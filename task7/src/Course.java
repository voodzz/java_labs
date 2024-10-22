import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Predicate;

public class Course implements Iterable<Student>{
    private String name;
    private Set<Student> students;

    public Course(String name, Set<Student> students) {
        this.name = name;
        this.students = students;
    }

    public Set<Postgraduate> getPostgraduates(String nameOfSupervisor) {
        Set<Postgraduate> result = new HashSet<>();
        for (Student student : students) {
            if (student instanceof Postgraduate postgraduate) {
                if (postgraduate.getSupervisor().getName().equals(nameOfSupervisor)) {
                    result.add(postgraduate);
                }
            }
        }
        return result;
    }

    public void addStudent(Student student) throws IllegalArgumentException {
        if (!students.contains(student)) {
            students.add(student);
        } else {
            throw new IllegalArgumentException("Such student already takes this course.");
        }
    }

    public Set<Student> getStudentsByCondition(Predicate<Student> predicate) {
        Set<Student> result = new HashSet<>();
        forEach(student -> {
            if (predicate.test(student)) {
                result.add(student);
            }
        });
//        for (Student student : students) {
//            if (predicate.test(student)) {
//                result.add(student);
//            }
//        }
        return result;
    }

    @Override
    public Iterator<Student> iterator() {
        return students.iterator();
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", students=" + students +
                '}';
    }


}
