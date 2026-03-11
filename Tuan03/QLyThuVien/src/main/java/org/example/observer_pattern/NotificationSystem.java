package org.example.observer_pattern;

import java.util.ArrayList;
import java.util.List;

public class NotificationSystem {

    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers(String message) {

        for (Observer o : observers) {
            o.update(message);
        }
    }
}