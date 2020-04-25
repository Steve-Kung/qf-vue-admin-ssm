package cn.stevekung.service;

import cn.stevekung.mapper.CartMapper;
import cn.stevekung.pojo.Cart;
import cn.stevekung.utils.UUID20;
import cn.stevekung.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartMapper;
    @Override
    public List<Cart> getCartByUserId(Long userId) {
        return cartMapper.getCartByUserId(userId);
    }

//    public List<CartVO> getCartVOByUserId(Long userId){
//        return cartMapper.getCartVOByUserId(userId);
//    }

    @Override
    public List<CartVO> addCart(Long userId, Long pid, Long pcount) {
        // 1.获取当前用户的购物车信息
        List<Cart> carts = cartMapper.getCartByUserId(userId);
        boolean havedFlag = true;
        for (Cart cart : carts){
            // 2. 如果商品已经有，在基础上加上
            if (cart.getPid().equals(pid)){
                cart.setPcount(cart.getPcount() + pcount);
                cartMapper.updateById(cart);
                havedFlag = false;
            }
        }
        // 3. 没有，添加新的记录
        if (havedFlag == true){
            Cart cart = new Cart();
            cart.setCartId(UUID20.getUUID20());
            cart.setUserId(userId);
            cart.setPcount(pcount);
            cart.setPid(pid);
            cartMapper.addCart(cart);
        }
        // 4.获取CartVO集合
        List<CartVO> cartVOByUserId = cartMapper.getCartVOByUserId(userId);


        return cartVOByUserId;
    }
}
