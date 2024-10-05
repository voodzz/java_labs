public class Main {
    public static void main(String[] args) {
        Integer[] dataForTree1 = {8, 3, 10, 1, 6, 4, 7, 14, 13};
        Tree<Integer> tree1 = new Tree<>(dataForTree1);
        tree1.leftNodeRightTraversal();
        System.out.println();
        tree1.leftRightNodeTraversal();
        System.out.println();

        Integer[] dataForTree2 = {8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13, 15};
        Tree<Integer> tree2 = new Tree<>(dataForTree2);
        tree2.add(16);
        tree2.nodeLeftRightTraversal();
    }
}
