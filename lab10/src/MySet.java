import java.util.*;

public class MySet<T> {
    private ArrayList<T> list;

    MySet() {
        list = new ArrayList<>();
    }

    MySet(Collection<? extends T> c) {
        list = new ArrayList<>();
        addAll(c);
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
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

    public List<T> toList() {
        return list;
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
            if (!list.contains(element)) {
                list.add(element);
            }
        }
    }

    public MySet<T> uniteWith(MySet<T> other) {
        MySet<T> result = new MySet<>();
        result.addAll(list);
        result.addAll(other.list);
        return result;
    }

    public MySet<T> intersectWith(MySet<T> other) {
        MySet<T> result = new MySet<>();
        if (list.size() >= other.list.size()) {
            for (T element : list) {
                if (other.list.contains(element)) {
                    result.add(element);
                }
            }
        } else {
            for (T element : other.list) {
                if (list.contains(element)) {
                    result.add(element);
                }
            }
        }
        return result;
    }

    public MySet<T> differenceWith(MySet<T> other) {
        MySet<T> result = new MySet<>(list);
        for (T element : other.list) {
            if (list.contains(element)) {
                result.remove(element);
            }
        }
        return result;
    }
}
