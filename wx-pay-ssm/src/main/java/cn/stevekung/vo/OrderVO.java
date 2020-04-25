package cn.stevekung.vo;

import cn.stevekung.pojo.Order;
import cn.stevekung.pojo.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// 跟订单功能相关的数据实体
// 而不是与数据库表对应的实体
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderVO {
    private Order order;
    // 当前订单所有商品的集合
    private List<Product> products;
}
