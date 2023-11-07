/*package ua.com.alevel.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainService {
    private final File file = new File("input.txt");

    public void startMainService() {
        if (checkIfFileExist()) {
            System.out.println("file exist");
        } else {
            System.out.println("doesn't exist");
            createDefaultFile();
        }
    }

    private boolean checkIfFileExist() {
        boolean checker = false;
        if (file.exists() && file.isFile()) {
            checker = true;
        }

        return checker;
    }

    private void createDefaultFile() {
        boolean result = false;
        try {
            result = file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (result) {
            System.out.println("File was created");
            defaultInputFileWriter();
        }
    }

    private void defaultInputFileWriter() {
        try (FileWriter fileWriter = new FileWriter(file, false)) {
            fileWriter.write("13\n");
            fileWriter.write("Kyiv\n3\n");
            fileWriter.write("Kharkiv 10\n");
            fileWriter.write("Lviv 4\n");
            fileWriter.write("Odesa 7\n");
            fileWriter.write("Kharkiv\n4\n");
            fileWriter.write("Kyiv 10\n");
            fileWriter.write("Lviv 3\n");
            fileWriter.write("Odesa 5\n");
            fileWriter.write("Dnipro 8\n");
            fileWriter.write("Lviv\n5\n");
            fileWriter.write("Kyiv 4\n");
            fileWriter.write("Kharkiv 6\n");
            fileWriter.write("Odesa 10\n");
            fileWriter.write("Dnipro 7\n");
            fileWriter.write("Zaporizhia 11\n");
            fileWriter.write("Odesa\n3\n");
            fileWriter.write("Kyiv 11\n");
            fileWriter.write("Kharkiv 10\n");
            fileWriter.write("Lviv 5\n");
            fileWriter.write("Dnipro\n2\n");
            fileWriter.write("Kharkiv 8\n");
            fileWriter.write("Lviv 7\n");
            fileWriter.write("Zaporizhia\n4\n");
            fileWriter.write("Lviv 11\n");
            fileWriter.write("Kryvyi Rih 13\n");
            fileWriter.write("Kharkiv 12\n");
            fileWriter.write("Mykolaiv 15\n");
            fileWriter.write("Kryvyi Rih\n2\n");
            fileWriter.write("Zaporizhia 14\n");
            fileWriter.write("Kharkiv 13\n");
            fileWriter.write("Mykolaiv\n3\n");
            fileWriter.write("Zaporizhia 15\n");
            fileWriter.write("Kryvyi Rih 16\n");
            fileWriter.write("Kherson 18\n");
            fileWriter.write("Kherson\n2\n");
            fileWriter.write("Mykolaiv 18\n");
            fileWriter.write("Simferopol 20\n");
            fileWriter.write("Simferopol\n2\n");
            fileWriter.write("Kherson 20\n");
            fileWriter.write("Sevastopol 22\n");
            fileWriter.write("Sevastopol\n2\n");
            fileWriter.write("Simferopol 22\n");
            fileWriter.write("Yalta 24\n");
            fileWriter.write("Yalta\n1\n");
            fileWriter.write("Sevastopol 24\n");
            fileWriter.write("Kiev\n3\n");
            fileWriter.write("Poltava 26\n");
            fileWriter.write("Zhytomyr 28\n");
            fileWriter.write("Vinnitsa 30\n");
            fileWriter.write("Poltava\n3\n");
            fileWriter.write("Kiev 26\n");
            fileWriter.write("Kharkiv 27\n");
            fileWriter.write("Zhytomyr 29\n");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

 */
