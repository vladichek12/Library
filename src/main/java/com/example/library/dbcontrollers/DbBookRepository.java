package com.example.library.dbcontrollers;

import com.example.library.classes.Book;
import com.example.library.classes.Reader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DbBookRepository implements BookRepository{
    @Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        DBWorker worker = new DBWorker();
        String query = "select * from books";
        try {
            Statement statement  = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Book book = new Book();
                book.setRussianName(resultSet.getString(2));
                book.setOriginalName(resultSet.getString(3));
                book.setPrice(resultSet.getDouble(4));
                book.setNumberOfCopies(resultSet.getInt(5));
                book.setCoverPhoto(resultSet.getString(6));
                book.setPricePerDay(resultSet.getDouble(7));
                book.setRegistrationDate(resultSet.getDate(8));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public void add(Book book) {

    }

    @Override
    public void lendBook(Book book) {

    }

    @Override
    public void acceptBook(Book book) {

    }
}
