package cn.stevekung.mapper;

import cn.stevekung.pojo.OrderInfo;

import java.util.List;

public interface OrderInfoMapper {
    void addOrderInfos(List<OrderInfo> orderInfos);

    List<OrderInfo> getOrderInfosByOrderId(Long orderId);
}
