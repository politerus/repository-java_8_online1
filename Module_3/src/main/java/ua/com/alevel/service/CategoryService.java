package ua.com.alevel.service;

import ua.com.alevel.dao.CategoryDao;
import ua.com.alevel.entity.Category;

import java.util.List;

public class CategoryService {
    private final CategoryDao categoryDao;

    public CategoryService(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public void createCategory(Category category) {
        categoryDao.save(category);
    }

    public Category findCategoryById(Long id) {
        return categoryDao.findById(id).orElse(null);
    }

    public void updateCategory(Category category) {
        categoryDao.save(category);
    }

    public void deleteCategory(Category category) {
        categoryDao.delete(category);
    }

    public List<Category> getAllCategories() {
        return categoryDao.findAll();
    }
}
