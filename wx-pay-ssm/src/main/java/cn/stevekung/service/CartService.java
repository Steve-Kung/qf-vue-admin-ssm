package cn.stevekung.service;

import cn.stevekung.pojo.Cart;
import cn.stevekung.vo.CartVO;

import java.util.List;

public interface CartService {
    public List<Cart> getCartByUserId(Long userId);
    public List<CartVO> addCart(Long userId, Long pid, Long pcount);

//    public List<CartVO> getCartVOByUserId(Long userId);
}
