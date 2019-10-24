package pl.bartlomiejpietrzyk.library;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class LibraryNegativeTest {

    @Test
    void should_not_lent_book_from_library() {
        //given
        Library library = new Library();
        Book b = new Book.Builder()
                .build();
        //when
        library.addBookToLibrary(b);
        library.lendBook(b.getId(), "Test User");
        //then
        assertThrows(IllegalArgumentException.class, () -> library.lendBook(1, "Test User1"));
    }

    @Test
    void should_not_return_book_to_library_when_available() {
        //given
        Library library = new Library();
        Book b = new Book.Builder()
                .build();
        //when
        library.addBookToLibrary(b);
        //then
        assertThrows(IllegalArgumentException.class, () -> library.returnBook(1));
    }

    @Test
    void should_not_return_book_to_library_when_do_not_exist() {
        //given
        Library library = new Library();
        //then
        assertThrows(IllegalArgumentException.class, () -> library.returnBook(1));
    }

    @Test
    void should_not_remove_book_from_library_when_lent() {
        //given
        Library library = new Library();
        Book b = new Book.Builder()
                .build();
        //when
        library.addBookToLibrary(b);
        library.lendBook(b.getId(), "Test User");
        //then
        assertThrows(IllegalArgumentException.class, () -> library.removeBook(1));
    }
}