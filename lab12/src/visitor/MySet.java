package visitor;

import javax.swing.*;
import java.util.*;

public class MySet<T extends Comparable<T>> implements Aggregate<T>, MyElement<T> {
    private ArrayList<T> list;

    public MySet() {
        list = new ArrayList<>();
    }

    public MySet(Collection<? extends T> c) {
        list = new ArrayList<>();
        addAll(c);
    }

    public int size() {
        SizeVisitor<T> sizeVisitor = new SizeVisitor<>();
        accept(sizeVisitor);
        return sizeVisitor.getSize();
    }

    public T getMaximum() {
        MaximumVisitor<T> maximumVisitor = new MaximumVisitor<T>();
        accept(maximumVisitor);
        return maximumVisitor.getMaximum();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void clear() {
        list.clear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MySet<?> mySet)) return false;
        return Objects.equals(list, mySet.list);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < list.size(); ++i) {
            if (i != list.size() - 1) {
                sb.append(list.get(i)).append(", ");
            }
            else {
                sb.append(list.get(i));
            }
        }
        sb.append("}\n");
        return sb.toString();
    }

    public DefaultListModel<T> getListModel() {
        DefaultListModel<T> model = new DefaultListModel<>();
        model.addAll(list);
        return model;
    }

    public void add(T element) {
        if (!list.contains(element)) {
            list.add(element);
        }
    }

    public void remove(T element) {
        if (list.contains(element)) {
            list.remove(element);
        } else {
            throw new NoSuchElementException();
        }
    }

    public void addAll(Collection<? extends T> c) {
        for (T element : c) {
            this.add(element);
        }
    }

    public MySet<T> uniteWith(MySet<T> other) {
        if (other == null || other.isEmpty()) {
            return this;
        }
        MySet<T> result = new MySet<>();
        result.addAll(list);
        result.addAll(other.list);
        return result;
    }

    public MySet<T> intersectWith(MySet<T> other) throws IteratorOutOfBoundsException {
        if (other == null || other.isEmpty()) {
            return this;
        }

        MySet<T> result = new MySet<>();
        MySetIterator<T> iterator;
        if (this.size() >= other.size()) {
            iterator = (MySetIterator<T>) this.createIterator();
            while (!iterator.isDone()) {
                T element = iterator.currentItem();
                if (other.contains(element)) {
                    result.add(element);
                }
                iterator.next();
            }
        } else {
            iterator = (MySetIterator<T>) other.createIterator();
            while (!iterator.isDone()) {
                T element = iterator.currentItem();
                if (this.contains(element)) {
                    result.add(element);
                }
                iterator.next();
            }
        }
        return result;
    }

    public MySet<T> differenceWith(MySet<T> other) throws IteratorOutOfBoundsException {
        if (other == null || other.isEmpty()) {
            return this;
        }
        MySet<T> result = new MySet<>(list);
        MySetIterator<T> iterator = (MySetIterator<T>) other.createIterator();
        while (!iterator.isDone()) {
            T element = iterator.currentItem();
            if (this.contains(element)) {
                result.remove(element);
            }
            iterator.next();
        }
        return result;
    }

    public T getElement(int index) {
        return list.get(index);
    }

    @Override
    public MyIterator<T> createIterator() {
        return new MySetIterator<>(this.list);
    }

    public boolean contains(T element) {
        return list.contains(element);
    }

    @Override
    public void accept(MyVisitor<T> visitor) {
        visitor.visitMySet(this);
    }
}
