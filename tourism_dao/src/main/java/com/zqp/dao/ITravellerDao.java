package com.zqp.dao;

import com.zqp.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ITravellerDao {

    @Select("select * from travellers where travellerId in (select travellerId from order_traveller where orderId=#{id})")
    List<Traveller> findTravellersByOrderId(Integer id);
}
