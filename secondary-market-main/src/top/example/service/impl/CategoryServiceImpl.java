package top.example.service.impl;

import top.example.dao.CategoryDAO;
import top.example.dao.impl.CategoryDAOImpl;
import top.example.domain.Category;
import top.example.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    final private CategoryDAO categoryDAO = new CategoryDAOImpl();


    @Override
    public int getTotalCategory() {
        return categoryDAO.getTotalCategory();
    }

    @Override
    public void addCategory(Category category) {
        categoryDAO.addCategory(category);
    }

    @Override
    public void deleteCategory(int id) {
        categoryDAO.deleteCategory(id);
    }

    @Override
    public void updateCategory(Category category) {
        categoryDAO.updateCategory(category);
    }

    @Override
    public Category getCategoryById(int id) {
        return categoryDAO.getCategoryById(id);
    }

    @Override
    public List<Category> findAllCategory() {
        return categoryDAO.listCategory(0, Short.MAX_VALUE);
    }

    @Override
    public List<Category> findSomeCategory(int start, int count) {
        return categoryDAO.listCategory(start, count);
    }
}
