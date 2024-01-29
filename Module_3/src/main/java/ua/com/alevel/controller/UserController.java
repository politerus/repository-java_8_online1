package ua.com.alevel.controller;

import ua.com.alevel.entity.User;
import ua.com.alevel.service.UserService;

import java.util.List;
import java.util.Optional;

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void createUser(User user) {
        userService.createUser(user);
    }

    public Optional<User> findUserById(Long id) {
        return Optional.ofNullable(userService.findUserById(id));
    }

    public void updateUser(User user) {
        userService.updateUser(user);
    }

    public void deleteUser(User user) {
        userService.deleteUser(user);
    }

    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
