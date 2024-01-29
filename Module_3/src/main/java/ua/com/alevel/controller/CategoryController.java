package ua.com.alevel.controller;

import ua.com.alevel.entity.Category;
import ua.com.alevel.service.CategoryService;

import java.util.List;
import java.util.Optional;

public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public void createCategory(Category category) {
        categoryService.createCategory(category);
    }

    public Optional<Category> findCategoryById(Long id) {
        return Optional.ofNullable(categoryService.findCategoryById(id));
    }

    public void updateCategory(Category category) {
        categoryService.updateCategory(category);
    }

    public void deleteCategory(Category category) {
        categoryService.deleteCategory(category);
    }

    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }
}