package com.example.library;

import com.example.library.classes.Book;
import com.example.library.dbcontrollers.BookRepository;
import com.example.library.dbcontrollers.DbBookRepository;
import com.example.library.dbcontrollers.DbReaderRepository;
import com.example.library.dbcontrollers.ReaderRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "BookReturn", value = "/book-return")
public class BookReturnServlet extends HttpServlet {

    public void init() {
        //извлечь инфу про книги
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<String> books = Arrays.asList(request.getParameterValues("booksItems"));
        ReaderRepository repository = new DbReaderRepository();
        Double sumToPay = repository.acceptBook(books);
        request.setAttribute("sum",sumToPay);
        request.getServletContext().getRequestDispatcher("/payMessage.jsp").forward(request,response);
    }


    public void destroy() {
    }
}
