package com.workintech.library.Interfaces;

public interface ReaderAuthority {
    void borrow(String book);
    void returnBook(String returnedBook);

    boolean login(String inputPassword , double inputTCKN);

}
