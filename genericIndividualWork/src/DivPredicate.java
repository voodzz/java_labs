import java.util.function.Predicate;

public class DivPredicate implements Predicate<Integer> {
    private int divider;

    DivPredicate(int divider) {
        this.divider = divider;
    }

    @Override
    public boolean test(Integer integer) {
        return integer % divider == 0;
    }
}
