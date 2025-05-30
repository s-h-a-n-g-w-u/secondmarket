package top.example.service;

import top.example.domain.Order;

import java.util.List;

/**
 * @Description: TODO
 * @Author: system
 * @Date: 2024-12-06
 */
public interface OrderService {
    int getTotalOrder();

    int getTotalOrderByUser(int uid);

    void addOrder(Order order);

    void deleteOrder(int id);

    void updateOrder(Order order);

    Order getOrderById(int id);

    List<Order> findAllOrder();

    List<Order> findSomeOrder(int start, int count);

    List<Order> findAllOrderWithoutStatus(int uid, String excludedStatus);

    List<Order> findSomeOrderWithoutStatus(int uid, String excludedStatus, int start, int count);
}
