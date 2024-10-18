import java.util.function.Predicate;

public class MyUtil {
    public static <T> int matchesPredicate(T[] array, Predicate<T> predicate) {
        int counter = 0;
        for (T element : array) {
            if (predicate.test(element)) {
                ++counter;
            }
        }
        return counter;
    }
}