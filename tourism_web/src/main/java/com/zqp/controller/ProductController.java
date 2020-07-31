package com.zqp.controller;

import com.zqp.domain.Product;
import com.zqp.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    /**
     * 查询所有产品
     * @return
     */
    @RequestMapping("/findAllProducts")
    public ModelAndView findAll(){

        ModelAndView modelAndView = new ModelAndView();
        List<Product> allProducts = productService.findAllProducts();
        modelAndView.addObject("productList",allProducts);
        modelAndView.setViewName("product-list1");

        return modelAndView;
    }


    /**
     * 跳转到添加产品的表单
     * @return
     */
    @RequestMapping("/gotoAdd")
    public String gotoAdd(){

        return "product-add";

    }


    /**
     * 添加产品
     * @return
     */
    @RequestMapping("/saveProduct")
    public String saveProduct(Product product){

        productService.saveProduct(product);
        return "redirect:/product/findAllProducts";

    }
}
