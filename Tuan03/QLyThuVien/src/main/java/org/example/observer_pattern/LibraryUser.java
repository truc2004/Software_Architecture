package org.example.observer_pattern;

public class LibraryUser implements Observer {

    private String name;

    public LibraryUser(String name) {
        this.name = name;
    }

    public void update(String message) {
        System.out.println(name + " received notification: " + message);
    }
}