package Strategy;

import java.util.stream.Collectors;

public class StreamStrategy implements Strategy {
    @Override
    public String listSubjects(Session session) {
        return session.getSubjects().stream().distinct().sorted().collect(Collectors.joining(", "));
    }
}
