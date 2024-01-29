package ua.com.alevel.dao;

import ua.com.alevel.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryDao {
    void save(Category category);

    Optional<Category> findById(Long id);

    void delete(Category category);

    List<Category> findAll();

    List<Category> findByType(String type);


}
