package cn.stevekung.mapper;

import cn.stevekung.pojo.Product;

import java.util.List;

public interface ProductMapper {
    public int deleteByPrimaryKey(Long id);
    public int insert(Product product);
    public int insertSelective(Product product);
    public Product selectByPrimaryKey(Long id);
    public int updateByPrimaryKeySelective(Product product);
    public int updateByPrimaryKey(Product product);
    public List<Product> selectProducts();
}
