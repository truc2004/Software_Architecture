package org.example;

import org.example.decorator_pattern.BasicBorrow;
import org.example.decorator_pattern.Borrow;
import org.example.decorator_pattern.ExtendTimeDecorator;
import org.example.decorator_pattern.SpecialEditionDecorator;
import org.example.factory_method_patter.*;
import org.example.observer_pattern.LibraryUser;
import org.example.observer_pattern.NotificationSystem;
import org.example.observer_pattern.Observer;
import org.example.singleton_pattern.Library;
import org.example.strategy_pattern.SearchByAuthor;
import org.example.strategy_pattern.SearchByTitle;
import org.example.strategy_pattern.SearchStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Singleton Pattern
        Library lib1 = Library.getInstance();
        Library lib2 = Library.getInstance();


        if (lib1 == lib2) {
            System.out.println("Both objects are the same instance");
        }

        // Factory Method Pattern
        Book book1 = BookFactory.createBook("paper",
                "Java Programming",
                "James Gosling",
                "Programming");

        Book book2 = BookFactory.createBook("ebook",
                "Design Patterns",
                "GoF",
                "Software Engineering");

        Book book3 = BookFactory.createBook("audio",
                "Clean Code",
                "Robert C. Martin",
                "Programming");

        book1.displayInfo();
        book2.displayInfo();
        book3.displayInfo();


//        Strategy Pattern:
        List<Book> books = new ArrayList<>();

        books.add(new PaperBook("Java Programming", "James Gosling", "Programming"));
        books.add(new EBook("Design Patterns", "GoF", "Software"));
        books.add(new AudioBook("Clean Code", "Robert Martin", "Programming"));

        // Tìm theo tiêu đề
        SearchStrategy searchByTitle = new SearchByTitle();
        List<Book> resultTitle = searchByTitle.search(books, "Java");

        System.out.println("Search by Title:");
        for (Book b : resultTitle) {
            b.displayInfo();
        }

        // Tìm theo tác giả
        SearchStrategy searchByAuthor = new SearchByAuthor();
        List<Book> resultAuthor = searchByAuthor.search(books, "Martin");

        System.out.println("\nSearch by Author:");
        for (Book b : resultAuthor) {
            b.displayInfo();
        }

        //Observer Pattern

        NotificationSystem notificationSystem = new NotificationSystem();

        // Tạo người dùng đăng ký nhận thông báo
        Observer user1 = new LibraryUser("Alice");
        Observer user2 = new LibraryUser("Bob");
        Observer user3 = new LibraryUser("Charlie");

        // Đăng ký theo dõi
        notificationSystem.addObserver(user1);
        notificationSystem.addObserver(user2);
        notificationSystem.addObserver(user3);

        // Thông báo khi có sách mới
        notificationSystem.notifyObservers("New book added: Design Patterns");

        // Decorator Pattern
        Borrow borrow = new BasicBorrow();

        borrow = new ExtendTimeDecorator(borrow);
        borrow = new SpecialEditionDecorator(borrow);

        System.out.println(borrow.getDescription());
    }
}