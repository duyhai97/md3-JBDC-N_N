package model;

public class Book {
    private int id;
    private String name;
    private String category;
    private int price;
    private Author author;

    public Book(int id, String name, String category, int price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public Book() {

    }

    public Book(String name, String cat, int price) {
        this.name = name;
        this.category = cat;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public Book(int id, String name, String category, int price, Author author) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.author = author;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
