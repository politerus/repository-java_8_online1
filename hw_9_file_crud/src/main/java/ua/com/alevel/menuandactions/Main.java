package ua.com.alevel.menuandactions;

import ua.com.alevel.empty.Author;
import ua.com.alevel.empty.Book;
import ua.com.alevel.manager.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static BookManager bookManager;
    private static AuthorManager authorManager;
    private static Scanner scanner;

    public static void main() {
        bookManager = new BookManager();
        authorManager = new AuthorManager();
        scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Додати автора");
            System.out.println("2. Додати книгу");
            System.out.println("3. Показати всі книги та їх авторів");
            System.out.println("4. Видалити автора з книги");
            System.out.println("5. Видалити книгу");
            System.out.println("6. Вийти");

            System.out.print("Виберіть опцію: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addAuthor();
                    break;
                case 2:
                    addBook();
                    break;
                case 3:
                    showAllBooks();
                    break;
                case 4:
                    removeAuthorFromBook();
                    break;
                case 5:
                    deleteBook();
                    break;
                case 6:
                    System.out.println(" Допобачення! ");
                    System.exit(0);
            }
        }
    }

    private static void addBook() {
        System.out.print("Введіть назву книги: ");
        scanner.nextLine();
        String title = scanner.nextLine();

        List<Integer> authorIds = new ArrayList<>();

        while (true) {
            System.out.print("Введіть ідентифікатор автора (або введіть 0 для завершення): ");
            int authorId = scanner.nextInt();
            scanner.nextLine();

            if (authorId == 0) {
                break;
            }

            authorIds.add(authorId);
        }


        if (authorIds.isEmpty()) {
            System.out.println("Не було введено жодного ID автора.");
            return;
        }

        List<Author> authors = new ArrayList<>();
        for (int authorId : authorIds) {
            Author author = authorManager.getAuthorById(authorId);
            if (author == null) {
                System.out.println("Автор з ID " + authorId + " не знайдений. Пропускається.");
            } else {
                authors.add(author);
            }
        }

        int bookId = generateBookId();
        Book book = new Book(bookId, title, authors);
        bookManager.addBook(book);
        System.out.println("Книга додана успішно.");
    }
    private static void deleteBook() {
        System.out.print("Введіть ID книги: ");
        int bookId = scanner.nextInt();

        bookManager.deleteBook(bookId);
        System.out.println("Книга видалена успішно.");
    }

    private static void showAllBooks() {
        List<Book> books = bookManager.getAllBooks();
        if (books.isEmpty()) {
            System.out.println("Немає доступних книг.");
        } else {
            System.out.println("Список книг:");
            for (Book book : books) {
                List<Author> authors = book.getAuthors();
                if (authors != null) {
                    StringBuilder authorNames = new StringBuilder();
                    for (Author author : authors) {
                        authorNames.append(author.name()).append(", ");
                    }
                    if (!authorNames.isEmpty()) {
                        authorNames.delete(authorNames.length() - 2, authorNames.length()); // Remove trailing comma and space
                    }
                    System.out.println("ID: " + book.getBookId() + ", Title: " + book + ", Authors: " + authorNames);
                }
            }
        }
    }

    private static int generateBookId() {
        List<Book> books = bookManager.getAllBooks();
        int maxId = 0;
        for (Book book : books) {
            if (book.getBookId() > maxId) {
                maxId = book.getBookId();
            }
        }
        return maxId + 1;
    }
    private static void addAuthor() {
        System.out.print("Введіть ID автора: ");
        int id = scanner.nextInt();
        System.out.print("Введіть ім'я автора: ");
        scanner.nextLine();

        String name = scanner.nextLine();

        Author author = new Author(id, name);
        authorManager.addAuthor(author);
        System.out.println("Автор доданий успішно."+ author);
    }

    private static void removeAuthorFromBook() {
        System.out.print("Введіть ID книги: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();

        Book book = bookManager.getBookById(bookId);
        if (book == null) {
            System.out.println("Книги з таким  ID " + bookId + " не знайдено.");
            return;
        }

        System.out.print("Введіть ID автора, щоб видалити його з книги: ");
        int authorId = scanner.nextInt();
        scanner.nextLine();

        List<Author> authors = book.getAuthors();
        boolean authorRemoved = false;

        for (int i = 0; i < authors.size(); i++) {
            Author author = authors.get(i);
            if (author.id() == authorId) {
                authors.remove(i);
                authorRemoved = true;
                break;
            }
        }

        if (authorRemoved) {
            System.out.println("Автора успішно вилучено з книги.");
        } else {
            System.out.println("Авторf з ID " + authorId + " не знайдено у списку авторів книги.");
        }
    }
}