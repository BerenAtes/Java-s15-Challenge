package com.workintech.library.Interfaces;

import com.workintech.library.Book;
import com.workintech.library.enums.BookStatus;
import com.workintech.library.enums.Category;

public interface LibrarianAuthority {

    void addBook(Book book );
    void deleteBook(Long ID);
    void updateBook(Book book, Long ID, String author, String name, double price, BookStatus bookStatus, int stock, Category category);
}
