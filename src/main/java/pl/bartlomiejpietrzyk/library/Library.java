package pl.bartlomiejpietrzyk.library;

import java.util.LinkedHashMap;
import java.util.Map;

public class Library {
    private Map<Integer, Book> allBooks = new LinkedHashMap<>();
    private Map<Integer, Book> lentBooks = new LinkedHashMap<>();
    private Map<Integer, Book> availableBooks = new LinkedHashMap<>();

    Map<Integer, Book> addBookToLibrary(Book book) throws IllegalArgumentException {
        if (allBooks.containsKey(book)) {
            throw new IllegalArgumentException("Book with specified ID already exist.");
        } else {
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
        }
    }

    Map<Integer, Book> lendBook(Integer id, String name) throws IllegalArgumentException {
        if (!this.availableBooks.containsKey(id)) {
            throw new IllegalArgumentException("Book with specified ID is already lent!");
        } else if (!this.allBooks.containsKey(id)) {
            throw new IllegalArgumentException("Book with specified ID does not exist!");
        } else {
            Book book = this.allBooks.get(id);
            book.setLentBy(name);
            this.lentBooks.put(book.getId(), book);
            this.availableBooks.remove(id);
            System.out.println(new StringBuilder()
                    .append("Book: ")
                    .append(book.getTitle())
                    .append(" written by ")
                    .append(book.getAuthor())
                    .append(" in ")
                    .append(book.getYear())
                    .append(" lent from library by ")
                    .append(name)
                    .append("\n--------------\n")
                    .append("List of lent books: \n")
                    .append("--------------")
                    .toString());
            return this.lentBooks;
        }
    }

    Map<Integer, Book> returnBook(Integer id) throws IllegalArgumentException {
        if (this.availableBooks.containsKey(id)) {
            throw new IllegalArgumentException("Book with specified ID is available!");
        } else if (!this.allBooks.containsKey(id)) {
            throw new IllegalArgumentException("Book with specified ID doesn't exist.");
        } else {
            Book book = allBooks.get(id);
            book.setLentBy("");
            this.lentBooks.remove(id);
            this.availableBooks.put(book.getId(), book);
            System.out.println(new StringBuilder()
                    .append("Book: ")
                    .append(book.getTitle())
                    .append(" written by ")
                    .append(book.getAuthor())
                    .append(" in ")
                    .append(book.getYear())
                    .append(" returned to library!\n")
                    .append("\n--------------\n")
                    .append("List of available books: \n")
                    .append("--------------")
                    .toString());
            return this.availableBooks;
        }
    }
    Map<Integer, Book> removeBook(Integer id) throws IllegalArgumentException {
        if (!this.allBooks.containsKey(id)) {
            throw new IllegalArgumentException("Book with specified ID doesn't exist.");
        } else if (this.lentBooks.containsKey(id)) {
            throw new IllegalArgumentException("Can't remove, book is lent");
        } else {
            Book book = allBooks.get(id);
            this.allBooks.remove(id);
            this.lentBooks.remove(id);
            this.availableBooks.remove(id);
            System.out.println(new StringBuilder()
                    .append("Book ")
                    .append("ID: ")
                    .append(id)
                    .append(" \"")
                    .append(book.getTitle())
                    .append("\" successfully removed from library!")
                    .append("\n--------------\n")
                    .append("List of available books: \n")
                    .append("--------------")
                    .toString());
            return this.allBooks;
        }
    }

    String countBooksInLibrary() {
        return new StringBuilder()
                .append("--------------\nAll books in library: ")
                .append(this.allBooks.size())
                .append("\n--------------\nAvailable books in library: ")
                .append(this.availableBooks.size())
                .append("\n--------------\nLent books in library: ")
                .append(this.lentBooks.size())
                .append("\n--------------")
                .toString();
    }

    void listAllBooks() {
        System.out.println("---------------------\nList of All books:\n---------------------");
        this.allBooks.forEach((integer, book) -> System.out.println(book));
        System.out.println("---------------------\n");
    }

    void listAvailableBooks() {
        System.out.println("---------------------\nList of All available books:\n---------------------");
        this.availableBooks.forEach((integer, book) -> System.out.println(book));
        System.out.println("---------------------\n");
    }

    void listAllLentBooks() {
        System.out.println("---------------------\nList of All lent books:\n---------------------");
        this.lentBooks.forEach((integer, book) -> System.out.println(book));
        System.out.println("---------------------\n");
    }

}
