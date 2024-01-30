package com.workintech.library;

import com.workintech.library.enums.ReaderStatus;

import java.text.Collator;
import java.time.LocalDate;
import java.util.Locale;

public class Bill implements Comparable<Bill> {
    private LocalDate date;
    private int ID;
    private String bookname;
    private ReaderStatus readerStatus;
    private double price;
    private double VAT;


    public Bill(int ID, String bookname, ReaderStatus readerStatus, double price,LocalDate date) {
        this.ID = ID;
        this.bookname = bookname;
        this.readerStatus = readerStatus;
        this.price = price;
        this.date=date;
    }

    public void billPrinter(){
        System.out.println("*****************");
        System.out.println("---FATURA---");
        System.out.println("Tarih:" + date);
        System.out.println("ID :" + ID);
        System.out.println("Kitap İsmi:" + bookname);
        System.out.println("Okuyucu Tipi:" + readerStatus);
        System.out.println("KDV:" + VAT);
        System.out.println("Toplam Fiyat:" + price);
        System.out.println("******************");
    }

    @Override
    public String toString() {
        return "Bill{" +
                "date=" + date +
                ", ID=" + ID +
                ", bookname='" + bookname + '\'' +
                ", readerStatus=" + readerStatus +
                ", price=" + price +
                ", VAT=" + VAT +
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
