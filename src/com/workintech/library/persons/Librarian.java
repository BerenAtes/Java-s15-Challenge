package com.workintech.library.persons;

import com.workintech.library.Book;
import com.workintech.library.Interfaces.CommonAuthority;
import com.workintech.library.Interfaces.LibrarianAuthority;
import com.workintech.library.Library;
import com.workintech.library.enums.BookStatus;
import com.workintech.library.enums.Category;
import com.workintech.library.enums.PersonRoles;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

public class Librarian extends Person implements LibrarianAuthority, CommonAuthority {
    private Library library;

    public Librarian(String name, String surname, PersonRoles personRoles, double TCKN) {
        super(name, surname, personRoles, TCKN);
    }
    public Librarian(String name,Library library){
        super(name);
        this.library=library;
    }


    @Override
    public void addBook(Book book) {
        if (book.getStock() == 0 && book.getBookStatus() == BookStatus.DAMAGED) {
            book.setBookStatus(BookStatus.NOT_DAMAGED);
        }

        if (library.getBooks().containsKey(book.getID())) {
            // ID'ye sahip bir kitap zaten var, güncelleme yap
            updateBook(book, book.getID(), book.getAuthor(), book.getName(), book.getPrice(),
                    book.getBookStatus(), book.getStock(), book.getCategory());
        } else {
            // ID'ye sahip bir kitap yok, ekle
            book.setStock(book.getStock() + 1);
            TreeMap<Long, Book> sortedBooks = new TreeMap<>(library.getBooks());
            sortedBooks.put(book.getID(), book);
            library.setBooks(sortedBooks);

            System.out.println("Kitap başarıyla eklenmiştir:" + book.getName());
        }
    }


    @Override
    public void deleteBook(Long ID) {
        Iterator<Book> iterator = library.getBooks().values().iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getID() == ID) {
                iterator.remove();
                System.out.println("Bu kitap sistemimizden kaldırılmıştır: " + book.getID() + "-" + book.getName());
                return;
            }
        }
        System.out.println("Sistemimizde bu kitap bulunmamaktadır.");
    }

    @Override
    public void updateBook(Book book, Long ID, String author, String name, double price, BookStatus bookStatus, int stock, Category category) {
        if (searchBook(book.getName())) {
            // Mevcut kitabın ID'sini değiştirmemek için eski ID'yi sakla
            Long oldID = book.getID();

            // Güncelleme işlemleri
            book.setStock(stock);
            book.setBookStatus(bookStatus);
            book.setName(name);
            book.setID(ID);
            book.setAuthor(author);
            book.setPrice(price);
            book.setCategory(category);

            // Mevcut kitabın ID'sini değiştir
            library.getBooks().remove(oldID);
            library.getBooks().put(book.getID(), book);
        }
    }

    @Override
    public boolean searchBook(String bookName) {
        for (Book book:library.getBooks().values()){
            if (book.getName().equalsIgnoreCase(bookName)){
                System.out.println("Aradığınız kitap sistemimizde bulunmuştur: " + book.getID() + "- " + book.getName() + "  (" + book.getAuthor() + ")" + "  Stock:" + book.getStock());
                return true;
            }
        }
        System.out.println("Aradığınız kitap sistemimizde bulunmamaktadır.");
        return false;
    }

    @Override
    public boolean searchBook(Long ID) {
        for (Book book : library.getBooks().values()) {
            if (book.getID() == ID) {
                System.out.println("Aradığınız kitap sistemimizde bulunmuştur: " + book.getID() + "- " + book.getName() + "  (" + book.getAuthor() + ")" + "  Stock:" + book.getStock());
                return true;
            }
        }
        System.out.println("Aradığınız kitap sistemimizde bulunmamaktadır.");
        return false;
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "library=" + library +
                '}';
    }
}



