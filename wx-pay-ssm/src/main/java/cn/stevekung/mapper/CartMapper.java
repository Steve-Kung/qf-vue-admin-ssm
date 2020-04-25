package cn.stevekung.mapper;

import cn.stevekung.pojo.Cart;
import cn.stevekung.vo.CartVO;

import java.util.List;

public interface CartMapper {
    public List<Cart> getCartByUserId(Long userId);
    public int updateById(Cart cart);
    public int addCart(Cart cart);
    public List<CartVO> getCartVOByUserId(Long userId);
}
