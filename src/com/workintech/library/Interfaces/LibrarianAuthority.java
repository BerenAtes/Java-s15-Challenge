package com.workintech.library.Interfaces;

import com.workintech.library.Book;
import com.workintech.library.enums.BookStatus;

public interface LibrarianAuthority {

    void addBook(Book book );
    void deleteBook(Integer ID);
    void updateBook(int ID, String author, String name,double price, BookStatus bookStatus,int edition,String dateOfPurchase);
}
