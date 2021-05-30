package service.authorjdbc;

import model.Author;
import model.Book;

import java.util.List;

public interface AuthorInterface {

    List<Author> selectAll();

    Author selectById(int id);

    void delete(int id);

    void create(Author author);

    void update(int id, Author author);
}
