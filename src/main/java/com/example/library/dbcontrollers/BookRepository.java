package com.example.library.dbcontrollers;

public interface BookRepository {
    public void findAll();
    public void add();
    public void lendBook();
    public void acceptBook();
}
