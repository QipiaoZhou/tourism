package com.zqp.dao;

import com.zqp.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 产品dao接口
 */
//@Repository
public interface IProductDao {

    /**
     * 查询所有产品
     * @return
     */
    @Select("select * from products")
    List<Product> findAllProducts();

    /**
     * 保存新建产品
     * @param product
     */
    @Insert("insert into products(id,productName,departureCity,departureTime,productPrice,productDesc,productStatus) values(#{id},#{productName},#{departureCity},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void saveProduct(Product product);


    /**
     * 根据id查询产品
     * @param id
     * @return
     */
    @Select("select * from products where id=#{id}")
    Product findProductById(Integer id);
}
