package com.example.library;

import com.example.library.classes.Book;
import com.example.library.classes.Reader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ReaderRegistrationServlet", value = "/reader-registration_servlet")
public class ReaderRegistrationServlet extends HttpServlet {
    private Reader reader = new Reader();

    public void init() {
        //занести инфу про читателя
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("reader",reader);
        request.getServletContext().getRequestDispatcher("/readerRegistration.jsp").forward(request,response);
    }

    public void destroy() {
    }

}
