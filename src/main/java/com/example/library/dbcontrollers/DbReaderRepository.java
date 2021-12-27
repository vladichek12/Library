package com.example.library.dbcontrollers;

import com.example.library.classes.Reader;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
                reader.setBirthday(resultSet.getDate(4));
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
        DBWorker worker = new DBWorker();
        String query = "insert into readers (id,surname,name,birthday,email,address) values(?,?,?,?,?,?)";
        try {
            PreparedStatement statement = worker.getConnection().prepareStatement(query);
            statement.setString(2, reader.getSurname());
            statement.setString(3, reader.getName());
            statement.setDate(4, (Date) reader.getBirthday());
            statement.setString(5, reader.getEmail());
            statement.setString(6,reader.getAddress());
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
