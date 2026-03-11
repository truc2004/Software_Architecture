package org.example.composite;

import java.util.ArrayList;
import java.util.List;

class Folder implements FileComponent {

    private String name;
    private List<FileComponent> children = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void add(FileComponent component) {
        children.add(component);
    }

    public void remove(FileComponent component) {
        children.remove(component);
    }

    @Override
    public void display() {
        System.out.println("Folder: " + name);

        for (FileComponent component : children) {
            component.display();
        }
    }
}