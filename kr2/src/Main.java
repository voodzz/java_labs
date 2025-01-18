public class Main {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(10);
        binaryTree.add(5);
        binaryTree.add(35);
        binaryTree.add(1);
        binaryTree.add(4);
        binaryTree.add(20);
        binaryTree.add(99);
        binaryTree.add(17);
        binaryTree.add(31);

        for (Integer element : binaryTree.getElements()) {
            System.out.print(element + " ");
        }
        System.out.println();

        PrintVisitor printVisitor = new PrintVisitor();
        binaryTree.accept(printVisitor);
        System.out.println(printVisitor.getResult());

        System.out.println(binaryTree.getPreOrderTraversal());

        System.out.println(binaryTree.moveToMin());
        System.out.println();

        binaryTree.setMinStrategy(new MinLeftSonStrategy());
        System.out.println(binaryTree.min());

        new Controller(binaryTree, new View());
    }
}