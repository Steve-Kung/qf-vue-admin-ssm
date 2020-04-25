package cn.stevekung.controller;

import cn.stevekung.dto.CreateOrderDTO;
import cn.stevekung.dto.OrderDTO;
import cn.stevekung.dto.ResultDTO;
import cn.stevekung.pojo.Order;
import cn.stevekung.pojo.Product;
import cn.stevekung.service.OrderServiceImpl;
import cn.stevekung.service.ProductServiceImpl;
import cn.stevekung.utils.UUID20;
import cn.stevekung.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Controller
public class OrderController {
    @Autowired
    OrderServiceImpl orderService;

    @Autowired
    ProductServiceImpl productService;

    @RequestMapping("/order")
    @ResponseBody
    public ResultDTO order(OrderDTO orderDTO){

        ResultDTO resultDTO = new ResultDTO();

//        System.out.println(orderDTO);
        try {
            OrderVO orderVO = new OrderVO();

            Order order = new Order();
            order.setOrderId(UUID20.getUUID20());
            order.setOrderFlag(1);

            order.setUserId(orderDTO.getUserId());
            order.setOrderPrice(orderDTO.getOrderPrice());
            order.setOrderAddress(orderDTO.getOrderAddr());
            order.setOrderTel(orderDTO.getOrderTel());
            order.setOrderUser(orderDTO.getOrderUser());

            List<Product> products = new LinkedList<>();
            List<Long> pids = orderDTO.getPids();
            for (Long pid : pids){
                Product productByPid = productService.getProductByPid(pid);
                products.add(productByPid);
            }

            orderVO.setOrder(order);
            orderVO.setProducts(products);

            // =========orderVO封装完毕============

            orderService.addOrder(orderVO);

            resultDTO.setResult(true);
            resultDTO.setMessage("下单成功");

        } catch (Exception e) {
            e.printStackTrace();
            resultDTO.setResult(false);
            resultDTO.setMessage("下单失败");
        }

        return resultDTO;


    }

    // 获收当前用户的所有订单
    @RequestMapping("/orderList")
    @ResponseBody
    public List<CreateOrderDTO> orderList(Long userId){
        return orderService.orderList(userId);
    }
}
