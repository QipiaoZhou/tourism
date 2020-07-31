package com.zqp.service;

import com.zqp.domain.Product;

import java.util.List;

/**
 * 产品业务接口
 */
public interface IProductService {

    /**
     * 查询所有
     * @return
     */
    List<Product> findAllProducts();

    /**
     * 保存产品
     */
    void saveProduct(Product product);
}
