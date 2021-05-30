package service.authorjdbc;

import model.Author;
import service.connection.ConnectionJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorJDBC implements AuthorInterface {

    Connection connection = ConnectionJDBC.getConnect();


    @Override
    public List<Author> selectAll() {
        List<Author> authorList = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("select  * from author");
            ResultSet set = statement.executeQuery();
            while (set.next()){
                int id = set.getInt("id");
                String name = set.getString("name");
                Author author = new Author(id,name);
                authorList.add(author);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return authorList;
    }

    @Override
    public Author selectById(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void create(Author author) {
        try {
            PreparedStatement statement = connection.prepareStatement("insert book (name ,category,price) values " +
                    "?,?,?");
            ResultSet set = statement.executeQuery();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void update(int id, Author author) {

    }
}
