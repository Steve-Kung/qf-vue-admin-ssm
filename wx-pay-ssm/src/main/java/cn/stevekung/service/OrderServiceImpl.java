package cn.stevekung.service;

import cn.stevekung.dto.CreateOrderDTO;
import cn.stevekung.dto.OrderProductDTO;
import cn.stevekung.mapper.OrderMapper;
import cn.stevekung.pojo.Order;
import cn.stevekung.pojo.OrderInfo;
import cn.stevekung.pojo.Product;
import cn.stevekung.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderInfoService orderInfoService;

    @Autowired
    private ProductServiceImpl productService;

    /**
     * Order
     List <Product>
     1. 往订单表里填数据
     2. 往订单详情里填数据
     3. 往已售商品表里填数据

     * @param orderVO
     */
    @Override
    public void addOrder(OrderVO orderVO) {
        // 从orderVO获得两部分对象，分别调用相应的service层函数，解耦
        Order order = orderVO.getOrder(); // 往订单表中写数据
        List<Product> products = orderVO.getProducts(); // 往订单详情表中写数据
        // 1
        orderMapper.addOrder(order);


        // 2 将数据存入到订单详情表中
        //需要封装一个List<Orderinfo>
        List<OrderInfo> orderInfos = new ArrayList<>();
        for (Product product : products){
            OrderInfo orderInfo = new OrderInfo();
            orderInfo.setOrderId(order.getOrderId());
            orderInfo.setPid(product.getPid());
            orderInfo.setPcount(1L);
            orderInfos.add(orderInfo);
        }
        orderInfoService.addOrderInfos(orderInfos);


    }

    /**
     * 订单的创建时间
     订单编号
     订单总金额

     商品集合：
     商品名称
     商品价格
     商品数量
     */
    @Override
    public List<CreateOrderDTO> orderList(Long userId) {
        List<Order> orders = orderMapper.getOrderByUserId(userId);

        List<CreateOrderDTO> cods = new ArrayList<>();

        orders.forEach(order -> {
            CreateOrderDTO cod = new CreateOrderDTO();
            cod.setCreateTime(order.getCreateTime());
            cod.setOrderId(order.getOrderId());
            cod.setOrderPrice(order.getOrderPrice());
            cods.add(cod);
        });

        /**
         * //这历cods根据订单编号，去订求详情表中获取该订单的所微商品前id及商品激量
         //还要根据商品的id我商品表组获我商品名称和商品价格
         */
        cods.forEach(cod ->{
            List<OrderInfo> orderInfos = orderInfoService.getOrderInfosByOrderId(cod.getOrderId());
            //封装OrderProductDT0
            List<OrderProductDTO> opds = new ArrayList<>();
            orderInfos.forEach(orderInfo -> {
                Long pid = orderInfo.getPid();
                OrderProductDTO opd = getOrderProductDTOByPid(pid);
                opd.setPcount(orderInfo.getPcount());
                opds.add(opd);
            });

            cod.setProducts(opds);

        });

        return cods;
    }

    // 根据商品pid获取商品对象， 并封装为OrderProductDTO对象
    private OrderProductDTO getOrderProductDTOByPid(Long pid) {
        OrderProductDTO opd = new OrderProductDTO();
        Product productByPid = productService.getProductByPid(pid);
        opd.setPname(productByPid.getPname());
        opd.setPrice(productByPid.getPrice());
        return opd;
    }
}
