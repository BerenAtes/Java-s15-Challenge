import com.workintech.library.Book;
import com.workintech.library.Library;
import com.workintech.library.enums.BookStatus;
import com.workintech.library.enums.Category;
import com.workintech.library.persons.Librarian;
import com.workintech.library.persons.Reader;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Kütüphanemize hoşgeldiniz!");

        //Kitaplar oluşturuldu.
        Book book1=new Book(1L,"Mehmet Rauf","Eylül",35, BookStatus.NOT_DAMAGED,2, Category.NOVEL);
        Book book2=new Book(2L,"Kemal Tahir","Devlet Ana",30, BookStatus.NOT_DAMAGED,6, Category.HISTORY);
        Book book3=new Book(3L,"Oğuz Atay","Bir Bilim Adamının Kitabı",40, BookStatus.NOT_DAMAGED,14, Category.BIOGRAPHY);
        Book book4=new Book(4L,"Ahmet Mehmet","Şafağın Çocuğu",20, BookStatus.NOT_DAMAGED,0, Category.BIOGRAPHY);
        Book book5=new Book(5L,"Ayşe Özkan","Problemlerle Matematik",85, BookStatus.NOT_DAMAGED,0, Category.STUDYBOOKS);
        Book book6=new Book(6L,"Buse Deniz","Aslanın Doğuşu",60, BookStatus.NOT_DAMAGED,20, Category.FANTASY);
        Book book7=new Book(7L,"Cengiz Elbaş","Eski Çocuklar",15, BookStatus.NOT_DAMAGED,6, Category.NOVEL);
        Book book8=new Book(8L,"Ceren Gören","Türklük Terimleri",12, BookStatus.NOT_DAMAGED,0, Category.ENCYCLOPEDIA);
        Book book9=new Book(9L,"Elif Işık","Şahane Hayat",20, BookStatus.NOT_DAMAGED,12, Category.MAGAZINES);
        Book book10=new Book(10L,"Kerim Pekmez","Bilimin Şafağında",20, BookStatus.NOT_DAMAGED,3, Category.SCIENFIFIC);


        //Kütüphane oluşturuldu ve kitaplar kütüphaneye eklendi.
        Library library=new Library();

        library.getBooks().put(book3.getID(), book3);
        library.getBooks().put(book1.getID(), book1);
        library.getBooks().put(book2.getID(), book2);
        System.out.println("Kütüphanede bulunan kitaplar:" +library.getBooks());



        //Ekleme işlemleri
        Librarian librarian = new Librarian("Leyla", library);
        librarian.addBook(book1);
        librarian.addBook(book1);
        librarian.addBook(book2);
        librarian.addBook(book3);
        librarian.addBook(book4);
        librarian.addBook(book5);
        librarian.addBook(book6);
        librarian.addBook(book7);
        librarian.addBook(book8);
        librarian.addBook(book7);
        librarian.addBook(book8);
        librarian.addBook(book9);
        librarian.addBook(book10);

        //Bu kod yanyana çıktı veriyor.
        //System.out.println("Kütüphanede bulunan kitaplar:" +library.getBooks());



        //Kütüphaneyi gezerek kitap listesini alt alta listeleme.
        for (Book book : library.getBooks().values()) {
            System.out.println(book);
        }

        //Kitap ismine göre arama
        librarian.searchBook("Aslanın Doğuşu");
        librarian.searchBook("Devlet Ana");
        librarian.searchBook("DEVLET ANA");
        librarian.searchBook("Güneş Doğarken");

        //Kitap ID'sine göre arama
        librarian.searchBook(5L);
        librarian.searchBook(3L);
        librarian.searchBook(16L);


        //Kitabı Silme
        librarian.deleteBook(7L);
        librarian.deleteBook(1L);
        //Yeni Kitap Listesi
        for (Book book : library.getBooks().values()) {
            System.out.println(book);
        }

        //Güncelleme

        librarian.updateBook(book4,11L,"Ahmet Mehmet","Şafağın Çocuğu",50,BookStatus.NOT_DAMAGED,5,Category.BIOGRAPHY);
        for (Book book : library.getBooks().values()) {
            System.out.println(book);
        }


        //////////READER İŞLEMLERİ


        //Okuyucu oluşturuldu
        Reader reader1=new Reader("Beren","Ateş","beren@beren.com",123456789,"Beren123",200,library);

        Reader reader2=new Reader("Ahmet","Aslan","ahmet@ahmet.com",789456123,"Bursa16.",50,library);

        Reader reader3=new Reader("Mehmet","Güney","mehmet@mehmet.com",741852963,"741852963Mehmet",45,library);

        Reader reader4=new Reader("Sema","Ateş","sema@sema.com",369258147,"Sema6612",85,library);
        //LOGIN
        //Doğru Giriş
        reader1.login("Beren","Ateş","beren@beren.com",123456789,"Beren123");
        reader2.login("Ahmet","Aslan","ahmet@ahmet.com",789456123,"Bursa16.");
        reader3.login("Mehmet","Güney","mehmet@mehmet.com",741852963,"741852963Mehmet");
        reader4.login("Sema","Ateş","sema@sema.com",369258147,"Sema6612");

        //Hatalı Giriş
        reader1.login("Beren","Ateş","beren@beren.com",123456789,"Berren1234");
        //Kitap Arama
        //İsme Göre
        reader1.searchBook("Şahane Hayat");
        reader2.searchBook("Merhaba Hayat");
        //ID'ye göre
        reader1.searchBook(5L);
        reader1.searchBook(14L);


        //Kitap Ödünç Alma-Fatura basılıyor
        //En fazla 5 kitap alınıyor.-Alınan kitaptan 2.si alınamıyor. -Kitap alındığında stock azalıyor.
        reader1.borrow("Şahane Hayat");
        reader1.borrow("Devlet Ana");
        reader1.borrow("Türklük Terimleri");
        reader1.borrow("Aslanın Doğuşu");
        reader1.borrow("Bir Bilim Adamının Kitabı");
        reader1.borrow("Devlet Ana");

        reader1.displayBorrowedBooks();
        //Kalan Parayı gösterme
        System.out.println("Bakiye: " +reader1.getMoney());

       // for (Book book : library.getBooks().values()) {
          //  System.out.println(book);
       // }
        //Stockta bulunmama durumu
        reader2.borrow("Türklük Terimleri");
        reader2.borrow("Devlet Ana");
        reader2.borrow("Devlet Ana");
        reader2.displayBorrowedBooks();
        System.out.println("Bakiye: " +reader2.getMoney());
        for (Book book : library.getBooks().values()) {
            System.out.println(book);
        }




        //Geri verme
        //Kitap hasarlı ise ücret iadesi yok.Hasarlı değilse fiyat/1.50 iade edilir

        reader1.returnBook("Şahane Hayat",true);
        reader1.returnBook("Aslanın Doğuşu",false);

        reader1.displayBorrowedBooks();
        //Kalan Parayı gösterme
        System.out.println("Bakiye: " +reader1.getMoney());

        for (Book book : library.getBooks().values()) {
            System.out.println(book);
        }











    }
}