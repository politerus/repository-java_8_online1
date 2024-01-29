package ua.com.alevel.dao;

import ua.com.alevel.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    void save(User user);

    Optional<User> findById(Long id);

    void delete(User user);

    List<User> findAll();


}
