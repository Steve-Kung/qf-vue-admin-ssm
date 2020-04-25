package cn.stevekung.service;

import cn.stevekung.mapper.OrderInfoMapper;
import cn.stevekung.pojo.OrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {
    @Autowired
    OrderInfoMapper orderInfoMapper;


    @Override
    public void addOrderInfos(List<OrderInfo> orderInfos) {
        orderInfoMapper.addOrderInfos(orderInfos);
    }

    @Override
    public List<OrderInfo> getOrderInfosByOrderId(Long orderId) {
        return orderInfoMapper.getOrderInfosByOrderId(orderId);
    }
}
