package com.zqp.dao;

import com.zqp.domain.Member;
import com.zqp.domain.Order;
import com.zqp.domain.Product;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderDao {

    /**
     * 查询订单的同时,查询产品信息
     * @return
     */
    @Select("select * from orders")
    @Results(value = {
            @Result(id = true,property = "orderId",column = "orderId"),
            @Result(property = "orderTime", column="orderTime"),
            @Result(property = "peopleCount", column="peopleCount"),
            @Result(property = "orderDesc", column="orderDesc"),
            @Result(property = "payType", column="payType"),
            @Result(property = "orderStatus", column="orderStatus"),


            @Result(property = "product", column="productId", javaType = Product.class, one = @One(select = "com.zqp.dao.IProductDao.findProductById",fetchType = FetchType.EAGER))
    })
    List<Order> findAllOrders();


    /**
     * 根据id查询订单详情(包含旅客信息,产品信息,;联系人信息)
     * @param id
     * @return
     */
    @Select("select * from orders where orderId=#{id}")
    @Results(value = {
            @Result(id = true,property = "orderId",column = "orderId"),
            @Result(property = "orderTime", column="orderTime"),
            @Result(property = "peopleCount", column="peopleCount"),
            @Result(property = "orderDesc", column="orderDesc"),
            @Result(property = "payType", column="payType"),
            @Result(property = "orderStatus", column="orderStatus"),


            @Result(property = "product", column="productId", javaType = Product.class,
                    one = @One(select = "com.zqp.dao.IProductDao.findProductById",fetchType = FetchType.EAGER)),

            @Result(property = "member", column = "memberId", javaType = Member.class,
                    one = @One(select = "com.zqp.dao.IMemberDao.findMemberById",fetchType = FetchType.EAGER)),

            @Result(property = "travellers", column = "orderId", javaType = java.util.List.class,
                    many = @Many(select = "com.zqp.dao.ITravellerDao.findTravellersByOrderId",fetchType = FetchType.LAZY))
    })
    Order findOrderById(int id);
}
