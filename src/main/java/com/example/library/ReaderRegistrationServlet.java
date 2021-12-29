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
import java.time.LocalDate;
import java.util.Date;

@WebServlet(name = "ReaderRegistrationServlet", value = "/reader-registration_servlet")
public class ReaderRegistrationServlet extends HttpServlet {
    private Reader reader = new Reader();

    public void init() {
        //занести инфу про читателя
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       // request.setAttribute("reader",reader);
       // request.getServletContext().getRequestDispatcher("/readerRegistration.jsp").forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //request.setAttribute("reader",reader);
       // request.getServletContext().getRequestDispatcher("/readerRegistration.jsp").forward(request,response);
        //Date birthday = request.getParameter("birthday");
        reader.setName(request.getParameter("name"));
        reader.setSurname(request.getParameter("surname"));
        reader.setAddress(request.getParameter("address"));
        reader.setBirthday(LocalDate.parse(request.getParameter("birthday")));
        reader.setEmail(request.getParameter("email"));
        ReaderRepository repository = new DbReaderRepository();
        repository.add(reader);
        request.getServletContext().getRequestDispatcher("/readerRegistration.jsp").forward(request,response);


    }

    public void destroy() {
    }

}
