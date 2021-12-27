package com.example.library;

import com.example.library.classes.Book;

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
        //извлечь инфу про книги
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("books",books);
        request.getServletContext().getRequestDispatcher("/bookList.jsp").forward(request,response);
    }

    public void destroy() {
    }
}
