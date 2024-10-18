import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();
        students.add(new Student("IvanVanya", "vanya@mail.ru", "Ivan"));
        students.add(new Student("petka", "vanyaloh@mail.ru", "Petya"));
        students.add(new Student("LeraVleria", "lera@mail.ru", "Lera"));

        Course course = new Course("MA", students);
        System.out.println(course);

        Set<Student> students2 = new TreeSet<>(new ComparatorByName());
        students2.add(new Student("ZIvanVanya", "vanya@mail.ru", "Ivan"));
        students2.add(new Student("petka", "vanyaloh@mail.ru", "Petya"));
        students2.add(new Student("LeraVleria", "lera@mail.ru", "Lera"));

        Course course2 = new Course("GA", students2);
        System.out.println(course2);
    }
}
