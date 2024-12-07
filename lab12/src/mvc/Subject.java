package mvc;

public interface Subject<T extends Comparable<T>> {
    void attach(Observer<T> observer);
    void detach(Observer<T> observer);
    void notifyObservers();
}
