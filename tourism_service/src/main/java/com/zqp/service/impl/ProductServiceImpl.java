package com.zqp.service.impl;

import com.zqp.dao.IProductDao;
import com.zqp.domain.Product;
import com.zqp.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;

    @Override
    public List<Product> findAllProducts() {
        return productDao.findAllProducts();
    }

    @Override
    public void saveProduct(Product product) {
        productDao.saveProduct(product);
    }
}
