package ua.com.alevel.manager;

import com.google.gson.Gson;
import ua.com.alevel.empty.Author;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorManager {
    private static final String AUTHORS_FILE = "authors.json";
    private static final Gson gson = new Gson();

    private final List<Author> authors;

    public AuthorManager() {
        this.authors = new ArrayList<>();

    }

    public void addAuthor(Author author) {
        authors.add(author);
        saveAuthors();
    }


    private void saveAuthors() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(AUTHORS_FILE))) {
            for (Author author : authors) {
                String json = gson.toJson(author);
                writer.write(json);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Author getAuthorById(int authorId) {
        for (Author author : authors) {
            if (author.id() == authorId) {
                return author;
            }
        }
        return null;
    }


}
