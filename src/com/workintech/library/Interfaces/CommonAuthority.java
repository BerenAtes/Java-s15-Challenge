package com.workintech.library.Interfaces;

import com.workintech.library.Book;

import java.util.List;
import java.util.Set;

public interface CommonAuthority  {
    boolean login(String inputPassword , long inputSchoolNumber);
    List<Book> searchByTitle(String title);
    Set<Book> searchByAuthor(long id);
    List<Book> searchByISBN(String ISBN);
    List<Book> searchByCategory(String category);
}
