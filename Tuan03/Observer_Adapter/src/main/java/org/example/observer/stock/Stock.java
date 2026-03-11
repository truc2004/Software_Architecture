package org.example.observer.stock;

import org.example.observer.Observer;
import org.example.observer.Subject;

import java.util.ArrayList;
import java.util.List;

public class Stock implements Subject {

    private String stockName;
    private double price;
    private List<Observer> observers = new ArrayList<>();

    public Stock(String stockName) {
        this.stockName = stockName;
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }

    public double getPrice() {
        return price;
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update("Giá cổ phiếu " + stockName + " thay đổi: " + price);
        }
    }
}
