import java.util.Objects;

public class Tree<T> {
    private Node<T> root;

    public void addNode(T value) {
        Node<T> newNode = new Node<>();
        newNode.setValue(value);

        if (root == null) {
            root = newNode;
        } else {
            
        }
    }

    private static class Node<T> {
        private Node<T> leftChild;
        private Node<T> rightChild;
        private T value;

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
