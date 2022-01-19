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
import java.util.List;

@WebServlet(name = "BookAcceptanceServlet", value = "/book-acceptance_servlet")
public class BookAcceptanceServlet extends HttpServlet {
    private ReaderRepository repository;

    public void init() {
        repository = new DbReaderRepository();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        Reader reader = new Reader();
        reader.setName(request.getParameter("name"));
        reader.setSurname(request.getParameter("surname"));
        reader.setEmail(request.getParameter("email"));
        reader.setAddress(request.getParameter("address"));
        reader.setBirthday(LocalDate.parse(request.getParameter("birthday")));
        if(repository.isRegisteredReader(reader)){
            List<Book> books = repository.findBooksByReader(reader);
            request.setAttribute("books",books);
            request.setAttribute("reader", reader);
            request.getServletContext().getRequestDispatcher("/bookReturn.jsp").forward(request,response);
        }
        else{
            //error message
        }
    }

    public void destroy() {
    }
}
