import java.util.Comparator;
import java.util.Objects;

public class Student extends Person implements Notifiable {
    private String email;
    private String login;

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public Student(String login, String email, String name) {
        super(name);
        this.email = email;
        this.login = login;
    }

    @Override
    public String toString() {
        return "Student{" +
                "email='" + email + '\'' +
                ", login='" + login + '\'' +
                "} " + super.toString() + '\n';
    }

    @Override
    public void notify(String message) {
        System.out.println("Notifying " + this.email);
    }
}
