package cn.stevekung.service;

import cn.stevekung.mapper.ProductMapper;
import cn.stevekung.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    public int deleteByPrimaryKey(Long id) {
        return productMapper.deleteByPrimaryKey(id);
    }

    public int insert(Product product) {
        return productMapper.insert(product);
    }

    public int insertSelective(Product product) {
        return productMapper.insertSelective(product);
    }

    public Product selectByPrimaryKey(Long id) {
        return productMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(Product product) {
        return productMapper.updateByPrimaryKeySelective(product);
    }

    public int updateByPrimaryKey(Product product) {
        return productMapper.updateByPrimaryKey(product);
    }

    public List<Product> selectProducts() {
        return productMapper.selectProducts();
    }
}
