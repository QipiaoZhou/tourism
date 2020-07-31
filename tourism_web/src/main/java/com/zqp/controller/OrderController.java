package com.zqp.controller;

import com.github.pagehelper.PageInfo;
import com.zqp.domain.Order;
import com.zqp.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

//    /**
//     * 查询所有订单(不分页)
//     * @return
//     */
//    @RequestMapping("/findAllOrders")
//    public ModelAndView findAll(){
//
//        ModelAndView modelAndView = new ModelAndView();
//        List<Order> allOrders = orderService.findAllOrders();
//        modelAndView.addObject("ordersList",allOrders);
//        modelAndView.setViewName("orders-list");
//
//        return modelAndView;
//    }


    /**
     * 查询所有订单(分页)
     * @return
     */
    @RequestMapping("/findAllOrders")
    public ModelAndView findAll(@RequestParam(value = "page",required = true,defaultValue = "1") int page,@RequestParam(value = "size",required = true,defaultValue = "4") int size){

        ModelAndView modelAndView = new ModelAndView();
        List<Order> allOrders = orderService.findAllOrders(page,size);
        PageInfo pageInfo = new PageInfo(allOrders);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("orders-page-list");

        return modelAndView;
    }


    /**
     * 根据订单id查找订单详情(包含旅客信息,联系人信息)
     * @param id
     * @return
     */
    @RequestMapping("/findOrderById")
    public ModelAndView findOrderById(@RequestParam(value = "id",required = true) int id){

        ModelAndView modelAndView = new ModelAndView();
        Order orderById = orderService.findOrderById(id);
        modelAndView.addObject("orders",orderById);
        modelAndView.setViewName("orders-show");

        return modelAndView;
    }

}
