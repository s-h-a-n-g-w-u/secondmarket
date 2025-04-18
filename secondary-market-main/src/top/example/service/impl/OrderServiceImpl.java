package top.example.service.impl;

import top.example.dao.OrderDAO;
import top.example.dao.OrderItemDAO;
import top.example.dao.impl.OrderDAOImpl;
import top.example.dao.impl.OrderItemDAOImpl;
import top.example.domain.Order;
import top.example.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {


    final private OrderDAO orderDAO = new OrderDAOImpl();
    final private OrderItemDAO orderItemDAO = new OrderItemDAOImpl();

    @Override
    public int getTotalOrder() {
        return orderDAO.getTotalOrder();
    }

    @Override
    public int getTotalOrderByUser(int uid) {
        return orderDAO.getTotalOrderByUser(uid);
    }

    @Override
    public void addOrder(Order order) {
        orderDAO.addOrder(order);
    }

    @Override
    public void deleteOrder(int id) {
        orderDAO.deleteOrder(id);
    }

    @Override
    public void updateOrder(Order order) {
        orderDAO.updateOrder(order);
    }

    @Override
    public Order getOrderById(int id) {
        return orderDAO.getOrderById(id);
    }

    @Override
    public List<Order> findAllOrder() {
        return orderDAO.listOrder(0, Short.MAX_VALUE);
    }

    @Override
    public List<Order> findSomeOrder(int start, int count) {
        return orderDAO.listOrder(start, count);
    }

    @Override
    public List<Order> findAllOrderWithoutStatus(int uid, String excludedStatus) {
        return orderDAO.listOrderWithoutStatus(uid, excludedStatus, 0, Short.MAX_VALUE);
    }

    @Override
    public List<Order> findSomeOrderWithoutStatus(int uid, String excludedStatus, int start, int count) {
        return orderDAO.listOrderWithoutStatus(uid, excludedStatus, start, count);
    }
}
