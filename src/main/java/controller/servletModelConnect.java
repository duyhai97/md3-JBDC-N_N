package controller;

import model.Author;
import model.Book;
import model.ModelConnection;
import service.authorjdbc.AuthorInterface;
import service.authorjdbc.AuthorJDBC;
import service.bookjdbc.BookInterface;
import service.bookjdbc.BookJDBC;
import service.modelconnectjdbc.ModelConnectInterface;
import service.modelconnectjdbc.ModelConnectJDBC;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "servletModelConnect", urlPatterns = "/connectmodel")
public class servletModelConnect extends HttpServlet {
    AuthorInterface author = new AuthorJDBC();
    BookInterface book = new BookJDBC();
    ModelConnectInterface modelConnect = new ModelConnectJDBC();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "";
        switch (action){
            case "":
                showAllBook(request,response);
                break;
            case "create":
                showFormCreate(request,response);
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        Book book = new Book();
        List<Author> authorList = this.author.selectAll();

    }

    private void showAllBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("connectmodel/listconnect.jsp");
        List<ModelConnection> modelConnectionList = this.modelConnect.selectAll();
        request.setAttribute("modelConnectionList",modelConnectionList);
        dispatcher.forward(request,response);



    }








    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
