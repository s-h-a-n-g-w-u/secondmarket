package top.example.service;

import top.example.domain.Product;
import top.example.domain.ProductImage;

import java.util.List;

/**
 * @Description: TODO
 * @Author: system
 * @Date: 2024-12-06
 */
public interface ProductImageService {
    void addProductImage(ProductImage productImage);

    void deleteProductImage(int id);

    ProductImage getProductImageById(int id);

    List<ProductImage> findAllProductImage(Product product, String type);

    List<ProductImage> findSomeProductImage(Product product, String type, int start, int count);

    /**
     * 设置填充产品的图片
     */
    void setProductImageWithProduct(Product product);
}
