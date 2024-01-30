package com.workintech.library;

import com.workintech.library.persons.Reader;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<Long, Reader> readers;
    private Map<Long,Book> books;

    public Library() {
        this.readers = new HashMap<>();
        this.books = new HashMap<>();
    }

    public Map<Long, Reader> getReaders() {
        return readers;
    }

    public void setReaders(Map<Long, Reader> readers) {
        this.readers = readers;
    }

    public Map<Long, Book> getBooks() {
        return books;
    }

    public void setBooks(Map<Long, Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Library{" +
                "readers=" + readers +
                ", books=" + books +
                '}';
    }
}
