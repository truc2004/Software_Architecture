package org.example.factory_method_patter;

public class EBook implements Book {

    private String title;
    private String author;
    private String category;

    public EBook(String title, String author, String category) {
        this.title = title;
        this.author = author;
        this.category = category;
    }

    public void displayInfo() {
        System.out.println("EBook: " + title);
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getCategory() { return category; }
}