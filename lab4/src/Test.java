public class Test {
    public static void main(String[] args) {
        Integer[] arr = {5, 3, 7, 1, 4};
        Tree<Integer> tree = new Tree<>(arr);
        tree.leftNodeRightTraversal();
        System.out.println();
        tree.delete(3);
        tree.leftNodeRightTraversal();
    }
}
