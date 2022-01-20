package com.example.library.classes;



import java.time.LocalDate;
import java.util.*;

public class Book {
    private static int count = 0;
    private long id;
    private String russianName;
    private String originalName;
    private List<String> genres;
    private double price;
    private int numberOfCopies;
    private List<String> authors;
    private String coverPhoto;
    private double pricePerDay;
    private LocalDate registrationDate;
    private int mark;

    public Book() {
        this.russianName = new String("windows-1251");
        this.originalName = null;
        this.genres = new ArrayList<>();
        this.price = 0;
        this.numberOfCopies = 0;
        this.authors = null;
        this.coverPhoto = null;
        this.pricePerDay = 0;
        this.registrationDate = null;
    }

    public Book(String russianName, String originalName, List<String> genres, double price, int numberOfCopies, List<String> authors, String coverPhoto, double pricePerDay, LocalDate registrationDate) {

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

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
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
        this.genres.addAll(genres);
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

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        if(authors.contains("\n")) {
            this.authors = Arrays.asList(authors.split("\r\n"));
        }
        else{
            this.authors = Collections.singletonList(authors);
        }
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

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
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
