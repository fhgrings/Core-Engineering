import com.github.erguerra.core_eng.tema_5_biblioteca.models.Library;
import com.github.erguerra.core_eng.tema_5_biblioteca.models.Book;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class LibraryTests {

    @Test
    public void registerBookTest(){
        Library library = new Library();
        Assert.assertEquals(true, library.registerBook("Bible", "God"));
    }

    @Test
    public void showAllBooksTest(){
        Library library = new Library();
        library.setNextId(0);

        library.registerBook("Bible", "God");
        library.registerBook("Tora", "God");
        Assert.assertEquals("0 Bible God available\n1 Tora God available\n", library.showAllBooks());
    }

    @Test
    public void searchBooksByAuthorTest(){
        Library library = new Library();
        library.setNextId(0);

        library.registerBook("Bible", "God");
        library.registerBook("Tora", "God");
        Assert.assertEquals("0 Bible God available\n1 Tora God available\n", library.showSpecificBooks(library.searchBookByAuthor("God")));
    }
    @Test
    public void searchBooksByTitleTest(){
        Library library = new Library();
        library.setNextId(0);

        library.registerBook("Bible", "God");
        library.registerBook("Tora", "God");
        Assert.assertEquals("0 Bible God available\n", library.showSpecificBooks(library.searchBookByTitle("Bible")));
    }

    @Test
    public void removeBookByIdTest(){
        Library library = new Library();
        library.setNextId(0);

        library.registerBook("Bible", "God");
        library.registerBook("Tora", "God");
        library.removeBookById("1");
        Assert.assertEquals("0 Bible God available\n", library.showSpecificBooks(library.searchBookByAuthor("God")));
    }


}
