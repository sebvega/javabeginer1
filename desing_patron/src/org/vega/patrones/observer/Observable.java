package org.vega.patrones.observer;

import java.util.ArrayList;
import java.util.List;

abstract public class Observable {
    protected List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void remove(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObserver() {
        notifyObserver(null);
    }

    public void notifyObserver(Object o) {
        for (Observer obs : this.observers) {
            obs.update(this, o);
        }
    }
}

