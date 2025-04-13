package top.example.dao;

import top.example.domain.Category;

import java.util.List;

/**
 * @Description: Category对象的ORM映射
 * @Author: system
 * @Date: 2024-12-06
 */
public interface CategoryDAO {

    /**
     * 获取分类总数量
     *
     * @return: int
     */
    int getTotalCategory();

    void addCategory(Category category);

    void deleteCategory(int id);

    void updateCategory(Category category);

    /**
     * 根据id获取分类
     *
     * @param: id
     * @return: Category
     */
    Category getCategoryById(int id);

    /**
     * 获取分类集合
     *
     * @param: start
     * @param: count
     * @return: List<Category>
     */
    List<Category> listCategory(int start, int count);
}
