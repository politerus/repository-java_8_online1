package ua.com.alevel.service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class InputFileCreator {

    private static final String INPUT_FILE = "input.txt";

    public static void createInputFile() {
        String content = """
                10
                Kyiv
                Kharkiv
                Odesa
                Dnipro
                Lviv
                Poltava
                Mykolaiv
                Zaporizhzhia
                Ivano-Frankivsk
                Lutsk
                Kyiv
                3
                Kharkiv 20
                Lviv 50
                Odesa 10
                Kharkiv
                3
                Kyiv 20
                Dnipro 40
                Poltava 10
                Odesa
                2
                Kyiv 50
                Mykolaiv 60
                Dnipro
                3
                Kyiv 10
                Kharkiv 30
                Zaporizhzhia 20
                Lviv
                3
                Kyiv 50
                Ivano-Frankivsk 50
                Lutsk 30
                Poltava
                1
                Kharkiv 10
                Mykolaiv
                1
                Odesa 60
                Zaporizhzhia
                1
                Dnipro 20
                Ivano-Frankivsk
                1
                Lviv 50
                Lutsk
                1
                Lviv 30
                2
                Kyiv Lviv
                Odesa Kharkiv
                """;

        try (PrintWriter out = new PrintWriter(new FileWriter(INPUT_FILE))) {
            out.print(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}