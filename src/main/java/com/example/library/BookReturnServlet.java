package com.example.library;

import com.example.library.classes.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookReturn", value = "/book-return")
public class BookReturnServlet extends HttpServlet {
    private List<Book> acceptanceBooks;

    public void init() {
        //извлечь инфу про книги
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("acceptanceBooks",acceptanceBooks);
        request.getServletContext().getRequestDispatcher("/BookAcceptance.jsp").forward(request,response);
    }

    public void destroy() {
    }
}
