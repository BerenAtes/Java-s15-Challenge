package com.workintech.library;

import com.workintech.library.enums.BookStatus;

import java.text.Collator;
import java.time.LocalDate;
import java.util.Locale;

public class Bill implements Comparable<Bill> {
    private LocalDate date;
    private Long ID;
    private String bookname;
    private BookStatus bookStatus;
    private double price;



    public Bill(LocalDate date, Long ID, String bookname, BookStatus bookStatus, double price) {
        this.date = date;
        this.ID = ID;
        this.bookname = bookname;
        this.bookStatus = bookStatus;
        this.price = price;
    }


    public void billPrinter(){
        System.out.println("*****************");
        System.out.println("---FATURA---");
        System.out.println("Tarih:" + date);
        System.out.println("ID :" + ID);
        System.out.println("Kitap İsmi:" + bookname);
        System.out.println("Kitap Tipi:" + bookStatus);
        System.out.println("Toplam Fiyat:" + price);
        System.out.println("******************");
    }

    @Override
    public String toString() {
        return "Bill{" +
                "date=" + date +
                ", ID=" + ID +
                ", bookname='" + bookname + '\'' +
                ", readerStatus=" + bookStatus +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Bill bill) {
        Collator collator = Collator.getInstance(new Locale("tr", "TR"));
        int nameComparison = collator.compare(this.bookname, bill.bookname);
        if (bill.date.isEqual(this.date)) {
            return nameComparison;
        }
        return bill.date.compareTo(this.date);
    }
}
