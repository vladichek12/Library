package com.example.library;

import com.example.library.classes.Book;
import com.example.library.dbcontrollers.DbBookRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookListServlet", value = "/book-list_servlet")
public class BookListServlet extends HttpServlet {
    private List<Book> books;
    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        DbBookRepository repository = new DbBookRepository();
        books = repository.findAll();
        request.setAttribute("books",books);
        request.getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("books",books);
        request.getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
    }

    public void destroy() {
    }
}
