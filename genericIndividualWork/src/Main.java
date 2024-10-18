import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, 5, 6};
        Predicate<Integer> predicate = new DivPredicate(5);
        System.out.println(MyUtil.matchesPredicate(array, predicate));

        System.out.println(MyUtil.matchesPredicate(array, integer -> integer % 3 == 0));
    }
}
