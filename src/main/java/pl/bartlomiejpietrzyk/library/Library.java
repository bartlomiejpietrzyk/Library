package pl.bartlomiejpietrzyk.library;

import java.util.LinkedHashMap;
import java.util.Map;

public class Library {
    private Map<Integer, Book> allBooks = new LinkedHashMap<>();
    private Map<Integer, Book> lentBooks = new LinkedHashMap<>();
    private Map<Integer, Book> availableBooks = new LinkedHashMap<>();

    Map<Integer, Book> addBookToLibrary(Book book) throws IllegalArgumentException {
        if (!allBooks.containsKey(book)) {
            this.allBooks.put(book.getId(), book);
            this.availableBooks.put(book.getId(), book);
            System.out.println(new StringBuilder()
                    .append("New Book: ID: ")
                    .append(book.getId())
                    .append(", Title: \"")
                    .append(book.getTitle())
                    .append("\" written by ")
                    .append(book.getAuthor())
                    .append(" in ")
                    .append(book.getYear())
                    .append(" added to library!\n")
                    .append("--------------\n")
                    .append("List of all books: \n")
                    .append("--------------")
                    .toString());
            return this.allBooks;
        } else {
            throw new IllegalArgumentException("Book with specified ID already exist.");
        }
    }
}
