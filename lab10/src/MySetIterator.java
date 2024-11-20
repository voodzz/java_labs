import java.util.NoSuchElementException;

public class MySetIterator<T> implements MyIterator<T> {
    private final MySet<T> set;
    private int current;

    MySetIterator(MySet<T> set) {
        this.set = set;
        current = 0;
    }

    @Override
    public void first() {
        current = 0;
    }

    @Override
    public void next() {
        ++current;
    }

    @Override
    public boolean isDone() {
        return current >= set.size();
    }

    @Override
    public T currentItem() throws IteratorOutOfBoundsException {
        if (!isDone()) {
            return set.getElement(current);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
}
