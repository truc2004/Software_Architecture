package org.example.observer.task;

import org.example.observer.Observer;
import org.example.observer.Subject;

import java.util.ArrayList;
import java.util.List;

public class ProjectTask implements Subject {

    private String taskName;
    private String status;
    private List<Observer> observers = new ArrayList<>();

    public ProjectTask(String taskName) {
        this.taskName = taskName;
    }

    public void setStatus(String status) {
        this.status = status;
        notifyObservers();
    }

    public String getStatus() {
        return status;
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
            o.update("Task '" + taskName + "' đổi trạng thái: " + status);
        }
    }
}
