package com.example.library.dbcontrollers;

import com.example.library.classes.Book;
import com.example.library.classes.Reader;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.Objects.hash;

public class DbReaderRepository implements ReaderRepository{
    @Override
    public List<Reader> findAll() {
        List<Reader> readers = new ArrayList<>();
        DBWorker worker = new DBWorker();
        String query = "select * from readers";
        try {
            Statement statement  = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Reader reader = new Reader();
                reader.setSurname(resultSet.getString(2));
                reader.setName(resultSet.getString(3));
                reader.setBirthday((LocalDate.parse(resultSet.getString(4))));
                reader.setEmail(resultSet.getString(5));
                reader.setAddress(resultSet.getString(6));
                readers.add(reader);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return readers;
    }

    @Override
    public void add(Reader reader) {
        Random random = new Random();
        DBWorker worker = new DBWorker();
        String query = "insert into readers (id,surname,name,birthday,email,address) values(?,?,?,?,?,?)";
        try {
            PreparedStatement statement = worker.getConnection().prepareStatement(query);
            statement.setInt(1, hash(reader)/100);
            statement.setString(2, reader.getSurname());
            statement.setString(3, reader.getName());
            statement.setDate(4, Date.valueOf((reader.getBirthday())));
            statement.setString(5, reader.getEmail());
            statement.setString(6,reader.getAddress());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public boolean isRegisteredReader(Reader reader) {
        List<Reader> readers= findAll();
        for(Reader tempReader : readers){
            if(reader.equals(tempReader))
                return true;
        }
        return false;
    }

    @Override
    public boolean isDebtor(Reader reader) {
        DBWorker worker = new DBWorker();
        String query = "select id from readers where email = ?";
        try {
            PreparedStatement preparedStatement = worker.getConnection().prepareStatement(query);
            preparedStatement.setString(1, reader.getEmail());
            ResultSet resultSet = preparedStatement.getResultSet();
            int readerId = resultSet.getInt(1);
            query = "select * from bookcopies where readerid = ?";
            preparedStatement = worker.getConnection().prepareStatement(query);
            preparedStatement.setInt(1,readerId);
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return true;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void lendBook(List<String> books,Reader reader) {
        Double discountSize = 1.;
        if(books.size()>2){
            discountSize = 0.9;
        }
        else if(books.size()>5){
            discountSize= 0.85;
        }
        DBWorker worker = new DBWorker();
        try {
        List<Integer> ids = new ArrayList<>();
        List<Integer> numberOfCopies = new ArrayList<>();
        String query = "select * from books";
        Statement statement  = worker.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()){
            for(String book : books){//найти книги которые выдать юзеру
                if((resultSet.getLong(1)) == Long.parseLong(book)&& resultSet.getInt(5)>0) {
                    ids.add(resultSet.getInt(1));
                    numberOfCopies.add(resultSet.getInt(5));
                }
            }
        }
      /*  for(int i = 0;i < numberOfCopies.size();i++){
            int a = numberOfCopies.get(i);
            a--;
            numberOfCopies.add(i,a);
            numberOfCopies[i]--;
        }*/
        String updateQuery = "update books set numberOfCopies = ? where id = ?";
        PreparedStatement updatePreparedStatement = worker.getConnection().prepareStatement(updateQuery);
        for(int i = 0;i < ids.size();i++){
            updatePreparedStatement.setInt(1,ids.get(i));
            updatePreparedStatement.setInt(2,numberOfCopies.get(i)-1);
            updatePreparedStatement.executeUpdate();
        }


        //найти ридера
            int readerId = 0;
            String query2 = "select * from readers";
            Statement statement2  = worker.getConnection().createStatement();
            ResultSet resultSet2 = statement2.executeQuery(query2);
           while (resultSet2.next()){
               if(resultSet2.getString(5).equals(reader.getEmail()))
               readerId = resultSet2.getInt(1);
           }

        //записать что книги выданы
            LocalDate date = LocalDate.now().plusMonths(1);

            String query1 = "insert into bookCopies(id,bookid,readerid,condition,discountSize,returnDate) values (?,?,?,1,?,?)";
            PreparedStatement preparedStatement1 = worker.getConnection().prepareStatement(query1);
           for(int i :ids){
               preparedStatement1.setInt(1, i + readerId);
               preparedStatement1.setInt(2,i);
               preparedStatement1.setInt(3,readerId);
               preparedStatement1.setDouble(4,discountSize);
               preparedStatement1.setDate(5, Date.valueOf(date));
               preparedStatement1.executeUpdate();
           }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void acceptBook(Book book) {

    }
}
