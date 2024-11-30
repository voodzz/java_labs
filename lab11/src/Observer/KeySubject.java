package Observer;

import java.util.ArrayList;

public class KeySubject implements Subject {
    ArrayList<Observer> observers;

    public KeySubject() {
        observers = new ArrayList<Observer>();
    }

    public KeySubject(ArrayList<Observer> observers) {
        this.observers = observers;
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String keyName) {
        observers.forEach(observer -> observer.update(keyName));
    }
}
