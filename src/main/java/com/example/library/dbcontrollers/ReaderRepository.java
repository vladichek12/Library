package com.example.library.dbcontrollers;

import com.example.library.classes.Reader;

import java.util.List;

public interface ReaderRepository {
    public List<Reader> findAll();
    public void add(Reader reader);
}
