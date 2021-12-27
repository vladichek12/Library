package com.example.library.classes;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Book {
    private String russianName;
    private String originalName;
    private List<String> genres;
    private double price;
    private int numberOfCopies;
    private List<Author> authors;
    private String coverPhoto;
    private double pricePerDay;
    private Date registrationDate;

    public Book() {
        this.russianName = null;
        this.originalName = null;
        this.genres = null;
        this.price = 0;
        this.numberOfCopies = 0;
        this.authors = null;
        this.coverPhoto = null;
        this.pricePerDay = 0;
        this.registrationDate = null;
    }

    public Book(String russianName, String originalName, List<String> genres, double price, int numberOfCopies, List<Author> authors, String coverPhoto, double pricePerDay, Date registrationDate) {
        this.russianName = russianName;
        this.originalName = originalName;
        this.genres = genres;
        this.price = price;
        this.numberOfCopies = numberOfCopies;
        this.authors = authors;
        this.coverPhoto = coverPhoto;
        this.pricePerDay = pricePerDay;
        this.registrationDate = registrationDate;
    }

    public String getRussianName() {
        return russianName;
    }

    public void setRussianName(String russianName) {
        this.russianName = russianName;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public String getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(String coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Double.compare(book.price, price) == 0 && numberOfCopies == book.numberOfCopies && Double.compare(book.pricePerDay, pricePerDay) == 0 && russianName.equals(book.russianName) && originalName.equals(book.originalName) && genres.equals(book.genres) && authors.equals(book.authors) && coverPhoto.equals(book.coverPhoto) && registrationDate.equals(book.registrationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(russianName, originalName, genres, price, numberOfCopies, authors, coverPhoto, pricePerDay, registrationDate);
    }

    @Override
    public String toString() {
        return "Book{" +
                "russianName='" + russianName + '\'' +
                ", originalName='" + originalName + '\'' +
                ", genres=" + genres +
                ", price=" + price +
                ", numberOfCopies=" + numberOfCopies +
                ", authors=" + authors +
                ", coverPhoto='" + coverPhoto + '\'' +
                ", pricePerDay=" + pricePerDay +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
