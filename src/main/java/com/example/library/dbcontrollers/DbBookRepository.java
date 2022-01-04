package com.example.library.dbcontrollers;

import com.example.library.classes.Book;
import com.example.library.classes.Reader;

import javax.swing.*;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

import static java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE;
import static java.util.Objects.hash;



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
                book.setRegistrationDate(LocalDate.parse(resultSet.getString(8)));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public void add(Book book) {
        DBWorker worker = new DBWorker();


        try {


            //запись информации о книге
            String query = "insert into books (id,russianName,originalName,price,numberOfCopies,coverPhoto,priceperday,registrationdate) values(?,?,?,?,?,?,?,?)";
            PreparedStatement statement = worker.getConnection().prepareStatement(query);
            //statement.setInt(1,statement.g);
            statement.setInt(1, book.hashCode()/100);
            statement.setString(2, book.getRussianName());
            statement.setString(3, book.getOriginalName());
            statement.setDouble(4, book.getPrice());
            statement.setInt(5, book.getNumberOfCopies());
            statement.setString(6,book.getCoverPhoto());
            statement.setDouble(7,book.getPricePerDay());
            statement.setDate(8, Date.valueOf(book.getRegistrationDate()));
            statement.executeUpdate();


            List<String> bookAuthors = book.getAuthors();//проверка есть ли такие авторы в базе данных
            List<String> authors = new ArrayList<>(bookAuthors);
            List<Integer> ids = new ArrayList<>();
            String authorsSearchQuery = "select * from authors";
            Statement statement1 = worker.getConnection().createStatement(TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = statement1.executeQuery(authorsSearchQuery);
            for(int i = 0; i < authors.size();i++){
                resultSet.beforeFirst();
                while (resultSet.next()) {
                    if (authors.get(i).equals(resultSet.getString(2))) {
                        ids.add(resultSet.getInt(1));
                        authors.remove(i);
                        if(authors.size() == 0){
                            break;
                        }
                    }
                }
            }


            String queryAuthorBooks = "insert into booksauthors (id,bookid,authorid) values (?,?,?)";
            String authorsAddQuery = "insert into authors (id,name,surname) values (?,?,null)";//запись новых авторов
            PreparedStatement statement2 = worker.getConnection().prepareStatement(authorsAddQuery);
            PreparedStatement statement3 = worker.getConnection().prepareStatement(queryAuthorBooks);
            for(String author : authors){
                statement2.setInt(1, hash(author)/100);
                statement2.setString(2,author);
                statement3.setInt(1,book.hashCode()/100 + hash(author)/100);
                statement3.setInt(2,book.hashCode()/100);
                statement3.setInt(3,hash(author)/100);
                statement2.executeUpdate();
                statement3.executeUpdate();
                //authorId++;
                //bookAuthorId++;
            }
            for(Integer id : ids){
                statement3.setInt(1,book.hashCode()/100 + id);
                statement3.setInt(2,book.hashCode()/100);
                statement3.setInt(3,id);
                statement3.executeUpdate();
                //authorId++;
               // bookAuthorId++;
            }
            //statement2.executeUpdate();
           // statement3.executeUpdate();



            //связь книги с жанрами
            String retrieveGenresIdQuery = "select * from genres";
            ArrayList<Integer> genreIds = new ArrayList<>();
            Statement statement4 = worker.getConnection().createStatement();
            ResultSet resultSet4 = statement4.executeQuery(retrieveGenresIdQuery);
            while(resultSet4.next()){
                for(String genre : book.getGenres()){
                    if(genre.equals(resultSet4.getString(2))){
                        genreIds.add(resultSet4.getInt(1));
                    }
                }
            }
            String bookGenresQuery = "insert into booksgenres(id,bookid,genreid) values (?,?,?)";
            PreparedStatement statement5 = worker.getConnection().prepareStatement(bookGenresQuery);
            for(Integer id : genreIds){
                statement5.setInt(1,book.hashCode()/100 + id*13);
                statement5.setInt(2,book.hashCode()/100);
                statement5.setInt(3,id);
                statement5.executeUpdate();
            }



            //bookId++;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void lendBook(Book book) {

    }

    @Override
    public void acceptBook(Book book) {

    }
}
