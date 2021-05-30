package service.bookjdbc;

import model.Book;

import java.util.List;

public interface BookInterface {
    List<Book> selectAll();

    Book selectById(int id);

    void delete(int id);

    void create(Book book, int[] author);

    void update(int id, Book book, int[] author);


}
