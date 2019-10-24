package pl.bartlomiejpietrzyk.library;


public class Book {
    private static int count = 0;
    private final Integer id = ++count;
    private final String title;
    private final String author;
    private final Integer year;
    private String lentBy = "";

    public Book(Builder builder) {
        this.title = builder.title;
        this.author = builder.author;
        this.year = builder.year;
    }

    static class Builder {
        private String title = null;
        private String author = null;
        private Integer year = null;

        Builder title(String title) {
            this.title = title;
            return this;
        }

        Builder author(String author) {
            this.author = author;
            return this;
        }

        Builder year(Integer year) {
            this.year = year;
            return this;
        }

        Book build() {
            Book book = new Book(this);
            return book;
        }
    }

    Integer getId() {
        return id;
    }

    String getTitle() {
        return title;
    }

    String getAuthor() {
        return author;
    }

    Integer getYear() {
        return year;
    }

    String getLentBy() {
        return lentBy;
    }

    void setLentBy(String lentBy) {
        this.lentBy = lentBy;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", lent by='" + lentBy + '\'' +
                '}';
    }
}
