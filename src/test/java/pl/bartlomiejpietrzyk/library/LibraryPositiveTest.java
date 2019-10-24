package pl.bartlomiejpietrzyk.library;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.stream.Collector;

import static org.junit.jupiter.api.Assertions.*;

class LibraryPositiveTest {

    @Test
    void should_add_book_to_library() {
        //given
        Library library = new Library();
        Book b = new Book.Builder()
                .build();
        //when
        library.addBookToLibrary(b);
        Map<Integer, Book> allBooks = library.getAllBooks();
        //then
        assertTrue(allBooks.containsValue(b));
    }

    @Test
    void should_lent_book_from_library() {
        //given
        Library library = new Library();
        Book b = new Book.Builder()
                .build();
        //when
        library.addBookToLibrary(b);
        library.lendBook(b.getId(), "TestUser");
        //then
        assertTrue(library.getLentBooks().containsValue(b));
        assertFalse(library.getAvailableBooks().containsValue(b));
    }

    @Test
    void should_return_book_to_library() {
        //given
        Library library = new Library();
        Book b = new Book.Builder()
                .build();
        //when
        library.addBookToLibrary(b);
        library.lendBook(b.getId(), "Test User");
        library.returnBook(b.getId());
        //then
        assertEquals(0, library.getLentBooks().size());
        assertEquals(1, library.getAvailableBooks().size());
        assertTrue(library.getAvailableBooks().containsValue(b));
        assertFalse(library.getLentBooks().containsValue(b));
    }

    @Test
    void should_remove_book_from_library() {
        //given
        Library library = new Library();
        Book b = new Book.Builder()
                .build();
        //when
        library.addBookToLibrary(b);
        library.removeBook(b.getId());
        //then
        assertEquals(0, library.getAllBooks().size());
        assertEquals(0, library.getLentBooks().size());
        assertEquals(0, library.getAvailableBooks().size());
        assertFalse(library.getAvailableBooks().containsValue(b));
        assertFalse(library.getLentBooks().containsValue(b));
        assertFalse(library.getAllBooks().containsValue(b));
    }

    @Test
    void should_count_books_in_library() {
        //given
        Library library = new Library();
        Book b = new Book.Builder()
                .build();
        Book b1 = new Book.Builder()
                .build();
        Book b2 = new Book.Builder()
                .build();
        //when
        library.addBookToLibrary(b);
        library.addBookToLibrary(b1);
        library.addBookToLibrary(b2);
        library.lendBook(b.getId(), "Test User");
        //then
        assertEquals(3, library.getAllBooks().size());
        assertEquals(2, library.getAvailableBooks().size());
        assertEquals(1, library.getLentBooks().size());
    }
}