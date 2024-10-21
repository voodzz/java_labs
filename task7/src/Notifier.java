import java.util.Set;

public class Notifier {
    private Set<Student> notifiables;

    public Notifier(Set<Student> notifiables) {
        this.notifiables = notifiables;
    }

    void doNotifyAll(String message) {
        for (Student student : notifiables) {
            student.notify(message);
        }
        System.out.println("Message: " + message);
    }
}
