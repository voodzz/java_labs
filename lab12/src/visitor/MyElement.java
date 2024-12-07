package visitor;

public interface MyElement<T extends Comparable<T>> {
    void accept(MyVisitor<T> visitor);
}
