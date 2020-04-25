package cn.stevekung.vo;

import cn.stevekung.pojo.Cart;
import cn.stevekung.pojo.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartVO {
    private Long cartId;
    private Long userId;
    private Long pid;
    private String pname;
    private Long price;
    private Long pcount;
}
