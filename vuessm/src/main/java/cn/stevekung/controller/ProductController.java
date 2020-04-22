package cn.stevekung.controller;

import cn.stevekung.pojo.Product;
import cn.stevekung.service.ProductService;
import cn.stevekung.service.ProductServiceImpl;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductServiceImpl productService;
    @RequestMapping("/products")
    public List<Product> products(){
        return productService.selectProducts();
    }

    @RequestMapping("/product/{pid}")
    public Product getProductById(@PathVariable("pid") Long id){
        return productService.selectByPrimaryKey(id);
    }

    @RequestMapping("/updateProduct")
    public String updateProduct(Product product){
        int i = productService.updateByPrimaryKey(product);
        if (i>= 1){
            return "success";
        } else {
            return "error";
        }
    }


    @RequestMapping("/deleteProduct/{pid}")
    public String deleteProduct(@PathVariable("pid") Long id){
        int i = productService.deleteByPrimaryKey(id);
        if (i>= 1){
            return "success";
        } else {
            return "error";
        }
    }

    @RequestMapping("/addProduct")
    public String addProduct(Product product){
        int i = productService.insert(product);
        if (i>= 1){
            return "success";
        } else {
            return "error";
        }
    }

    @RequestMapping("/pageInfo")
    public PageInfo<Product> pageInfo(int pageNum, int pageSize){
        //1.通过调用PageHelper前静态方法开始获我分页数据
        // 指定当前是第几页，以及每页显示的记录条数
        PageHelper.startPage(pageNum, pageSize);
        //2.得所有前记录
        List<Product> list = productService.selectProducts();
        // 获得当前分页对象
        PageInfo<Product> pageInfo  = new PageInfo<Product>(list);
        return pageInfo;
    }

//    //只需要加上下面这段即可，注意不能忘记注解
//     // Failed to convert value of type 'java.lang.String' to required type 'java.util.Date';解决方案
//    @InitBinder
//    public void initBinder(WebDataBinder binder, WebRequest request) {
//
//        //转换日期
//        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
//    }
}
