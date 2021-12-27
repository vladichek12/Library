package com.example.library;


import com.example.library.classes.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookAcceptanceServlet", value = "/book-acceptance_servlet")
public class BookAcceptanceServlet {
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
