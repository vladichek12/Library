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
        String query = "select id from readers where email =  " + "'" +reader.getEmail() + "'";
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
        List<Long> ids = new ArrayList<>();
        List<Integer> numberOfCopies = new ArrayList<>();
        String query = "select * from books";
        Statement statement  = worker.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()){
            for(String book : books){//найти книги которые выдать юзеру
                if((resultSet.getLong(1)) == Long.parseLong(book)&& resultSet.getInt(5)>0) {
                    ids.add(resultSet.getLong(1));
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
            updatePreparedStatement.setLong(2,ids.get(i));
            updatePreparedStatement.setInt(1,numberOfCopies.get(i)-1);
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
           for(Long i :ids){
               preparedStatement1.setLong(1, i + readerId);
               preparedStatement1.setLong(2,i);
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
    public double acceptBook(List<String> books) {
        DBWorker worker = new DBWorker();
        double sumToPay = 0;
        double pricePerDay = 0;
        int fine = 0;
        double discount = 0;
        Date date = null;
        LocalDate buf = LocalDate.now();
        Date currentDate = Date.valueOf(buf);

        String query3 = "update books set numberofcopies = ? where id = ?";
        String query4 = "update bookcopies set delete = true where bookid = ?";
        try {
            for(String id : books) {
                String query1 = "select * from bookcopies where bookid = " + id;
                String query2 = "select * from books where id = " + id;
                Statement statement1 = worker.getConnection().createStatement();
                Statement statement2 = worker.getConnection().createStatement();
                ResultSet resultSet1 = statement1.executeQuery(query1);
                ResultSet resultSet2 = statement2.executeQuery(query2);
                if(resultSet1.next()) {
                    discount = resultSet1.getDouble(6);
                    date = resultSet1.getDate(7);
                }
                if(resultSet2.next()) {
                    pricePerDay = resultSet2.getDouble(7);
                }
                if((date.getTime()>currentDate.getTime())) {
                    sumToPay += discount * (pricePerDay * (currentDate.getTime() - Date.valueOf(date.toLocalDate().minusMonths(1)).getTime())/(24 * 60 * 60 * 1000));
                }
                else
                    sumToPay+= discount * (pricePerDay*30)+ 0.01*(currentDate.getTime()-date.getTime())/(24 * 60 * 60 * 1000);

                int numberOfCopies = resultSet2.getInt(5);
                PreparedStatement preparedStatement3 = worker.getConnection().prepareStatement(query3);
                preparedStatement3.setInt(1,numberOfCopies+1);
                preparedStatement3.setLong(2,Long.parseLong(id));
                PreparedStatement preparedStatement4 = worker.getConnection().prepareStatement(query4);
                preparedStatement4.setLong(1,Long.parseLong(id));
                preparedStatement3.executeUpdate();
                preparedStatement4.executeUpdate();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sumToPay;

    }

    @Override
    public List<Book> findBooksByReader(Reader reader) {
        DBWorker worker = new DBWorker();
        int readerId = 0;
        String query2 = "select id from readers where email = " + "'" +reader.getEmail() + "'";
        try {
            Statement statement2 = worker.getConnection().createStatement();
            ResultSet resultSet2 = statement2.executeQuery(query2);
            if(resultSet2.next())
                readerId = resultSet2.getInt(1);


            String query = "select * from books inner join bookcopies on books.id = bookcopies.bookid and bookcopies.readerid = "
                    + String.valueOf(readerId) + " and bookcopies.delete = false" ;
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            List<Book> result = new ArrayList<>();
            while (resultSet.next()){
                Book book = new Book();
                book.setId(resultSet.getLong(1));
                book.setRussianName(resultSet.getString(2));
                book.setOriginalName(resultSet.getString(3));
                book.setPrice(resultSet.getDouble(4));
                book.setNumberOfCopies(resultSet.getInt(5));
                book.setCoverPhoto(resultSet.getString(6));
                book.setPricePerDay(resultSet.getDouble(7));
                book.setRegistrationDate(LocalDate.parse(resultSet.getString(8)));
                result.add(book);
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
