package com.example.library.classes;

import java.util.Date;
import java.util.Objects;

public class Reader {
    private String surname;
    private String name;
    private Date birthday;
    private  String email;//unique
    private String address;

    public Reader() {
        this.surname = null;
        this.name = null;
        this.birthday = null;
        this.email = null;
        this.address = null;
    }

    public Reader(String surname, String name, Date birthday, String email, String address) {
        this.surname = surname;
        this.name = name;
        this.birthday = birthday;
        this.email = email;
        this.address = address;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reader reader = (Reader) o;
        return surname.equals(reader.surname) && name.equals(reader.name) &&
                birthday.equals(reader.birthday) && email.equals(reader.email) &&
                address.equals(reader.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name, birthday, email, address);
    }

    @Override
    public String toString() {
        return "Reader{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
