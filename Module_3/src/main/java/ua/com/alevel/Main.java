package ua.com.alevel;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import ua.com.alevel.controller.AccountController;
import ua.com.alevel.controller.CategoryController;
import ua.com.alevel.controller.TransactionController;
import ua.com.alevel.controller.UserController;
import ua.com.alevel.dao.*;
import ua.com.alevel.entity.Account;
import ua.com.alevel.entity.Transaction;
import ua.com.alevel.entity.User;
import ua.com.alevel.service.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class Main {
    private static CsvExportService csvExportService;
    public static void main(String[] args) {
        // Создание EntityManagerFactory и EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("createEntityManagerFactory");



        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            // Створення DAO
            AccountDao accountDao = new AccountDaoImpl();
            CategoryDao categoryDao = new CategoryDaoImpl();
            TransactionDao transactionDao = new TransactionDaoImpl();
            UserDao userDao = new UserDaoImpl();

            // Створення сервісів
            AccountService accountService = new AccountService(accountDao);
            CategoryService categoryService = new CategoryService(categoryDao);
            TransactionService transactionService = new TransactionService(transactionDao);
            UserService userService = new UserService(userDao);

            // Створення контролерів з використанням сервісів
            AccountController accountController = new AccountController(accountService);
            CategoryController categoryController = new CategoryController(categoryService);
            TransactionController transactionController = new TransactionController(transactionService);
            UserController userController = new UserController( userService);

            String line;
            while (true) {
                System.out.println("Виберіть дію:");
                System.out.println("1. Створити користувача");
                System.out.println("2. Створити рахунок");
                System.out.println("3. Створити транзакцію");
                System.out.println("4. Експорт виписки в CSV");
                System.out.println("0. Вийти");

                line = reader.readLine();
                int choice = Integer.parseInt(line);

                switch (choice) {
                    case 1:
                        createUser(reader, userController);
                        break;
                    case 2:
                        createAccount(reader, accountController);
                        break;
                    case 3:
                        createTransaction(reader, transactionController);
                        break;
                    case 4:
                        exportTransactionsToCsv(reader, csvExportService);
                        break;
                    // Обробка інших випадків
                    case 0:
                        System.out.println("Вихід з програми");
                        return;
                    default:
                        System.out.println("Невідома команда");
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Введено некоректне значення, будь ласка, введіть число.");
        }
    }

    private static void createUser(BufferedReader reader, UserController userController) throws IOException {
        System.out.println("Введіть ім'я користувача:");
        String name = reader.readLine();
        User user = new User();
        user.setName(name);
        userController.createUser(user);
        System.out.println("Користувача створено.");
    }
    private static void createAccount(BufferedReader reader, AccountController accountController) throws IOException {
        System.out.println("Введите баланс аккаунта:");
        String balanceString = reader.readLine();
        Double balance = Double.parseDouble(balanceString);

        // Предположим, что для создания аккаунта нужен только баланс
        Account account = new Account();
        account.setBalance(balance);

        accountController.createAccount(account);
        System.out.println("Аккаунт создан.");
    }

    private static void createTransaction(BufferedReader reader, TransactionController transactionController) throws IOException {
        // Запросите данные от пользователя для создания транзакции
        System.out.println("Введите сумму транзакции:");
        Double amount = Double.parseDouble(reader.readLine());

        // Предположим, что для создания транзакции требуется только сумма
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);

        // Дополнительные данные, такие как дата, аккаунт и категория, должны быть заполнены здесь

        transactionController.createTransaction(transaction);
        System.out.println("Транзакция создана.");
        try {
            transactionController.createTransaction(transaction);
            System.out.println("Транзакция создана.");
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }

    }




    private static void exportTransactionsToCsv(BufferedReader reader, CsvExportService csvExportService) throws IOException {
        System.out.println("Введите ID аккаунта для экспорта транзакций:");
        Long accountId = Long.parseLong(reader.readLine());

        System.out.println("Введите начальную дату (формат YYYY-MM-DD):");
        LocalDate startDate = LocalDate.parse(reader.readLine());

        System.out.println("Введите конечную дату (формат YYYY-MM-DD):");
        LocalDate endDate = LocalDate.parse(reader.readLine());

        csvExportService.exportTransactionsToCsv(accountId, startDate, endDate);
        System.out.println("Экспорт завершен.");
    }


    public static void setCsvExportService(CsvExportService csvExportService) {
        Main.csvExportService = csvExportService;
    }
}
