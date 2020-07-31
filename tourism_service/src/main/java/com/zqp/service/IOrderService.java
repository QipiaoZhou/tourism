package com.zqp.service;

import com.zqp.domain.Order;

import java.util.List;

public interface IOrderService {

    /**
     * 分页查询所有订单
     * @param page
     * @param size
     * @return
     */
    List<Order> findAllOrders(int page,int size);

    /**
     * 根据id查询订单详情(包含旅客信息,产品信息,;联系人信息)
     * @param id
     * @return
     */
    Order findOrderById(int id);
}
