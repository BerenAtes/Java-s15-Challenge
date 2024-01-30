package com.workintech.library.persons;

import com.workintech.library.Book;
import com.workintech.library.Interfaces.CommonAuthority;
import com.workintech.library.Interfaces.LibrarianAuthority;
import com.workintech.library.Library;
import com.workintech.library.enums.BookStatus;
import com.workintech.library.enums.PersonRoles;

import java.util.Iterator;

public class Librarian extends Person implements LibrarianAuthority, CommonAuthority {
    private Library library;

    public Librarian(String name, String surname, String phoneNumber, String email, PersonRoles personRoles, double TCKN, Library library) {
        super(name, surname, phoneNumber, email, personRoles, TCKN);
        this.library = library;
    }

    public Librarian(String name, String surname, PersonRoles personRoles, double TCKN) {
        super(name, surname, personRoles, TCKN);
    }
    public Librarian(String name,Library library){
        super(name);
        this.library=library;
    }


    @Override
    public void addBook(Book book) {
        if (book.getStock()==0 && book.getBookStatus()== BookStatus.NOT_AVAILABLE){
            book.setBookStatus(BookStatus.AVAILABLE);
        }
        book.setStock(book.getStock() + 1);
        library.getBooks().put(book.getID(),book);
        System.out.println("Kitap başarıyla eklenmiştir:" + book.getName());

    }

    @Override
    public void deleteBook(Integer ID) {
        Iterator<Book> iterator = library.getBooks().values().iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getID() == ID) {
                iterator.remove();
                System.out.println("Bu kitap sistemimizden kaldırılmıştır: " + book.getName());
                return;
            }
        }
        System.out.println("Sistemimizde bu kitap bulunmamaktadır.");
    }

    @Override
    public void updateBook(Book book,int ID, String author, String name, double price, BookStatus bookStatus, int edition, String dateOfPurchase) {
        if (searchBook(book.getName())){
            book.setStock(book.getStock());
            book.setBookStatus(bookStatus);
            book.setName(name);
            book.setID(ID);
            book.setAuthor(author);
            book.setPrice(price);
            book.setCategory(book.getCategory());
        }
    }

    @Override
    public boolean searchBook(String bookName) {
        for (Book book:library.getBooks().values()){
            if (book.getName().equalsIgnoreCase(bookName)){
                System.out.println("Aradığınız kitap sistemimizde bulunmuştur: " + book.getName());
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



