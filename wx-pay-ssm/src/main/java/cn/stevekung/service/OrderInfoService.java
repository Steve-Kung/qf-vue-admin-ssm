package cn.stevekung.service;

import cn.stevekung.pojo.OrderInfo;

import java.util.List;

public interface OrderInfoService {
    /**
     * 因为一个订单会有多个商品
     * 将多条记录添加到订单详情表中。
     */
    void addOrderInfos(List<OrderInfo> orderInfos);

    List<OrderInfo> getOrderInfosByOrderId(Long orderId);
}
