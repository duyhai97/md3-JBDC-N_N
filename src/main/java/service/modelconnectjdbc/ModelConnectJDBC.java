package service.modelconnectjdbc;

import model.Author;
import model.Book;
import model.ModelConnection;
import service.connection.ConnectionJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModelConnectJDBC implements ModelConnectInterface{

    Connection connection = ConnectionJDBC.getConnect();

    @Override
    public List<ModelConnection> selectAll() {

        List<ModelConnection> modelConnectionList = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("select b.id,b.name,category,price,a.id as author_id,a.name as name_author from connect\n" +
                    "join author a on a.id = connect.id_author\n" +
                    "join book b on b.id = connect.id_book");
            ResultSet set = statement.executeQuery();
            while (set.next()){
                int id_book = set.getInt("id");
                String name_book = set.getString("name");
                String category = set.getString("category");
                int price = set.getInt("price");
                Book book = new Book(id_book,name_book,category,price);
                int id_author = set.getInt("author_id");
                String name_author = set.getString("name_author");
                Author author = new Author(id_author,name_author);
                ModelConnection modelConnection = new ModelConnection(book,author);
                modelConnectionList.add(modelConnection);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return modelConnectionList;
    }

    @Override
    public ModelConnection selectById(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void create(ModelConnection modelConnection) {
    }

    @Override
    public void update(int id, ModelConnection modelConnection) {

    }
}
