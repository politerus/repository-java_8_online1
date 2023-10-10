package ua.com.alevel.empty;

public record Author(int id, String name) {

    @Override
    public String toString() {
        return " Author id= " +
                id +
                ",Author name " + name;
    }
}
