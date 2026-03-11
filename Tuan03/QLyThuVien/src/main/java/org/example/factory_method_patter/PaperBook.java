package org.example.factory_method_patter;

public class PaperBook implements Book {

    private String title;
    private String author;
    private String category;

    public PaperBook(String title, String author, String category) {
        this.title = title;
        this.author = author;
        this.category = category;
    }

    public void displayInfo() {
        System.out.println("Paper Book: " + title);
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
}