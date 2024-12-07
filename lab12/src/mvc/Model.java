package mvc;

import visitor.MySet;

import java.util.ArrayList;

public class Model<T extends Comparable<T>> implements Subject<T> {
    private MySet<T> set1;
    private MySet<T> set2;
    private ArrayList<Observer<T>> observers;

    public Model() {
        set1 = new MySet<>();
        set2 = new MySet<>();
        observers = new ArrayList<>();
    }

    public Model(MySet<T> set1, MySet<T> set2) {
        this.set1 = set1;
        this.set2 = set2;
    }

    public MySet<T> getSet1() {
        return set1;
    }

    public MySet<T> getSet2() {
        return set2;
    }

    public void setSet1(MySet<T> set1) {
        this.set1 = set1;
    }

    public void setSet2(MySet<T> set2) {
        this.set2 = set2;
    }

    @Override
    public void attach(Observer<T> observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer<T> observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> observer.update(this));
    }
}
