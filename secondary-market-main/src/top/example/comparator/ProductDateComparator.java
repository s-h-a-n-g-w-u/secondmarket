package top.example.comparator;

import top.example.domain.Product;

import java.util.Comparator;

/**
 * @Description: 产品发布日期比较器
 * @Author: system
 * @Date: 2024-12-04
 */
public class ProductDateComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        // 升序，发布日期从早到晚
        return o1.getCreateDate().compareTo(o2.getCreateDate());
    }

}
