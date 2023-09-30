package ua.com.alevel;

import java.util.Scanner;

public class Start extends FileHelper{
    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("File Helper Menu:");
            System.out.println("1. List files and folders");
            System.out.println("2. Create file or folder");
            System.out.println("3. Delete file or folder");
            System.out.println("4. Move folder to  folder");
            System.out.println("5. Move file to folder");
            System.out.println("6. Search for file or folder");
            System.out.println("7. Search text in files");
            System.out.println("8. Navigate to folder");
            System.out.println("9. Navigate back");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    listFilesAndFolders();
                    break;
                case 2:
                    createFileOrFolder(scanner);
                    break;
                case 3:
                    deleteFileOrFolder(scanner);
                    break;
                case 4:
                    moveFileOrFolder(scanner);
                    break;
                case 5:
                    moveFileToFolder(scanner);
                    break;
                case 6:
                    searchFileOrFolder(scanner);
                    break;
                case 7:
                    searchTextInFiles(scanner);
                    break;
                case 8:
                    navigateToFolder(scanner);
                    break;
                case 9:
                    navigateBack();
                    break;
                case 10:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("File Helper exited.");
    }

}
