package top.example.domain;

/**
 * @Description: ProductImage实体类
 * @Author: system
 * @Date: 2024-12-05
 */
public class ProductImage {
    private int id;
    private Product product;
    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
