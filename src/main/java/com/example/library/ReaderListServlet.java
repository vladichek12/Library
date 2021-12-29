package com.example.library;

import com.example.library.classes.Book;
import com.example.library.classes.Reader;
import com.example.library.dbcontrollers.DbReaderRepository;
import com.example.library.dbcontrollers.ReaderRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ReaderListServlet", value = "/reader-list_servlet")
public class ReaderListServlet extends HttpServlet {
    private List<Reader> readers;
    public void init() {
        ReaderRepository repository = new DbReaderRepository();
        readers = repository.findAll();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("readers",readers);
        request.getServletContext().getRequestDispatcher("/readerList.jsp").forward(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("readers",readers);
        request.getServletContext().getRequestDispatcher("/readerList.jsp").forward(request,response);
    }

    public void destroy() {
    }
}

