package com.example.library.dbcontrollers;

import com.example.library.classes.Book;

import java.util.List;

public interface BookRepository {
    public List<Book> findAll();
    public void add(Book book);
    public void lendBook(Book book);
    public void acceptBook(Book book);
}
