package com.example.library.dbcontrollers;

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
}
