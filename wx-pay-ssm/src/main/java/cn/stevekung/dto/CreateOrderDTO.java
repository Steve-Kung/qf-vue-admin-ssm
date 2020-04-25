package cn.stevekung.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateOrderDTO {
    /**
     * 订单的创建时间
     订单编号
     订单总金额

     商品集合：
     商品名称
     商品价格
     商品数量
     */
    private Date createTime;
    private Long orderId;
    private Long orderPrice;

    private List<OrderProductDTO> products;
}
