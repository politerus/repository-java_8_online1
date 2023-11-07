package ua.com.alevel.entity;

public class Neighbor {
    private String neighborCityName;
    private int cost;

    public Neighbor(String neighborCityName, int cost) {
        this.neighborCityName = neighborCityName;
        this.cost = cost;
    }

    public String getNeighborCityName() {
        return neighborCityName;
    }

    public int getCost() {
        return cost;
    }
}
