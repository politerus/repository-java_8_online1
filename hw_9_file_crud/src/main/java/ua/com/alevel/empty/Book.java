package ua.com.alevel.empty;

import java.util.List;

public class Book {
    private final int bookId;
    private final String title;
    private final List<Author> authors;

    public Book(int bookId, String title, List<Author> authors) {
        this.bookId = bookId;
        this.title = title;
        this.authors = authors;
    }

    public int getBookId() {
        return bookId;
    }


    public List<Author> getAuthors() {
        return authors;
    }

    @Override
    public String toString() {
        return title;
    }
}



