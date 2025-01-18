import java.util.ArrayList;

class PreOrderTraversalTreeIterator implements MyIterator {
    private final ArrayList<Integer> tree;
    private final ArrayList<Integer> traversal;
    private int currentIndex;

    public PreOrderTraversalTreeIterator(BinaryTree tree) {
        this.tree = tree.getElements();
        this.traversal = new ArrayList<>();
        this.currentIndex = -1;
        preOrderTraversal(0);
    }

    private void preOrderTraversal(int index) {
        if (index >= tree.size() || tree.get(index) == 0) {
            return;
        }
        traversal.add(tree.get(index));
        preOrderTraversal(2 * index + 1);
        preOrderTraversal(2 * index + 2);
    }

    @Override
    public void first() {
        currentIndex = 0;
    }

    @Override
    public void next() {
        currentIndex++;
    }

    @Override
    public boolean isDone() {
        return currentIndex >= traversal.size();
    }

    @Override
    public Integer currentItem() {
        if (isDone()) {
            throw new IllegalStateException("No current item");
        }
        return traversal.get(currentIndex);
    }
}
