
    package ua.com.alevel.service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

    public class InputFileCreator {

        private static final String INPUT_FILE = "input.txt";

        public static void createInputFile() {
            String content =
                    "11\n" +
                    "Rubizne\n" +
                    "Kyiv\n" +
                    "Kharkiv\n" +
                    "Odesa\n" +
                    "Dnipro\n" +
                    "Lviv\n" +
                    "Poltava\n" +
                    "Mykolaiv\n" +
                    "Zaporizhzhia\n" +
                    "Ivano-Frankivsk\n" +
                    "Lutsk\n" +
                    "Kyiv\n" +
                    "3\n" +
                    "Kharkiv 20\n" +
                    "Lviv 50\n" +
                    "Odesa 10\n" +
                    "Kharkiv\n" +
                    "3\n" +
                    "Kyiv 20\n" +
                    "Dnipro 40\n" +
                    "Poltava 10\n" +
                    "Odesa\n" +
                    "2\n" +
                    "Kyiv 50\n" +
                    "Mykolaiv 60\n" +
                    "Dnipro\n" +
                    "3\n" +
                    "Kyiv 10\n" +
                    "Kharkiv 30\n" +
                    "Zaporizhzhia 20\n" +
                    "Lviv\n" +
                    "3\n" +
                    "Kyiv 50\n" +
                    "Ivano-Frankivsk 50\n" +
                    "Lutsk 30\n" +
                    "Poltava\n" +
                    "1\n" +
                    "Kharkiv 10\n" +
                    "Mykolaiv\n" +
                    "1\n" +
                    "Odesa 60\n" +
                    "Zaporizhzhia\n" +
                    "1\n" +
                    "Dnipro 20\n" +
                    "Ivano-Frankivsk\n" +
                    "1\n" +
                    "Lviv 50\n" +
                    "Lutsk\n" +
                    "1\n" +
                    "Lviv 30\n" +
                    "Rubizne\n" +
                    "1\n" +
                    "Lviv 30\n" +
                    "2\n" +
                    "Kyiv Lviv\n" +
                    "Odesa Kharkiv\n";

            try (PrintWriter out = new PrintWriter(new FileWriter(INPUT_FILE))) {
                out.print(content);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


