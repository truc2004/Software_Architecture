package org.example.observer;

interface Subject {

    void attach(Observer observer);

    void detach(Observer observer);

    void notifyObservers();
}