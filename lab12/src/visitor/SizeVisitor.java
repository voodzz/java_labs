package visitor;

public class SizeVisitor<T extends Comparable<T>> implements MyVisitor<T> {
    int size = 0;

    int getSize() {
        return size;
    }

    @Override
    public void visitMySet(MySet<T> set) {
        MySetIterator<T> iterator = (MySetIterator<T>) set.createIterator();
        while(!iterator.isDone()) {
            ++size;
            iterator.next();
        }
    }
}
