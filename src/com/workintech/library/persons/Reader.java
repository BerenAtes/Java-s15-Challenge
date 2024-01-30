package com.workintech.library.persons;

import com.sun.java.accessibility.util.AccessibilityListenerList;
import com.workintech.library.Bill;
import com.workintech.library.Book;
import com.workintech.library.Interfaces.CommonAuthority;
import com.workintech.library.Interfaces.ReaderAuthority;
import com.workintech.library.enums.PersonRoles;
import com.workintech.library.enums.ReaderStatus;

import java.util.List;
import java.util.Set;

public class Reader extends Person implements ReaderAuthority, CommonAuthority {
    private String id;
    private ReaderStatus readerStatus;
    private String password;
    private List<Book> borrowedBooks;
    private List<Bill> bills;


    public Reader(String name, String surname, String phoneNumber, String email, PersonRoles personRoles, double TCKN, String id, ReaderStatus readerStatus, String password, List<Book> borrowedBooks, List<Bill> bills) {
        super(name, surname, phoneNumber, email, personRoles, TCKN);
        this.id = id;
        this.readerStatus = readerStatus;
        this.password = password;
        this.borrowedBooks = borrowedBooks;
        this.bills = bills;
    }

    public Reader(String name, String surname, PersonRoles personRoles, double TCKN, String id, ReaderStatus readerStatus, String password) {
        super(name, surname, personRoles, TCKN);
        this.id = id;
        this.readerStatus = readerStatus;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ReaderStatus getReaderStatus() {
        return readerStatus;
    }

    public void setReaderStatus(ReaderStatus readerStatus) {
        this.readerStatus = readerStatus;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }




    @Override
    public boolean login(String inputPassword, double inputTCKN) {
        if(password.equals(inputPassword) && inputTCKN == getTCKN()  ){
            System.out.println("Sistemimize Hoşgeldin " + getName());
            return true;
        }
        System.out.println("Hatalı giriş denemesi.Lütfen tekrar deneyiniz.");
        return false;
    }


    @Override
    public void borrow(String book) {

    }

    @Override
    public void returnBook(String returnedBook) {

    }

    @Override
    public boolean searchBook(String bookName) {
        return false;
    }
}
