package com.example.library;

import com.example.library.classes.Book;

import java.io.*;
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

    public void destroy() {
    }
}