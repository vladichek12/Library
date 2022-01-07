package com.example.library;

import com.example.library.classes.Book;
import com.example.library.classes.Reader;
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
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "BookLendingServlet", value = "/book-lending_servlet")
public class BookLendingServlet extends HttpServlet {
    private List<Book> lendingBooks;

    public void init() {
        //извлечь инфу про книги
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        BookRepository repository = new DbBookRepository();
        lendingBooks = repository.findAll();
        request.setAttribute("lendingBooks",lendingBooks);
        request.getServletContext().getRequestDispatcher("/bookLending.jsp").forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ReaderRepository repository= new DbReaderRepository();
        Reader reader = new Reader();
        reader.setName(request.getParameter("name"));
        reader.setSurname(request.getParameter("surname"));
        reader.setEmail(request.getParameter("email"));
        reader.setAddress(request.getParameter("address"));
        reader.setBirthday(LocalDate.parse(request.getParameter("birthday")));
        if(!repository.isRegisteredReader(reader)){
            repository.add(reader);
        }
        else{
            if(repository.isDebtor(reader)){
                //ne vidat knigu
            }
            else{
                //vidacha knig


            }
        }

    }

    public void destroy() {
    }
}
