import com.workintech.library.Book;
import com.workintech.library.Library;
import com.workintech.library.enums.BookStatus;
import com.workintech.library.enums.Category;
import com.workintech.library.persons.Librarian;

public class Main {
    public static void main(String[] args) {
        System.out.println("Kütüphanemize hoşgeldiniz!");

        //Kitaplar oluşturuldu.
        Book book1=new Book(1,"Mehmet Rauf","Eylül",35, BookStatus.AVAILABLE,2, Category.NOVEL);
        Book book2=new Book(2,"Kemal Tahir","Devlet Ana",42, BookStatus.AVAILABLE,6, Category.HISTORY);
        Book book3=new Book(3,"Oğuz Atay","Bir Bilim Adamının Kitabı",50, BookStatus.AVAILABLE,14, Category.BIOGRAPHY);
        Book book4=new Book(4,"Ahmet Mehmet","Şafağın Çocuğu",20, BookStatus.NOT_AVAILABLE,0, Category.BIOGRAPHY);



        //Kütüphane oluşturuldu ve kitaplar kütüphaneye eklendi.
        Library library=new Library();
        library.getBooks().put(book1.getID(), book1);
        library.getBooks().put(book2.getID(), book2);
        library.getBooks().put(book3.getID(), book3);

        System.out.println("Kütüphanede bulunan kitaplar:" +library.getBooks());

        Librarian librarian = new Librarian("Leyla", library);
        librarian.addBook(book1);
        librarian.addBook(book1);
        librarian.addBook(book2);
        librarian.addBook(book4);
        System.out.println("Kütüphanede bulunan kitaplar:" +library.getBooks());




    }
}