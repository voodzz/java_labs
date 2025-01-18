import java.util.ArrayList;

public class MinStreamAPIStrategy implements MyStrategy {

    @Override
    public int execute(BinaryTree tree) {
        ArrayList<Integer> list = tree.getElements();
        return list.stream()
                .filter(value -> value != 0) // Фильтруем элементы, отличные от нуля
                .min(Integer::compareTo)
                .orElse(0);
    }
}
