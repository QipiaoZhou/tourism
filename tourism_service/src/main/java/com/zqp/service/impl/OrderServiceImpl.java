package com.zqp.service.impl;

import com.github.pagehelper.PageHelper;
import com.zqp.dao.IOrderDao;
import com.zqp.domain.Order;
import com.zqp.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IOrderDao orderDao;
    @Override
    public List<Order> findAllOrders(int page,int size) {
        PageHelper.startPage(page,size);
        return orderDao.findAllOrders();
    }

    @Override
    public Order findOrderById(int id) {
        return orderDao.findOrderById(id);

    }
}
