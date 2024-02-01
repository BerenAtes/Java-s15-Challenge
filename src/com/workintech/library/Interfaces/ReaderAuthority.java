package com.workintech.library.Interfaces;

public interface ReaderAuthority {
    void borrow(String book);
    void returnBook(String returnedBook,boolean isDamaged);

    boolean login(String inputName,String inputSurname,String inputEmail,double inputTCKN, String inputPassword);

}
