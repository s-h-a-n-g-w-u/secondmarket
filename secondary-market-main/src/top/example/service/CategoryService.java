package top.example.service;

import top.example.domain.Category;

import java.util.List;

/**
 * @Description: TODO
 * @Author: system
 * @Date: 2024-12-06
 */
public interface CategoryService {
    int getTotalCategory();

    void addCategory(Category category);

    void deleteCategory(int id);

    void updateCategory(Category category);

    Category getCategoryById(int id);

    List<Category> findAllCategory();

    List<Category> findSomeCategory(int start, int count);
}
