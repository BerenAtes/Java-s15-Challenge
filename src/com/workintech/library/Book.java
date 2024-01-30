package com.workintech.library;

import com.workintech.library.enums.BookStatus;
import com.workintech.library.enums.Category;

import java.util.Objects;

public class Book {
    private int ID;
    private String author;
    private String name;
    private double price;
    private BookStatus bookStatus;
    private int stock;
    private Category category;

    public Book(int ID, String author, String name, double price, BookStatus bookStatus, int stock, Category category) {
        this.ID = ID;
        this.author = author;
        this.name = name;
        this.price = price;
        this.bookStatus = bookStatus;
        this.stock = stock;
        this.category = category;
    }

    public long getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public BookStatus getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
        if (stock>0){
            this.bookStatus=BookStatus.AVAILABLE;
        } else {
            this.bookStatus=BookStatus.NOT_AVAILABLE;
        }
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return ID == book.ID && Objects.equals(name, book.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name);
    }

    @Override
    public String toString() {
        return "Book{" +
                "ID=" + ID +
                ", author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", bookStatus=" + bookStatus +
                ", stock=" + stock +
                ", category=" + category +
                '}';
    }
}
