package com.zqp.controller;

import com.zqp.domain.Role;
import com.zqp.domain.UserInfo;
import com.zqp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/findAllUsers")
    public ModelAndView findAllUsers(){

        ModelAndView modelAndView = new ModelAndView();
        List<UserInfo> allUsers = userService.findAllUsers();
        modelAndView.addObject("userList",allUsers);
        modelAndView.setViewName("user-list");

        return modelAndView;
    }


    /**
     * 跳转添加用户界面
     * @return
     */
    @RequestMapping("/gotoAdd")
    public ModelAndView gotoAdd(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user-add");

        return modelAndView;
    }


    /**
     * 保存用户信息
     * @return
     */
    @RequestMapping("/saveUser")
    public String saveUser(UserInfo user){

        userService.saveUser(user);
        return "redirect:/user/findAllUsers";

    }


    /**
     * 根据id查询用户详情,包含角色及权限
     * @param id
     * @return
     */
    @RequestMapping("/findUserById")
    public ModelAndView findUserById(@RequestParam("id") int id){
        ModelAndView modelAndView = new ModelAndView();
        UserInfo userById = userService.findUserById(id);
        modelAndView.addObject("user",userById);
        modelAndView.setViewName("user-show");

        return modelAndView;
    }


    @RequestMapping("/findUserByIdAndAllRole")
    public ModelAndView findUserByIdAndAllRole(@RequestParam("id") int id){

        ModelAndView modelAndView = new ModelAndView();
        UserInfo userInfo = userService.findUserById(id);

        List<Role> otherRoles = userService.findOtherRoles(id);

        modelAndView.addObject("user",userInfo);
        modelAndView.addObject("roleList",otherRoles);
        modelAndView.setViewName("user-role-add");

        return modelAndView;
    }


    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(@RequestParam("userId") int userId, @RequestParam("ids") int[] roleIds){

        userService.addRoleToUser(userId,roleIds);

        return "redirect:/user/findAllUsers";

    }
}
