package ua.com.alevel.application;
import ua.com.alevel.controller.PathController;
import ua.com.alevel.service.PathService;

public class Application {
    public static void main(String[] args) {
        PathService pathService = new PathService();
        PathController controller = new PathController(pathService);
        controller.start();
    }
}