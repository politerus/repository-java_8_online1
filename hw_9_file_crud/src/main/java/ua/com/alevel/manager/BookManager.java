package ua.com.alevel.manager;

import com.google.gson.Gson;
import ua.com.alevel.empty.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private static final String BOOKS_FILE = "books.json";
    private static final Gson gson = new Gson();

    private final List<Book> books;

    public BookManager() {
        this.books = new ArrayList<>();
        loadBooks();
    }

    public void addBook(Book book) {
        books.add(book);
        saveBooks();
    }

    public void deleteBook(int bookId) {
        Book bookToDelete = null;
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                bookToDelete = book;
                break;
            }
        }

        if (bookToDelete != null) {
            books.remove(bookToDelete);
            saveBooks();
        }
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    private void loadBooks() {
        try (BufferedReader reader = new BufferedReader(new FileReader(BOOKS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Book book = gson.fromJson(line, Book.class);
                books.add(book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveBooks() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BOOKS_FILE))) {
            for (Book book : books) {
                String json = gson.toJson(book);
                writer.write(json);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Book getBookById(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
    }
}
