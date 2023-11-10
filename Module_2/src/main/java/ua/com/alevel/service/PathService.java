package ua.com.alevel.service;

import ua.com.alevel.entity.City;

import java.io.*;
import java.util.*;

public class PathService {
    private static final String INPUT_FILE = "input.txt";
    private static final String OUTPUT_FILE = "output.txt";
    private static final int MAX_COST =20000 ;
    private final List<String[]> pathsToFind = new ArrayList<>();
    private static final Map<String, City> cities = new HashMap<>();

    public PathService() {
        InputFileCreator.createInputFile();
        try {
            readInput();
        } catch (IOException e) {
            throw new RuntimeException("Failed to read cities from input file.", e);
        }
    }private void readInput() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE))) {
            int numCities = Integer.parseInt(br.readLine().trim());

            for (int i = 0; i < numCities; i++) {
                String cityName = br.readLine().trim();
                cities.put(cityName, new City(cityName));
            }

            for (int i = 0; i < numCities; i++) {
                String cityName = br.readLine().trim();
                City city = cities.get(cityName);

                int numNeighbors = Integer.parseInt(br.readLine().trim());

                for (int j = 0; j < numNeighbors; j++) {
                    String[] neighborInfo = br.readLine().split(" ");
                    String neighborCityName = neighborInfo[0];
                    int cost = Integer.parseInt(neighborInfo[1]);
                    City neighborCity = cities.get(neighborCityName);
                    if (neighborCity != null) {
                        city.addNeighbor(neighborCity, cost);
                    } else {
                        throw new IOException("Neighbor city " + neighborCityName + " not found for city " + cityName);
                    }
                }
            }

            int numPathsToFind = Integer.parseInt(br.readLine().trim());

            for (int i = 0; i < numPathsToFind; i++) {
                String[] path = br.readLine().split(" ");
                pathsToFind.add(path);
            }
        }
    }


    public void displayCities() {
        System.out.println("Available cities:");
        cities.keySet().forEach(System.out::println);
    }

    public void calculateAndDisplayShortestPath(Scanner scanner) {
        System.out.println("Enter the starting city:");
        String startCity = scanner.nextLine().trim();

        System.out.println("Enter the destination city:");
        String destinationCity = scanner.nextLine().trim();

        int cost = findShortestPath(startCity, destinationCity);
        if (cost == MAX_COST) {
            System.out.println("There is no path between " + startCity + " and " + destinationCity + ".");
        } else {
            System.out.println("The cheapest path from " + startCity + " to " + destinationCity + " costs: " + cost);
            writePathToFile(startCity, destinationCity, cost);
        }
    }

    public static int findShortestPath(String startName, String endName) {
        if (!cities.containsKey(startName) || !cities.containsKey(endName)) {
            return -1;
        }

        City startCity = cities.get(startName);
        City endCity = cities.get(endName);

        Map<City, Integer> distances = new HashMap<>();
        for (City city : cities.values()) {
            distances.put(city, Integer.MAX_VALUE);
        }
        distances.put(startCity, 0);

        PriorityQueue<City> queue = new PriorityQueue<>(Comparator.comparingInt(distances::get));
        queue.add(startCity);

        Set<City> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            City currentCity = queue.poll();
            if (currentCity.equals(endCity)) {
                break;
            }
            visited.add(currentCity);

            for (Map.Entry<City, Integer> neighborEntry : currentCity.getNeighbors().entrySet()) {
                City neighbor = neighborEntry.getKey();
                if (visited.contains(neighbor)) continue;

                int newDist = distances.get(currentCity) + neighborEntry.getValue();
                if (newDist < distances.get(neighbor)) {
                    distances.put(neighbor, newDist);
                    queue.remove(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        return distances.getOrDefault(endCity, -1);
    }
    public static void writePathToFile(String startCity, String destinationCity, int cost) {
        try (FileWriter fw = new FileWriter(OUTPUT_FILE, true);
             PrintWriter out = new PrintWriter(new BufferedWriter(fw))) {
            out.println("The cheapest path from " + startCity + " to " + destinationCity + " costs: " + cost);
        } catch (IOException e) {
            System.err.println("There was a problem writing to the output file: " + e.getMessage());
        }
    }
}
