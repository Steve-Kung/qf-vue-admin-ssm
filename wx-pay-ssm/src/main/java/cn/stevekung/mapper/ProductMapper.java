package cn.stevekung.mapper;

import cn.stevekung.pojo.Product;

import java.util.List;

public interface ProductMapper {
    public List<Product> getAllProduct();
    public Product getProductById(Long id);
    public int addProduct(Product product);
    public int deleteProductById(Long id);
    public int updateProduct(Product product);

    public Product getProductByPid(Long pid);
}
