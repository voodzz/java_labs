package Strategy;

import java.util.Set;
import java.util.TreeSet;

public class SetStrategy implements Strategy {
    @Override
    public String listSubjects(Session session) {
        Set<String> subjects = new TreeSet<>(session.getSubjects());
        return String.join(", ", subjects);
    }
}
