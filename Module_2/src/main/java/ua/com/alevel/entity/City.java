package ua.com.alevel.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class City {
    String name;
    public final Map<City, Integer> neighbors = new HashMap<>();

    public City(String name) {
        this.name = name;
    }

    public void addNeighbor(City neighbor, int cost) {
        neighbors.put(neighbor, cost);
    }

    public Map<City, Integer> getNeighbors() {
        return neighbors;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City city)) return false;
        return Objects.equals(name, city.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}