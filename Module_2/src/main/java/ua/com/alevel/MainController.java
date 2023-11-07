package ua.com.alevel;

import ua.com.alevel.entity.City;
import ua.com.alevel.entity.Neighbor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainController {
    private List<City> cities;

    public void start() {
        read();
        showMenu();
    }

    private void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Travel between cities");
            System.out.println("2. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    if (cities != null) {
                        travelBetweenCities(scanner);
                    }
                    break;
                case 2:
                    return; // Exit the program
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private void read() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));

            String line;
            int n = 0;

            if ((line = reader.readLine()) != null) {
                try {
                    n = Integer.parseInt(line);
                } catch (NumberFormatException e) {
                    System.err.println("Error: Invalid number of cities.");
                    return;
                }
            }

            cities = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String cityName = reader.readLine();
                if (cityName == null || cityName.trim().isEmpty()) {
                    System.err.println("Error: City name cannot be empty.");
                    return;
                }

                City city = new City(cityName);

                int p = 0;
                if ((line = reader.readLine()) != null) {
                    try {
                        p = Integer.parseInt(line);
                    } catch (NumberFormatException e) {
                        System.err.println("Error: Invalid number of neighbors for city " + cityName);
                        return;
                    }
                }

                for (int j = 0; j < p; j++) {
                    if ((line = reader.readLine()) != null) {
                        String[] neighborData = line.split(" ");
                        if (neighborData.length != 2) {
                            System.err.println("Error: Invalid neighbor data for city " + cityName);
                            return;
                        }

                        String neighborCityName = neighborData[0];
                        int cost = Integer.parseInt(neighborData[1]);
                        city.getNeighbors().add(new Neighbor(neighborCityName, cost));
                    } else {
                        System.err.println("Error: Insufficient neighbor data for city " + cityName);
                        return;
                    }
                }

                cities.add(city);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void travelBetweenCities(Scanner scanner) {
        System.out.println("Select a starting city:");
        for (int i = 0; i < cities.size(); i++) {
            System.out.println((i + 1) + ". " + cities.get(i).getName());
        }

        int startCityIndex = scanner.nextInt();
        if (startCityIndex < 1 || startCityIndex > cities.size()) {
            System.out.println("Invalid city selection.");
            return;
        }

        System.out.println("Select a destination city:");
        for (int i = 0; i < cities.size(); i++) {
            System.out.println((i + 1) + ". " + cities.get(i).getName());
        }

        int destinationCityIndex = scanner.nextInt();
        if (destinationCityIndex < 1 || destinationCityIndex > cities.size()) {
            System.out.println("Invalid city selection.");
            return;
        }

        String startCityName = cities.get(startCityIndex - 1).getName();
        String destinationCityName = cities.get(destinationCityIndex - 1).getName();

        List<String> path = new ArrayList<>();
        int minCost = findMinCost(startCityName, destinationCityName, path, 0);
        if (minCost == Integer.MAX_VALUE) {
            System.out.println("There is no route between the selected cities.");
        } else {
            System.out.println("Minimum cost to travel from " + startCityName + " to " + destinationCityName + ": " + minCost);
        }
    }

    private int findMinCost(String startCityName, String endCityName, List<String> path, int currentCost) {
        if (startCityName.equals(endCityName)) {
            System.out.println("Path: " + String.join(" -> ", path));
            return currentCost;
        }

        int minCost = Integer.MAX_VALUE;
        City startCity = findCityByName(startCityName);

        if (startCity != null) {
            for (Neighbor neighbor : startCity.getNeighbors()) {
                if (!path.contains(neighbor.getNeighborCityName())) {
                    path.add(neighbor.getNeighborCityName());
                    int cost = findMinCost(neighbor.getNeighborCityName(), endCityName, path, currentCost + neighbor.getCost());
                    if (cost != Integer.MAX_VALUE) {
                        minCost = Math.min(minCost, cost);
                    }
                    path.remove(path.size() - 1);
                }
            }
        }

        return minCost;
    }

    private City findCityByName(String cityName) {
        for (City city : cities) {
            if (city.getName().equals(cityName)) {
                return city;
            }
        }
        return null;
    }
}