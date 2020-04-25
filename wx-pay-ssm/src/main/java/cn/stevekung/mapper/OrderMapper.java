package cn.stevekung.mapper;

import cn.stevekung.pojo.Order;

import java.util.List;

public interface OrderMapper {
    public List<Order> getAllOrder();
    public Order getOrderById(Long id);
    public int addOrder(Order order);
    public int deleteOrderById(Long id);
    public int updateOrder(Order order);

    List<Order> getOrderByUserId(Long userId);
}
