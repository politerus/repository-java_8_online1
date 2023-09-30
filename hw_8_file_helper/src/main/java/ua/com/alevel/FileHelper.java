package ua.com.alevel;
import java.io.*;
import java.nio.file.*;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

public class FileHelper {
    private String currentDirectory;
    private final Stack<String> directoryHistory;

    public FileHelper() {
        String os = System.getProperty("os.name");
        String userHome = System.getProperty("user.home");
        currentDirectory = os.startsWith("Mac") ? userHome : userHome + File.separator;
        directoryHistory = new Stack<>();
        directoryHistory.push(currentDirectory);
    }
    void listFilesAndFolders() {
        try {
            Files.list(Paths.get(currentDirectory))
                    .forEach(path -> System.out.println(path.getFileName()));
        } catch (IOException e) {
            System.out.println("Error listing files and folders: " + e.getMessage());
        }
    }

    void createFileOrFolder(Scanner scanner) {
        System.out.print("Enter file/folder name: ");
        String name = scanner.nextLine();

        Path path = Paths.get(currentDirectory, name);

        try {
            if (name.contains(".")) {
                Files.createFile(path);
                System.out.println("File created: " + path);
            } else {
                Files.createDirectory(path);
                System.out.println("Folder created: " + path);
            }
        } catch (IOException e) {
            System.out.println("Error creating file/folder: " + e.getMessage());
        }
    }

    void deleteFileOrFolder(Scanner scanner) {
        System.out.print("Enter file/folder name: ");
        String name = scanner.nextLine();

        Path path = Paths.get(currentDirectory, name);

        try {
            if (Files.isDirectory(path)) {
                if (Files.list(path).findFirst().isPresent()) {
                    System.out.println("The folder is not empty. Deleting it will also delete its contents.");
                    System.out.print("Are you sure you want to delete it? (yes/no): ");
                    String confirmation = scanner.nextLine().trim().toLowerCase();
                    if (confirmation.equals("yes")) {
                        deleteDirectoryRecursively(path);
                        System.out.println("Folder and its contents deleted: " + path);
                    } else {
                        System.out.println("Deletion canceled.");
                    }
                } else {
                    Files.deleteIfExists(path);
                    System.out.println("Folder deleted: " + path);
                }
            } else {
                Files.deleteIfExists(path);
                System.out.println("File deleted: " + path);
            }
        } catch (IOException e) {
            System.out.println("Error deleting file/folder: " + e.getMessage());
        }
    }

    private void deleteDirectoryRecursively(Path directory) throws IOException {
        Files.walk(directory)
                .sorted(Comparator.reverseOrder())
                .map(Path::toFile)
                .forEach(File::delete);
    }

    void moveFileOrFolder(Scanner scanner) {
        System.out.print("Enter source path: ");
        String sourcePath = scanner.nextLine();
        System.out.print("Enter destination path: ");
        String destinationPath = scanner.nextLine();

        Path source = Paths.get(currentDirectory, sourcePath);
        Path destination = Paths.get(currentDirectory, destinationPath);

        try {
            if (Files.isDirectory(source) && Files.isDirectory(destination)) {
                destination = destination.resolve(source.getFileName());
                Files.move(source, destination, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Folder moved to: " + destination);
            } else {
                System.out.println("Both source and destination must be directories.");
            }
        } catch (IOException e) {
            System.out.println("Error moving folder: " + e.getMessage());
        }
    }
    void moveFileToFolder(Scanner scanner) {
        System.out.print("Enter file name to move: ");
        String fileName = scanner.nextLine();
        System.out.print("Enter destination folder name: ");
        String destinationFolderName = scanner.nextLine();

        Path source = Paths.get(currentDirectory, fileName);
        Path destination = Paths.get(currentDirectory, destinationFolderName);

        try {
            if (Files.exists(source) && Files.isDirectory(destination)) {
                destination = destination.resolve(fileName);
                Files.move(source, destination, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("File moved to: " + destination);
            } else {
                System.out.println("Source file not found or destination is not a directory.");
            }
        } catch (IOException e) {
            System.out.println("Error moving file: " + e.getMessage());
        }
    }

    void searchFileOrFolder(Scanner scanner) {
        System.out.print("Enter file/folder name to search for: ");
        String name = scanner.nextLine();

        try {
            Files.walk(Paths.get(currentDirectory))
                    .filter(path -> path.getFileName().toString().equals(name))
                    .forEach(path -> System.out.println("Found at: " + path));
        } catch (IOException e) {
            System.out.println("Error searching for file/folder: " + e.getMessage());
        }
    }

    void searchTextInFiles(Scanner scanner) {
        System.out.print("Enter text to search for: ");
        String searchText = scanner.nextLine();

        try {
            Files.walk(Paths.get(currentDirectory))
                    .filter(Files::isRegularFile)
                    .forEach(file -> {
                        try (BufferedReader reader = Files.newBufferedReader(file)) {
                            String line;
                            int lineNumber = 0;
                            while ((line = reader.readLine()) != null) {
                                lineNumber++;
                                if (line.contains(searchText)) {
                                    System.out.println("Found in file: " + file + " at line " + lineNumber);
                                }
                            }
                        } catch (IOException e) {
                            System.out.println("Error reading file: " + e.getMessage());
                        }
                    });
        } catch (IOException e) {
            System.out.println("Error searching for text: " + e.getMessage());
        }
    }

    void navigateToFolder(Scanner scanner) {
        System.out.print("Enter folder name to navigate to: ");
        String folderName = scanner.nextLine();

        Path newPath = Paths.get(currentDirectory, folderName);

        if (Files.isDirectory(newPath)) {
            directoryHistory.push(currentDirectory);
            currentDirectory = newPath.toString();
            System.out.println("Navigating to folder: " + newPath);
        } else {
            System.out.println("The specified folder does not exist.");
        }
    }

    void navigateBack() {
        if (!directoryHistory.isEmpty()) {
            String previousDirectory = directoryHistory.pop();
            currentDirectory = previousDirectory;
            System.out.println("Navigating back to: " + previousDirectory);
        } else {
            System.out.println("No previous directory to navigate to.");
        }
    }
}

