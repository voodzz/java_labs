import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Predicate;

public class ProgrammingTest {
    public static void main(String[] args) {
        Academic academicDietel = new Academic("Paul Dietel");
        Academic academicHorstmann = new Academic("Cay Horstmann");

        Set<Student> studentSet = new HashSet<>();
        studentSet.add(new Postgraduate("te2", "te2@gmal.com", "Erik Track", academicDietel));
        studentSet.add(new Postgraduate("yj34", "yj34@gmal.com", "Ying Ju", academicHorstmann));
        studentSet.add(new Postgraduate("jj8", "jj8@gmal.com", "Jack Jonson", academicHorstmann));
        studentSet.add(new Undergraduate("gg4", "gg4@gamil.com", "Garrett Gordon", academicDietel));
        studentSet.add(new Undergraduate("pr3", "pr3@gamil.com", "Patrick Richter", academicHorstmann));

        Course course = new Course("MA", studentSet);
        System.out.println(course.getPostgraduates("Cay Horstmann"));
        Notifier notifier = new Notifier(studentSet);
        notifier.doNotifyAll("Hello, Students");

        course.addStudent(new Undergraduate("nm2", "nm@gmail.com", "Nigel Mansell", academicDietel));
        Iterator<Student> iterator = course.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getName());
        }

        Predicate<Student> predicate = student -> {
            if (student instanceof Postgraduate postgraduate) {
                return postgraduate.getSupervisor().getName().equals("Paul Dietel");
            } else if (student instanceof Undergraduate undergraduate) {
                return undergraduate.getTutor().getName().equals("Paul Dietel");
            }
            return false;
        };
        Set<Student> conditionSet = course.getStudentsByCondition(predicate);
        System.out.println();
        System.out.println(conditionSet);

        Writer writer = new Writer();
        writer.saveCourseToFile(course, "output.txt");
    }
}
