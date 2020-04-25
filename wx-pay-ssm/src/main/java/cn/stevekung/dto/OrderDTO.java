package cn.stevekung.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// 存放是交订单时前请求参数
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDTO {
    private Long userId;
    private Long orderPrice;
    private String orderUser;
    private String orderTel;
    private String orderAddr;
    private List<Long> pids;
}
