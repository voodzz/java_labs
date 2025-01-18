import java.util.ArrayList;

public class MinLeftSonStrategy implements MyStrategy{
    @Override
    public int execute(BinaryTree tree) {
        return calculateMin(tree.getElements(), 0, Integer.MAX_VALUE);
    }

    private int calculateMin(ArrayList<Integer> tree, int index, int currentMin) {
        if (index >= tree.size() || tree.get(index) == 0) {
            return currentMin;
        }
        int value = tree.get(index);
        currentMin = Math.min(currentMin, value);
        currentMin = calculateMin(tree, 2 * index + 1, currentMin);
        return calculateMin(tree, 2 * index + 2, currentMin);
    }
}
