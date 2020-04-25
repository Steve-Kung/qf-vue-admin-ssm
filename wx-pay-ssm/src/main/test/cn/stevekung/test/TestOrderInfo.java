package cn.stevekung.test;

import cn.stevekung.dto.CreateOrderDTO;
import cn.stevekung.pojo.OrderInfo;
import cn.stevekung.service.OrderInfoServiceImpl;
import cn.stevekung.service.OrderServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:ApplicationContext.xml")
public class TestOrderInfo {

    @Autowired
    OrderInfoServiceImpl orderInfoService;

    @Autowired
    OrderServiceImpl orderService;

    @Test
    public void test1(){
        List<OrderInfo> orderInfosByOrderId = orderInfoService.getOrderInfosByOrderId(20200424165047L);
        System.out.println(orderInfosByOrderId);
    }

    @Test
    public void test2(){
        List<CreateOrderDTO> list = orderService.orderList(1L);
        System.out.println(list);
    }
}
