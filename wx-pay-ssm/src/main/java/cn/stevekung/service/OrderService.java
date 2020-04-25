package cn.stevekung.service;

import cn.stevekung.dto.CreateOrderDTO;
import cn.stevekung.vo.OrderVO;

import java.util.List;

public interface OrderService {
    void addOrder(OrderVO orderVO);

    List<CreateOrderDTO> orderList(Long userId);
}
