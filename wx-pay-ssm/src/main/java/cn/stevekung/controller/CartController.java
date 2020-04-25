package cn.stevekung.controller;

import cn.stevekung.pojo.Cart;
import cn.stevekung.service.CartServiceImpl;
import cn.stevekung.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CartController {
    @Autowired
    private CartServiceImpl cartService;

//    @RequestMapping("/test/{userId}")
//    public List<CartVO> getCartVOByUserId(@PathVariable("userId") Long userId){
//        List<CartVO> cartVOByUserId = cartService.getCartVOByUserId(userId);
//        return cartVOByUserId;
//    }

    @RequestMapping("/cart/{userId}")
    public List<Cart> getCartByUserId(@PathVariable("userId") Long userId){
        List<Cart> cartByUserId = cartService.getCartByUserId(userId);
        return cartByUserId;
    }


    @RequestMapping("/addCart")
    public List<CartVO> addCart(Long userId, Long pid, Long pcount){
        // 1.获取当前用户的购物车信息
        // 2. 如果商品已经有，在基础上加上
        // 3. 没有，添加新的记录
        return cartService.addCart(userId, pid, pcount);

    }


}
