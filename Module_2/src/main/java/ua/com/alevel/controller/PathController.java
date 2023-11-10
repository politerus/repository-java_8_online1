package ua.com.alevel.controller;

import ua.com.alevel.service.PathService;

import java.util.Scanner;

public class PathController {
    private final PathService pathService;

    public PathController(PathService pathService) {
        this.pathService = pathService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. View list of cities");
            System.out.println("2. Calculate shortest path between two cities");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    pathService.displayCities();
                    break;
                case 2:
                    pathService.calculateAndDisplayShortestPath(scanner);
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}