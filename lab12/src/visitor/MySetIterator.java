package visitor;

import java.util.ArrayList;

public class MySetIterator<T extends Comparable<T>> implements MyIterator<T> {
    private final ArrayList<T> set;
    private int current;

    MySetIterator(ArrayList<T> set) {
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
            return set.get(current);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
}
