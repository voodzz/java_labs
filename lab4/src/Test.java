public class Test {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(1);
        System.out.println(tree.contains(1));
        tree.leftNodeRightTraversal();
    }
}
