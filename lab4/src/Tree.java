public class Tree<T extends Comparable<T>> {
    private Node<T> root;

    public void add(T value) {
        root = add(root, value);
    }

    private Node<T> add(Node<T> currentNode, T value) {
        if (currentNode == null) {
            currentNode = new Node<T>(value);
            return currentNode;
        } else if (value.compareTo(currentNode.value) < 0) {
            currentNode.leftChild = add(currentNode.leftChild, value);
        } else {
            currentNode.rightChild = add(currentNode.rightChild, value);
        }
        return currentNode;
    }

    private Node<T> find(T value) {
        return find(root, value);
    }

    public boolean contains(T value) {
        return find(root, value) != null;
    }

    private Node<T> find(Node<T> currentNode, T value) {
        if (currentNode == null) {
            return null;
        }
        if (value.compareTo(currentNode.value) == 0) {
            return currentNode;
        } else if (value.compareTo(currentNode.value) < 0) {
            return find(currentNode.leftChild, value);
        } else {
            return find(currentNode.rightChild, value);
        }
    }

    public void nodeLeftRightTraversal() {
        NLRTraversal(root);
    }

    private void NLRTraversal(Node<T> currentNode) {
        if (currentNode != null) {
            System.out.println(currentNode.value);
            NLRTraversal(currentNode.leftChild);
            NLRTraversal(currentNode.rightChild);
        }
    }

    public void leftRightNodeTraversal() {
        LRNTraversal(root);
    }

    private void LRNTraversal(Node<T> currentNode) {
        if (currentNode!= null) {
            NLRTraversal(currentNode.leftChild);
            NLRTraversal(currentNode.rightChild);
            System.out.println(currentNode.value);
        }
    }

    public void leftNodeRightTraversal() {
        LNRTraversal(root);
    }

    private void LNRTraversal(Node<T> currentNode) {
        if (currentNode != null) {
            LRNTraversal(currentNode.leftChild);
            System.out.println(currentNode.value);
            LNRTraversal(currentNode.rightChild);
        }
    }

    private static class Node<T> {
        private Node<T> leftChild;
        private Node<T> rightChild;
        private T value;

        Node(T value) {
            this.value = value;
            leftChild = null;
            rightChild = null;
        }

        // getters
        public Node<T> getLeftChild() {
            return leftChild;
        }
        public Node<T> getRightChild() {
            return rightChild;
        }
        public T getValue() {
            return value;
        }

        // setters
        public void setLeftChild(Node<T> leftChild) {
            this.leftChild = leftChild;
        }

        public void setRightChild(Node<T> rightChild) {
            this.rightChild = rightChild;
        }

        public void setValue(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "leftChild=" + leftChild +
                    ", rightChild=" + rightChild +
                    ", value=" + value +
                    '}';
        }
    }
}
