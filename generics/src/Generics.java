import java.util.function.Predicate;

public class Generics<T extends Comparable<T>> {
    T[] array;
    boolean contains(T value) {
        for (T element : array) {
            if (element.compareTo(value) == 0) {
                return true;
            }
        }
        return false;
        /* or just
        return Arrays.asList(array).contains(value);
         */
    }

    int countElementsWithValue(T value) {
        int counter = 0;
        for (T element : array) {
            if (element.equals(value)) {
                ++counter;
            }
        }
        return counter;
    }

    int countElementsGreaterThan(T value) {
        int counter = 0;
        for (T element : array) {
            if (element.compareTo(value) > 0) {
                ++counter;
            }
        }
        return counter;
    }

    int countElementsMatchingPredicate(Predicate<T> predicate) {
        int counter = 0;
        for (T element : array) {
            if (predicate.test(element)) {
                counter++;
            }
        }
        return counter;
    }
}