package org.example.strategy_pattern;

import org.example.factory_method_patter.Book;

import java.util.List;

public interface SearchStrategy {
    List<Book> search(List<Book> books, String keyword);
}