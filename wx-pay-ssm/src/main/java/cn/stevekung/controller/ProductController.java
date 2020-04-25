package cn.stevekung.controller;

import cn.stevekung.pojo.Product;
import cn.stevekung.service.ProductService;
import cn.stevekung.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductServiceImpl productService;

    @RequestMapping("/products")
    public List<Product> getAllProduct(){
        List<Product> allProduct = productService.getAllProduct();
        return allProduct;
    }

    @RequestMapping("/product/{pid}")
    public Product getProductByPid(@PathVariable("pid") Long pid){
        Product product = productService.getProductByPid(pid);
        return product;
    }
}
