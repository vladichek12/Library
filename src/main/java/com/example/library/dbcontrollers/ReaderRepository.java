package com.example.library.dbcontrollers;

import com.example.library.classes.Book;
import com.example.library.classes.Reader;

import java.util.List;

public interface ReaderRepository {
    public List<Reader> findAll();
    public void add(Reader reader);
    public boolean isRegisteredReader(Reader reader);
    public boolean isDebtor(Reader reader);
    public void lendBook(List<String> books,Reader reader);
    public double acceptBook(List<String> book);
    public List<Book> findBooksByReader(Reader reader);
}
