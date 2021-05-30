package controller;

import model.Author;
import model.Book;
import service.authorjdbc.AuthorInterface;
import service.authorjdbc.AuthorJDBC;
import service.bookjdbc.BookInterface;
import service.bookjdbc.BookJDBC;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "servletBook", urlPatterns = "/book")
public class servletBook extends HttpServlet {
    AuthorInterface author = new AuthorJDBC();
    BookInterface book = new BookJDBC();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "";
        switch (action){
            case "createBook":
                showFormCreate(request,response);
                break;
            case "updateBook":
                showFormUpdate(request,response);
                break;
            case "deleteBook":
                showFormDelete(request,response);
                break;

        }
    }

    private void showFormDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Book book = this.book.selectById(id);
        request.setAttribute("book",book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("book/deleteBook.jsp");
        dispatcher.forward(request,response);

    }

    private void showFormUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Book book = this.book.selectById(id);
        List<Author> authorList = this.author.selectAll();
        request.setAttribute("book", book);
        request.setAttribute("authorList", authorList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("book/updateBook.jsp");
        dispatcher.forward(request,response);

    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("book/createBook.jsp");
        List<Author> authorList = this.author.selectAll();
        request.setAttribute("authorList",authorList);
        dispatcher.forward(request,response);


    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "";
        switch (action){
            case "create":
                createBook(request,response);
                break;
            case "updateBook":
                updateBook(request,response);
                break;
            case "deleteBook":
                deleteBook(request,response);
                break;
        }

    }

    private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        this.book.delete(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("book/deleteBook.jsp");
        request.setAttribute("message","success to delete");
        dispatcher.forward(request,response);
    }

    private void updateBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        String name = request.getParameter("name");
        String cat = request.getParameter("category");
        int price = Integer.parseInt(request.getParameter("price"));
        Book book = new Book(id,name,cat,price);

        String [] authorListString =request.getParameterValues("authorId");
        int [] authorListInt = new int[authorListString.length];
        for (int i = 0; i < authorListString.length; i++) {
            authorListInt[i] = Integer.parseInt(authorListString[i]);
        }

        this.book.update(id,book,authorListInt);
        RequestDispatcher dispatcher = request.getRequestDispatcher("book/updateBook.jsp");
        request.setAttribute("message","Success to create");
        dispatcher.forward(request,response);


    }

    private void createBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String cat = request.getParameter("category");
        int price = Integer.parseInt(request.getParameter("price"));

        String[] authorString = request.getParameterValues("listAuthor");
        int [] authorList = new int[authorString.length];
        for (int i = 0; i < authorString.length; i++) {
            authorList[i] = Integer.parseInt(authorString[i]);
        }
        Book book = new Book(name,cat,price);
        this.book.create(book,authorList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("book/createBook.jsp");
        request.setAttribute("message","Success to create");
        dispatcher.forward(request,response);

    }
}
