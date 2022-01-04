package com.example.library;

import com.example.library.classes.Book;
import com.example.library.dbcontrollers.BookRepository;
import com.example.library.dbcontrollers.DbBookRepository;

import java.io.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "BookRegistrationServlet", value = "/book-registration_servlet")
public class BookRegistrationServlet extends HttpServlet {
    private Book book;

    public void init() {
       book = new Book();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       request.setAttribute("book",book);
       request.getServletContext().getRequestDispatcher("/bookRegistration.jsp").forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String buf = request.getParameter("russianName");
        byte bytes[] = buf.getBytes("ISO-8859-1");
        String value = new String(bytes,"UTF-8");
        book.setRussianName(value);
       // book.setRussianName(request.getParameter("russianName"));
        book.setOriginalName(request.getParameter("originalName"));
        LocalDate date = LocalDate.now();
        book.setRegistrationDate(date);
        book.setPrice(Double.parseDouble(request.getParameter("price")));
        book.setPricePerDay(Double.parseDouble(request.getParameter("pricePerDay")));
        book.setCoverPhoto(request.getParameter("coverPhoto"));
        book.setNumberOfCopies(Integer.parseInt(request.getParameter("numberOfCopies")));
        book.setAuthors(request.getParameter("authors"));
        book.setGenres(Arrays.asList(request.getParameterValues("genres")));
        BookRepository repository = new DbBookRepository();
        repository.add(book);
        request.setAttribute("book",book);
        request.getServletContext().getRequestDispatcher("/bookRegistration.jsp").forward(request,response);
    }

    public void destroy() {
    }
}