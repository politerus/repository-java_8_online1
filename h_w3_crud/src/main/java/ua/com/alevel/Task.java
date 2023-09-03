package ua.com.alevel;

public class Task {
    private final int id;
    private String title;
    private String description;


    public Task(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;

    }



    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public boolean isValid() {
        return !title.isEmpty() && !description.isEmpty();
    }
}
