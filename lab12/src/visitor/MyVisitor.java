package visitor;

public interface MyVisitor<T extends Comparable<T>> {
    void visitMySet(MySet<T> set);
}
