package service.modelconnectjdbc;

import model.Book;
import model.ModelConnection;

import java.util.List;

public interface ModelConnectInterface {
    List<ModelConnection> selectAll();

    ModelConnection selectById(int id);

    void delete(int id);

    void create(ModelConnection modelConnection);

    void update(int id, ModelConnection modelConnection);
}
