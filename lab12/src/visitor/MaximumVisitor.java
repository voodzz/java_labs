package visitor;

import javax.swing.*;

public class MaximumVisitor<T extends Comparable<T>> implements MyVisitor<T> {
    T maximum;

    T getMaximum() {
        return maximum;
    }

    @Override
    public void visitMySet(MySet<T> set) {
        try {
            MySetIterator<T> iterator = (MySetIterator<T>) set.createIterator();
            maximum = set.getElement(0);
            while (!iterator.isDone()) {
                if (maximum.compareTo(iterator.currentItem()) < 0) {
                    maximum = iterator.currentItem();
                }
                iterator.next();
            }
        } catch (IteratorOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
