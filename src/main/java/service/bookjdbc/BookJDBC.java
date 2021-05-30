package service.bookjdbc;

import model.Book;
import service.connection.ConnectionJDBC;

import java.sql.*;
import java.util.List;

public class BookJDBC implements BookInterface{

    public static final String INSERT_NEW_BOOK = "insert book (name ,category,price)" +
            "value (?,?,?)";
    public static final String INSERT_NEW_BOOK_AUTHOR = "insert connect (id_book, id_author) value " +
            "(? ,?)";
    public static final String SELECT_BOOK_BY_ID = "select  * from book where id = ?";
    public static final String UPDATE_BOOK_BY_ID = "update book set name = ?, category =  ?, price = ? " +
            "where id = ?";
    public static final String UPDATE_BOOK_AUTHOR_BY_ID = "update connect set id_book = ?, id_author = ? where id_book = ?";
    public static final String DELETE_BOOK = "delete from book where id = ?";
    public static final String DELETE_BOOK_AUTHOR = "delete from connect where id_book = ?";

    Connection connection = ConnectionJDBC.getConnect();



    @Override
    public List<Book> selectAll() {
        return null;
    }

    @Override
    public Book selectById(int id) {
        Book book = null;
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_BOOK_BY_ID);
            statement.setInt(1,id);
            ResultSet set = statement.executeQuery();
            while (set.next()){
                String name = set.getString("name");
                String cat = set.getString("category");
                int price = set.getInt("price");
                book = new Book(id,name,cat,price);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return book;
    }

    @Override
    public void delete(int id) {
        PreparedStatement statement = null;
        try {
            PreparedStatement statement1 = connection.prepareStatement(DELETE_BOOK_AUTHOR);
            statement1.setInt(1,id);
            statement1.executeUpdate();


            statement = connection.prepareStatement(DELETE_BOOK);
            statement.setInt(1,id);
            final int i = statement.executeUpdate();
            System.out.println(i);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void create(Book book , int[] author)  {
        int book_id = 0;

        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_NEW_BOOK, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,book.getName());
            statement.setString(2,book.getCategory());
            statement.setInt(3,book.getPrice());

            int rowAffected = statement.executeUpdate();

            ResultSet set = statement.getGeneratedKeys();

           while (set.next()){
               book_id = set.getInt(1);
           }

                PreparedStatement statement1 = connection.prepareStatement(INSERT_NEW_BOOK_AUTHOR);
                for ( int id_author : author
                     ) {
                    statement1.setInt(1,book_id);
                    statement1.setInt(2,id_author);
                    statement1.executeUpdate();
                }



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    @Override
    public void update(int id, Book book, int[] author) {
        System.out.println(id);
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_BOOK_BY_ID);
            statement.setInt(4,id);
            statement.setString(1,book.getName());
            statement.setString(2,book.getCategory());
            statement.setInt(3,book.getPrice());

            final int i = statement.executeUpdate();
            System.out.println(i);

            PreparedStatement statement1 = connection.prepareStatement(UPDATE_BOOK_AUTHOR_BY_ID);
            statement1.setInt(3,id);
            for (int id_author: author
                 ) {
                statement1.setInt(1,id);
                statement1.setInt(2,id_author);
                statement1.executeUpdate();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
