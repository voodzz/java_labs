package visitor;

public interface Aggregate<T> {
    MyIterator<T> createIterator();
}
