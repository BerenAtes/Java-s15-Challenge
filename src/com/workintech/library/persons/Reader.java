package com.workintech.library.persons;

import com.sun.java.accessibility.util.AccessibilityListenerList;
import com.workintech.library.Bill;
import com.workintech.library.Book;
import com.workintech.library.Interfaces.CommonAuthority;
import com.workintech.library.Interfaces.ReaderAuthority;
import com.workintech.library.Library;
import com.workintech.library.enums.BookStatus;
import com.workintech.library.enums.PersonRoles;


import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Reader extends Person implements ReaderAuthority, CommonAuthority {
    private String id;

    private String password;
    private List<Book> borrowedBooks;
    private double money;

    private List<Bill> bills;
    private Library library;

    public Reader(String name, String surname, String email, double TCKN, String password, double money, Library library) {
        super(name, surname, email, TCKN);
        this.password = password;
        this.money = money;
        this.library = library;
        this.borrowedBooks = new LinkedList<>();
        this.bills = new LinkedList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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



    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public boolean login(String inputName, String inputSurname,String inputEmail,double inputTCKN, String inputPassword ) {
        if(password.equals(inputPassword) && inputTCKN == getTCKN() && inputEmail== getEmail()  ){
            System.out.println("Sistemimize Hoşgeldin " + inputName + " " + inputSurname);
            return true;
        }
        System.out.println("Hatalı giriş denemesi.Lütfen tekrar deneyiniz.");
        return false;
    }

    public boolean searchBook(String bookName) {
        if (library == null) {
            System.out.println("Hata: Kütüphane bulunamadı.");
            return false;
        }

        for (Book book : library.getBooks().values()) {
            if (book.getName().equalsIgnoreCase(bookName)) {
                System.out.println("Aradığınız kitap sistemimizde bulunmuştur: "  + book.getID() + "- " + book.getName() + "  (" + book.getAuthor() + ")" + "  Stock:" + book.getStock());
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




    public Library getLibrary() {
        return library;
    }

    @Override
    public void borrow(String requestBook) {
        //Bir reader en fazla 5 kitap alabilir.
        if (borrowedBooks.size() >= 5) {
            System.out.println("En fazla 5 kitap kiralayabilirsiniz.");
            return;
        }

        //Kitap zaten ödünç alınmış mı?
        for (Book borrowedBook : borrowedBooks) {
            if (requestBook.equalsIgnoreCase(borrowedBook.getName())) {
                System.out.println(requestBook + " kitabını daha önce zaten ödünç aldınız.");
                return;
            }
        }

        // Kitap kütüphanede mevcut mu ve stokta var mı?
        for (Book book : library.getBooks().values()) {
            if (requestBook.equalsIgnoreCase(book.getName()) && book.getStock() > 0) {

                // Kitap durumu "NOT_AVAILABLE" ise ödünç alınmasına izin verme
                if (book.getBookStatus() == BookStatus.DAMAGED) {
                    System.out.println(requestBook + " kitabı şu anda ödünç alınamaz.");
                    return;
                }

                double bookPrice = book.getPrice();

                //Yeterli bakiye var mı?
                if (this.getMoney() >= bookPrice) {
                    borrowedBooks.add(book);
                    book.setStock(book.getStock() - 1);
                    this.setMoney(this.getMoney() - bookPrice);

                    Bill bill = new Bill(LocalDate.now(), book.getID(), book.getName(), book.getBookStatus(), book.getPrice());
                    bills.add(bill);

                    if (book.getBookStatus() == BookStatus.DAMAGED) {
                        System.out.println("Son " + requestBook + " kitabi alinmistir. Bakiyenizden " + bookPrice + " TL düşüldü.");
                        bill.billPrinter();
                    } else {
                        System.out.println(requestBook + " kitabınız alınmıştır. Bakiyenizden " + bookPrice + " TL düşüldü.");
                        bill.billPrinter();
                    }
                    return;
                } else {
                    System.out.println("Yetersiz bakiye. Kitabı ödünç almak için bakiyenizi yükleyin.");
                    return;
                }
            }
        }

        // Kitap stokta yoksa veya kütüphanede bulunmuyorsa
        System.out.println(requestBook + " kitabı stoklarda bulunmamaktadır.");
    }



    public void displayBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println("Ödünç alınan kitap bulunmamaktadır.");
            return;
        }

        System.out.println("Ödünç alınan kitaplar:");
        for (Book book : borrowedBooks) {
            System.out.println("- " + book.getName());
        }
    }


    public void returnBook(String returnedBook, boolean isDamaged) {
        for (Book book : borrowedBooks) {
            if (book.getName().equalsIgnoreCase(returnedBook)) {
                borrowedBooks.remove(book);

                // İade işlemi
                book.setStock(book.getStock() + 1);

                // Hasar durumuna göre ücret iadesi ve not bastırma
                if (isDamaged) {
                    System.out.println(returnedBook + " kitabınız hasarlı iade edildi. Ücret iadesi yapılmayacak.");
                    return;
                } else {
                    double refundedAmount = book.getPrice() / 1.50;
                    this.setMoney(this.getMoney() + refundedAmount);
                    System.out.println(returnedBook + " kitabınız başarıyla iade edildi. Ücret iadesi yapıldı: " + refundedAmount + " TL");
                    return;
                }
            }
        }
        System.out.println("Bu kitap ödünç alınmamış ya da hatalı bir kitap ismi girdiniz.");
    }



}
